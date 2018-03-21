package com.etfmovies.videoinfo.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    @NotNull
    private String Title;

    @NotNull
    private Long uploadedBy;

    @NotNull
    private Date uploadDate;


    public Long getUploadedBy() {
        return uploadedBy;
    }

    public void setUploadedBy(Long uploadedBy) {
        uploadedBy = uploadedBy;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        uploadDate = uploadDate;
    }


    public Video(@NotNull String title, @NotNull Long uploadedBy, @NotNull Date uploadDate) {
        Title = title;
        this.uploadedBy = uploadedBy;
        this.uploadDate = uploadDate;
    }
}
