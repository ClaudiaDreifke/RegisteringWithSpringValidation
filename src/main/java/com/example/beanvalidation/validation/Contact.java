package com.example.beanvalidation.validation;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@Builder
public class Contact {

    @Pattern(regexp = "\\+49 \\d+ \\d+", message = "This is not a valid german phone number")
    String phoneNumber;

    @NotNull
    @Email
    String emailAddress;

    @Pattern(regexp = "^((https?|ftp|smtp):\\/\\/)?(www.)?[a-z0-9]+\\.[a-z]+(\\/[a-zA-Z0-9#]+\\/?)*$", message = "This is not a valid website-URL")
    String websiteProfile;

    @Pattern(regexp = "\\DE\\d{2}\\s*\\d{4}\\s*\\d{4}\\s*\\d{4}\\s*\\d{4}\\s*\\d{2}", message = "This is not a valid german account number")
    String accountNumber;



}
