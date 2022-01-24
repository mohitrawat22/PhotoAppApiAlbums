package com.mor.photoapp.api.albums.service;

import com.mor.photoapp.api.albums.ui.model.AlbumRequest;
import com.mor.photoapp.api.albums.ui.model.AlbumResponse;

import java.util.List;

public interface IAlbumService {
    AlbumResponse createAlbum(AlbumRequest albumRequest);
    List<AlbumResponse> getUserAlbums(Long userId);
}
