package com.etfmovies.videostream.repositories;

import com.etfmovies.videostream.models.Video;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VideoRepository extends CrudRepository<Video, Long> {
    List<Video> findAll();
//    Video findById(Long videoId);
}
