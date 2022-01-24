package com.mor.photoapp.api.users.ui.model;

import com.mor.photoapp.api.users.shared.AlbumsResponseInUser;

import java.util.List;

public class UserResponse {
    private String firstName;
    private String lastName;
    private String email;
    private List<AlbumsResponseInUser> albumsList;

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

    public List<AlbumsResponseInUser> getAlbumsList() {
        return albumsList;
    }

    public void setAlbumsList(List<AlbumsResponseInUser> albumsList) {
        this.albumsList = albumsList;
    }
}
