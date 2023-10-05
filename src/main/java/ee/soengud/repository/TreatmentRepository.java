package ee.soengud.repository;

import ee.soengud.entity.Treatment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface TreatmentRepository extends JpaRepository<Treatment, Long> {
    List<Treatment> findByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice);
}
