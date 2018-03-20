package com.etfmovies.users.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class ETFVideoUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String userName;

    @NotNull
    private String passwordHash;

    @NotNull
    private Boolean isActive; // User activated account using e-mail activation

    @NotNull
    @ManyToOne
    @JoinColumn(name="roleid")
    private UserRoles roleId;

    @NotNull
    @OneToOne
    @JoinColumn(name="personaldata")
    private PersonalData personalData;

    public ETFVideoUser(@NotNull String username, @NotNull String passwordhash, @NotNull Boolean isactive, @NotNull UserRoles role, @NotNull PersonalData personalData) {
        this.userName = username;
        this.passwordHash = passwordhash;
        this.isActive = isactive;
        this.roleId = role;
        this.personalData = personalData;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public UserRoles getRoleId() {
        return roleId;
    }

    public void setRoleId(UserRoles roleId) {
        this.roleId = roleId;
    }

    public PersonalData getPersonalData() {
        return personalData;
    }

    public void setPersonalData(PersonalData personalData) {
        this.personalData = personalData;
    }
}
