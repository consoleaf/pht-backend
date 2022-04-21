package com.example.demo.services.implementations;

import com.example.demo.contract.RecommendationContract;
import com.example.demo.model.entities.Feedback;
import com.example.demo.model.entities.Recommendation;
import com.example.demo.repositories.RecommendationRepository;
import com.example.demo.services.interfaces.IRecommendationService;
import com.example.demo.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RecommendationService implements IRecommendationService {
    @Autowired
    private RecommendationRepository repository;

    @Override
    public Recommendation updateOrCreate(RecommendationContract contract) {
        Recommendation recommendation =
                repository.findById(Optional.ofNullable(contract.getId()).orElse(-1L)).orElseGet(Recommendation::new);

        Util.assignIfNotNull(contract::getContent, recommendation::setContent);
        Util.assignIfNotNull(contract::getTitle, recommendation::setTitle);

        return repository.save(recommendation);
    }
}
