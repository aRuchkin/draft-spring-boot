package com.example.draftspringboot.model;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Draft response model")
public class DraftResponse {

    @Schema(description = "Id", example = "15")
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
