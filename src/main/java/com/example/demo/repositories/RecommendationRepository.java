package com.example.demo.repositories;

import com.example.demo.model.entities.Recommendation;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface RecommendationRepository extends PagingAndSortingRepository<Recommendation, Long> {
}
