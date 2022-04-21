package com.example.demo.services.interfaces;

import com.example.demo.contract.DosageContract;
import com.example.demo.contract.EffectContract;
import com.example.demo.model.entities.Dosage;
import com.example.demo.model.entities.Effect;

public interface IEffectService {
    Effect updateOrCreate(EffectContract contract);
}
