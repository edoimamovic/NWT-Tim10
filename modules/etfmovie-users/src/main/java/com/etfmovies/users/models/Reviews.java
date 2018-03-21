package com.etfmovies.users.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Reviews {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String review;

    public Reviews(@NotNull String review) {
        this.review = review;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}
