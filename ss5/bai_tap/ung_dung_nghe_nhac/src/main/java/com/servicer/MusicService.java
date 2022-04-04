package com.servicer;

import com.model.Music;
import com.repository.BaseRepository;
import com.repository.IMusicRepository;
import com.repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.TypedQuery;
import java.util.List;

@Service
public class MusicService implements IMusicService {

    @Autowired
    IMusicRepository iMusicRepository;

    @Override
    public void save(Music music) {

    }

    @Override
    public List<Music> findAll() {
        return iMusicRepository.findAll();
    }

    @Override
    public Music findById(Integer id) {
        return iMusicRepository.findById(id);
    }

    @Override
    public void remove(Integer id) {

    }
}
