package com.mor.photoapp.api.users.service;

import com.mor.photoapp.api.users.shared.AlbumsResponseInUser;
import com.mor.photoapp.api.users.shared.AlbumsServiceClient;
import com.mor.photoapp.api.users.ui.model.*;
import com.mor.photoapp.api.users.repository.UserRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/*
@Service is special case of @Component.
We mark beans with @Service to indicate that they're holding the business logic.
Besides being used in the service layer, there isn't any other special use for this annotation.
 */
@Service
public class UserServiceImpl implements IUserService {

    UserResponse userResponse = null;

    /*
    It allows Spring to resolve and inject collaborating beans into our bean.
     */
    @Autowired
    private UserRepository userRepository;

    //@Autowired
    //private RestTemplate restTemplate;

    @Autowired
    private Environment env;

    @Autowired
    AlbumsServiceClient albumsServiceClient;

    @Override
    public UserResponse createUser(UserRequest userRequest) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserEntity userEntity = modelMapper.map(userRequest, UserEntity.class);
        UserEntity userEntityCreated = userRepository.save(userEntity);
        userResponse = modelMapper.map(userEntityCreated, UserResponse.class);
        return userResponse;
    }

    @Override
    public UserResponse getUserById(Long id) {
        ModelMapper modelMapper = new ModelMapper();
        Optional<UserEntity> optionalUserEntity = userRepository.findById(id);
        if(!optionalUserEntity.isPresent())
            return null;
        UserEntity userEntity = optionalUserEntity.get();
        userResponse = modelMapper.map(userEntity, UserResponse.class);
        /*
        String albumsUrl = String.format(env.getProperty("albums.url"), id);
        ResponseEntity<List<AlbumsResponseInUser>> albumsResponseEntity =
                restTemplate.exchange(albumsUrl, HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<AlbumsResponseInUser>>() {});
        List<AlbumsResponseInUser> albumsResponseInUsers = albumsResponseEntity.getBody();
        */
        List<AlbumsResponseInUser> albumsResponseInUsers = albumsServiceClient.getAlbums(id);
        userResponse.setAlbumsList(albumsResponseInUsers);
        return userResponse;
    }
}
