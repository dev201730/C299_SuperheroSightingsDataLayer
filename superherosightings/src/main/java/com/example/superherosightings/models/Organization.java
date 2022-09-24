package com.example.superherosightings.models;

import java.util.List;
import java.util.Objects;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Organization {
    
    private int id;
    
    @NotBlank(message = "Name must not be empty.")
    @Size(max = 50, message="Name must be less than 50 characters.")
    private String name;
    
    private boolean attrHero;
    
    @Size(max = 255, message="Description must be less than 255 characters.")
    private String description;
    
    @Size(max = 255, message="Address must be less than 255 characters.")
    private String address;
    
    @Size(max = 255, message="Contact must be less than 255 characters.")
    private String contact;
    
    private List<Hero> members;
    
    
    public boolean getAttrHero() {
        return attrHero;
    }

    public void setAttrHero(boolean attrHero) {
        this.attrHero = attrHero;
    }



    @Override
    public String toString() {
        return "Organization{" + "id=" + id + ", name=" + name + ", attrHero=" + attrHero + ", description=" + description + ", address=" + address + ", contact=" + contact + ", members=" + members + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.id;
        hash = 53 * hash + Objects.hashCode(this.name);
        hash = 53 * hash + (this.attrHero ? 1 : 0);
        hash = 53 * hash + Objects.hashCode(this.description);
        hash = 53 * hash + Objects.hashCode(this.address);
        hash = 53 * hash + Objects.hashCode(this.contact);
        hash = 53 * hash + Objects.hashCode(this.members);
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
        final Organization other = (Organization) obj;
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
        if (!Objects.equals(this.address, other.address)) {
            return false;
        }
        if (!Objects.equals(this.contact, other.contact)) {
            return false;
        }
        if (!Objects.equals(this.members, other.members)) {
            return false;
        }
        return true;
    }

    
}
