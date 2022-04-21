package com.example.demo.services.implementations;

import com.example.demo.contract.EffectContract;
import com.example.demo.model.entities.Effect;
import com.example.demo.repositories.EffectRepository;
import com.example.demo.services.interfaces.IEffectService;
import com.example.demo.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class EffectService implements IEffectService {
    @Autowired
    EffectRepository repository;

    @Override
    @Transactional
    public Effect updateOrCreate(EffectContract contract) {
        Effect effect =
                repository.findById(Optional.ofNullable(contract.getId()).orElse(-1L)).orElseGet(Effect::new);

        Util.assignIfNotNull(contract::getEffect, effect::setEffect);

        return effect;
    }
}
