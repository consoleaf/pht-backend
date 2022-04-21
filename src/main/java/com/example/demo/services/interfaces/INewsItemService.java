package com.example.demo.services.interfaces;

import com.example.demo.contract.NewsItemContract;
import com.example.demo.model.entities.NewsItem;

public interface INewsItemService {
    NewsItem updateOrCreate(NewsItemContract contract);
}
