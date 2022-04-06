package com.repository.impl;

import com.model.Picture;
import com.repository.IPictureRepository;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.List;

@Repository
public class PictureRepository implements IPictureRepository {

    @Override
    public void createPicture(Picture picture) {
        picture.setLikeComment(0);
        String now = LocalDate.now().toString();
        picture.setComment(now);
        EntityTransaction transaction = BaseRepository.entityManager.getTransaction();
        transaction.begin();
        BaseRepository.entityManager.persist(picture);
        transaction.commit();
    }

    @Override
    public List<Picture> getAllPicture() {
        String sql = "select p from picture p";
        TypedQuery<Picture> query = BaseRepository.entityManager.createQuery(sql, Picture.class);
        return query.getResultList();
    }

    @Override
    public Picture findPictureById(Integer id) {
        return BaseRepository.entityManager.find(Picture.class,id);
    }

    @Override
    public void save(Picture picture) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.merge(picture);
        entityTransaction.commit();
    }

    @Override
    public void increateLike(Picture picture) {
        picture.setLikeComment(picture.getLikeComment() + 1);
        BaseRepository.entityManager.merge(picture);
    }
}
