package com.example.draftspringboot.service;

import com.example.draftspringboot.model.DraftClassListOfString;
import com.example.draftspringboot.model.Gender;
import com.example.draftspringboot.model.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StreamTest {

    private static final Integer OLD_PERSON_AGE = 75;

    /**
     * Test transforms List of DraftClassListOfString -> List of strings
     */
    @Test
    public void TransformationCollectionTest() {
        List<String> result = createInputListForTransformationTest()
                .stream()
                .flatMap(p -> p.getSomeField().stream())
                .collect(Collectors.toList());
        result.forEach(System.out::println);
    }

    /**
     * Test creates report about average age of person by gender
     */
    @Test
    public void averageAgePersonTest() {
        Map<Gender, Double> resultMap = createSomePersonList()
                .stream()
                .collect(groupingBy(Person::getGender, averagingInt(Person::getAge)));
        System.out.println("Average age of persons by gender:");
        resultMap.entrySet().forEach(System.out::println);
    }

    /**
     * Test creates list of person older than "OLD_PERSON_AGE"
     */
    @Test
    public void findOldPersonTest() {
        List<Person> resultList = createSomePersonList()
                .stream()
                .filter(person -> person.getAge() > OLD_PERSON_AGE)
                .collect(Collectors.toList());
        resultList.forEach(System.out::println);
    }

    /**
     * @return List of some persons
     */
    private List<Person> createSomePersonList() {
        return Arrays.asList(
                new Person(Gender.FEMALE, 25),
                new Person(Gender.FEMALE, 45),
                new Person(Gender.FEMALE, 18),
                new Person(Gender.MALE, 32),
                new Person(Gender.MALE, 38),
                new Person(Gender.MALE, 78),
                new Person(Gender.MALE, 82)
        );
    }

    /**
     * @return List of DraftClassListOfString
     * (DraftClassListOfString is List of strings)
     */
    private List<DraftClassListOfString> createInputListForTransformationTest() {
        return Arrays.asList(
                new DraftClassListOfString(createListOfSomeStrings()),
                new DraftClassListOfString(createListOfSomeStrings()),
                new DraftClassListOfString(createListOfSomeStrings())
        );
    }

    /**
     * @return List of random strings
     */
    private List<String> createListOfSomeStrings() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            list.add(UUID.randomUUID().toString().replace("-", ""));
        }
        return list;
    }
}
