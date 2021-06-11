package com.example.draftspringboot.service;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
public class DraftServiceTest {

    public final DraftService draftService;

    public DraftServiceTest(DraftService draftService) {
        this.draftService = draftService;
    }

    @Test
    public void test() {
        DraftService mockDraftService = mock(DraftService.class);
        when(mockDraftService.getSomeNumber()).thenReturn(4);
        System.out.println(mockDraftService.getSomeNumber());
    }

}