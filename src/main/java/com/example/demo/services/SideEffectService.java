package com.example.demo.services;

import com.example.demo.contract.SideEffectContract;
import com.example.demo.model.entities.Effect;
import com.example.demo.model.entities.SideEffect;
import com.example.demo.repositories.SideEffectRepository;
import com.example.demo.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SideEffectService implements ISideEffectService {
    @Autowired
    SideEffectRepository repository;

    @Autowired
    ISystemService systemService;

    @Override
    public SideEffect updateOrCreate(SideEffectContract contract) {
        SideEffect effect =
                repository.findById(Optional.ofNullable(contract.getId()).orElse(-1L)).orElseGet(SideEffect::new);

        Util.assignIfNotNull(contract::getSystem, (systemContract -> {
            var system = systemService.updateOrCreate(systemContract);
            if (!effect.getSystem().getId().equals(system.getId())) {
                effect.setSystem(system);
            }
        }));

        return effect;
    }
}
