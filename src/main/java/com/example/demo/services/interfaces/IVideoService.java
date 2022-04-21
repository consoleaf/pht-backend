package com.example.demo.services.interfaces;

import com.example.demo.contract.VideoContract;
import com.example.demo.model.entities.Video;

public interface IVideoService {
    Video updateOrCreate(VideoContract contract);
}
