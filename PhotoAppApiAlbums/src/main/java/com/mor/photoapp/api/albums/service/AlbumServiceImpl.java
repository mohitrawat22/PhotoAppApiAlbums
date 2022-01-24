package com.mor.photoapp.api.albums.service;

import com.mor.photoapp.api.albums.repository.AlbumRepository;
import com.mor.photoapp.api.albums.ui.model.AlbumEntity;
import com.mor.photoapp.api.albums.ui.model.AlbumRequest;
import com.mor.photoapp.api.albums.ui.model.AlbumResponse;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlbumServiceImpl implements IAlbumService{

    @Autowired
    private AlbumRepository albumRepository;

    @Override
    public AlbumResponse createAlbum(AlbumRequest albumRequest) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        AlbumEntity albumEntity = modelMapper.map(albumRequest, AlbumEntity.class);
        AlbumEntity albumEntityCreated = albumRepository.save(albumEntity);
        AlbumResponse albumResponse = modelMapper.map(albumEntityCreated, AlbumResponse.class);
        return albumResponse;
    }

    @Override
    public List<AlbumResponse> getUserAlbums(Long userId) {
        ModelMapper modelMapper = new ModelMapper();
        List<AlbumEntity> albumEntity = albumRepository.findByUserId(userId);
        List<AlbumResponse> albumResponse =
                modelMapper.map(albumEntity, new TypeToken<List<AlbumResponse>>() {}.getType());

        return albumResponse;
    }
}
