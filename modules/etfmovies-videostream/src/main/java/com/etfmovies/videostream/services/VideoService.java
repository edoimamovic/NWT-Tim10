package com.etfmovies.videostream.services;

import com.etfmovies.videostream.models.Video;
import com.etfmovies.videostream.repositories.VideoRepository;
import com.etfmovies.videostream.service_interfaces.IVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VideoService implements IVideoService {
    @Autowired
    private VideoRepository videoRepository;

    @Override
    public String serveVideo(Long videoId) {
        return videoRepository.findById(videoId).get().getPath();
    }
}
