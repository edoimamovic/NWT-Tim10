package com.etfmovies.videoinfo.repositories;

import com.etfmovies.videoinfo.models.Show;
import com.etfmovies.videoinfo.models.Video;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface ETFVideoVideoRepository extends CrudRepository<Video, Long>{
    List<Video> findAll();
}
