package com.example.demo.model.entities;

import java.util.Set;
import javax.persistence.*;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicUpdate
@Table(name = "drugs")
public class Drug {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column()
  private Long id;

  public Drug() {
  }

  private Boolean first_line;
  @Column(columnDefinition = "TEXT")
  private String inp_name;
  @OneToMany(mappedBy = "drug", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<TradeName> trade_names;
  @Column(columnDefinition = "TEXT")
  private String pharm_dynamics;

  @OneToMany(mappedBy = "drug", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<PharmKinetic> pharm_kinetics;
  @OneToMany(mappedBy = "drug", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<SideEffect> side_effects;
  @Column(columnDefinition = "TEXT")
  private String contraindications;
  @Column(columnDefinition = "TEXT")
  private String role_in_treatment;
  @OneToMany(mappedBy = "drug", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<Dosage> dosages;

  // Pregnancy info
  @Column(columnDefinition = "TEXT")
  private String fda_category;
  @Column(columnDefinition = "TEXT")
  private String pregnancy_usage;
  @Column(columnDefinition = "TEXT")
  private String pregnancy_additional_info;

  @OneToMany(mappedBy = "drug", orphanRemoval = true, cascade = CascadeType.ALL)
  private Set<Interaction> interactions;

  // Liver condition based dosage info
  @Column(columnDefinition = "TEXT")
  private String dose_change_prerequisites;
  @OneToMany(mappedBy = "drug", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<CreatinineBasedDosage> creatinine_based_dosages;

  // Food info
  @Column(columnDefinition = "TEXT")
  private String food_recommendations;
  @Column(columnDefinition = "TEXT")
  private String food_comment;

  @JoinColumn(name = "acting_substance", referencedColumnName = "id")
  @OneToOne(cascade = {CascadeType.ALL}, orphanRemoval = false)
  private ActingSubstance acting_substance;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Set<TradeName> getTrade_names() {
    return trade_names;
  }

  public void setTrade_names(Set<TradeName> trade_names) {
    this.trade_names = trade_names;
  }

  public Set<PharmKinetic> getPharm_kinetics() {
    return pharm_kinetics;
  }

  public void setPharm_kinetics(Set<PharmKinetic> pharm_kinetics) {
    this.pharm_kinetics = pharm_kinetics;
  }

  public Set<SideEffect> getSide_effects() {
    return side_effects;
  }

  public void setSide_effects(Set<SideEffect> side_effects) {
    this.side_effects = side_effects;
  }

  public Set<Dosage> getDosages() {
    return dosages;
  }

  public void setDosages(Set<Dosage> dosages) {
    this.dosages = dosages;
  }

  public Set<Interaction> getInteractions() {
    return interactions;
  }

  public void setInteractions(Set<Interaction> interactions) {
    this.interactions = interactions;
  }

  public Set<CreatinineBasedDosage> getCreatinine_based_dosages() {
    return creatinine_based_dosages;
  }

  public void setCreatinine_based_dosages(Set<CreatinineBasedDosage> creatinine_based_dosages) {
    this.creatinine_based_dosages = creatinine_based_dosages;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((contraindications == null) ? 0 : contraindications.hashCode());
    result = prime * result + ((creatinine_based_dosages == null) ? 0 : creatinine_based_dosages.hashCode());
    result = prime * result + ((dosages == null) ? 0 : dosages.hashCode());
    result = prime * result + ((dose_change_prerequisites == null) ? 0 : dose_change_prerequisites.hashCode());
    result = prime * result + ((fda_category == null) ? 0 : fda_category.hashCode());
    result = prime * result + ((first_line == null) ? 0 : first_line.hashCode());
    result = prime * result + ((food_comment == null) ? 0 : food_comment.hashCode());
    result = prime * result + ((food_recommendations == null) ? 0 : food_recommendations.hashCode());
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((inp_name == null) ? 0 : inp_name.hashCode());
    result = prime * result + ((interactions == null) ? 0 : interactions.hashCode());
    result = prime * result + ((pharm_dynamics == null) ? 0 : pharm_dynamics.hashCode());
    result = prime * result + ((pharm_kinetics == null) ? 0 : pharm_kinetics.hashCode());
    result = prime * result + ((pregnancy_additional_info == null) ? 0 : pregnancy_additional_info.hashCode());
    result = prime * result + ((pregnancy_usage == null) ? 0 : pregnancy_usage.hashCode());
    result = prime * result + ((role_in_treatment == null) ? 0 : role_in_treatment.hashCode());
    result = prime * result + ((side_effects == null) ? 0 : side_effects.hashCode());
    result = prime * result + ((trade_names == null) ? 0 : trade_names.hashCode());
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
    Drug other = (Drug) obj;
    if (contraindications == null) {
      if (other.contraindications != null)
        return false;
    } else if (!contraindications.equals(other.contraindications))
      return false;
    if (creatinine_based_dosages == null) {
      if (other.creatinine_based_dosages != null)
        return false;
    } else if (!creatinine_based_dosages.equals(other.creatinine_based_dosages))
      return false;
    if (dosages == null) {
      if (other.dosages != null)
        return false;
    } else if (!dosages.equals(other.dosages))
      return false;
    if (dose_change_prerequisites == null) {
      if (other.dose_change_prerequisites != null)
        return false;
    } else if (!dose_change_prerequisites.equals(other.dose_change_prerequisites))
      return false;
    if (fda_category == null) {
      if (other.fda_category != null)
        return false;
    } else if (!fda_category.equals(other.fda_category))
      return false;
    if (first_line == null) {
      if (other.first_line != null)
        return false;
    } else if (!first_line.equals(other.first_line))
      return false;
    if (food_comment == null) {
      if (other.food_comment != null)
        return false;
    } else if (!food_comment.equals(other.food_comment))
      return false;
    if (food_recommendations == null) {
      if (other.food_recommendations != null)
        return false;
    } else if (!food_recommendations.equals(other.food_recommendations))
      return false;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    if (inp_name == null) {
      if (other.inp_name != null)
        return false;
    } else if (!inp_name.equals(other.inp_name))
      return false;
    if (interactions == null) {
      if (other.interactions != null)
        return false;
    } else if (!interactions.equals(other.interactions))
      return false;
    if (pharm_dynamics == null) {
      if (other.pharm_dynamics != null)
        return false;
    } else if (!pharm_dynamics.equals(other.pharm_dynamics))
      return false;
    if (pharm_kinetics == null) {
      if (other.pharm_kinetics != null)
        return false;
    } else if (!pharm_kinetics.equals(other.pharm_kinetics))
      return false;
    if (pregnancy_additional_info == null) {
      if (other.pregnancy_additional_info != null)
        return false;
    } else if (!pregnancy_additional_info.equals(other.pregnancy_additional_info))
      return false;
    if (pregnancy_usage == null) {
      if (other.pregnancy_usage != null)
        return false;
    } else if (!pregnancy_usage.equals(other.pregnancy_usage))
      return false;
    if (role_in_treatment == null) {
      if (other.role_in_treatment != null)
        return false;
    } else if (!role_in_treatment.equals(other.role_in_treatment))
      return false;
    if (side_effects == null) {
      if (other.side_effects != null)
        return false;
    } else if (!side_effects.equals(other.side_effects))
      return false;
    if (trade_names == null) {
      return other.trade_names == null;
    } else return trade_names.equals(other.trade_names);
  }

  public String getInp_name() {
    return inp_name;
  }

  public void setInp_name(String inp_name) {
    this.inp_name = inp_name;
  }

  public Boolean getFirst_line() {
    return first_line;
  }

  public void setFirst_line(Boolean first_line) {
    this.first_line = first_line;
  }

  public String getFda_category() {
    return fda_category;
  }

  public void setFda_category(String fda_category) {
    this.fda_category = fda_category;
  }

  public String getFood_comment() {
    return food_comment;
  }

  public void setFood_comment(String food_comment) {
    this.food_comment = food_comment;
  }

  public String getPharm_dynamics() {
    return pharm_dynamics;
  }

  public void setPharm_dynamics(String pharm_dynamics) {
    this.pharm_dynamics = pharm_dynamics;
  }

  public String getPregnancy_usage() {
    return pregnancy_usage;
  }

  public void setPregnancy_usage(String pregnancy_usage) {
    this.pregnancy_usage = pregnancy_usage;
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

  public String getFood_recommendations() {
    return food_recommendations;
  }

  public void setFood_recommendations(String food_recommendations) {
    this.food_recommendations = food_recommendations;
  }

  public String getPregnancy_additional_info() {
    return pregnancy_additional_info;
  }

  public void setPregnancy_additional_info(String pregnancy_additional_info) {
    this.pregnancy_additional_info = pregnancy_additional_info;
  }

  public String getDose_change_prerequisites() {
    return dose_change_prerequisites;
  }

  public void setDose_change_prerequisites(String dose_change_prerequisites) {
    this.dose_change_prerequisites = dose_change_prerequisites;
  }

  public ActingSubstance getActing_substance() {
    return acting_substance;
  }

  public void setActing_substance(ActingSubstance acting_substance) {
    this.acting_substance = acting_substance;
  }
}
