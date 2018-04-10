package com.etfmovies.videoinfo.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "videoId")
    @NotNull
    private Video video;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @ManyToOne
    @JoinColumn(name = "categoryId")
    @NotNull
    private Category category;

    public void setVideo(Video video) {
        this.video = video;
    }

    public Film(@NotNull Video video, @NotNull Category category) {
        this.video = video;
        this.category = category;
    }

    public Film() {
    }
}
