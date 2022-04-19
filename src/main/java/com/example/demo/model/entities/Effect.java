package com.example.demo.model.entities;

import org.hibernate.annotations.DynamicUpdate;

import java.util.Set;

import javax.persistence.*;

@Entity
@DynamicUpdate
@Table(name = "effects")
public class Effect  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "effect_id", columnDefinition = "serial")
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String effect;

    @ManyToMany
    @JoinTable(name = "SIDE_EFFECT_EFFECTS", joinColumns = { @JoinColumn(name = "effect_id") }, inverseJoinColumns = {
            @JoinColumn(name = "side_effect_id") })
    private Set<SideEffect> sideEffects;

    public Set<SideEffect> getSideEffects() {
        return sideEffects;
    }

    public void setSideEffects(Set<SideEffect> sideEffects) {
        this.sideEffects = sideEffects;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((effect == null) ? 0 : effect.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Effect other = (Effect) obj;
        if (effect == null) {
            if (other.effect != null)
                return false;
        } else if (!effect.equals(other.effect))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}
