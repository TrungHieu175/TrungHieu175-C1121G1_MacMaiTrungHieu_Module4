package com.codegym.service;

import com.codegym.model.Mail;

public interface IMailService {

    Mail getMail();

    void save(Mail mail);

}
