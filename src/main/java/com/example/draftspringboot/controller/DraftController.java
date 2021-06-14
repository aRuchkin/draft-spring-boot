package com.example.draftspringboot.controller;

import com.example.draftspringboot.model.DraftResponse;
import com.example.draftspringboot.service.DraftService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DraftController {

    public final DraftService draftService;

    public DraftController(DraftService draftService) {
        this.draftService = draftService;
    }

    @GetMapping("/{id}")
    public DraftResponse getById(@PathVariable Integer id) {
        return draftService.getById(id);
    }

    @GetMapping
    public List<DraftResponse> getAll() {
        return draftService.getAll();
    }

}
