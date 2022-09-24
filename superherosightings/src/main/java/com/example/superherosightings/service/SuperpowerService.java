package com.example.superherosightings.service;

import com.example.superherosightings.dao.HeroDao;
import com.example.superherosightings.dao.LocationDao;
import com.example.superherosightings.dao.OrganizationDao;
import com.example.superherosightings.dao.SightingDao;
import com.example.superherosightings.dao.SuperpowerDao;
import com.example.superherosightings.models.Hero;
import com.example.superherosightings.models.Superpower;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SuperpowerService {
    
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
    
    // SERVICE FUNCTION
    public Superpower createSuperpower(String name, String description){
        Superpower superpower = new Superpower();
        superpower.setName(name);
        superpower.setDescription(description);

        return superpower;
    }
    
    // EXTERNAL DAO FUNCTIONS  
    public List<Hero> getHerosForSuperpower(Superpower superpower){
        return heroDao.getHerosForSuperpower(superpower);
    }
    // LOCAL DAO FUNCTIONS  
    public Superpower getSuperpowerById(int id){
        return superpowerDao.getSuperpowerById(id);      
    }
    public List<Superpower> getAllSuperpowers(){
        return superpowerDao.getAllSuperpowers();
    }
    public Superpower addSuperpower(Superpower superpower){
        return superpowerDao.addSuperpower(superpower);
    }
    public void updateSuperpower(Superpower superpower){
        superpowerDao.updateSuperpower(superpower);
    }
    public void deleteSuperpowerById(int id){
        superpowerDao.deleteSuperpowerById(id);
    }
}
