package com.doan.app.webservices;

import com.doan.app.gmail.GmailValidator;
import com.doan.app.webservices.model.EmailsRequestModel;
import com.doan.app.webservices.model.EmailsResponseModel;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/emails")
public class EmailsEntryPoint {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public EmailsResponseModel countGmailEmails(EmailsRequestModel requestObject) {
        GmailValidator gmailValidator = new GmailValidator();
        int count = gmailValidator.ingestEmail(requestObject.getEmails());

        EmailsResponseModel returnValue = new EmailsResponseModel();
        returnValue.setCount(count);
        return returnValue;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String helloWorld() {
        return "Hello World!!";
    }
}
