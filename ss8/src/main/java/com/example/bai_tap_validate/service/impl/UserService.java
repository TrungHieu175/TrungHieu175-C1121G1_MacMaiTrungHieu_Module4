package com.example.bai_tap_validate.service.impl;

import com.example.bai_tap_validate.model.User;
import com.example.bai_tap_validate.repository.IUserRepository;
import com.example.bai_tap_validate.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class UserService implements IUserService {

    @Autowired
    private IUserRepository iUserRepository;
    @Override
    public void save(User user) {
        iUserRepository.save(user);
    }

    @Override
    public void deleteById(Integer id) {
        iUserRepository.deleteById(id);
    }

    @Override
    public User findById(Integer id) {
        return iUserRepository.findById(id).orElse(null);
    }

    @Override
    public Page<User> findByName(String keyword, Pageable pageable) {
        return iUserRepository.findAllByNameContainingOrderByName(keyword,pageable);
    }

    @Override
    public Page<User> findAllByName(Pageable pageable) {
        return iUserRepository.findAllByOrderById(pageable);
    }

    @Override
    public List<User> findAll() {
        return null;
    }
}
