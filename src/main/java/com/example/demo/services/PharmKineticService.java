package com.example.demo.services;

import com.example.demo.contract.PharmKineticContract;
import com.example.demo.model.entities.PharmKinetic;
import com.example.demo.repositories.PharmKineticRepository;
import com.example.demo.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PharmKineticService implements IPharmKineticService {
    @Autowired
    PharmKineticRepository repository;

    @Override
    public PharmKinetic updateOrCreate(PharmKineticContract contract) {
        PharmKinetic pharmKinetic =
                repository.findById(Optional.ofNullable(contract.getId()).orElse(-1L)).orElseGet(PharmKinetic::new);

        Util.assignIfNotNull(contract::getName, pharmKinetic::setName);
        Util.assignIfNotNull(contract::getValue, pharmKinetic::setValue);

        return pharmKinetic;
    }
}
