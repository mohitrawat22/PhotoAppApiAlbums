package com.mor.photoapp.api.users.shared;

import com.mor.photoapp.api.users.service.UserServiceImpl;
import com.mor.photoapp.api.users.shared.AlbumsResponseInUser;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

/*
we declare a Feign client
 */
@FeignClient(name="albums-ws")
public interface AlbumsServiceClient {

    Logger logger = LoggerFactory.getLogger(AlbumsServiceClient.class);
    @GetMapping("/albums/users/{id}")
    @Retry(name="callAlbums", fallbackMethod = "getAlbumsCircuitBreaker")
    public List<AlbumsResponseInUser> getAlbums(@PathVariable Long id);

    default List<AlbumsResponseInUser> getAlbumsCircuitBreaker(Long id, Throwable ex) {
        logger.info("Trying to connect ...");
        logger.error(ex.getLocalizedMessage());
        return new ArrayList<AlbumsResponseInUser>();
    }
}
