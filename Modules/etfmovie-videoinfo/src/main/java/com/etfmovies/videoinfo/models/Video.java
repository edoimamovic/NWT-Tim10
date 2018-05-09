package com.etfmovies.videoinfo.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        title = title;
    }

    @NotNull
    @Size(min = 0, max = 250)
    private String title;

    @NotNull
    private Long uploadedBy;

    @NotNull
    //@Past
    private Date uploadDate;

    @OneToOne(mappedBy = "video", orphanRemoval = true)
    @JsonManagedReference
    private VideoData videoData;

    @Transient
    private String url;

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

    public Video() {
    }

    public Video(@NotNull String title, @NotNull Long uploadedBy, @NotNull Date uploadDate) {
        this.title = title;
        this.uploadedBy = uploadedBy;
        this.uploadDate = uploadDate;
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
}
