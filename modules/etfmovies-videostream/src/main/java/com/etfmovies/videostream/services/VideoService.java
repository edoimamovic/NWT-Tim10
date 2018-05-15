package com.etfmovies.videostream.services;

import com.etfmovies.videostream.repositories.VideoRepository;
import com.etfmovies.videostream.service_interfaces.IVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideoService implements IVideoService {
    @Autowired
    private VideoRepository videoRepository;

    @Override
    public String serveVideo(Integer videoId) {
        return videoRepository.findByVideoId(videoId).getPath();
    }
}
