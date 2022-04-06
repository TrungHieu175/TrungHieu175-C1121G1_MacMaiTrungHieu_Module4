package com.repository;

import com.model.Picture;

import java.util.List;

public interface IPictureRepository {

    void createPicture(Picture picture);

    List<Picture> getAllPicture();

    Picture findPictureById(Integer id);

    void save(Picture picture);

    void increateLike(Picture picture);
}
