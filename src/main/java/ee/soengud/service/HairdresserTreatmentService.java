package ee.soengud.service;

import ee.soengud.entity.Hairdresser;
import ee.soengud.entity.HairdresserTreatment;
import ee.soengud.repository.HairdresserTreatmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HairdresserTreatmentService {

    @Autowired
    private HairdresserTreatmentRepository hairdresserTreatmentRepository;

    /**
     * Retrieve all hairdresser treatments from the database.
     *
     * @return a list of all hairdresser treatments.
     */
    public List<HairdresserTreatment> findAll() {
        return hairdresserTreatmentRepository.findAll();
    }

    /**
     * Retrieve a specific hairdresser treatment by its ID.
     *
     * @param id the ID of the hairdresser treatment to be retrieved.
     * @return the hairdresser treatment, if found.
     */
    public Optional<HairdresserTreatment> findById(Long id) {
        return hairdresserTreatmentRepository.findById(id);
    }

    /**
     * Save a hairdresser treatment to the database.
     * This method will handle both "create" and "update" operations.
     *
     * @param hairdresserTreatment the hairdresser treatment to be saved.
     * @return the saved hairdresser treatment.
     */
    public HairdresserTreatment save(HairdresserTreatment hairdresserTreatment) {
        return hairdresserTreatmentRepository.save(hairdresserTreatment);
    }

    /**
     * Delete a specific hairdresser treatment by its ID.
     *
     * @param id the ID of the hairdresser treatment to be deleted.
     */
    public void deleteById(Long id) {
        hairdresserTreatmentRepository.deleteById(id);
    }

    /**
     * Retrieve hairdresser treatments based on a specific hairdresser.
     *
     * @param hairdresser the hairdresser to search treatments for.
     * @return a list of hairdresser treatments related to the specified hairdresser.
     */
    public List<HairdresserTreatment> findByHairdresser(Hairdresser hairdresser) {
        return hairdresserTreatmentRepository.findByHairdresser(hairdresser);
    }

    // You can continue to add more methods specific to the HairdresserTreatment entity as required.
}
