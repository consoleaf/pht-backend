package com.example.demo.contract;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.model.entities.Drug;

public class DrugContract implements Serializable {
    private Long id;

    private ActingSubstanceContract acting_substance;

    private Boolean first_line;
    private String inp_name;
    private List<TradeNameContract> trade_names;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getFirst_line() {
        return first_line;
    }

    public void setFirst_line(Boolean first_line) {
        this.first_line = first_line;
    }

    public String getInp_name() {
        return inp_name;
    }

    public void setInp_name(String inp_name) {
        this.inp_name = inp_name;
    }

    public List<TradeNameContract> getTrade_names() {
        return trade_names;
    }

    public void setTrade_names(List<TradeNameContract> trade_names) {
        this.trade_names = trade_names;
    }

    public String getPharm_dynamics() {
        return pharm_dynamics;
    }

    public void setPharm_dynamics(String pharm_dynamics) {
        this.pharm_dynamics = pharm_dynamics;
    }

    public List<PharmKineticContract> getPharm_kinetics() {
        return pharm_kinetics;
    }

    public void setPharm_kinetics(List<PharmKineticContract> pharm_kinetics) {
        this.pharm_kinetics = pharm_kinetics;
    }

    public List<SideEffectContract> getSide_effects() {
        return side_effects;
    }

    public void setSide_effects(List<SideEffectContract> side_effects) {
        this.side_effects = side_effects;
    }

    public String getContraindications() {
        return contraindications;
    }

    public void setContraindications(String contraindications) {
        this.contraindications = contraindications;
    }

    public String getRole_in_treatment() {
        return role_in_treatment;
    }

    public void setRole_in_treatment(String role_in_treatment) {
        this.role_in_treatment = role_in_treatment;
    }

    public List<DosageContract> getDosages() {
        return dosages;
    }

    public void setDosages(List<DosageContract> dosages) {
        this.dosages = dosages;
    }

    public List<InteractionContract> getInteractions() {
        return interactions;
    }

    public void setInteractions(List<InteractionContract> interactions) {
        this.interactions = interactions;
    }

    public PregnancyInfoContract getPregnancy_info() {
        return pregnancy_info;
    }

    public void setPregnancy_info(PregnancyInfoContract pregnancy_info) {
        this.pregnancy_info = pregnancy_info;
    }

    public LiverDosageInfoContract getLiver_dosage_info() {
        return liver_dosage_info;
    }

    public void setLiver_dosage_info(LiverDosageInfoContract liver_dosage_info) {
        this.liver_dosage_info = liver_dosage_info;
    }

    public FoodInfoContract getFood_info() {
        return food_info;
    }

    public void setFood_info(FoodInfoContract food_info) {
        this.food_info = food_info;
    }

    private String pharm_dynamics;
    private List<PharmKineticContract> pharm_kinetics;
    private List<SideEffectContract> side_effects;
    private String contraindications;
    private String role_in_treatment;

    private List<DosageContract> dosages;
    private List<InteractionContract> interactions;

    private PregnancyInfoContract pregnancy_info;
    private LiverDosageInfoContract liver_dosage_info;
    private FoodInfoContract food_info;

    public static DrugContract fromDrug(Drug drug) {
        var res = new DrugContract(drug);
        return res;
    }

    public DrugContract() {
    }

    private DrugContract(Drug drug) {
        this.acting_substance = new ActingSubstanceContract(drug.getActing_substance());
        this.contraindications = drug.getContraindications();
        this.dosages = drug.getDosages().stream().map(DosageContract::new)
                .collect(Collectors.toList());
        this.first_line = drug.getFirst_line();
        this.food_info = new FoodInfoContract(drug);
        this.id = drug.getId();
        this.inp_name = drug.getInp_name();
        this.interactions = drug.getInteractions().stream().map(InteractionContract::new)
                .collect(Collectors.toList());
        this.liver_dosage_info = new LiverDosageInfoContract(drug);
        this.pharm_dynamics = drug.getPharm_dynamics();
        this.pharm_kinetics = drug.getPharm_kinetics().stream().map(PharmKineticContract::new)
                .collect(Collectors.toList());
        this.pregnancy_info = new PregnancyInfoContract(drug);
        this.role_in_treatment = drug.getRole_in_treatment();
        this.side_effects = drug.getSide_effects().stream().map(SideEffectContract::new)
                .collect(Collectors.toList());
        this.trade_names = drug.getTrade_names().stream().map(TradeNameContract::new)
                .collect(Collectors.toList());
    }

    public ActingSubstanceContract getActing_substance() {
        return acting_substance;
    }

    public void setActing_substance(ActingSubstanceContract acting_substance) {
        this.acting_substance = acting_substance;
    }
}
