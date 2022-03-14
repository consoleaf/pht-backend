package com.example.demo.contract;

import com.example.demo.model.entities.Interaction;

public class InteractionContract {
    public InteractionContract(Interaction interaction) {
        this.setId(interaction.getId());
        this.setClinical_consequence(interaction.getClinical_consequence());
        this.setActing_substance(new ActingSubstanceContract(interaction.getActingSubstance()));
        this.setKind_of_interaction(interaction.getKind_of_interaction());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public InteractionContract() {
    }

    public ActingSubstanceContract getActing_substance() {
        return acting_substance;
    }

    public void setActing_substance(ActingSubstanceContract acting_substance) {
        this.acting_substance = acting_substance;
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

    private Long id;
    private ActingSubstanceContract acting_substance;
    private String kind_of_interaction;
    private String clinical_consequence;

    public Interaction toEntity() {
        Interaction interaction = new Interaction();
        interaction.setKind_of_interaction(kind_of_interaction);
        interaction.setId(id);
        interaction.setClinical_consequence(clinical_consequence);
        interaction.setActingSubstance(acting_substance.toEntity());
        return interaction;
    }
}
