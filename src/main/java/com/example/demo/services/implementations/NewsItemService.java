package com.example.demo.services.implementations;

import com.example.demo.contract.NewsItemContract;
import com.example.demo.model.entities.Feedback;
import com.example.demo.model.entities.NewsItem;
import com.example.demo.repositories.NewsItemRepository;
import com.example.demo.services.interfaces.INewsItemService;
import com.example.demo.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NewsItemService implements INewsItemService {
    @Autowired
    private NewsItemRepository repository;

    @Override
    public NewsItem updateOrCreate(NewsItemContract contract) {
        NewsItem newsItem =
                repository.findById(Optional.ofNullable(contract.getId()).orElse(-1L)).orElseGet(NewsItem::new);

        Util.assignIfNotNull(contract::getTitle, newsItem::setTitle);
        Util.assignIfNotNull(contract::getContent, newsItem::setContent);
        Util.assignIfNotNull(contract::getDate, newsItem::setDate);
        Util.assignIfNotNull(contract::getImage_url, newsItem::setImageUrl);

        return repository.save(newsItem);
    }
}
