package com.doan;

import com.doan.app.gmail.GmailValidator;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class EmailValidatorTest {
    GmailValidator gmailValidator = new GmailValidator();

    @Test
    public void invalidEmails() {
        List<String> emails = new ArrayList<>();
        emails.add("Lamvdoan@yahoo.com");
        emails.add("Lamvdoan@gmail.coms");
        emails.add("Lamvdoan@gmail.net");
        emails.add("Lam@doan@gmail.com");
        emails.add("Lam_doan@gmail.com");
        emails.add("Lam&doan@gmail.com");
        emails.add("Lam=doan@gmail.com");
        emails.add("Lam'doan@gmail.com");
        emails.add("Lam,doan@gmail.com");
        emails.add("Lam<doan@gmail.com");
        emails.add("Lam>doan@gmail.com");
        emails.add("@gmail.com");
        emails.add("Lamv..doan@gmail.com");
        emails.add("1234567890123456789012345678901@gmail.com");
        Assert.assertEquals(0, gmailValidator.ingestEmail(emails));
    }

    @Test
    public void validEmails() {
        List<String> emails = new ArrayList<>();
        emails.add("Lamvdoan1@gmail.com");
        emails.add("Lam.v.doan+more@gmail.com");
        emails.add("Lamvdoan2+5+more@gmail.com");
        emails.add("123456789012345678901234567890@gmail.com");
        Assert.assertEquals(gmailValidator.ingestEmail(emails), emails.size());
    }

    @Test
    public void duplicateEmails() {
        List<String> emails = new ArrayList<>();
        emails.add("Lamvdoan@gmail.com");
        emails.add(".Lamvdoan@gmail.com");
        emails.add("Lamvdoan.@gmail.com");
        emails.add("Lamvdoan+5@gmail.com");
        emails.add("Lamv.doan@gmail.com");
        emails.add("Lam.v.doan+more@gmail.com");
        emails.add("Lamvdoan+5+more@gmail.com");
        Assert.assertEquals(1, gmailValidator.ingestEmail(emails));
    }
}
