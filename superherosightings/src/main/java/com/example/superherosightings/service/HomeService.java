package com.example.superherosightings.service;

import com.example.superherosightings.dao.HeroDao;
import com.example.superherosightings.dao.LocationDao;
import com.example.superherosightings.dao.OrganizationDao;
import com.example.superherosightings.dao.SightingDao;
import com.example.superherosightings.dao.SuperpowerDao;
import com.example.superherosightings.models.Hero;
import com.example.superherosightings.models.Organization;
import com.example.superherosightings.models.Sighting;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomeService {
    
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
    
    public String createGoogleMapUrl(HashMap<Sighting,Hero> heroSightings){
    	
        final String BASE_URL = "https://maps.googleapis.com/maps/api/staticmap?zoom=10&size=400x400&maptype=roadmap";
        
        String markers = "";
        if(heroSightings != null){
            for(Sighting sighting : heroSightings.keySet()){
                markers += "&markers="
                        + "label:"
                        + heroSightings.get(sighting).getName().charAt(0)
                        + "%7C"
                        + sighting.getLocation().getLatitude()
                        + ","
                        + sighting.getLocation().getLongitude();
            }
        }
        
        final String url = BASE_URL + markers + "&key=" + getApiKey();
        
        return url;
    }
    
    private String getApiKey(){
        final String GOOGLE_MAPS_API_KEY = "";
        return GOOGLE_MAPS_API_KEY;
    }
    
    public int getNumberOfSuperheros(){
        int numberOfSuperheros = 0;
        List<Hero> heros = heroDao.getAllHeros();
        for(Hero hero : heros){
            if(hero.getAttrHero()){
                numberOfSuperheros++;
            }
        }
        return numberOfSuperheros;
    }
    
    public int getNumberOfSupervillains(){
        int numberOfSupervillains = 0;
        List<Hero> heros = heroDao.getAllHeros();
        for(Hero hero : heros){
            if(!hero.getAttrHero()){
                numberOfSupervillains++;
            }
        }
        return numberOfSupervillains;
    }
    
    public int getNumberOfHeroOrganization(){
        int numberOfHeroOrganization = 0;
        List<Organization> organizations = organizationDao.getAllOrganizations();
        for(Organization organization : organizations){
            if(organization.getAttrHero()){
                numberOfHeroOrganization++;
            }
        }
        return numberOfHeroOrganization;
    }
    
    public int getNumberOfVillainOrganization(){
        int numberOfVillainOrganization = 0;
        List<Organization> organizations = organizationDao.getAllOrganizations();
        for(Organization organization : organizations){
            if(!organization.getAttrHero()){
                numberOfVillainOrganization++;
            }
        }
        return numberOfVillainOrganization;
    }
    
    public int getNumberOfLocations(){
        return locationDao.getAllLocations().size();
    }
    
    public int getNumberOfSightings(){
        return sightingDao.getAllSightings().size();
    }
    
    public int getNumberOfSuperpowers(){
        return superpowerDao.getAllSuperpowers().size();
    }
}
