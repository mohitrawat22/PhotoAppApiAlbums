package com.mor.photoapp.api.albums.ui.controller;

import com.mor.photoapp.api.albums.service.IAlbumService;
import com.mor.photoapp.api.albums.ui.model.AlbumRequest;
import com.mor.photoapp.api.albums.ui.model.AlbumResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/albums")
public class AlbumController {

    @Autowired
    private Environment env;

    @Autowired
    private IAlbumService ialbumService;

    @GetMapping("/status")
    public String status() {
        return "Working on port: "+env.getProperty("local.server.port");
    }

    @GetMapping("/users/{id}")
    public List<AlbumResponse> getUserAlbums(@PathVariable("id") Long userId) {
        System.out.println(userId);
        return ialbumService.getUserAlbums(userId);
    }

    @PostMapping
    public ResponseEntity<AlbumResponse> createUser(@RequestBody AlbumRequest albumRequest) {
        AlbumResponse userResponse = ialbumService.createAlbum(albumRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(userResponse);
    }
}
