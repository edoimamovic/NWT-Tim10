package com.etfmovies.videostream.service_interfaces;

import com.etfmovies.videostream.models.Video;

public interface IVideoService {
    String serveVideo(Integer videoId);
    Boolean addVideo(Video video);
}
