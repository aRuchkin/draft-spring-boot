package com.example.draftspringboot.model;

public class DraftResponse {
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DraftResponse() {
    }

    public DraftResponse(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
