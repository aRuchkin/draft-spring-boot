package com.example.draftspringboot.service;

import com.example.draftspringboot.model.Gender;
import com.example.draftspringboot.model.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.averagingInt;
import static java.util.stream.Collectors.groupingBy;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StreamTest {

    private static final Integer OLD_PERSON_AGE = 75;

    /**
     * Test transforms List of DraftClassListOfString -> List of strings
     */
    @Test
    public void TransformationCollectionTest() {
        List<String> result = TestUtils.createListOfSomeListsOfStrings(3)
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
        return IntStream.range(0, 10)
                .mapToObj(o -> new Person(randomGender(), (int) Math.round(Math.random() * 100)))
                .collect(Collectors.toList());
    }

    /**
     * @return random gender of person
     */
    private Gender randomGender() {
        return Math.random() < 0.5
                ? Gender.FEMALE : Gender.MALE;
    }

}
