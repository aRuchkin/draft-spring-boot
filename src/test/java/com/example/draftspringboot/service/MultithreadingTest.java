package com.example.draftspringboot.service;

import com.example.draftspringboot.model.DraftResponse;
import com.example.draftspringboot.repository.DraftRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.springframework.test.context.jdbc.SqlConfig.TransactionMode.ISOLATED;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MultithreadingTest {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private DraftService draftService;

    @Autowired
    private DraftRepository draftRepository;

    @Test
    @Transactional
    @Sql(scripts = {"/sql/clean-draft-entity.sql"},
            executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD,
            config = @SqlConfig(transactionMode = ISOLATED))
    public void transformModelsToEntitiesAndSaveMultithreadingTest() {
        List<DraftResponse> firstListOfSomeModels = prepareTestList(0, 5);
        List<DraftResponse> secondListOfSomeModels = prepareTestList(5, 15);
        List<DraftResponse> thirdListOfSomeModels = prepareTestList(15, 30);

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit(() -> {
            transformModelsToEntitiesAndSave(firstListOfSomeModels);
        });
        executorService.submit(() -> {
            transformModelsToEntitiesAndSave(secondListOfSomeModels);
        });
        executorService.submit(() -> {
            transformModelsToEntitiesAndSave(thirdListOfSomeModels);
        });
        executorService.shutdown();

        // just check the number of items in the repository
        Assert.assertEquals(
                firstListOfSomeModels.size() + secondListOfSomeModels.size() + thirdListOfSomeModels.size(),
                draftRepository.findAll().size());
    }

    private List<DraftResponse> prepareTestList(int startIndexOfList, int endIndexOfList) {
        return TestUtils.createListOfSomeModels(startIndexOfList, endIndexOfList);
    }

    private void transformModelsToEntitiesAndSave(List<DraftResponse> list) {
        for(DraftResponse element : list) {
            logger.info("Collection is processing in the thread: " + Thread.currentThread().getName());
            draftRepository.save(draftService.toEntity(element));
        }
    }

}
