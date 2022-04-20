package com.example.demo.services;

import com.example.demo.contract.InteractionContract;
import com.example.demo.model.entities.Interaction;

public interface IInteractionService {
    Interaction updateOrCreate(InteractionContract contract);
}
