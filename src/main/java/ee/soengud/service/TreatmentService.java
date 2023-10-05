package ee.soengud.service;

import ee.soengud.entity.Treatment;
import ee.soengud.repository.TreatmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class TreatmentService {

    @Autowired
    private TreatmentRepository treatmentRepository;

    /**
     * Retrieve all treatments from the database.
     *
     * @return a list of all treatments.
     */
    public List<Treatment> findAll() {
        return treatmentRepository.findAll();
    }

    /**
     * Retrieve a specific treatment by its ID.
     *
     * @param id the ID of the treatment to be retrieved.
     * @return the treatment, if found.
     */
    public Optional<Treatment> findById(Long id) {
        return treatmentRepository.findById(id);
    }

    /**
     * Save a treatment to the database.
     * This method will handle both "create" and "update" operations.
     *
     * @param treatment the treatment to be saved.
     * @return the saved treatment.
     */
    public Treatment save(Treatment treatment) {
        return treatmentRepository.save(treatment);
    }

    /**
     * Delete a specific treatment by its ID.
     *
     * @param id the ID of the treatment to be deleted.
     */
    public void deleteById(Long id) {
        treatmentRepository.deleteById(id);
    }

    /**
     * Retrieve treatments based on a specific price range.
     *
     * @param minPrice the minimum price.
     * @param maxPrice the maximum price.
     * @return a list of treatments within the specified price range.
     */
    public List<Treatment> findByPriceRange(BigDecimal minPrice, BigDecimal maxPrice) {
        return treatmentRepository.findByPriceBetween(minPrice, maxPrice);
    }

}
