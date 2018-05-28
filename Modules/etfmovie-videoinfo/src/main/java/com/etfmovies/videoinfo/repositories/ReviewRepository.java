package com.etfmovies.videoinfo.repositories;

import com.etfmovies.videoinfo.models.Review;
import com.etfmovies.videoinfo.models.Show;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReviewRepository extends CrudRepository<Review, Long> {
    List<Review> findAll();
    List<Review> getAllByVideoId(Long id);
}
