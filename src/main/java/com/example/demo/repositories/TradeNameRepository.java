package com.example.demo.repositories;

import com.example.demo.model.entities.TradeName;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TradeNameRepository extends CrudRepository<TradeName, Long> {
}
