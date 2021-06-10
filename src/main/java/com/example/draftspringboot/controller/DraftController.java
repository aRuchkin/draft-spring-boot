package com.example.draftspringboot.controller;

import com.example.draftspringboot.domain.DraftEntity;
import com.example.draftspringboot.model.DraftResponse;
import com.example.draftspringboot.service.DraftService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DraftController {

    public final DraftService draftService;
    public final ModelMapper modelMapper;

    public DraftController(DraftService draftService,
                           ModelMapper modelMapper) {
        this.draftService = draftService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/{id}")
    public DraftResponse get(@PathVariable Integer id) {
        return toModel(draftService.getById(id));
    }

    private DraftResponse toModel(DraftEntity draftEntity) {
        return modelMapper.map(draftEntity, DraftResponse.class);
    }
}
