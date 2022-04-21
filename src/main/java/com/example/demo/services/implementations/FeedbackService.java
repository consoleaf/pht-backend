package com.example.demo.services.implementations;

import com.example.demo.contract.FeedbackContract;
import com.example.demo.model.entities.Feedback;
import com.example.demo.model.entities.User;
import com.example.demo.repositories.FeedbackRepository;
import com.example.demo.services.interfaces.IFeedbackService;
import com.example.demo.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FeedbackService implements IFeedbackService {
    @Autowired
    FeedbackRepository repository;

    @Override
    public Feedback updateOrCreate(FeedbackContract contract) {
        Feedback feedback =
                repository.findById(Optional.ofNullable(contract.getId()).orElse(-1L)).orElseGet(Feedback::new);

        Util.assignIfNotNull(contract::getContent, feedback::setContent);
        Util.assignIfNotNull(contract::getEmail, feedback::setEmail);
        Util.assignIfNotNull(contract::getTimestamp, feedback::setTimestamp);
        Util.assignIfNotNull(contract::getIs_processed, feedback::setProcessed);
        Util.assignIfNotNull(contract::getIs_medical_professional, feedback::setMedicalProfessional);

        return repository.save(feedback);
    }
}
