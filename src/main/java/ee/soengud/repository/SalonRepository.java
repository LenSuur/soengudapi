package ee.soengud.repository;

import ee.soengud.entity.Salon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SalonRepository extends JpaRepository<Salon, Long> {
    List<Salon> findByAddress(String address);
}
