package com.example.superherosightings.dao;

import com.example.superherosightings.models.Hero;
import com.example.superherosightings.models.Location;
import com.example.superherosightings.models.Organization;
import com.example.superherosightings.models.Sighting;
import com.example.superherosightings.models.Superpower;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class LocationDaoImplTest {
    
    @Autowired
    HeroDao heroDao;
    
    @Autowired
    LocationDao locationDao;
    
    @Autowired
    OrganizationDao organizationDao;
    
    @Autowired
    SightingDao sightingDao;
    
    @Autowired
    SuperpowerDao superpowerDao;
    
    public LocationDaoImplTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        List<Hero> heros = heroDao.getAllHeros();
        for(Hero hero : heros){
            heroDao.deleteHeroById(hero.getId());
        }
        
        List<Location> locations = locationDao.getAllLocations();
        for(Location location : locations){
            locationDao.deleteLocationById(location.getId());
        }
        
        List<Organization> organizations = organizationDao.getAllOrganizations();
        for(Organization organization : organizations){
            organizationDao.deleteOrganizationById(organization.getId());
        }
        
        List<Sighting> sightings = sightingDao.getAllSightings();
        for(Sighting sighting : sightings){
            sightingDao.deleteSightingById(sighting.getId());
        }
        
        List<Superpower> superpowers = superpowerDao.getAllSuperpowers();
        for(Superpower superpower : superpowers){
            superpowerDao.deleteSuperpowerById(superpower.getId());
        }
    }
    
    @AfterEach
    public void tearDown() {
    }

   
    @Test
    public void testGetLocationById() {
    }

    @Test
    public void testGetAndAddLocation(){

        Location location = new Location();
        location.setName("Kensington");
        location.setLatitude(12.3);
        location.setLongitude(-5.36);
        location.setDescription("This is in Central London");
        location.setAddressInformation("8 High Street");
        location = locationDao.addLocation(location);
        
        Location fromDao = locationDao.getLocationById(location.getId());        
        assertEquals(location,fromDao);
    }
    
   
    @Test
    public void testGetAllLocations() {       
        Location location = new Location();
        location.setName("Kensington");
        location.setLatitude(12.3);
        location.setLongitude(-5.36);
        location.setDescription("This is in Central London");
        location.setAddressInformation("8 High Street");
        location = locationDao.addLocation(location);
        
        Location location2 = new Location();
        location2.setName("Milano");
        location2.setLatitude(1.3);
        location2.setLongitude(5.36);
        location2.setDescription("This is in Italy");
        location2.setAddressInformation("10 Via Milano");
        location2 = locationDao.addLocation(location2);
        
        List<Location> locations = locationDao.getAllLocations();
        assertEquals(2, locations.size());
        assertTrue(locations.contains(location));
        assertTrue(locations.contains(location2));    
    }

    
    @Test
    public void testAddLocation() {
    }

   
    @Test
    public void testUpdateLocation() {
        Location location = new Location();
        location.setName("Kensington");
        location.setLatitude(12.3);
        location.setLongitude(-5.36);
        location.setDescription("This is in Central London");
        location.setAddressInformation("8 High Street");
        location = locationDao.addLocation(location);
        
        Location fromDao = locationDao.getLocationById(location.getId());        
        assertEquals(location,fromDao);
        
        location.setName("Test name2");
        location.setLatitude(12.33);
        location.setLongitude(-5.365);
        location.setDescription("Test description2");
        
        locationDao.updateLocation(location);
        assertNotEquals(location,fromDao);
        
        fromDao = locationDao.getLocationById(location.getId());
        assertEquals(location,fromDao);
    }

    
    @Test
    public void testDeleteLocationById() {
        
        Location location = new Location();
        location.setName("Kensington");
        location.setLatitude(12.3);
        location.setLongitude(-5.36);
        location.setDescription("This is in Central London");
        location.setAddressInformation("8 High Street");
        location = locationDao.addLocation(location);
        
        Location fromDao = locationDao.getLocationById(location.getId());        
        assertEquals(location,fromDao);
        
        locationDao.deleteLocationById(location.getId());
        
        fromDao = locationDao.getLocationById(location.getId());
        assertNull(fromDao);
    }
    
}
