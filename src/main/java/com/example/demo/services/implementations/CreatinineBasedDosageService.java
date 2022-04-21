package com.example.demo.services.implementations;

import com.example.demo.contract.CreatinineBasedDosageContract;
import com.example.demo.model.entities.CreatinineBasedDosage;
import com.example.demo.repositories.CreatinineBasedDosageRepository;
import com.example.demo.services.interfaces.ICreatinineBasedDosageService;
import com.example.demo.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CreatinineBasedDosageService implements ICreatinineBasedDosageService {
    @Autowired
    CreatinineBasedDosageRepository repository;

    @Override
    @Transactional
    public CreatinineBasedDosage updateOrCreate(CreatinineBasedDosageContract contract) {
        CreatinineBasedDosage creatinineBasedDosage =
                repository.findById(Optional.ofNullable(contract.getId()).orElse(-1L)).orElseGet(CreatinineBasedDosage::new);


        Util.assignIfNotNull(contract::getDosage_fraction, creatinineBasedDosage::setDosage_fraction);
        Util.assignIfNotNull(contract::getCreatinine_clearance, creatinineBasedDosage::setCreatinine_clearance);

        return creatinineBasedDosage;
    }
}
