package com.example.superherosightings.dao;

import com.example.superherosightings.models.Hero;
import com.example.superherosightings.models.Location;
import com.example.superherosightings.models.Sighting;
import com.example.superherosightings.models.Superpower;
import java.util.List;

public interface HeroDao {
    
    Hero getHeroById(int id);
    List<Hero> getAllHeros();
    Hero addHero(Hero hero);
    void updateHero(Hero hero);
    void deleteHeroById(int id);
    
    List<Hero> getHerosForSuperpower(Superpower superpower);
    Hero getHeroForSighting(Sighting sighting);
    List<Hero> getHerosForLocation(Location location);
}
