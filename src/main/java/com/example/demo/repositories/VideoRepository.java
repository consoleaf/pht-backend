package com.example.demo.repositories;

import com.example.demo.model.entities.Video;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface VideoRepository extends PagingAndSortingRepository<Video, Long> {
}
