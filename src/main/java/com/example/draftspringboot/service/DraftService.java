package com.example.draftspringboot.service;

import com.example.draftspringboot.domain.DraftEntity;
import com.example.draftspringboot.model.DraftResponse;
import com.example.draftspringboot.repository.DraftRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public List<DraftResponse> getAll() {
        return draftRepository.findAll()
                .stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    private DraftResponse toModel(DraftEntity draftEntity) {
        return modelMapper.map(draftEntity, DraftResponse.class);
    }

    public String getSomeString() {
        return "SomeString";
    }
}
