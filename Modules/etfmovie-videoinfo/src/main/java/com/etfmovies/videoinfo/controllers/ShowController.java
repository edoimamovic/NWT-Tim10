package com.etfmovies.videoinfo.controllers;

import com.etfmovies.videoinfo.services.ShowsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping(path = "/shows")
public class ShowController {

    @Autowired
    private ShowsService showsService;

    @RequestMapping(path = "/episodes")
    ResponseEntity Episodes(Long id) {
        if (id < 0 || id == null) {
            return new ResponseEntity("Id must be provided as a positive integer.", HttpStatus.BAD_REQUEST);
        }

        return ResponseEntity.ok().body(showsService.getEpisodes(id));
    }

    @RequestMapping(path = "/season")
    ResponseEntity Episodes(Long id, int season) {
        if (id < 0 || id == null) {
            return new ResponseEntity("Id must be provided as a positive integer.", HttpStatus.BAD_REQUEST);
        }

        return ResponseEntity.ok().body(showsService.getEpisodes(id, season));
    }
}
