package com.etfmovies.videoinfo.service_interfaces;

import com.etfmovies.videoinfo.models.Episode;
import com.etfmovies.videoinfo.models.Show;

import java.util.List;

public interface IShowsService {
    List<Episode> getEpisodes(Long showId);
    List<Show>getShows();
    List<Episode> getEpisodes(Long showId, int season);
}
