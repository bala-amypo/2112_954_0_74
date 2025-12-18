package com.example.demo.service.impl;

import com.example.demo.entity.Shipment;
import com.example.demo.entity.Vehicle;
import com.example.demo.repository.ShipmentRepository;
import com.example.demo.repository.VehicleRepository;
import com.example.demo.service.ShipmentService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ShipmentServiceImpl implements ShipmentService {

    private final ShipmentRepository shipmentRepo;
    private final VehicleRepository vehicleRepo;

    public ShipmentServiceImpl(ShipmentRepository shipmentRepo,
                               VehicleRepository vehicleRepo) {
        this.shipmentRepo = shipmentRepo;
        this.vehicleRepo = vehicleRepo;
    }

    @Override
    public Shipment createShipment(Long vehicleId, Shipment shipment) {

        Vehicle vehicle = vehicleRepo.findById(vehicleId).orElse(null);
        if (vehicle == null) return null;

        if (shipment.getWeightKg() == null) return null;
        if (shipment.getScheduledDate() == null) return null;

        if (shipment.getWeightKg() > vehicle.getCapacityKg()) return null;
        if (shipment.getScheduledDate().isBefore(LocalDate.now())) return null;

        shipment.setVehicle(vehicle);
        return shipmentRepo.save(shipment);
    }

    @Override
    public Shipment getShipment(Long shipmentId) {
        return shipmentRepo.findById(shipmentId).orElse(null);
    }
}
