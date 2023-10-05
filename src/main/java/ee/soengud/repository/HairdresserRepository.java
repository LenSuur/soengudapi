package ee.soengud.repository;

import ee.soengud.entity.Hairdresser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HairdresserRepository extends JpaRepository<Hairdresser, Long> {
}
