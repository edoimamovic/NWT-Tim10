package com.etfmovies.videoinfo.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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
    private String title;

    @NotNull
    private Long uploadedBy;

    @NotNull
    private Date uploadDate;

    @OneToOne(mappedBy = "video", orphanRemoval = true)
    @JsonManagedReference
    private VideoData videoData;


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

    public Video(){
    }

    public Video(@NotNull String title, @NotNull Long uploadedBy, @NotNull Date uploadDate) {
        title = title;
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
}
