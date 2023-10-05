package ee.soengud.controller;

import ee.soengud.entity.Hairdresser;
import ee.soengud.service.HairdresserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hairdressers")
public class HairdresserController {

    private final HairdresserService hairdresserService;

    public HairdresserController(HairdresserService hairdresserService) {
        this.hairdresserService = hairdresserService;
    }

    @GetMapping
    public List<Hairdresser> getAllHairdressers() {
        return hairdresserService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hairdresser> getHairdresserById(@PathVariable Long id) {
        return hairdresserService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Hairdresser createHairdresser(@RequestBody Hairdresser hairdresser) {
        return hairdresserService.save(hairdresser);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Hairdresser> updateHairdresser(
            @PathVariable Long id,
            @RequestBody Hairdresser hairdresser) {
        return hairdresserService.findById(id)
                .map(existingHairdresser -> {
                    hairdresser.setId(id);
                    return ResponseEntity.ok(hairdresserService.save(hairdresser));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHairdresser(@PathVariable Long id) {
        if (hairdresserService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        hairdresserService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
