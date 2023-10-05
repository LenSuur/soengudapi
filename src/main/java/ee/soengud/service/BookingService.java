package ee.soengud.service;

import ee.soengud.entity.Booking;
import ee.soengud.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public List<Booking> findAll() {
        return bookingRepository.findAll();
    }

    public Optional<Booking> findById(Long id) {
        return bookingRepository.findById(id);
    }

    public Booking save(Booking booking) {
        return bookingRepository.save(booking);
    }

    public void deleteById(Long id) {
        bookingRepository.deleteById(id);
    }

    public List<Booking> findByHairdresserId(Long hairdresserId) {
        return bookingRepository.findByHairdresserId(hairdresserId);
    }

    public List<Booking> findByBookingDate(LocalDateTime date) {
        return bookingRepository.findByBookingDate(date);
    }

    public List<Booking> findByTreatmentId(Long treatmentId) {
        return bookingRepository.findByHairdresserTreatment_Id(treatmentId);
    }

}
