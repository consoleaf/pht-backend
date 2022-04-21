package com.example.demo.services;

import com.example.demo.contract.TradeNameContract;
import com.example.demo.model.entities.Effect;
import com.example.demo.model.entities.TradeName;
import com.example.demo.repositories.TradeNameRepository;
import com.example.demo.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class TradeNameService implements ITradeNameService {
    @Autowired
    TradeNameRepository repository;

    @Override
    @Transactional
    public TradeName updateOrCreate(TradeNameContract contract) {
        TradeName tradeName =
                repository.findById(Optional.ofNullable(contract.getId()).orElse(-1L)).orElseGet(TradeName::new);

        Util.assignIfNotNull(contract::getTrade_name, tradeName::setTrade_name);
        Util.assignIfNotNull(contract::getPharm_form, tradeName::setPharm_form);

        return tradeName;
    }
}
