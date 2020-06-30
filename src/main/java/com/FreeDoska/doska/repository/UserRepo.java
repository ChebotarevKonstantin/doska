package com.FreeDoska.doska.repository;

import com.FreeDoska.doska.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserEntity, String> {
}
