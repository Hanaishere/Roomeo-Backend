package com.dormFindrBackend.dormfindr.repository;

import com.dormFindrBackend.dormfindr.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String email);

}