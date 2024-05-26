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

}