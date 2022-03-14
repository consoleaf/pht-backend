package com.example.demo.contract;

import java.io.Serializable;

import com.example.demo.model.entities.Drug;

public class FoodInfoContract implements Serializable {
    public FoodInfoContract() {
    }

    public FoodInfoContract(Drug drug) {
        this.setRecommendations(drug.getFood_recommendations());
        this.setComment(drug.getFood_comment());
    }

    public String getRecommendations() {
        return recommendations;
    }

    public void setRecommendations(String recommendations) {
        this.recommendations = recommendations;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    private String recommendations;
    private String comment;
}
