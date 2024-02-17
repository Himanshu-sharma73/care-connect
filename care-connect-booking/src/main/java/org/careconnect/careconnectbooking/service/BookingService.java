package org.careconnect.careconnectbooking.service;

import jakarta.validation.constraints.NotNull;
import org.careconnect.careconnectbooking.dto.BookingDto;
import org.careconnect.careconnectbooking.dto.DoctorDto;
import org.careconnect.careconnectbooking.dto.PatientDto;
import org.careconnect.careconnectbooking.entity.bookingappointment.BookingAppointment;

public interface BookingService {
    DoctorDto getDoctor(@NotNull BookingDto bookingDto);

    void checkConflictOfDateAndTime(BookingDto bookingDto,DoctorDto doctorDto);

    BookingAppointment bookAppointment(DoctorDto doctorDto, PatientDto patientDto, BookingDto bookingDto);
}
