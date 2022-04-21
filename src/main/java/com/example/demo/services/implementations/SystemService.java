package com.example.demo.services.implementations;

import com.example.demo.contract.SystemContract;
import com.example.demo.model.entities.System;
import com.example.demo.repositories.SystemRepository;
import com.example.demo.services.interfaces.ISystemService;
import com.example.demo.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class SystemService implements ISystemService {
    @Autowired
    SystemRepository repository;

    @Override
    @Transactional
    public System updateOrCreate(SystemContract contract) {
        System system =
                repository.findById(Optional.ofNullable(contract.getId()).orElse(-1L)).orElseGet(System::new);

        Util.assignIfNotNull(contract::getSystem, system::setSystem);

        return system;
    }
}
