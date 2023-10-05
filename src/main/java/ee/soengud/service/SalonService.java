package ee.soengud.service;

import ee.soengud.entity.Salon;
import ee.soengud.repository.SalonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalonService {

    @Autowired
    private SalonRepository salonRepository;

    /**
     * Retrieve all salons from the database.
     *
     * @return a list of all salons.
     */
    public List<Salon> findAll() {
        return salonRepository.findAll();
    }

    /**
     * Retrieve a specific salon by its ID.
     *
     * @param id the ID of the salon to be retrieved.
     * @return the salon, if found.
     */
    public Optional<Salon> findById(Long id) {
        return salonRepository.findById(id);
    }

    /**
     * Save a salon to the database.
     * This method will handle both "create" and "update" operations.
     *
     * @param salon the salon to be saved.
     * @return the saved salon.
     */
    public Salon save(Salon salon) {
        return salonRepository.save(salon);
    }

    /**
     * Delete a specific salon by its ID.
     *
     * @param id the ID of the salon to be deleted.
     */
    public void deleteById(Long id) {
        salonRepository.deleteById(id);
    }

    /**
     * Retrieve salons based on a specific address.
     *
     * @param address the address to search by.
     * @return a list of salons located at the specified address.
     */
    public List<Salon> findByAddress(String address) {
        return salonRepository.findByAddress(address);
    }

}
