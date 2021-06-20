package com.example.draftspringboot.service;

import com.example.draftspringboot.domain.DraftEntity;
import com.example.draftspringboot.model.DraftResponse;
import com.example.draftspringboot.repository.DraftRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DraftServiceTest {

    @Mock
    public DraftService draftService;

    @MockBean
    private DraftRepository draftRepository;

    @Autowired
    public DraftService realDraftService;


    @Test
    public void testMockMethod() {
        when(draftService.getSomeString()).thenReturn("MockSomeString");
        Assert.assertEquals("MockSomeString", draftService.getSomeString());
    }

    @Test
    public void testRealMethod() {
        Assert.assertEquals( "SomeString", realDraftService.getSomeString());
    }

    @Test
    public void getByIdTest() {
        DraftEntity expectedDraftEntity = new DraftEntity(2, "TestName");
        when(draftRepository.getById(1)).thenReturn(expectedDraftEntity);
        DraftResponse draftEntity = realDraftService.getById(1);
        Assert.assertEquals(expectedDraftEntity.getId(), draftEntity.getId());
        Assert.assertEquals(expectedDraftEntity.getName(), draftEntity.getName());
    }

}