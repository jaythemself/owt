package com.owt.owtbackend.models;

import jakarta.persistence.Entity;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;
import java.util.Objects;

// using lombok rn but is it best? spring validation n hib
@Entity
public class location extends abstractEntity {

    @NotBlank(message = "Name of location is required.")
    private String locationName;

    @NotBlank(message = "Street address of location is required.")
    @Size(min = 1, max = 99)
    private String locationStreet;

    @NotBlank(message = "City of location is required.")
    private String locationCity;

    @NotBlank(message = "State of location is required.")
    private String locationState;

    @Size(min = 5, message = "Please enter a valid zip code, i.e. XXXXX or XXXXX-XXXX")
    private String locationZip;


    public String getLocationName() {
        return locationName;
    }
    public void setLocationName() {
        this.locationName = locationName;
    }

    public String getLocationStreet() {
        return locationStreet;
    }
    public void setLocationStreet() {
        this.locationStreet = locationStreet;
    }

    //getters and setters for city state and zip
}
