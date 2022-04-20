package com.example.demo.repositories;

import com.example.demo.model.entities.Effect;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EffectRepository extends CrudRepository<Effect, Long> {
}
