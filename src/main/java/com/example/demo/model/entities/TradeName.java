package com.example.demo.model.entities;


import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@DynamicUpdate
@Table(name = "trade_names")
public class TradeName {
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((pharm_form == null) ? 0 : pharm_form.hashCode());
        result = prime * result + ((trade_name == null) ? 0 : trade_name.hashCode());
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
        TradeName other = (TradeName) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (pharm_form == null) {
            if (other.pharm_form != null)
                return false;
        } else if (!pharm_form.equals(other.pharm_form))
            return false;
        if (trade_name == null) {
            if (other.trade_name != null)
                return false;
        } else if (!trade_name.equals(other.trade_name))
            return false;
        return true;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "SERIAL")
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String trade_name;
    @Column(columnDefinition = "TEXT")
    private String pharm_form;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTrade_name() {
        return trade_name;
    }

    public void setTrade_name(String trade_name) {
        this.trade_name = trade_name;
    }

    public String getPharm_form() {
        return pharm_form;
    }

    public void setPharm_form(String pharm_form) {
        this.pharm_form = pharm_form;
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
