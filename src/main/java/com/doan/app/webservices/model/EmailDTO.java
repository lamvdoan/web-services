package com.doan.app.webservices.model;

import java.io.Serializable;
import java.util.List;

public class EmailDTO implements Serializable {
    private List<String> emails;

    public List<String> getEmails() {
        return emails;
    }

    public void setEmails(List<String> emails) {
        this.emails = emails;
    }
}
