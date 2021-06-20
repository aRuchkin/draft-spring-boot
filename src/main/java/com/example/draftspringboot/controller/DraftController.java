package com.example.draftspringboot.controller;

import com.example.draftspringboot.model.DraftResponse;
import com.example.draftspringboot.service.DraftService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

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
    public DraftResponse getById(@PathVariable @Parameter(description = "Id of something") Integer id) {
        return draftService.getById(id);
    }

    @Operation(summary = "Get list of something with pagination and search by part of name")
    @GetMapping()
    public Page<DraftResponse> searchByPartName(
            @Parameter(description = "index of page") @RequestParam(required = false) Integer index,
            @Parameter(description = "number of elements on the page") @RequestParam Integer limit,
            @Parameter(description = "part of name") @RequestParam(required = false) String partName) {
        return draftService.searchByPartName(index, limit, partName);
    }
}
