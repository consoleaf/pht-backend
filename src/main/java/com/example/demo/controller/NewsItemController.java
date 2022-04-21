package com.example.demo.controller;

import com.example.demo.contract.NewsItemContract;
import com.example.demo.exceptions.BadRequestException;
import com.example.demo.model.entities.NewsItem;
import com.example.demo.repositories.NewsItemRepository;
import com.example.demo.services.implementations.NewsItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/news")
public class NewsItemController {
    @Autowired
    private NewsItemRepository repository;
    @Autowired
    private NewsItemService service;

    @GetMapping
    public ResponseEntity<List<NewsItemContract>> getNewsItems() {
        List<NewsItem> items = (List<NewsItem>) repository.findAll();
        var NewsItems = items.stream().map(NewsItemContract::new).collect(Collectors.toUnmodifiableList());
        return new ResponseEntity<>(NewsItems, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<NewsItemContract> createNewsItem(@RequestBody NewsItemContract contract) {
        if (contract.getId() != null)
            throw new BadRequestException();
        var res = service.updateOrCreate(contract);
        return new ResponseEntity<>(new NewsItemContract(res), HttpStatus.CREATED);
    }

    @PostMapping
    public ResponseEntity<NewsItemContract> updateNewsItem(@RequestBody NewsItemContract contract) {
        if (contract.getId() == null)
            throw new BadRequestException();
        var res = service.updateOrCreate(contract);
        return new ResponseEntity<>(new NewsItemContract(res), HttpStatus.CREATED);
    }
}
