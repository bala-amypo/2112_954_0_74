package com.example.demo.service.impl;

import com.example.demo.entity.Location;
import com.example.demo.repository.LocationRepository;
import com.example.demo.service.LocationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {

    private final LocationRepository locationRepo;

    public LocationServiceImpl(LocationRepository locationRepo) {
        this.locationRepo = locationRepo;
    }

    public Location createLocation(Location location) {
        if (location.getLatitude() > 90)
            throw new IllegalArgumentException("Invalid latitude value");
        return locationRepo.save(location);
    }

    public List<Location> getAllLocations() {
        return locationRepo.findAll();
    }
}
