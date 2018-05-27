package com.etfmovies.videoinfo.repositories;

import com.etfmovies.videoinfo.models.Video;
import com.etfmovies.videoinfo.models.VideoImage;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VideoImageRepository extends CrudRepository<VideoImage, Long> {
    List<VideoImage> findAll();
    List<VideoImage> findByVideo(Video video);
}
