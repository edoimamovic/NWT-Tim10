package com.etfmovies.users.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Favourites {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String videoId;

    @NotNull
    private Long user_id;

    public Favourites(@NotNull String videoId) {
        this.videoId = videoId;
    }

    public Favourites() { }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }
}
