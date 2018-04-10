package com.etfmovies.videoinfo.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 10, max = 1000)
    private String reviewText;

    @NotNull
    @Past
    private Date date;

    @ManyToOne
    @JoinColumn(name = "videoId")
    @NotNull
    private Video video;

    @NotNull
    private Long reviewerId;

    public Review(@NotNull String lastname, @NotNull Date date, Long reviewerId) {
        this.reviewText = lastname;
        this.date = date;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public Long getReviewerId() {
        return reviewerId;
    }

    public void setReviewerId(Long reviewerId) {
        this.reviewerId = reviewerId;
    }

    public Review() {
    }
}
