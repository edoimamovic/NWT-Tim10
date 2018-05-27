package com.etfmovies.videoinfo.utils;

import com.etfmovies.videoinfo.models.Category;
import com.etfmovies.videoinfo.models.VideoData;
import com.etfmovies.videoinfo.models.VideoImage;

import java.util.Date;
import java.util.List;

public class VideoInfoResponseObject {
    public Long id;
    public String title;
    public String description;
    public Long uploadedBy;
    public String uploadedByUser;
    public Date uploadDate;
    public VideoData videoData;
    public Category category;
    public String url;
    public String thumbnailUrl;
    public Long rating;
    public List<VideoImage> images;

    public VideoInfoResponseObject(Long id, String title, String description, Long uploadedBy, String uploadedByUser, Date uploadDate, VideoData videoData, Category category, String url, String thumbnailUrl, Long rating, List<VideoImage> images) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.uploadedBy = uploadedBy;
        this.uploadedByUser = uploadedByUser;
        this.uploadDate = uploadDate;
        this.videoData = videoData;
        this.category = category;
        this.url = url;
        this.thumbnailUrl = thumbnailUrl;
        this.rating = rating;
        this.images = images;
    }
}
