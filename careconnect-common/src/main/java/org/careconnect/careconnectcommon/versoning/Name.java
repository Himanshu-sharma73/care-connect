package org.careconnect.careconnectcommon.versoning;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.ToString;

@ToString
@Data
@Embeddable
public class Name {

    @Size(min = 3,message = "First name should have at least 3 character")
    private String firstName;

    private String middleName;

    @Size(min = 3,message = "Last name should have at least 3 character")
    private String lastName;
}
