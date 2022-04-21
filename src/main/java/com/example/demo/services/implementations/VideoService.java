package com.example.demo.services.implementations;

import com.example.demo.contract.VideoContract;
import com.example.demo.model.entities.Feedback;
import com.example.demo.model.entities.Video;
import com.example.demo.repositories.VideoRepository;
import com.example.demo.services.interfaces.IVideoService;
import com.example.demo.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VideoService implements IVideoService {
    @Autowired
    private VideoRepository repository;

    @Override
    public Video updateOrCreate(VideoContract contract) {
        Video feedback =
                repository.findById(Optional.ofNullable(contract.getId()).orElse(-1L)).orElseGet(Video::new);

        Util.assignIfNotNull(contract::getTitle, feedback::setTitle);
        Util.assignIfNotNull(contract::getUrl, feedback::setUrl);

        return repository.save(feedback);
    }
}
