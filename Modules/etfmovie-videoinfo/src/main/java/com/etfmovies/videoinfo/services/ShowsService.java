package com.etfmovies.videoinfo.services;

import com.etfmovies.videoinfo.models.Episode;
import com.etfmovies.videoinfo.repositories.EpisodesRepository;
import com.etfmovies.videoinfo.repositories.ShowsRepository;
import com.etfmovies.videoinfo.repositories.VideoRepository;
import com.etfmovies.videoinfo.service_interfaces.IShowsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowsService implements IShowsService {
    @Autowired
    private VideoRepository vidRepository;

    @Autowired
    private EpisodesRepository epRepository;

    @Autowired
    private ShowsRepository showsRepository;


    @Override
    public List<Episode> getEpisodes(Long showId, int season) {
        try {
            return epRepository.findAllByShowIdAndSeason(showId, season);
        } catch (EmptyResultDataAccessException ex) {
            throw new EmptyResultDataAccessException("No show the with provided Id.", 1);
        }
    }

    @Override
    public List<Episode> getEpisodes(Long showId) {
        try {
            return epRepository.findAllByShowId(showId);
        } catch (EmptyResultDataAccessException ex) {
            throw new EmptyResultDataAccessException("No show the with provided Id.", 1);
        }
    }
}
