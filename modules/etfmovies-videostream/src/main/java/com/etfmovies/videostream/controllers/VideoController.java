package com.etfmovies.videostream.controllers;

import com.etfmovies.videostream.services.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(path="/video")
public class VideoController {
    @Autowired
    private VideoService videoService;

    @RequestMapping(value="/getUrl")
    public ResponseEntity getVideoUrl(@RequestParam("id") Long id) {
        if (id == null || id <= 0){
            return new ResponseEntity("Id must be provided as a positive integer.", HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(videoService.serveVideo(id));
    }
}
