package com.example.demo.repositories;

import com.example.demo.model.entities.Feedback;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface FeedbackRepository extends PagingAndSortingRepository<Feedback, Long> {
}
