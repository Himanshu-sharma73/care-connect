package org.careconnect.careconnectcommon.entity;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.careconnect.careconnectcommon.versoning.Address;
import org.careconnect.careconnectcommon.versoning.Name;

@Entity(name = "doctors")
@Data
public class DoctorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long doctorId;

    @Valid
    private Name name;

    @Column(unique = true)
    @NotBlank(message = "Enter Email")
    @Email
    private String email;

    @Column(unique = true)
    @Min(value = 1000000000L, message = "Mobile number must be at least 10 digits")
    @Max(value = 9999999999L, message = "Mobile number must not exceed 10 digits")
    private long mobileNo;

    @NotBlank(message = "Enter Gender")
    private String gender;

    @Column(unique = true)
    @NotBlank(message = "Enter License Number")
    private String licenseNumber;

    @Valid
    private Address address;

    @Column(unique = true)
    @Min(value = 100000000000l,message = "Enter correct Adhar number")
    @Max(value = 999999999999l,message = "Enter correct Adhar number")
    private long adharNo;

    @NotBlank(message = "Enter Blood Group")
    private String bloodGroup;

    @NotBlank(message = "Enter Marital Status")
    private String maritalStatus;

    @NotNull(message="specialization cannot be null")
    @Enumerated(EnumType.STRING)
    private Specialization specialization;

}
