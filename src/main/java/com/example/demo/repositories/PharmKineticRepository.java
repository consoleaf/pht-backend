package com.example.demo.repositories;

import com.example.demo.model.entities.PharmKinetic;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PharmKineticRepository extends CrudRepository<PharmKinetic, Long> {
}
