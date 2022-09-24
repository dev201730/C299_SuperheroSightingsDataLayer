package com.example.superherosightings.models;

import java.sql.Date;
import java.util.List;
import java.util.Objects;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Sighting {
    
    private int id;
    private int heroId;
    private Location location;
    private Date date;

    @Override
    public String toString() {
        return "Sighting{" + "id=" + id + ", heroId=" + heroId + ", location=" + location + ", date=" + date + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.id;
        hash = 97 * hash + this.heroId;
        hash = 97 * hash + Objects.hashCode(this.location);
        hash = 97 * hash + Objects.hashCode(this.date);
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
        final Sighting other = (Sighting) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.heroId != other.heroId) {
            return false;
        }
        if (!Objects.equals(this.location, other.location)) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        return true;
    }

    
}
