package com.example.demo.services;

import com.example.demo.contract.DosageContract;
import com.example.demo.model.entities.CreatinineBasedDosage;
import com.example.demo.model.entities.Dosage;
import com.example.demo.repositories.DosageRepository;
import com.example.demo.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DosageService implements IDosageService {
    @Autowired
    DosageRepository repository;

    @Override
    public Dosage updateOrCreate(DosageContract contract) {
        Dosage dosage =
                repository.findById(Optional.ofNullable(contract.getId()).orElse(-1L)).orElseGet(Dosage::new);

        Util.assignIfNotNull(contract::getAdult, dosage::setAdult);
        Util.assignIfNotNull(contract::getDaily_dose, dosage::setDaily_dose);
        Util.assignIfNotNull(contract::getMax_daily_dose, dosage::setMax_daily_dose);
        Util.assignIfNotNull(contract::getPharm_form, dosage::setPharm_form);

        return dosage;
    }
}
