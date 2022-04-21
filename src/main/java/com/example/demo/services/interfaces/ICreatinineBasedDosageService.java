package com.example.demo.services.interfaces;

import com.example.demo.contract.CreatinineBasedDosageContract;
import com.example.demo.model.entities.CreatinineBasedDosage;

public interface ICreatinineBasedDosageService {
    CreatinineBasedDosage updateOrCreate(CreatinineBasedDosageContract contract);
}
