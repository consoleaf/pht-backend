package com.example.demo.controller;

import com.example.demo.contract.RecommendationContract;
import com.example.demo.exceptions.BadRequestException;
import com.example.demo.model.entities.Recommendation;
import com.example.demo.repositories.RecommendationRepository;
import com.example.demo.services.implementations.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/recommendations")
public class RecommendationController {
    @Autowired
    private RecommendationRepository repository;
    @Autowired
    private RecommendationService service;

    @GetMapping
    public ResponseEntity<List<RecommendationContract>> getRecommendations() {
        List<Recommendation> items = (List<Recommendation>) repository.findAll();
        var Recommendations = items.stream().map(RecommendationContract::new).collect(Collectors.toUnmodifiableList());
        return new ResponseEntity<>(Recommendations, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<RecommendationContract> createRecommendation(@RequestBody RecommendationContract contract) {
        if (contract.getId() != null)
            throw new BadRequestException();
        var res = service.updateOrCreate(contract);
        return new ResponseEntity<>(new RecommendationContract(res), HttpStatus.CREATED);
    }

    @PostMapping
    public ResponseEntity<RecommendationContract> updateRecommendation(@RequestBody RecommendationContract contract) {
        if (contract.getId() == null)
            throw new BadRequestException();
        var res = service.updateOrCreate(contract);
        return new ResponseEntity<>(new RecommendationContract(res), HttpStatus.CREATED);
    }
}
