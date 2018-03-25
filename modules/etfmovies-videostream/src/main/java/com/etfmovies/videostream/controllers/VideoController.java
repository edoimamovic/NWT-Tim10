package com.etfmovies.videostream.controllers;

import com.etfmovies.videostream.services.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping(path="/video")
public class VideoController {
    @Autowired
    private VideoService videoService;

    @RequestMapping(value="/getUrl")
    public String getVideoUrl(@RequestParam("id") Long id) {
        return videoService.serveVideo(id);
    }
}
