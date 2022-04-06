package com.service.impl;

import com.model.Picture;
import com.repository.IPictureRepository;
import com.service.IPictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PictureService implements IPictureService {
    @Autowired
    private IPictureRepository iPictureRepository ;


    @Override
    public void createPicture(Picture picture) {
        iPictureRepository.createPicture(picture);
    }

    @Override
    public List<Picture> getAllPicture() {
        return iPictureRepository.getAllPicture();
    }

    @Override
    public Picture findPictureById(Integer id) {
        return iPictureRepository.findPictureById(id);
    }

    @Override
    public void save(Picture picture) {
        iPictureRepository.save(picture);
    }

    @Override
    public void increateLike(Picture picture) {
        iPictureRepository.increateLike(picture);
    }
}
