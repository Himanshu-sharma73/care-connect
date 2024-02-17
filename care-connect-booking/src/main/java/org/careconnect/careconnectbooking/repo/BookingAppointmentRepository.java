package org.careconnect.careconnectbooking.repo;

import org.careconnect.careconnectbooking.entity.bookingappointment.BookingAppointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingAppointmentRepository extends JpaRepository<BookingAppointment,Long> {

    List<BookingAppointment> findByDoctorId(long doctorId);
}
