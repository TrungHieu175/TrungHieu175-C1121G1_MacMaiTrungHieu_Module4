package com.codegym.service;

import com.codegym.model.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MailService implements IMailService {


    private static Mail mail = new Mail();

    @Override
    public Mail getMail() {
        return mail;
    }

    @Override
    public void save(Mail mail1) {
        mail = mail1;
    }

}
