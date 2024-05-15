package org.careconnect.careconnectcommon.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity(name = "bookingappointment")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingAppointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long appointmentId;

    private long doctorId;

    private Long patientId;

    private LocalDate appointmentDate;

    private LocalTime appointmentStartTime;

    private LocalTime appointmentEndTime;

    private String status;

    public BookingAppointment(long doctorId, long patientId, LocalDate appointmentDate,
                              LocalTime appointmentStartTime, LocalTime appointmentEndTime, String status) {
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.appointmentDate = appointmentDate;
        this.appointmentStartTime = appointmentStartTime;
        this.appointmentEndTime = appointmentEndTime;
        this.status = status;
    }


}


