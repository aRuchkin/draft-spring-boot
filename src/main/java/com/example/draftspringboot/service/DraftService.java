package com.example.draftspringboot.service;

import com.example.draftspringboot.domain.DraftEntity;
import com.example.draftspringboot.repository.DraftRepository;
import org.springframework.stereotype.Service;

@Service
public class DraftService {

    public final DraftRepository draftRepository;

    public DraftService(DraftRepository draftRepository) {
        this.draftRepository = draftRepository;
    }

    public DraftEntity getById(Integer id) {
        return draftRepository.getById(id);
    }

    public Integer getSomeNumber() {
        return 7;
    }
}
