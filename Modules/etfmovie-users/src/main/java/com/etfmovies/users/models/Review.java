package com.etfmovies.users.models;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 0, max = 1000)
    private String review;

    @NotNull
    @DecimalMin(value="1")
    @DecimalMax(value="5")
    private Integer rating;

    @NotNull
    private Long user_id;

    public Review() { }

    public Review(@NotNull String review, @NotNull Integer rating, @NotNull Long userId) {
        this.review = review;
        this.rating = rating;
        this.user_id = userId;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }
}
