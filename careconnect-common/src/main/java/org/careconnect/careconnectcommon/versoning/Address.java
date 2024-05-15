package org.careconnect.careconnectcommon.versoning;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Embeddable
public class Address {

    @NotNull(message = "Enter Street")
    @NotEmpty(message = "Enter Street")
    private String street;

    @NotNull(message = "Enter City")
    @NotEmpty(message = "Enter City")
    private String city;

    @NotNull(message = "Enter State")
    @NotEmpty(message = "Enter State")
    private String state;

    @NotNull(message = "Enter PostalCode")
    @NotEmpty(message = "Enter PostalCode")
    private String postalCode;

    @NotNull(message = "Enter Country")
    @NotEmpty(message = "Enter Country")
    private String country;
}
