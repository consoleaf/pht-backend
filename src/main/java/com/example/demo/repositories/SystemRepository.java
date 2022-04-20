package com.example.demo.repositories;

import com.example.demo.model.entities.System;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemRepository extends CrudRepository<System, Long> {
}
