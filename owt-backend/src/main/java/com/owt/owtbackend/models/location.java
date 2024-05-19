package com.owt.owtbackend.models;

import jakarta.persistence.Entity;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

// using lombok rn but is it best? spring validation n hib
@Entity
public class location extends abstractEntity {

    @Getter
    @NotBlank(message = "Name of location is required.")
    private String locationName;

    @Getter
    @NotBlank(message = "Street address of location is required.")
    @Size(min = 1, max = 99)
    private String locationStreet;

    @Getter
    @NotBlank(message = "City of location is required.")
    private String locationCity;

    @Getter
    @NotBlank(message = "State of location is required.")
    private String locationState;

    @Size(min = 5, message = "Please enter a valid zip code, i.e. XXXXX or XXXXX-XXXX")
    private String locationZip;


    //is there any conflict in using lombok @Setter as well? double check intended use
    public void setLocationName() {
        this.locationName = locationName;
    }

    public void setLocationStreet() {
        this.locationStreet = locationStreet;
    }

    public void setLocationCity() {
        this.locationCity = locationCity;
    }

    public void setLocationState() {
        this.locationState = locationState;
    }

    public String getLocationZip() {
        return locationZip;
    }
    public void setLocationZip() {
        this.locationZip = locationZip;
    }

    //overrides
}
