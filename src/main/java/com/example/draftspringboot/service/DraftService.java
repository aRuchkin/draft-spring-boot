package com.example.draftspringboot.service;

import com.example.draftspringboot.domain.DraftEntity;
import com.example.draftspringboot.model.DraftResponse;
import com.example.draftspringboot.repository.DraftRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class DraftService {

    private final DraftRepository draftRepository;

    private final ModelMapper modelMapper;

    public DraftService(DraftRepository draftRepository,
                        ModelMapper modelMapper) {
        this.draftRepository = draftRepository;
        this.modelMapper = modelMapper;
    }

    public DraftResponse getById(Integer id) {
        return toModel(draftRepository.getById(id));
    }

    public Page<DraftResponse> searchByName(PageRequest pageRequest, String name) {
        Page<DraftEntity> pageOfEntities =
                draftRepository.searchByName(pageRequest, name != null ? name.toLowerCase() : null);
        return pageToPageModel(pageRequest, pageOfEntities);
    }

    private Page<DraftResponse> pageToPageModel(PageRequest pageRequest, Page<DraftEntity> page) {
        return new PageImpl<>(page.stream().map(this::toModel).collect(Collectors.toList()),
                pageRequest, page.getTotalElements());
    }

    private DraftResponse toModel(DraftEntity draftEntity) {
        return modelMapper.map(draftEntity, DraftResponse.class);
    }

    public String getSomeString() {
        return "SomeString";
    }
}
