package ee.soengud.repository;

import ee.soengud.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByHairdresserId(Long hairdresserId);

    List<Booking> findByBookingDate(LocalDateTime bookingDate);

    List<Booking> findByHairdresserTreatment_Id(Long treatmentId);
}
