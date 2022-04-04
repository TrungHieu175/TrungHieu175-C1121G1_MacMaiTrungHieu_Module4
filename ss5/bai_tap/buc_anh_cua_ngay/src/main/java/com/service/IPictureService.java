package com.service;

import picture_of_day.model.FeedBack;

import java.util.List;

public interface IPictureService {

    void createFeedback(FeedBack feedBack);

    List<FeedBack> getAllFeedback();

    FeedBack findFeedbackById(Integer id);

    void save(FeedBack feedBack);
}
