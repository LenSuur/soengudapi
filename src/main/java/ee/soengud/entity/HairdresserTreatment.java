package ee.soengud.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class HairdresserTreatment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hairdresser_id", nullable = false)
    private Hairdresser hairdresser;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "treatment_id", nullable = false)
    private Treatment treatment;

    private long durationMinutes;
}
