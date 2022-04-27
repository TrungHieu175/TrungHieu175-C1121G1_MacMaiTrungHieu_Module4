package com.example.repository.sercurity;


import com.example.model.security.AppUser;
import com.example.model.security.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole,Long> {

    List<UserRole> findAllByAppUser(AppUser appUser);
}