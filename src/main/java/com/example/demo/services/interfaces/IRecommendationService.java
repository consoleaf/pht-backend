package com.example.demo.services.interfaces;

import com.example.demo.contract.RecommendationContract;
import com.example.demo.model.entities.Recommendation;

public interface IRecommendationService {
    Recommendation updateOrCreate(RecommendationContract contract);
}
