package com.example.demo.repositories;

import com.example.demo.model.entities.SideEffect;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SideEffectRepository extends CrudRepository<SideEffect, Long> {
}
