package com.example.draftspringboot.service;

import com.example.draftspringboot.domain.DraftEntity;
import com.example.draftspringboot.repository.DraftRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DraftService {

    private final DraftRepository draftRepository;

    public DraftService(DraftRepository draftRepository) {
        this.draftRepository = draftRepository;
    }

    public DraftEntity getById(Integer id) {
        return draftRepository.getById(id);
    }

    public List<DraftEntity> getAll() {
        return draftRepository.findAll();
    }

    public String getSomeString() {
        return "SomeString";
    }
}
