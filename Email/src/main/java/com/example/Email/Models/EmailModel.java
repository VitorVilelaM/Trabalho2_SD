package com.example.Email.Models;

public class EmailModel {
    private String name;
    private String emailTO;

    private String subject;

    private String text;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailTO() {
        return emailTO;
    }

    public void setEmailTO(String emailTO) {
        this.emailTO = emailTO;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
