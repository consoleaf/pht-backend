package com.example.demo.contract;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.model.entities.Drug;

public class DrugContract implements Serializable {
    private Long id;

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

    public LiverDosageInfoContract getLiverDosageInfo() {
        return liverDosageInfo;
    }

    public void setLiverDosageInfo(LiverDosageInfoContract liverDosageInfo) {
        this.liverDosageInfo = liverDosageInfo;
    }

    public FoodInfoContract getFoodInfo() {
        return foodInfo;
    }

    public void setFoodInfo(FoodInfoContract foodInfo) {
        this.foodInfo = foodInfo;
    }

    private String pharm_dynamics;
    private List<PharmKineticContract> pharm_kinetics;
    private List<SideEffectContract> side_effects;
    private String contraindications;
    private String role_in_treatment;

    private List<DosageContract> dosages;
    private List<InteractionContract> interactions;

    private PregnancyInfoContract pregnancy_info;
    private LiverDosageInfoContract liverDosageInfo;
    private FoodInfoContract foodInfo;

    public static DrugContract fromDrug(Drug drug) {
        var res = new DrugContract(drug);
        return res;
    }

    public DrugContract() {
    }

    private DrugContract(Drug drug) {
        this.contraindications = drug.getContraindications();
        this.dosages = drug.getDosages().stream().map(dosage -> new DosageContract(dosage))
                .collect(Collectors.toList());
        this.first_line = drug.getFirst_line();
        this.foodInfo = new FoodInfoContract(drug);
        this.id = drug.getId();
        this.inp_name = drug.getInp_name();
        this.interactions = drug.getInteractions().stream().map(interaction -> new InteractionContract(interaction))
                .collect(Collectors.toList());
        this.liverDosageInfo = new LiverDosageInfoContract(drug);
        this.pharm_dynamics = drug.getPharm_dynamics();
        this.pharm_kinetics = drug.getPharm_kinetics().stream().map(kin -> new PharmKineticContract(kin))
                .collect(Collectors.toList());
        this.pregnancy_info = new PregnancyInfoContract(drug);
        this.role_in_treatment = drug.getRole_in_treatment();
        this.side_effects = drug.getSide_effects().stream().map(eff -> new SideEffectContract(eff))
                .collect(Collectors.toList());
        this.trade_names = drug.getTrade_names().stream().map(nam -> new TradeNameContract(nam))
                .collect(Collectors.toList());
    }

    public Drug toDrug() {
        Drug drug = new Drug();
        drug.setContraindications(contraindications);
        drug.setCreatinine_based_dosages(this.liverDosageInfo.getCreatinine_based_dosages().stream()
                .map(v -> v.toEntity()).collect(Collectors.toSet()));
        drug.setDosages(this.dosages.stream().map(v -> v.toEntity()).collect(Collectors.toSet()));
        drug.setDose_change_prerequisites(liverDosageInfo.getDose_change_prerequisites());
        drug.setFda_category(pregnancy_info.getFda_category());
        drug.setFirst_line(first_line);
        drug.setFood_comment(foodInfo.getComment());
        drug.setFood_recommendations(foodInfo.getRecommendations());
        drug.setId(id);
        drug.setInp_name(inp_name);
        drug.setInteractions(interactions.stream().map(i -> i.toEntity()).collect(Collectors.toSet()));
        drug.setPharm_dynamics(pharm_dynamics);
        drug.setPharm_kinetics(pharm_kinetics.stream().map(i -> i.toEntity()).collect(Collectors.toSet()));
        drug.setPregnancy_additional_info(pregnancy_info.getAdditional_info());
        drug.setPregnancy_usage(pregnancy_info.getUsage());
        drug.setRole_in_treatment(role_in_treatment);
        drug.setSide_effects(side_effects.stream().map(i -> i.toEntity()).collect(Collectors.toSet()));
        return drug;
    }
}
