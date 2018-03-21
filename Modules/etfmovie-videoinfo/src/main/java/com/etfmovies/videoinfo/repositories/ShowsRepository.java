package com.etfmovies.videoinfo.repositories;

import com.etfmovies.videoinfo.models.Film;
import com.etfmovies.videoinfo.models.Show;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ShowsRepository extends CrudRepository<Show, Long> {
    List<Show> findAll();
    Show findByTitle(String title);
}
