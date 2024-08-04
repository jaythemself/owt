// set package, imports, and shell for adding, updating, deleting, displaying site info
// set up sql and basic user authentication, refactor frontend to manage queries, api

package com.owt.owtbackend.controllers;

import com.owt.owtbackend.models.location;
import com.owt.owtbackend.models.data.locationRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/locations")
public class locationController {

    @Autowired
    private locationRepository locationRepository;

    @GetMapping
    public String displayLocationPage(Model model) {
        model.addAttribute("locations", locationRepository.findAll());
        return "locations/locationindex";
    }

    @GetMapping("/add")
    public String displayAddLocationForm(Model model) {
        model.addAttribute("location", new location());
        return "locations/add";
    }

    @PostMapping("/add")
    public String processAddLocationForm(@ModelAttribute @Valid location location, Errors errors) {
        if (errors.hasErrors()) {
            return "locations/add";
        } else {
            locationRepository.save(location);
            return "redirect:/locations";
        }
    }

    @GetMapping("/delete")
    public String displayLocationDeleteForm(Model model) {
        model.addAttribute("locationList", locationRepository.findAll());
        return "locations/delete";
    }

    @PostMapping("/delete")
    public String processDeleteLocationForm(@RequestParam(required = false) int[] locationIds) {
        for (int id : locationIds) {
            locationRepository.deleteById(id);
        }
        return "redirect:/locations";
    }

    @GetMapping("/update/{id}")
    public String showUpdateLocationForm(@PathVariable int id, Model model) {
        location location = locationRepository.findById(id).orElse(null);

        if (location == null) {
            return "redirect:/locations";
        }

        model.addAttribute("location", location);
        return "locations/update";
    }

    @PostMapping("/update/{id}")
    public String updateLocation(@PathVariable int id, @ModelAttribute @Valid location updatedLocation, Errors errors) {
        if (errors.hasErrors()) {
            return "/locations/update";
        }

        location existingLocation = locationRepository.findById(id).orElse(null);

        if (existingLocation == null) {
            return "redirect:/locations";
        }

        existingLocation.setLocationName(updatedLocation.getLocationName());
        existingLocation.setLocationStreet(updatedLocation.getLocationStreet());
        existingLocation.setLocationCity(updatedLocation.getLocationCity());
        existingLocation.setLocationState(updatedLocation.getLocationState());
        existingLocation.setLocationZip(updatedLocation.getLocationZip());
        existingLocation.setHours(updatedLocation.getHours());
        existingLocation.setUniqueComment(updatedLocation.getUniqueComment());

        locationRepository.save(existingLocation);
        return "redirect:/locations";
    }
}