package com.example.draftspringboot.repository;

import com.example.draftspringboot.domain.DraftEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DraftRepository extends JpaRepository<DraftEntity, Integer> {

    Page<DraftEntity> findAll(Pageable pageable);
}
