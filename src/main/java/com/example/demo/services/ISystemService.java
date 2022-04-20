package com.example.demo.services;

import com.example.demo.contract.EffectContract;
import com.example.demo.contract.SystemContract;
import com.example.demo.model.entities.Effect;
import com.example.demo.model.entities.System;

public interface ISystemService {
    System updateOrCreate(SystemContract contract);

}
