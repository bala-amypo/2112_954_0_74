package com.example.demo.service;

import com.example.demo.entity.RouteOptimization;

public interface RouteOptimizationService {
    RouteOptimizationResult optimizeRoute(Long shipmentId);
}
