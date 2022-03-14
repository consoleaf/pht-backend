package com.example.demo.contract;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.model.entities.SideEffect;

public class SideEffectContract implements Serializable {
    public SideEffectContract() {
    }

    public SideEffectContract(SideEffect eff) {
        this.setId(eff.getId());
        this.setEffects(
                eff.getEffects().stream().map(effect -> new EffectContract(effect)).collect(Collectors.toList()));
        this.setSystem(new SystemContract(eff.getSystem()));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<EffectContract> getEffects() {
        return effects;
    }

    public void setEffects(List<EffectContract> effects) {
        this.effects = effects;
    }

    public SystemContract getSystem() {
        return system;
    }

    public void setSystem(SystemContract system) {
        this.system = system;
    }

    private Long id;
    private List<EffectContract> effects;
    private SystemContract system;

    public SideEffect toEntity() {
        SideEffect sideEffect = new SideEffect();
        sideEffect.setId(id);
        sideEffect.setSystem(system.toEntity());
        sideEffect.setEffects(effects.stream().map(t -> t.toEntity()).collect(Collectors.toSet()));
        return sideEffect;
    }
}
