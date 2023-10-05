package ee.soengud.controller;


import ee.soengud.entity.Salon;
import ee.soengud.service.SalonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/salons")
public class SalonController {

    private final SalonService salonService;

    public SalonController(SalonService salonService) {
        this.salonService = salonService;
    }

    @GetMapping
    public List<Salon> getAllSalons() {
        return salonService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Salon> getSalonById(@PathVariable Long id) {
        return salonService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Salon createSalon(@RequestBody Salon salon) {
        return salonService.save(salon);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Salon> updateSalon(
            @PathVariable Long id,
            @RequestBody Salon salon) {
        return salonService.findById(id)
                .map(existingSalon -> {
                    salon.setId(id);
                    return ResponseEntity.ok(salonService.save(salon));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSalon(@PathVariable Long id) {
        if (salonService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        salonService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
