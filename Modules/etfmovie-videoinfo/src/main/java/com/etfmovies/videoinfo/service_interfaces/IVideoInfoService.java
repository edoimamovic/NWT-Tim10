package com.etfmovies.videoinfo.service_interfaces;

import com.etfmovies.videoinfo.models.Video;

import java.util.List;

public interface IVideoInfoService {
    Video getInfo(Long videoId);

    Boolean deleteVideo(Long videoId);

    List<Video> searchVideos(String query);

    List<Video> getUsersVideos(Long userId);

    Long getVideoRating(Long id);
}
