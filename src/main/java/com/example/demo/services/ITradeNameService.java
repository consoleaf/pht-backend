package com.example.demo.services;

import com.example.demo.contract.EffectContract;
import com.example.demo.contract.TradeNameContract;
import com.example.demo.model.entities.Effect;
import com.example.demo.model.entities.TradeName;

public interface ITradeNameService {
    TradeName updateOrCreate(TradeNameContract contract);
}
