package org.careconnect.careconnectbooking.repo;

import org.careconnect.careconnectbooking.entity.bookingappointment.BookingAppointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingAppointmentRepository extends JpaRepository<BookingAppointment,Long> {
}
