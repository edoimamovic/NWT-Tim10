package com.etfmovies.videoinfo.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
public class Show {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        title = title;
    }

    public Show(@NotNull String title) {
        title = title;
    }
    public Show(){
    }
    @NotNull
	@Size(min = 0, max = 250)
    private String title;

}
