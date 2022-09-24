package com.example.superherosightings.service;

import com.example.superherosightings.dao.HeroDao;
import com.example.superherosightings.dao.LocationDao;
import com.example.superherosightings.dao.OrganizationDao;
import com.example.superherosightings.dao.SightingDao;
import com.example.superherosightings.dao.SuperpowerDao;
import com.example.superherosightings.models.Hero;
import com.example.superherosightings.models.Organization;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrganizationService {
    
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
    public Organization createOrganization(String name, boolean attrHero, String description, String address, String contact, List<Hero> heros){
        Organization organization = new Organization();
        organization.setName(name);
        organization.setAttrHero(attrHero);
        organization.setDescription(description);
        organization.setAddress(address);
        organization.setContact(contact);
        organization.setMembers(heros);

        return organization;
    }
    
    
    // EXTERNAL DAO FUNCTIONS  

    // LOCAL DAO FUNCTIONS  
    public Organization getOrganizationById(int id){
        return organizationDao.getOrganizationById(id);      
    }
    public List<Organization> getAllOrganizations(){
        return organizationDao.getAllOrganizations();
    }
    public Organization addOrganization(Organization organization){
        return organizationDao.addOrganization(organization);
    }
    public void updateOrganization(Organization organization){
        organizationDao.updateOrganization(organization);
    }
    public void deleteOrganizationById(int id){
        organizationDao.deleteOrganizationById(id);
    }
}
