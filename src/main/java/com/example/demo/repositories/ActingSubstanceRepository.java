package com.example.demo.repositories;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.entities.ActingSubstance;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActingSubstanceRepository extends PagingAndSortingRepository<ActingSubstance, Long> {
    @Query("SELECT d FROM ActingSubstance d WHERE lower(name) LIKE lower(concat('%', :inp_name, '%'))")
    List<ActingSubstance> findAllByInpName(String inp_name, Sort sort);

    Optional<ActingSubstance> findByDrugId(Long drugId);
}
