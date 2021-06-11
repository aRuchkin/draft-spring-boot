package com.example.draftspringboot.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cities")
public class DraftEntity {

    @Id
    private Integer id;

    private String name;

    public DraftEntity() {

    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public DraftEntity(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
