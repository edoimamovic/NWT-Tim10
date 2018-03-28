package com.etfmovies.videoinfo.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class VideoData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getBitRate() {
        return bitRate;
    }

    public void setBitRate(Integer bitRate) {
        this.bitRate = bitRate;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    @NotNull
    private Integer length;

    @NotNull
    private Integer bitRate;

    @NotNull
    private String format;

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    @OneToOne
    @JoinColumn(name = "videoId")
    @JsonBackReference
    @NotNull
    private Video video;


    public String getDiskPath() {
        return diskPath;
    }

    public void setDiskPath(String diskPath) {
        this.diskPath = diskPath;
    }

    @NotNull
    private String diskPath;

    public VideoData(){
    }

    public VideoData(@NotNull Integer length, @NotNull Integer bitRate, @NotNull String format, @NotNull Video video, @NotNull String diskPath) {
        this.length = length;
        this.bitRate = bitRate;
        this.format = format;
        this.video = video;
        this.diskPath = diskPath;
    }
}
