package com.mor.photoapp.api.albums.ui.model;

import javax.persistence.*;

@Entity
@Table(name="albums")
public class AlbumEntity {

    @Id
    @GeneratedValue
    @Column(name="album_id")
    private long albumId;

    @Column(name="user_id")
    private long userId;

    @Column(name="album_name")
    private String albumName;

    @Column(name="album_description")
    private String albumDescription;

    public long getAlbumId() {
        return albumId;
    }

    public void setAlbumId(long albumId) {
        this.albumId = albumId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getAlbumDescription() {
        return albumDescription;
    }

    public void setAlbumDescription(String albumDescription) {
        this.albumDescription = albumDescription;
    }
}
