package com.etfmovies.videoinfo.repositories;

import com.etfmovies.videoinfo.models.Category;
import com.etfmovies.videoinfo.models.Video;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface VideoRepository extends CrudRepository<Video, Long> {
    List<Video> findAll();
    Video findByTitle(String title);
    List<Video> findByTitleContaining(String title);
    List<Video> findVideosByUploadedBy(Long id);
    List<Video> findByCategory(Category category);
    void deleteById(Long id);
}
