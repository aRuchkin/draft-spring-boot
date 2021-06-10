package com.example.draftspringboot.service;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class DraftServiceTest {

    public final DraftService draftService;

    public DraftServiceTest(DraftService draftService) {
        this.draftService = draftService;
    }

    @Test
    public void test() {
        System.out.println((Mockito.when(draftService.getSomeNumber()).thenReturn(4)));
    }

}