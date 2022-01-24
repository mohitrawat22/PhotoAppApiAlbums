package com.mor.photoapp.api.users.service;

import com.mor.photoapp.api.users.ui.model.UserRequest;
import com.mor.photoapp.api.users.ui.model.UserResponse;

public interface IUserService {
    UserResponse createUser(UserRequest userRequest);
    UserResponse getUserById(Long id);
}
