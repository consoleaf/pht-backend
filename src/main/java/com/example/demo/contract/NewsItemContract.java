package com.example.demo.contract;

import com.example.demo.model.entities.NewsItem;

import java.sql.Timestamp;

public class NewsItemContract {
    private Long id;
    private String content;
    private Timestamp date;
    private String image_url;
    private String title;

    public NewsItemContract(NewsItem newsItem) {
        setId(newsItem.getId());
        setContent(newsItem.getContent());
        setDate(newsItem.getDate());
        setImage_url(newsItem.getImageUrl());
        setTitle(newsItem.getTitle());
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

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
