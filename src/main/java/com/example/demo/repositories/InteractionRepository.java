package com.example.demo.repositories;

import com.example.demo.model.entities.Interaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InteractionRepository extends CrudRepository<Interaction, Long> {
}
