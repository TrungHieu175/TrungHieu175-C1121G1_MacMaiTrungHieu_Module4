package com.example.repository;

import com.example.model.security.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser,Long> {
    AppUser findAllByUserName(String userNam);
}
