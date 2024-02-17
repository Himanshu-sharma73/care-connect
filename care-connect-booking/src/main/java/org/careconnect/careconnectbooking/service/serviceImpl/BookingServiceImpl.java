package org.careconnect.careconnectbooking.service.serviceImpl;

import jakarta.validation.constraints.NotNull;
import org.careconnect.careconnectbooking.dto.BookingDto;
import org.careconnect.careconnectbooking.dto.DoctorDto;
import org.careconnect.careconnectbooking.dto.PatientDto;
import org.careconnect.careconnectbooking.entity.bookingappointment.BookingAppointment;
import org.careconnect.careconnectbooking.exception.BookingDtoException;
import org.careconnect.careconnectbooking.repo.BookingAppointmentRepository;
import org.careconnect.careconnectbooking.service.BookingService;
import org.careconnect.careconnectbooking.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    DoctorService doctorService;

    @Autowired
    BookingAppointmentRepository bookingAppointmentRepository;

    public DoctorDto getDoctor(@NotNull BookingDto bookingDto) {
        if (bookingDto.getDoctorId() != null) {
            return doctorService.getDoctorById(bookingDto.getDoctorId());

        } else if (bookingDto.getSpecialization() != null) {
            return doctorService.getDoctorBySpecialization(bookingDto.getSpecialization());
        } else {
            throw new BookingDtoException("At least the specialty or doctor ID must be filled in");
        }
    }

    public void checkConflictOfDateAndTime(BookingDto bookingDto,DoctorDto doctorDto) {
        List<BookingAppointment> bookingAppointment = bookingAppointmentRepository.findByDoctorId(doctorDto.getDoctorId());
        for (BookingAppointment appointment : bookingAppointment) {
            if ((appointment.getAppointmentStartTime().equals(bookingDto.getAppointmentStartTime())
                    || bookingDto.getAppointmentStartTime().isBefore(appointment.getAppointmentEndTime()))
                    && appointment.getAppointmentDate().equals(bookingDto.getAppointmentDate())) {
                if ((appointment.getPatientId().equals(bookingDto.getPatientId()))
                        && appointment.getAppointmentDate().equals(bookingDto.getAppointmentDate())) {
                    throw new BookingDtoException("This patient have already appointment on the give date Appointment Time:" + appointment.getAppointmentStartTime());
                }

                throw new BookingDtoException("Doctor have already appointment on this Date and Time");
            }
            if (appointment.getPatientId().equals(bookingDto.getPatientId())
                    && appointment.getAppointmentDate().equals(bookingDto.getAppointmentDate())) {
                throw new BookingDtoException("This patient have already appointment on the give date Appointment Time:" + appointment.getAppointmentStartTime());

            }

        }
    }

    public BookingAppointment bookAppointment(DoctorDto doctorDto, PatientDto patientDto,BookingDto bookingDto){
        return new BookingAppointment(doctorDto.getDoctorId(), patientDto.getPatientId(),
                bookingDto.getAppointmentDate(), bookingDto.getAppointmentStartTime()
                , bookingDto.getAppointmentStartTime().plusMinutes(30), "active");
    }


}
