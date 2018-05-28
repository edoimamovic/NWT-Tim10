package com.etfmovies.videoinfo.controllers;

import com.etfmovies.videoinfo.models.Category;
import com.etfmovies.videoinfo.models.Video;
import com.etfmovies.videoinfo.models.VideoImage;
import com.etfmovies.videoinfo.services.VideoInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "/video")
public class VideoInfoController {

    @Autowired
    private VideoInfoService videoInfoService;

    @RequestMapping(path = "/data")
    ResponseEntity Search(Long id) {
        if (id < 0) {
            return new ResponseEntity("Id must be provided as a positive integer.", HttpStatus.BAD_REQUEST);
        }

        return ResponseEntity.ok().body(videoInfoService.getInfo(id));
    }

    @RequestMapping(path = "/search")
    ResponseEntity Search(String string) {
        if (string == null) {
            return new ResponseEntity("Search string must be provided.", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(videoInfoService.searchVideos(string), HttpStatus.OK);
    }

    @RequestMapping("/get-rating")
    Long getVideoRating(Long id){
        return videoInfoService.getVideoRating(id);
    }


    List<VideoImage> getVideoImages(Long id){
        return videoInfoService.getVideoImages(id);
    }

    @RequestMapping(path = "/uploadedBy")
    ResponseEntity UploadedBy(Long id) {
        if (id < 0) {
            return new ResponseEntity("Id must be provided as a positive integer.", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity(videoInfoService.getUsersVideos(id), HttpStatus.OK);
    }

    @RequestMapping(path = "/delete", method = RequestMethod.DELETE)
    ResponseEntity Delete(Long id) {
        if (id < 0) {
            return new ResponseEntity("Id must be provided as a positive integer.", HttpStatus.BAD_REQUEST);
        }

        videoInfoService.deleteVideo(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @RequestMapping("/getAllCategories")
    public List<Category> getAllCategories(){
        return videoInfoService.getAllCategories();
    }

    @RequestMapping("/getVideosByCategory/{category}")
    public List<Video> getVideosByCategory(@PathVariable("category") String category){
        return videoInfoService.getVideosByCategory(category);
    }
}
