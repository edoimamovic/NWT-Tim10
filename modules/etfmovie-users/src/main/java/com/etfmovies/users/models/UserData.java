package com.etfmovies.users.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
public class UserData {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 1, max = 50)
    private String firstName;

    @NotNull
    @Size(min = 1, max = 50)
    private String lastName;

    @NotNull
    @Past
    private Date birthDate;

    @NotNull
    @Pattern(regexp=".*@.*\\..*")
    private String email;

    @NotNull
    @Size(min = 5, max = 30)
    private String password;

    @NotNull
    private Boolean isActive;

    @NotNull
    private Long role_id;

    @OneToMany(mappedBy = "user_id")
    private List<Review> reviews;

    @OneToMany(mappedBy = "user_id")
    private List<Favourite> favourites;

    public UserData(){ }

    public UserData(@NotNull String firstName, @NotNull String lastname, @NotNull String email) {
        this.firstName = firstName;
        this.lastName = lastname;
        this.email = email;
    }

    public UserData(@NotNull String firstName, @NotNull String lastname, @NotNull Date birthDate, @NotNull String email, @NotNull String password, @NotNull Long role_id) {
        this.firstName = firstName;
        this.lastName = lastname;
        this.birthDate = birthDate;
        this.email = email;
        this.password = password;
        this.isActive = false;
        this.role_id = role_id;
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

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public List<Favourite> getFavourites() {
        return favourites;
    }

    public void setFavourites(List<Favourite> favourites) {
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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
