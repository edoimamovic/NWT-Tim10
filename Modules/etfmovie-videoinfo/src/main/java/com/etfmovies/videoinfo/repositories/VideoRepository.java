package com.etfmovies.videoinfo.repositories;

import com.etfmovies.videoinfo.models.Video;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface VideoRepository extends CrudRepository<Video, Long> {
    List<Video> findAll();

    List<Video> findByTitleContaining(String title);

    List<Video> findVideosByUploadedBy(Long id);

    void deleteById(Long id);
}
