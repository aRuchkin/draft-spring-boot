package com.example.draftspringboot.service;

import com.example.draftspringboot.model.DraftClassListOfString;
import com.example.draftspringboot.model.DraftResponse;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TestUtils {

    /**
     * @return List of DraftClassListOfString
     * (DraftClassListOfString is List of strings)
     */
    public static List<DraftClassListOfString> createListOfSomeListsOfStrings(int sizeOfList) {
        return IntStream.range(0, sizeOfList)
                .mapToObj(o -> new DraftClassListOfString(createListOfSomeStrings(sizeOfList)))
                .collect(Collectors.toList());
    }

    /**
     * @return List of random strings
     */
    public static List<String> createListOfSomeStrings(int sizeOfList) {
        return IntStream.range(0, sizeOfList)
                .mapToObj(o -> RandomStringUtils.randomAlphabetic(16))
                .collect(Collectors.toList());
    }

    public static List<DraftResponse> createListOfSomeModels(int startIndexOfList, int endIndexOfList) {
        return IntStream.range(startIndexOfList, endIndexOfList)
                .mapToObj(o -> new DraftResponse(o, RandomStringUtils.randomAlphabetic(16)))
                .collect(Collectors.toList());
    }

}
