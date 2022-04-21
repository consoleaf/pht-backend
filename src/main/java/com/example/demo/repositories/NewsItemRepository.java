package com.example.demo.repositories;

import com.example.demo.model.entities.NewsItem;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsItemRepository extends PagingAndSortingRepository<NewsItem, Long> {
}
