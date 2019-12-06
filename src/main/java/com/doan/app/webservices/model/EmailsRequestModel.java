package com.doan.app.webservices.model;

import java.util.List;

public class EmailsRequestModel {
    private List<String> emails;

    public void setEmails(List<String> emails) {
        this.emails = emails;
    }

    public List<String> getEmails() {
        return emails;
    }
}
