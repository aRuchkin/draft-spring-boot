package com.example.draftspringboot.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DraftServiceTest {

    @Mock
    public DraftService draftService;

    @Autowired
    public DraftService realDraftService;


    @Test
    public void testMockMethod() {
        when(draftService.getSomeString()).thenReturn("MockSomeString");
        Assert.assertEquals("MockSomeString", draftService.getSomeString());
    }

    @Test
    public void realRealMethod() {
        Assert.assertEquals( "SomeString", realDraftService.getSomeString());
    }

}