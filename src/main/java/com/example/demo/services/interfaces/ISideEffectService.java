package com.example.demo.services.interfaces;

import com.example.demo.contract.EffectContract;
import com.example.demo.contract.SideEffectContract;
import com.example.demo.model.entities.Effect;
import com.example.demo.model.entities.SideEffect;

public interface ISideEffectService {
    SideEffect updateOrCreate(SideEffectContract contract);
}
