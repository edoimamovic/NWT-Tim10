package com.etfmovies.videoinfo.services;

import com.etfmovies.videoinfo.models.Video;
import com.etfmovies.videoinfo.repositories.VideoRepository;
import com.etfmovies.videoinfo.service_interfaces.IVideoInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoInfoService implements IVideoInfoService {
    @Autowired
    private VideoRepository videoRepository;

    @Override
    public List<Video> searchVideos(String query) {
        return videoRepository.findByTitleContaining(query);
    }

    @Override
    public Boolean deleteVideo(Long videoId) {
         videoRepository.deleteById(videoId);
         return true;
    }

    @Override
    public Video getInfo(Long videoId) {
        return videoRepository.findById(videoId).get();
    }
}

