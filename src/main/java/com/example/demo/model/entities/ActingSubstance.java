package com.example.demo.model.entities;

import javax.persistence.*;
import org.hibernate.annotations.DynamicUpdate;

import java.util.Set;

@Entity
@Table(name = "acting_substances")
public class ActingSubstance {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(columnDefinition = "TEXT") private String name;

  @OneToOne(mappedBy = "acting_substance")
  private Drug drug;

  @OneToMany(mappedBy = "actingSubstance", cascade = CascadeType.MERGE)
  private Set<Interaction> interactions;

  public Drug getDrug() { return drug; }

  public void setDrug(Drug drug) { this.drug = drug; }

  public Long getId() { return id; }

  public void setId(Long id) { this.id = id; }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((name == null) ? 0 : name.hashCode());
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
    ActingSubstance other = (ActingSubstance)obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    if (name == null) {
      return other.name == null;
    } else return name.equals(other.name);
  }

  public String getName() { return name; }

  public void setName(String name) { this.name = name; }


  public Set<Interaction> getInteractions() {
    return interactions;
  }

  public void setInteractions(Set<Interaction> interactions) {
    this.interactions = interactions;
  }
}
