package com.example.ddd.repository;

import com.example.ddd.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByCin(Long cin);

}


