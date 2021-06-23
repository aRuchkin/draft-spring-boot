package com.example.draftspringboot.repository;

import com.example.draftspringboot.domain.DraftEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DraftRepository extends JpaRepository<DraftEntity, Integer> {

    @Query("select c from DraftEntity c where (:name is null or lower(c.name) like %:name%)")
    Page<DraftEntity> searchByName(Pageable pageable, @Param("name") String name);

}
