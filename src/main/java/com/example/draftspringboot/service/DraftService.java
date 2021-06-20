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

    public Page<DraftResponse> searchByPartName(Integer index, Integer limit, String partName) {
        // index of page can be null
        // so we will give first (0th) page if index is not set
        PageRequest pageRequest = PageRequest.of(index == null ? 0 : index, limit);
        Page<DraftEntity> pageOfEntities = draftRepository.searchByPartName(pageRequest, partName);
        return new PageImpl<>(pageOfEntities.stream().map(this::toModel).collect(Collectors.toList()),
                pageRequest, pageOfEntities.getTotalElements());
    }

        private DraftResponse toModel(DraftEntity draftEntity) {
        return modelMapper.map(draftEntity, DraftResponse.class);
    }

    public String getSomeString() {
        return "SomeString";
    }
}
