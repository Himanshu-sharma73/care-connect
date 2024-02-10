package org.careconnect.careconnectbooking.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class BookingDto {
    private Long doctorId;

    @NotNull(message = "Patient id cannot be null")
    private Long patientId;

    @Future(message = "Appointment data should b in future")
    @NotNull(message = "Patient id cannot be null")
    private LocalDate appointmentDate;

    private LocalTime appointmentStartTime;

    private String specialization;
}
