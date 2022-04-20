package com.example.demo.repositories;

import com.example.demo.model.entities.Dosage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DosageRepository extends CrudRepository<Dosage, Long> {
}
