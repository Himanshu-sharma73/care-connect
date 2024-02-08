package org.careconnect.careconnectpatient.versoning;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Embeddable
public class Address {

    @NotNull
    @NotEmpty
    private String street;

    @NotNull
    @NotEmpty
    private String city;

    @NotNull
    @NotEmpty
    private String state;

    @NotNull
    @NotEmpty
    private String postalCode;

    @NotNull
    @NotEmpty
    private String country;
}
