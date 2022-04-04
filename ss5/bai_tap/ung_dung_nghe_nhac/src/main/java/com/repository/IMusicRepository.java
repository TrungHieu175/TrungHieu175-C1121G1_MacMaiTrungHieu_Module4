package com.repository;

import com.model.Music;

import java.util.List;

public interface IMusicRepository {

    void save (Music music);

    List<Music> findAll();

    Music findById(Integer id);

    void remove(Integer id);

}
