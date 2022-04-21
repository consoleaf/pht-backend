package com.example.demo.controller;

import com.example.demo.contract.FeedbackContract;
import com.example.demo.exceptions.BadRequestException;
import com.example.demo.model.entities.Feedback;
import com.example.demo.repositories.FeedbackRepository;
import com.example.demo.services.implementations.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/feedback")
public class FeedbackController {
    @Autowired
    private FeedbackRepository repository;
    @Autowired
    private FeedbackService service;

    @GetMapping
    public ResponseEntity<List<FeedbackContract>> getFeedbacks() {
        List<Feedback> items = (List<Feedback>) repository.findAll();
        var Feedbacks = items.stream().map(FeedbackContract::new).collect(Collectors.toUnmodifiableList());
        return new ResponseEntity<>(Feedbacks, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<FeedbackContract> createFeedback(@RequestBody FeedbackContract contract) {
        if (contract.getId() != null)
            throw new BadRequestException();
        var res = service.updateOrCreate(contract);
        return new ResponseEntity<>(new FeedbackContract(res), HttpStatus.CREATED);
    }

    @PostMapping
    public ResponseEntity<FeedbackContract> updateFeedback(@RequestBody FeedbackContract contract) {
        if (contract.getId() == null)
            throw new BadRequestException();
        var res = service.updateOrCreate(contract);
        return new ResponseEntity<>(new FeedbackContract(res), HttpStatus.CREATED);
    }
}
