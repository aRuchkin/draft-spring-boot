package com.example.draftspringboot.controller;

import com.example.draftspringboot.domain.DraftEntity;
import com.example.draftspringboot.model.DraftResponse;
import com.example.draftspringboot.service.DraftService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

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
    public DraftResponse getById(@PathVariable Integer id) {
        return toModel(draftService.getById(id));
    }

    @GetMapping
    public List<DraftResponse> getAll() {
        return draftService.getAll()
                .stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }


    private DraftResponse toModel(DraftEntity draftEntity) {
        return modelMapper.map(draftEntity, DraftResponse.class);
    }
}
