package com.etfmovies.videoinfo.service_interfaces;

import com.etfmovies.videoinfo.models.Category;
import com.etfmovies.videoinfo.models.Video;
import com.etfmovies.videoinfo.models.VideoImage;
import com.etfmovies.videoinfo.utils.VideoInfoResponseObject;

import java.util.List;

public interface IVideoInfoService {
    VideoInfoResponseObject getInfo(Long videoId);
    Boolean deleteVideo(Long videoId);
    List<Video> searchVideos(String query);
    List<Video> getUsersVideos(Long userId);
    Long getVideoRating(Long id);
    List<VideoImage> getVideoImages(Long videoId);
    List<Category> getAllCategories();
    List<Video> getVideosByCategory(String category);
}
