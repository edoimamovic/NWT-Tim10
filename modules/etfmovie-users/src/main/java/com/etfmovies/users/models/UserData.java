package com.etfmovies.users.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class UserData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private String email;

    @NotNull
    private String password;

    @NotNull
    private Boolean isActive;

    @NotNull
    private Long role_id;

    @OneToMany(mappedBy = "user_id")
    private List<Reviews> reviews;

    @OneToMany(mappedBy = "user_id")
    private List<Favourites> favourites;

    public UserData(){ }

    public UserData(@NotNull String firstName, @NotNull String lastname, @NotNull String email) {
        this.firstName = firstName;
        this.lastName = lastname;
        this.email = email;
    }

    public UserData(@NotNull String firstName, @NotNull String lastname, @NotNull String email, @NotNull String password) {
        this.firstName = firstName;
        this.lastName = lastname;
        this.email = email;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Reviews> getReviews() {
        return reviews;
    }

    public void setReviews(List<Reviews> reviews) {
        this.reviews = reviews;
    }

    public List<Favourites> getFavourites() {
        return favourites;
    }

    public void setFavourites(List<Favourites> favourites) {
        this.favourites = favourites;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Long getRole_id() {
        return role_id;
    }

    public void setRole_id(Long role_id) {
        this.role_id = role_id;
    }
}
