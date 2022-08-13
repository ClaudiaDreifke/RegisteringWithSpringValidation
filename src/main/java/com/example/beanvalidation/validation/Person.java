package com.example.beanvalidation.validation;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@Builder
public class Person {
    @NotNull
    @Size(max=256)
    String firstName;

    @NotNull
    @Size(max=256)
    String lastName;

    @Size(max=256)
    String middleName;

    @NotNull
    @Past
    LocalDate dateOfBirth;


    String nationality;


    String languages;


    String gender;

    @PastOrPresent
    LocalDate creationDate;

}
