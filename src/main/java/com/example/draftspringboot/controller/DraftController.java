package com.example.draftspringboot.controller;

import com.example.draftspringboot.model.DraftResponse;
import com.example.draftspringboot.service.DraftService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name="Draft controller", description="Controller for example")
@RestController
@RequestMapping("/")
public class DraftController {

    public final DraftService draftService;

    public DraftController(DraftService draftService) {
        this.draftService = draftService;
    }

    @Operation(summary = "Get something by Id")
    @GetMapping("/{id}")
    public DraftResponse getById(@PathVariable Integer id) {
        return draftService.getById(id);
    public DraftResponse getById(@PathVariable @Parameter(description = "Id of something") Integer id) {
        return toModel(draftService.getById(id));
    }

    @GetMapping
    public List<DraftResponse> getAll() {
        return draftService.getAll();
    }

}
