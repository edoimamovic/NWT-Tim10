package com.etfmovies.videoinfo.repositories;

import com.etfmovies.videoinfo.models.Show;
import com.etfmovies.videoinfo.models.Video;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;


public interface VideoRepository extends CrudRepository<Video, Long>{
    List<Video> findAll();

    List<Video> findByTitleContaining(String title);

    void deleteById(Long id);
}
