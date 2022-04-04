package com.repository;

import picture_of_day.model.FeedBack;

import java.util.List;

public interface IPictureRepository {

    void createFeedback(FeedBack feedBack);

    List<FeedBack> getAllFeedback();

    FeedBack findFeedbackById(Integer id);

    void save(FeedBack feedBack);
}
