package com.repository;

import com.model.Music;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class MusicRepository implements IMusicRepository{

    @Override
    public void save(Music music) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        if (music.getId() == null){
            BaseRepository.entityManager.persist(music);
        }else {
            BaseRepository.entityManager.merge(music);
        }
        entityTransaction.commit();
    }

    @Override
    public List<Music> findAll() {
        TypedQuery<Music> typedQuery =
                BaseRepository.entityManager.createQuery("select m from music m",Music.class);
        return typedQuery.getResultList();
    }

    @Override
    public Music findById(Integer id) {
        return BaseRepository.entityManager.find(Music.class,id);
    }

    @Override
    public void remove(Integer id) {
        BaseRepository.entityManager.remove(id);
    }
}
