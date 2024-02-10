package org.careconnect.careconnectbooking.controller;

import org.careconnect.careconnectbooking.dto.BookingDto;
import org.careconnect.careconnectbooking.dto.DoctorDto;
import org.careconnect.careconnectbooking.dto.PatientDto;
import org.careconnect.careconnectbooking.entity.bookingappointment.BookingAppointment;
import org.careconnect.careconnectbooking.exception.BookingDtoException;
import org.careconnect.careconnectbooking.repo.BookingAppointmentRepository;
import org.careconnect.careconnectbooking.responce.ApiResponse;
import org.careconnect.careconnectbooking.service.DoctorService;
import org.careconnect.careconnectbooking.service.serviceImpl.PatientServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;

@RestController
public class BookingController {

    private Logger logger = LoggerFactory.getLogger(BookingController.class);

    @Autowired
    BookingAppointmentRepository bookingAppointmentRepository;

    @Autowired
    PatientServiceImpl patientService;
    @Autowired
    DoctorService doctorService;

    @PostMapping("/patient/appointment/patient/{patientId}/doctor/{doctorId}")
    public BookingAppointment bookAppointment(@PathVariable long patientId, @PathVariable long doctorId) {
        PatientDto patientDto = patientService.getPatientById(patientId);
        DoctorDto doctorDto = doctorService.getDoctorById(doctorId);
        BookingAppointment bookingAppointment = new BookingAppointment(doctorId, patientId, LocalDate.now(), LocalTime.now(), LocalTime.now().plusMinutes(30), "active");
        return bookingAppointmentRepository.save(bookingAppointment);
    }


    @PostMapping("/patient/appointment")
    public ResponseEntity<ApiResponse> bookAppointmentBySpecialization(@RequestBody BookingDto bookingDto) {
        PatientDto patientDto = patientService.getPatientById(bookingDto.getPatientId());
        DoctorDto doctorDto = null;
        if (bookingDto.getDoctorId() != null) {
            doctorDto = doctorService.getDoctorById(bookingDto.getDoctorId());
        } else if (bookingDto.getSpecialization() != null) {
            doctorDto = doctorService.getDoctorBySpecialization(bookingDto.getSpecialization());
        }else {
            throw new BookingDtoException("At least the specialty or doctor ID must be filled in");
        }
        
        BookingAppointment bookingAppointment=new BookingAppointment(doctorDto.getDoctorId(),patientDto.getPatientId(),
                bookingDto.getAppointmentDate(),bookingDto.getAppointmentStartTime()
                ,bookingDto.getAppointmentStartTime().plusMinutes(30),"active");
        BookingAppointment savedAppointment = bookingAppointmentRepository.save(bookingAppointment);
        logger.info("Booking confirmed {}",bookingAppointment);
        ApiResponse apiResponse=new ApiResponse();
        apiResponse.setData(savedAppointment);
        return ResponseEntity.ok(apiResponse);

    }

    @GetMapping("/doctors/{doctorId}")
    public DoctorDto getDoctorById(@PathVariable long doctorId) {
        return doctorService.getDoctorById(doctorId);
    }

    @GetMapping("/patients/{patientId}")
    public PatientDto getPatientById(@PathVariable long patientId) {
        return patientService.getPatientById(patientId);
    }

}
