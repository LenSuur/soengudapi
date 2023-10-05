package ee.soengud.controller;

import ee.soengud.entity.Treatment;
import ee.soengud.service.TreatmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/treatments")
public class TreatmentController {

    private final TreatmentService treatmentService;

    public TreatmentController(TreatmentService treatmentService) {
        this.treatmentService = treatmentService;
    }

    @GetMapping
    public List<Treatment> getAllTreatments() {
        return treatmentService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Treatment> getTreatmentById(@PathVariable Long id) {
        return treatmentService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Treatment createTreatment(@RequestBody Treatment treatment) {
        return treatmentService.save(treatment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Treatment> updateTreatment(
            @PathVariable Long id,
            @RequestBody Treatment treatment) {
        return treatmentService.findById(id)
                .map(existingTreatment -> {
                    treatment.setId(id);
                    return ResponseEntity.ok(treatmentService.save(treatment));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTreatment(@PathVariable Long id) {
        if (treatmentService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        treatmentService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
