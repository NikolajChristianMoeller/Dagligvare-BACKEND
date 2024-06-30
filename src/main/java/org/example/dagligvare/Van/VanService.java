package org.example.dagligvare.Van;

import org.hibernate.service.spi.ServiceException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VanService {

    final VanRepository vanRepository;

    public VanService(VanRepository vanRepository) {
        this.vanRepository = vanRepository;
    }

    public Van getVanById(Integer id) {
        return vanRepository.findById(id).orElseThrow(() -> new RuntimeException("Van with id " + id + " not found."));
    }

    public List<Van> getAllVans() {
        try {
            return vanRepository.findAll();
        } catch (Exception e) {
            throw new ServiceException("Error while getting all vans in service", e);
        }
    }

    public Van createVan(Van newVan) {
        try {
            return vanRepository.save(newVan);
        } catch (Exception e) {
            throw new ServiceException("Error while creating van in service", e);
        }
    }

    public Van updateVan(int id, Van updatedVan) {
        Van vanToUpdate = vanRepository.findById(id).orElseThrow(() -> new RuntimeException("Van with id " + id + " not found."));
        if (updatedVan.getId() == id) {
            vanToUpdate.setBrand(updatedVan.getBrand());
            vanToUpdate.setModel(updatedVan.getModel());
            vanToUpdate.setCapacity(updatedVan.getCapacity());
            return vanRepository.save(vanToUpdate);
        } else {
            throw new RuntimeException("Error while updating van in service.");
        }
    }

    public ResponseEntity<String> deleteVan(int id){
        Optional<Van> vanToDelete = vanRepository.findById(id);
        if(vanToDelete.isPresent()) {
            vanRepository.deleteById(id);
            return ResponseEntity.ok().body("Van with id " + id + " deleted successfully.");
        } else {
            return ResponseEntity.status(404).body("Error while deleting van in service" + " " + "van with id " + id + " not found.");
        }
    }
}
