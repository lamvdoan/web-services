package com.doan.app.webservices.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class EmailsRequestModel {
    private List<String> emails;

    public List<String> getEmails() {
        return emails;
    }
}
