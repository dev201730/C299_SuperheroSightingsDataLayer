package com.example.superherosightings.dao;

import com.example.superherosightings.models.Location;
import com.example.superherosightings.models.Hero;
import java.util.List;

public interface LocationDao {
    
    Location getLocationById(int id);
    List<Location> getAllLocations();
    Location addLocation(Location location);
    void updateLocation(Location location);
    void deleteLocationById(int id);
    
    List<Location> getLocationsForHero(Hero hero);
}
