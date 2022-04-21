package com.example.demo.services.interfaces;

import com.example.demo.contract.FeedbackContract;
import com.example.demo.model.entities.Feedback;

public interface IFeedbackService {
    Feedback updateOrCreate(FeedbackContract contract);

}
