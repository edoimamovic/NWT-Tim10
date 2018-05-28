package com.etfmovies.videoinfo.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class VideoData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Min(1)
    @Max(1000)
    private Integer length;

    @NotNull
    @Min(16)
    @Max(11200000)
    private Integer bitRate;

    @NotNull
    @Size(min = 0, max = 100)
    private String format;

    @OneToOne
    @JoinColumn(name = "videoId")
    @JsonBackReference
    @NotNull
    private Video video;

    @NotNull
    @Size(min = 0, max = 1000000)
    private String diskPath;

    public VideoData() {
    }

    public VideoData(@NotNull Integer length, @NotNull Integer bitRate, @NotNull String format, @NotNull Video video, @NotNull String diskPath) {
        this.length = length;
        this.bitRate = bitRate;
        this.format = format;
        this.video = video;
        this.diskPath = diskPath;
    }

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

    public String getDiskPath() {
        return diskPath;
    }

    public void setDiskPath(String diskPath) {
        this.diskPath = diskPath;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }
}
