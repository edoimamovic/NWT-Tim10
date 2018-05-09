package com.etfmovies.videoinfo.repositories;

import com.etfmovies.videoinfo.models.Episode;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EpisodesRepository extends CrudRepository<Episode, Long> {

    List<Episode> findAllByShowIdAndSeason(Long showId, int season);

    List<Episode> findAllByShowId(Long showId);

    List<Episode> findAllByShowTitle(String title);


}
