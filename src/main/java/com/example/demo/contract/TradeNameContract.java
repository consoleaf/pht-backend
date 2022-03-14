package com.example.demo.contract;

import java.io.Serializable;

import com.example.demo.model.entities.TradeName;

public class TradeNameContract implements Serializable {
    public TradeNameContract() {
    }

    public TradeNameContract(TradeName nam) {
        this.setId(nam.getId());
        this.setPharm_form(nam.getPharm_form());
        this.setTrade_name(nam.getTrade_name());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTrade_name() {
        return trade_name;
    }

    public void setTrade_name(String trade_name) {
        this.trade_name = trade_name;
    }

    public String getPharm_form() {
        return pharm_form;
    }

    public void setPharm_form(String pharm_form) {
        this.pharm_form = pharm_form;
    }

    private Long id;
    private String trade_name;
    private String pharm_form;
}
