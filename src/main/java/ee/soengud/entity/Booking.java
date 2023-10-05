package ee.soengud.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Booking {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "hairdresser_id", nullable = false)
        private Hairdresser hairdresser;

        @ManyToOne
        @JoinColumn(name = "hairdresser_service_association_id", nullable = false)
        private HairdresserTreatment hairdresserTreatment;

        private LocalDateTime bookingDate;
        private String name;
        private String phone;
        private LocalDateTime startTime;
        private LocalDateTime endTime;
        private String comment;
}
