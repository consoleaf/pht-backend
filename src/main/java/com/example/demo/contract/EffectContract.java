package com.example.demo.contract;

import com.example.demo.model.entities.Effect;

public class EffectContract {
    private Long id;
    private String effect;

    public EffectContract() {
    }

    public EffectContract(Effect effect2) {
        this.setId(effect2.getId());
        this.setEffect(effect2.getEffect());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public Effect toEntity() {
        Effect entity = new Effect();
        entity.setEffect(effect);
        entity.setId(id);
        return entity;
    }
}
