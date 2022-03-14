package com.example.demo.repositories;

import java.util.List;

import com.example.demo.model.entities.Drug;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrugRepository extends PagingAndSortingRepository<Drug, Long> {
    @Query("SELECT d FROM Drug d WHERE lower(inp_name) LIKE lower(concat('%', :inp_name, '%'))")
    List<Drug> findAllByInpName(String inp_name, Sort sort);
}
