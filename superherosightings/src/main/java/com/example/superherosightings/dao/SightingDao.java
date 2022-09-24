package com.example.superherosightings.dao;

import com.example.superherosightings.models.Hero;
import com.example.superherosightings.models.Sighting;
import com.example.superherosightings.models.Location;

import java.util.List;

public interface SightingDao {
    
    Sighting getSightingById(int id);
    List<Sighting> getAllSightings();
    Sighting addSighting(Sighting sighting);
    void updateSighting(Sighting sighting);
    void deleteSightingById(int id);
    
    List<Sighting> getSightingsForLocation(Location location);
}
