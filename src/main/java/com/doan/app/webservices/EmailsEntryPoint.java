package com.doan.app.webservices;

import com.doan.app.gmail.GmailValidator;
import com.doan.app.webservices.model.EmailDTO;
import com.doan.app.webservices.model.EmailsRequestModel;
import com.doan.app.webservices.model.EmailsResponseModel;
import org.springframework.beans.BeanUtils;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/emails")
public class EmailsEntryPoint {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public EmailsResponseModel countGmailEmails(EmailsRequestModel requestObject) {
        // Prepare EmailDTO
        EmailDTO emailDTO = new EmailDTO();
        BeanUtils.copyProperties(requestObject, emailDTO);

        // Prepare Response object
        EmailsResponseModel returnValue = new EmailsResponseModel();
        BeanUtils.copyProperties(emailDTO, returnValue);

        // Count the emails
        GmailValidator gmailValidator = new GmailValidator();
        int count = gmailValidator.ingestEmail(requestObject.getEmails());
        returnValue.setCount(count);
        return returnValue;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String helloWorld() {
        return "Hello World!!";
    }
}
