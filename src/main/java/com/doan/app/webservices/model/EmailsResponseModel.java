package com.doan.app.webservices.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class EmailsResponseModel {
    int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
