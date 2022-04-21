package com.example.demo.contract;

import com.example.demo.model.entities.Recommendation;

public class RecommendationContract {
    private Long id;
    private String content;
    private String title;

    public RecommendationContract(Recommendation recommendation) {
        setId(recommendation.getId());
        setContent(recommendation.getContent());
        setTitle(recommendation.getTitle());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
