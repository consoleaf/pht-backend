package com.example.demo.contract;

import com.example.demo.model.entities.Video;

public class VideoContract {
    private Long id;
    private String title;
    private String url;

    public VideoContract(Video video) {
        setId(video.getId());
        setTitle(video.getTitle());
        setUrl(video.getUrl());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
