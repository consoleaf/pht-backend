package com.example.demo.model.entities;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@DynamicUpdate
@Table(name = "interactions")
public class Interaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "SERIAL")
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String kind_of_interaction;
    @Column(columnDefinition = "TEXT")
    private String clinical_consequence;
    @ManyToOne(targetEntity = ActingSubstance.class)
    private ActingSubstance actingSubstance;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((actingSubstance == null) ? 0 : actingSubstance.hashCode());
        result = prime * result + ((clinical_consequence == null) ? 0 : clinical_consequence.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((kind_of_interaction == null) ? 0 : kind_of_interaction.hashCode());
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
        Interaction other = (Interaction) obj;
        if (actingSubstance == null) {
            if (other.actingSubstance != null)
                return false;
        } else if (!actingSubstance.equals(other.actingSubstance))
            return false;
        if (clinical_consequence == null) {
            if (other.clinical_consequence != null)
                return false;
        } else if (!clinical_consequence.equals(other.clinical_consequence))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (kind_of_interaction == null) {
            if (other.kind_of_interaction != null)
                return false;
        } else if (!kind_of_interaction.equals(other.kind_of_interaction))
            return false;
        return true;
    }

    public ActingSubstance getActingSubstance() {
        return actingSubstance;
    }

    public void setActingSubstance(ActingSubstance actingSubstance) {
        this.actingSubstance = actingSubstance;
    }

    public String getKind_of_interaction() {
        return kind_of_interaction;
    }

    public void setKind_of_interaction(String kind_of_interaction) {
        this.kind_of_interaction = kind_of_interaction;
    }

    public String getClinical_consequence() {
        return clinical_consequence;
    }

    public void setClinical_consequence(String clinical_consequence) {
        this.clinical_consequence = clinical_consequence;
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
