package com.etfmovies.videoinfo.repositories;

import com.etfmovies.videoinfo.models.VideoData;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VideoDataRepository extends CrudRepository<VideoData, Long> {
    List<VideoData> findAll();
}
