package com.example.beanvalidation.validation;

import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Builder
public class Address {

    @NotEmpty
    @Size(max=256)
    String street;

    @NotEmpty
    @Size(max=256)
    String houseNumber;

    @NotEmpty
    @Min(10000)@Max(99999)
    String zipCode;

    @NotEmpty
    @Size(max=256)
    String country;
}
