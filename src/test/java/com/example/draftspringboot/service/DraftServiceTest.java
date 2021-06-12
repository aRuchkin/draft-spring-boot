package com.example.draftspringboot.service;

import com.example.draftspringboot.domain.DraftEntity;
import com.example.draftspringboot.model.Gender;
import com.example.draftspringboot.model.Person;
import com.example.draftspringboot.repository.DraftRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DraftServiceTest {

    @Mock
    public DraftService draftService;

    @Mock
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
        when(draftRepository.getById(1)).thenReturn(new DraftEntity(2, "TestName"));
        DraftEntity draftEntity = realDraftService.getById(1);
        System.out.println("test");
    }

    @Test
    public void groupPersonTest() {
        List<Person> resultList = createSomePersonList().stream()
                .filter(person -> person.getGender() == Gender.FEMALE && person.getAge() < 26)
                .collect(Collectors.toList());
        System.out.println("groupPersonTest is done");
    }

    private List<Person> createSomePersonList() {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(Gender.FEMALE, 25));
        personList.add(new Person(Gender.FEMALE, 45));
        personList.add(new Person(Gender.FEMALE, 18));
        personList.add(new Person(Gender.MALE, 32));
        personList.add(new Person(Gender.MALE, 38));
        return personList;
    }

}