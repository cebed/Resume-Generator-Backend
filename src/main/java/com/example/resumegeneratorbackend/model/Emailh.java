package com.example.resumegeneratorbackend.model;

import javax.persistence.Entity;

@Entity
public class Emailh {

    private String fromEmail;
    private String emailSubject;
    private String toEmail;


    public Emailh( ){


    }

    public String getToEmail() {
        return toEmail;
    }

    public void setToEmail(String toEmail) {
        this.toEmail = toEmail;
    }

    public String getFromEmail() {
        return fromEmail;
    }

    public void setFromEmail(String fromEmail) {
        this.fromEmail = fromEmail;
    }

    public String getEmailSubject() {
        return emailSubject;
    }

    public void setEmailSubject(String emailSubject) {
        this.emailSubject = emailSubject;
    }
}
