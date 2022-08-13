package com.example.beanvalidation;

import com.example.beanvalidation.validation.Address;
import com.example.beanvalidation.validation.Contact;
import com.example.beanvalidation.validation.Person;
import lombok.extern.slf4j.Slf4j;

import org.junit.jupiter.api.Test;


import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
class UnitTest {

    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    Validator validator = factory.getValidator();

    @Test
    void contactIsValidTestPass() {
        //given
        Contact testContact = Contact.builder()
                .phoneNumber("+49 8348 382389")
                .accountNumber("DE23 1234 1234 1234 1234 12")
                .emailAddress("blabla@web.de")
                .websiteProfile("www.blablub.de")
                .build();
        //when
        Set<ConstraintViolation<Contact>> violations = validator.validate(testContact);
        log.info(violations.stream().map(v -> v.getPropertyPath() + ": " + v.getInvalidValue() + ": " + v.getMessage())
                .collect(Collectors.joining("\n")));
        //then
        assertTrue(violations.isEmpty());
    }

    @Test
    void contactIsValidTestFail() {
        //given
        Contact testContact = Contact.builder()
                .phoneNumber("+49 834d 382389")
                .accountNumber("DE23 1234 1234 1234 12")
                .emailAddress("blablaweb")
                .websiteProfile("wwwblablubde")
                .build();
        //when
        Set<ConstraintViolation<Contact>> violations = validator.validate(testContact);
        log.info(violations.stream().map(v -> v.getPropertyPath() + ": " + v.getInvalidValue() + ": " + v.getMessage())
                .collect(Collectors.joining("\n")));
        //then
        assertFalse(violations.isEmpty());
    }

    @Test
    void buildPersonTestPass() {
        //given
        Person testPerson = Person.builder()
                .firstName("Max")
                .lastName("Mustermann")
                .dateOfBirth(LocalDate.of(1999, 3, 24))
                .creationDate(LocalDate.of(2022,8,13))
                .build();
        //when
        Set<ConstraintViolation<Person>> violations = validator.validate(testPerson);
        log.info(violations.stream().map(v -> v.getPropertyPath() + ": " + v.getInvalidValue() + ": " + v.getMessage())
                .collect(Collectors.joining("\n")));
        //then
        assertTrue(violations.isEmpty());
    }

    @Test
    void buildPersonTestFail() {
        //given
        Person testPerson = Person.builder()
                .dateOfBirth(LocalDate.of(2050, 3, 24))
                .creationDate(LocalDate.of(2025,9,9))
                .build();
        //when
        Set<ConstraintViolation<Person>> violations = validator.validate(testPerson);
        log.info(violations.stream().map(v -> v.getPropertyPath() + ": " + v.getInvalidValue() + ": " + v.getMessage())
                .collect(Collectors.joining("\n")));
        //then
        assertFalse(violations.isEmpty());
    }

    @Test
    void buildAddressTestPass() {
        //given
        Address testAddress = Address.builder()
                .street("Hauptstr")
                .houseNumber("12b")
                .zipCode("94939")
                .country("DE")
                .build();
        //when
        Set<ConstraintViolation<Address>> violations = validator.validate(testAddress);
        log.info(violations.stream().map(v -> v.getPropertyPath() + ": " + v.getInvalidValue() + ": " + v.getMessage())
                .collect(Collectors.joining("\n")));
        //then
        assertTrue(violations.isEmpty());
    }

    @Test
    void buildAddressTestFail() {
        //given
        Address testAddress = Address.builder()
                .zipCode("94")
                .build();
        //when
        Set<ConstraintViolation<Address>> violations = validator.validate(testAddress);
        log.info(violations.stream().map(v -> v.getPropertyPath() + ": " + v.getInvalidValue() + ": " + v.getMessage())
                .collect(Collectors.joining("\n")));
        //then
        assertFalse(violations.isEmpty());
    }
}
