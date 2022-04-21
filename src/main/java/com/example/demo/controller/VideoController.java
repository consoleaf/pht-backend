package com.example.demo.controller;

import com.example.demo.contract.VideoContract;
import com.example.demo.exceptions.BadRequestException;
import com.example.demo.model.entities.Video;
import com.example.demo.repositories.VideoRepository;
import com.example.demo.services.implementations.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/videos")
public class VideoController {
    @Autowired
    private VideoRepository repository;
    @Autowired
    private VideoService service;

    @GetMapping
    public ResponseEntity<List<VideoContract>> getVideos() {
        List<Video> items = (List<Video>) repository.findAll();
        var videos = items.stream().map(VideoContract::new).collect(Collectors.toUnmodifiableList());
        return new ResponseEntity<>(videos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<VideoContract> createVideo(@RequestBody VideoContract contract) {
        if (contract.getId() != null)
            throw new BadRequestException();
        var res = service.updateOrCreate(contract);
        return new ResponseEntity<>(new VideoContract(res), HttpStatus.CREATED);
    }

    @PostMapping
    public ResponseEntity<VideoContract> updateVideo(@RequestBody VideoContract contract) {
        if (contract.getId() == null)
            throw new BadRequestException();
        var res = service.updateOrCreate(contract);
        return new ResponseEntity<>(new VideoContract(res), HttpStatus.CREATED);
    }

}
