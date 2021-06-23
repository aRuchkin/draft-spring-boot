package com.example.draftspringboot.service;

import com.example.draftspringboot.domain.DraftEntity;
import com.example.draftspringboot.model.DraftResponse;
import com.example.draftspringboot.repository.DraftRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.context.jdbc.SqlConfig.TransactionMode.ISOLATED;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InMemoryDataBaseTest {

    @Autowired
    DraftRepository draftRepository;

    @Autowired
    DraftService draftService;

    @Test
    @Transactional
    @Sql("/sql/create-draft-entity.sql")
    @Sql(scripts = {"/sql/clean-draft-entity.sql"},
            executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD,
            config = @SqlConfig(transactionMode = ISOLATED))
    public void getFromInMemoryDataBaseTest() {
        DraftResponse expectedResponse = new DraftResponse(1, "test-city");
        Assert.assertEquals(expectedResponse.getName(), draftService.getById(1).getName());
    }

    @Test
    @Transactional
    public void saveEntityToInMemoryDataBaseAndVerifyTest() {
        draftRepository.save(new DraftEntity(2, "test-city-2"));
        Assert.assertEquals("test-city-2", draftService.getById(2).getName());
    }

}
