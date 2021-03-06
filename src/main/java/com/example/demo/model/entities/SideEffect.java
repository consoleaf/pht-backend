package com.example.demo.model.entities;


import org.hibernate.annotations.DynamicUpdate;

import java.util.Set;

import javax.persistence.*;

@Entity
@DynamicUpdate
@Table(name = "side_effects")
public class SideEffect {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column()
    private Long id;

    @ManyToMany(mappedBy = "sideEffects", cascade = CascadeType.ALL)
    private Set<Effect> effects;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "system_id")
    private System system;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((effects == null) ? 0 : effects.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((system == null) ? 0 : system.hashCode());
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
        SideEffect other = (SideEffect) obj;
        if (drug == null) {
            if (other.drug != null)
                return false;
        } else if (!drug.equals(other.drug))
            return false;
        if (effects == null) {
            if (other.effects != null)
                return false;
        } else if (!effects.equals(other.effects))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (system == null) {
            return other.system == null;
        } else return system.equals(other.system);
    }

    public Set<Effect> getEffects() {
        return effects;
    }

    public void setEffects(Set<Effect> effects) {
        this.effects = effects;
    }

    @ManyToOne
    @JoinColumn(name = "system_id")
    public System getSystem() {
        return system;
    }

    public void setSystem(System system) {
        this.system = system;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "drug_id")
    private Drug drug;

    public Drug getDrug() {
        return drug;
    }

    public void setDrug(Drug drug) {
        this.drug = drug;
    }
}
