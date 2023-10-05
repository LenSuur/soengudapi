package ee.soengud.controller;

import ee.soengud.entity.HairdresserTreatment;
import ee.soengud.service.HairdresserTreatmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hairdresser-treatments")
public class HairdresserTreatmentController {

    private final HairdresserTreatmentService hairdresserTreatmentService;

    @Autowired
    public HairdresserTreatmentController(HairdresserTreatmentService hairdresserTreatmentService) {
        this.hairdresserTreatmentService = hairdresserTreatmentService;
    }

    @GetMapping
    public List<HairdresserTreatment> getAllHairdresserTreatments() {
        return hairdresserTreatmentService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<HairdresserTreatment> getHairdresserTreatmentById(@PathVariable Long id) {
        return hairdresserTreatmentService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public HairdresserTreatment createHairdresserTreatment(@RequestBody HairdresserTreatment hairdresserTreatment) {
        return hairdresserTreatmentService.save(hairdresserTreatment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HairdresserTreatment> updateHairdresserTreatment(
            @PathVariable Long id,
            @RequestBody HairdresserTreatment hairdresserTreatment) {
        if (hairdresserTreatmentService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        hairdresserTreatment.setId(id);
        return ResponseEntity.ok(hairdresserTreatmentService.save(hairdresserTreatment));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHairdresserTreatment(@PathVariable Long id) {
        if (hairdresserTreatmentService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        hairdresserTreatmentService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
