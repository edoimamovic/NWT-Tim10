package com.etfmovies.videoinfo.controllers;

import com.etfmovies.videoinfo.models.Video;
import com.etfmovies.videoinfo.services.VideoInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path="/video")
public class VideoInfoController {

    @Autowired
    private VideoInfoService videoInfoService;

    @RequestMapping(path="/data")
    Video Search(Long id){
        return videoInfoService.getInfo(id);
    }

    @RequestMapping(path="/search")
        List<Video> Search(String string){
        return videoInfoService.searchVideos(string);
    }

    @RequestMapping(path="/delete", method = RequestMethod.DELETE)
    Boolean Delete(Long id){
        videoInfoService.deleteVideo(id);
        return true;
    }

}
