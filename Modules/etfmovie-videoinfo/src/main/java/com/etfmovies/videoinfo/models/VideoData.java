package com.etfmovies.videoinfo.models;

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

    public VideoData getVideoData() {
        return videoData;
    }

    public void setVideoData(VideoData videoData) {
        this.videoData = videoData;
    }

    @OneToOne
    @JoinColumn(name = "videoDataId")
    @NotNull
    private VideoData videoData;


    public String getDiskPath() {
        return diskPath;
    }

    public void setDiskPath(String diskPath) {
        this.diskPath = diskPath;
    }

    @NotNull
    private String diskPath;

    public VideoData(@NotNull Integer length, @NotNull Integer bitRate, @NotNull String format, @NotNull VideoData videoData, @NotNull String diskPath) {
        this.length = length;
        this.bitRate = bitRate;
        this.format = format;
        this.videoData = videoData;
        this.diskPath = diskPath;
    }
}
