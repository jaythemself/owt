package com.owt.owtbackend.models;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Objects;

// using lombok rn but is it best? spring validation n hib
@Getter
@Setter
@Entity
@NoArgsConstructor
public class location extends abstractEntity {

    @Id
    private int id;

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

    //placeholder; turn this into a dropdown menu with a limited selection of categories during second pass
    @NotBlank(message = "Type of venue is required.")
    private String typeOfVenue;

    //maybe make this optional for sites with hours that change by week day/month or obscured?
    @NotBlank(message = "Hours of operation are required.")
    private String hours;

    //optional
    @Size(max = 255, message = "Comment cannot exceed 255 characters.")
    private String uniqueComment;

}
