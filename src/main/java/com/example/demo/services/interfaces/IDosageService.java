package com.example.demo.services.interfaces;

import com.example.demo.contract.DosageContract;
import com.example.demo.model.entities.Dosage;

public interface IDosageService {
    Dosage updateOrCreate(DosageContract contract);
}
