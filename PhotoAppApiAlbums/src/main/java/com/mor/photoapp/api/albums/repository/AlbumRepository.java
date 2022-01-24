package com.mor.photoapp.api.albums.repository;

import com.mor.photoapp.api.albums.ui.model.AlbumEntity;
import com.mor.photoapp.api.albums.ui.model.AlbumResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlbumRepository extends JpaRepository<AlbumEntity, Long> {

    List<AlbumEntity> findByUserId(Long userId);

}
