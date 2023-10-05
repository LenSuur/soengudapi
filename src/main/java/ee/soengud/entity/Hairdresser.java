package ee.soengud.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Hairdresser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String phone;
    private String description;
    private String email;
    private String instagram;

    @OneToMany(mappedBy = "hairdresser", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Booking> bookings = new ArrayList<>();

    @OneToMany(mappedBy = "hairdresser", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<HairdresserTreatment> treatments = new ArrayList<>();
}
