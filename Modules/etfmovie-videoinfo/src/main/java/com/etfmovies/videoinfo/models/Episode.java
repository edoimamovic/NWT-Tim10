package com.etfmovies.videoinfo.models;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Min;
@Entity
public class Episode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
	@Min(1)
    private Integer season;

    @NotNull
	@Min(1)
    private Integer number;

    @ManyToOne
    @JoinColumn(name = "showId")
    @NotNull
    private Show show;


    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    @OneToOne
    @JoinColumn(name = "videoId")
    @NotNull
    private Video video;

    private String title;

    public Episode(@NotNull Integer season, @NotNull Integer number, String title, Show show, Video video) {
        this.season = season;
        this.number = number;
        this.title = title;
        this.show = show;
        this.video = video;
    }

    public Integer getSeason() {
        return season;
    }

    public void setSeason(Integer season) {
        this.season = season;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public Episode(){}
}
