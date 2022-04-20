package com.example.demo.repositories;

import com.example.demo.model.entities.CreatinineBasedDosage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreatinineBasedDosageRepository extends CrudRepository<CreatinineBasedDosage, Long> {
}
