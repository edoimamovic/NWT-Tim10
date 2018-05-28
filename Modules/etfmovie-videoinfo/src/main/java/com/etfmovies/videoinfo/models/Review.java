package com.etfmovies.videoinfo.models;

import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;

@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 1, max = 1000)
    private String reviewText;

    @Min(1)
    @Max(10)
    @NotNull
    private Integer reviewRating;

    @NotNull
    @Past
    private Date date;

    @ManyToOne
    @JoinColumn(name = "video_id")
    @NotNull
    private Video video;

    @NotNull
    private Long reviewerId;

    public Review() {
    }

    public Review(@NotNull String reviewText, @NotNull Date date, Long reviewerId, Integer reviewRating, Video video) {
        this.reviewText = reviewText;
        this.date = date;
        this.reviewerId = reviewerId;
        this.reviewRating = reviewRating;
        this.video = video;
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

    public Integer getReviewRating() {
        return reviewRating;
    }

    public void setReviewRating(Integer reviewRating) {
        this.reviewRating = reviewRating;
    }
}
