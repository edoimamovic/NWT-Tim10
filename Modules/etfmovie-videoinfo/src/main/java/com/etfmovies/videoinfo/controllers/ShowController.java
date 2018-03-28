package com.etfmovies.videoinfo.controllers;

import com.etfmovies.videoinfo.models.Episode;
import com.etfmovies.videoinfo.models.Video;
import com.etfmovies.videoinfo.services.ShowsService;
import com.etfmovies.videoinfo.services.VideoInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path="/shows")
public class ShowController {

    @Autowired
    private ShowsService showsService;

    @RequestMapping(path="/episodes")
    List<Episode> Episodes(Long id)
    {
        return showsService.getEpisodes(id);
    }

    @RequestMapping(path="/season")
    List<Episode> Episodes(Long id, int season)
    {
        return showsService.getEpisodes(id, season);
    }
}
