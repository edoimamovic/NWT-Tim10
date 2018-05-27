package com.etfmovies.videoinfo.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 0, max = 250)
    private String title;

    @Size(min = 0, max = 1000)
    private String description;

    @NotNull
    private Long uploadedBy;

    @Transient
    private String uploadedByUser;

    @NotNull
    private Date uploadDate;

    @OneToOne(mappedBy = "video", orphanRemoval = true)
    @JsonManagedReference
    private VideoData videoData;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @Transient
    private String url;

    private String thumbnailUrl;

    @OneToMany
    private List<VideoImage> images;

    public Video() {
    }

    public Video(@NotNull String title, @NotNull Long uploadedBy, @NotNull Date uploadDate, String thumbnailUrl, String description, Category category, List<VideoImage> images) {
        this.title = title;
        this.uploadedBy = uploadedBy;
        this.uploadDate = uploadDate;
        this.thumbnailUrl = thumbnailUrl;
        this.description = description;
        this.category = category;
        this.images = images;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        title = title;
    }

    public VideoData getVideoData() {
        return videoData;
    }

    public void setVideoData(VideoData videoData) {
        this.videoData = videoData;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUploadedByUser() {
        return uploadedByUser;
    }

    public void setUploadedByUser(String uploadedByUser) {
        this.uploadedByUser = uploadedByUser;
    }

    public Long getUploadedBy() {
        return uploadedBy;
    }

    public void setUploadedBy(Long uploadedBy) {
        uploadedBy = uploadedBy;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        uploadDate = uploadDate;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<VideoImage> getImages() {
        return images;
    }

    public void setImages(List<VideoImage> images) {
        this.images = images;
    }
}
