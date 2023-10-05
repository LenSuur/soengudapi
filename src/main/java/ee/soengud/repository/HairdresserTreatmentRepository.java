package ee.soengud.repository;

import ee.soengud.entity.Hairdresser;
import ee.soengud.entity.HairdresserTreatment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HairdresserTreatmentRepository extends JpaRepository<HairdresserTreatment, Long> {
    List<HairdresserTreatment> findByHairdresser(Hairdresser hairdresser);
}
