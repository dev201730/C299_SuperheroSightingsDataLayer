package com.example.superherosightings.models;

import java.util.List;
import java.util.Objects;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Hero {
    
    private int id;
    private boolean attrHero;
    
    @NotBlank(message = "Name must not be empty.")
    @Size(max = 50, message="Name must be less than 50 characters.")
    private String name;
    
    @Size(max = 255, message="Description must be less than 255 characters.")
    private String description;
    
    private List<Superpower> superpowers;
    private List<Sighting> sightings;
    
    
    
    public boolean getAttrHero() {
        return attrHero;
    }

    public void setAttrHero(boolean attrHero) {
        this.attrHero = attrHero;
    }


    @Override
    public String toString() {
        return "Hero{" + "id=" + id + ", attrHero=" + attrHero + ", name=" + name + ", description=" + description + ", superpowers=" + superpowers + ", sightings=" + sightings + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + this.id;
        hash = 79 * hash + (this.attrHero ? 1 : 0);
        hash = 79 * hash + Objects.hashCode(this.name);
        hash = 79 * hash + Objects.hashCode(this.description);
        hash = 79 * hash + Objects.hashCode(this.superpowers);
        hash = 79 * hash + Objects.hashCode(this.sightings);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Hero other = (Hero) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.attrHero != other.attrHero) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.superpowers, other.superpowers)) {
            return false;
        }
        if (!Objects.equals(this.sightings, other.sightings)) {
            return false;
        }
        return true;
    }
   

    
}
