package com.example.bai_tap_validate.repository;

import com.example.bai_tap_validate.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User,Integer> {

    Page<User> findAllByNameContainingOrderByName(String name, Pageable pageable);

    Page<User> findAllByOrderById(Pageable pageable);
}
