package com.example.superherosightings.models;

import java.util.Objects;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class Location {
    
    private int id;
    
    @NotBlank(message = "Name must not be empty.")
    @Size(max = 50, message="Name must be less than 50 characters.")
    private String name;
    
    @Digits(integer=10, fraction=8)
    private double latitude;
    
    @Digits(integer=11, fraction=8)
    private double longitude;
    
    @Size(max = 255, message="Description must be less than 255 characters.")
    private String description;
    
    @Size(max = 255, message="Address Information must be less than 255 characters.")
    private String addressInformation;

    @Override
    public String toString() {
        return "Location{" + "id=" + id + ", name=" + name + ", latitude=" + latitude + ", longitude=" + longitude + ", description=" + description + ", addressInformation=" + addressInformation + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.id;
        hash = 83 * hash + Objects.hashCode(this.name);
        hash = 83 * hash + (int) (Double.doubleToLongBits(this.latitude) ^ (Double.doubleToLongBits(this.latitude) >>> 32));
        hash = 83 * hash + (int) (Double.doubleToLongBits(this.longitude) ^ (Double.doubleToLongBits(this.longitude) >>> 32));
        hash = 83 * hash + Objects.hashCode(this.description);
        hash = 83 * hash + Objects.hashCode(this.addressInformation);
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
        final Location other = (Location) obj;
        if (this.id != other.id) {
            return false;
        }
        if (Double.doubleToLongBits(this.latitude) != Double.doubleToLongBits(other.latitude)) {
            return false;
        }
        if (Double.doubleToLongBits(this.longitude) != Double.doubleToLongBits(other.longitude)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.addressInformation, other.addressInformation)) {
            return false;
        }
        return true;
    }

    
}
