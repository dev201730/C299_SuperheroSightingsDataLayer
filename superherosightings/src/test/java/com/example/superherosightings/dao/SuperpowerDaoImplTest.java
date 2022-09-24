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
public class SuperpowerDaoImplTest {
    
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
    
    public SuperpowerDaoImplTest() {
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
    public void testGetSuperpowerById() {
    }
    
    @Test
    public void testGetAndAddSuperpower(){

        Superpower superpower = new Superpower();
        superpower.setName("Fly");
        superpower.setDescription("Flies at a very high speed.");
        superpower = superpowerDao.addSuperpower(superpower);
        
        Superpower fromDao = superpowerDao.getSuperpowerById(superpower.getId());       
        assertEquals(superpower,fromDao);
    }

    
    @Test
    public void testGetAllSuperpowers() {
        
        Superpower superpower = new Superpower();
        superpower.setName("Fly");
        superpower.setDescription("Flies at a very high speed.");
        superpower = superpowerDao.addSuperpower(superpower);
        
        Superpower superpower2 = new Superpower();
        superpower2.setName("Sings");
        superpower2.setDescription("Sings very high notes.");
        superpower2 = superpowerDao.addSuperpower(superpower2);
        
        List<Superpower> superpowers = superpowerDao.getAllSuperpowers();
        assertEquals(2, superpowers.size());
        assertTrue(superpowers.contains(superpower));
        assertTrue(superpowers.contains(superpower2));
    }

   
    @Test
    public void testAddSuperpower() {
    }

   
    @Test
    public void testUpdateSuperpower() {
        Superpower superpower = new Superpower();
        superpower.setName("Fly");
        superpower.setDescription("Flies at a very high speed.");
        superpower = superpowerDao.addSuperpower(superpower);
        
        Superpower fromDao = superpowerDao.getSuperpowerById(superpower.getId());       
        assertEquals(superpower,fromDao);
        
        superpower.setName("Sings");
        superpower.setDescription("Sings very high notes.");
        
        superpowerDao.updateSuperpower(superpower);
        assertNotEquals(superpower,fromDao);
        
        fromDao = superpowerDao.getSuperpowerById(superpower.getId());
        assertEquals(superpower,fromDao);
    }

    
    @Test
    public void testDeleteSuperpowerById() {
        Superpower superpower = new Superpower();
        superpower.setName("Fly");
        superpower.setDescription("Flies at a very high speed.");
        superpower = superpowerDao.addSuperpower(superpower);
        
        Superpower fromDao = superpowerDao.getSuperpowerById(superpower.getId());       
        assertEquals(superpower,fromDao);
        
        superpowerDao.deleteSuperpowerById(superpower.getId());
        
        fromDao = superpowerDao.getSuperpowerById(superpower.getId());
        assertNull(fromDao);
    }
    
}
