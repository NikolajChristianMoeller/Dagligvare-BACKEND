package org.example.dagligvare.services;

import org.example.dagligvare.entities.Delivery;
import org.example.dagligvare.repositories.DeliveryRepository;
import org.hibernate.service.spi.ServiceException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeliveryService {

    final DeliveryRepository deliveryRepository;

    public DeliveryService(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }

    public Delivery getDeliveryById(Integer id) {
        return deliveryRepository.findById(id).orElseThrow(() -> new RuntimeException("Delivery with id " + id + " not found."));
    }

    public List<Delivery> getAllDeliveries() {
        try {
            return deliveryRepository.findAll();
        } catch (Exception e) {
            throw new ServiceException("Error while getting all deliveries in service", e);
        }
    }

    public Delivery createDelivery(Delivery newDelivery) {
        try {
            return deliveryRepository.save(newDelivery);
        } catch (Exception e) {
            throw new ServiceException("Error while creating delivery in service", e);
        }
    }

    public Delivery updateDelivery(int id, Delivery updatedDelivery) {
        Delivery deliveryToUpdate = deliveryRepository.findById(id).orElseThrow(() -> new RuntimeException("Delivery with id " + id + " not found."));
        if (updatedDelivery.getId() == id) {
            deliveryToUpdate.setDeliveryDate(updatedDelivery.getDeliveryDate());
            deliveryToUpdate.setFromWarehouse(updatedDelivery.getFromWarehouse());
            deliveryToUpdate.setDestination(updatedDelivery.getDestination());

            return deliveryRepository.save(deliveryToUpdate);
        } else {
            throw new RuntimeException("Error while updating delivery in service.");
        }
    }

    public ResponseEntity<String> deleteDelivery(int id){
        Optional<Delivery> deliveryToDelete = deliveryRepository.findById(id);
        if(deliveryToDelete.isPresent()) {
            deliveryRepository.deleteById(id);
            return ResponseEntity.ok().body("Delivery with id: " + id + " deleted successfully.");
        } else {
            return ResponseEntity.status(404).body("Error while deleting delivery in service:" + " " + "delivery with id " + id + " not found.");
        }
    }
}
