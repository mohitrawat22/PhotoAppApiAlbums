package com.mor.photoapp.api.users.repository;

import com.mor.photoapp.api.users.ui.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
