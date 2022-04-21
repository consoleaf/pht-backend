package com.example.demo.services.interfaces;

import com.example.demo.contract.PharmKineticContract;
import com.example.demo.model.entities.PharmKinetic;

public interface IPharmKineticService {
    PharmKinetic updateOrCreate(PharmKineticContract contract);
}
