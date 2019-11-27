package com.doan.app.gmail;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class GmailValidator {
    public int ingestEmail(List<String> emails) {
        Set<String> uniqueEmails = new HashSet<>();

        for (String email : emails) {
            email = email.toLowerCase();

            if (isValidGmail(email)) {
                email = sanitizeGmailEmail(email);
                uniqueEmails.add(email);
            }
        }

        return uniqueEmails.size();
    }

    private boolean isValidGmail(String email) {
        if (email.contains("..")) {
            return false;
        }

        // Basic gmail email validator, can definitely be stricter for email validations
        String regex = "^[A-Za-z0-9+.]{1,30}@gmail.com$";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(email).matches();
    }

    private String sanitizeGmailEmail(String email) {
        int indexOfAtSymbol = email.length() - 10;
        String username = email.substring(0, indexOfAtSymbol);

        if (username.contains("+")) {
            for (int i = 0; i < username.length(); i++) {
                if (username.charAt(i) == '+') {
                    username = username.substring(0, i);
                    break;
                }
            }
        }

        return username.replace(".", "") + "@gmail.com";
    }
}
