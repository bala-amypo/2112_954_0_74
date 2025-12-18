package com.example.demo.service.impl;

import com.example.demo.entity.RouteOptimization;
import com.example.demo.entity.Shipment;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.RouteOptimizationRepository;
import com.example.demo.repository.ShipmentRepository;
import com.example.demo.service.RouteOptimizationService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class RouteOptimizationServiceImpl implements RouteOptimizationService {

    private final ShipmentRepository shipmentRepo;
    private final RouteOptimizationRepository resultRepo;

    public RouteOptimizationServiceImpl(ShipmentRepository shipmentRepo,
                                        RouteOptimizationRepository resultRepo) {
        this.shipmentRepo = shipmentRepo;
        this.resultRepo = resultRepo;
    }

    @Override
    public RouteOptimization optimizeRoute(Long shipmentId) {

        Shipment shipment = shipmentRepo.findById(shipmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Shipment not found"));

        RouteOptimization result = new RouteOptimization();
        result.setShipment(shipment);
        result.setOptimizedDistanceKm(120.0);
        result.setEstimatedFuelUsage(15.0);
        result.setGeneratedAt(LocalDateTime.now());

        return resultRepo.save(result);
    }
}
