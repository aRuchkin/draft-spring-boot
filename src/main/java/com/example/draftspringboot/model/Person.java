package com.example.draftspringboot.model;

public class Person {
    private Gender gender;
    private int age;

    public Gender getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public Person(Gender gender, int age) {
        this.gender = gender;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "gender=" + gender +
                ", age=" + age +
                '}';
    }
}

