package ee.soengud.service;

import ee.soengud.entity.Hairdresser;
import ee.soengud.repository.HairdresserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HairdresserService {
    @Autowired
    private HairdresserRepository hairdresserRepository;

    public List<Hairdresser> findAll() {
        return hairdresserRepository.findAll();
    }

    public Optional<Hairdresser> findById(Long id) {
        return hairdresserRepository.findById(id);
    }

    public Hairdresser save(Hairdresser hairdresser) {
        return hairdresserRepository.save(hairdresser);
    }

    public void deleteById(Long id) {
        hairdresserRepository.deleteById(id);
    }
}
