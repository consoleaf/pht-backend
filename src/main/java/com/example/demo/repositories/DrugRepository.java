package com.example.demo.repositories;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.entities.Drug;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrugRepository extends CrudRepository<Drug, Long> {
    public Optional<Drug> getById(Long id);
}
