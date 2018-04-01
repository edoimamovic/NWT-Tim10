package com.etfmovies.users.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Favourite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private @NotNull Long videoId;

    @NotNull
    private Long user_id;

    public Favourite(@NotNull Long videoId, @NotNull Long userId) {
        this.videoId = videoId;
        this.user_id = userId;
    }

    public Favourite() { }

    public @NotNull Long getVideoId() {
        return videoId;
    }

    public void setVideoId(@NotNull Long videoId) {
        this.videoId = videoId;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }
}
