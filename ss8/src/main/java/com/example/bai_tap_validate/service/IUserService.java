package com.example.bai_tap_validate.service;

import com.example.bai_tap_validate.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IUserService {
    void save(User user);

    void deleteById(Integer id);

    User findById(Integer id);

    Page<User> findByName(String keyword, Pageable pageable);

    Page<User> findAllByName(Pageable pageable);


    List<User> findAll();
}
