package com.example.repository.sercurity;

import com.example.model.security.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser,String> {
    AppUser findByUserName(String userName);
}
