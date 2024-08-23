package com.snowmiku.universitysearchapi.controller;

import com.snowmiku.universitysearchapi.model.University;
import com.snowmiku.universitysearchapi.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class UniversitySearchController {

    @Autowired
    private UniversityService universityService;

    @GetMapping("/search")
    public ResponseEntity<University[]> getUniversitiesByCountry(@RequestParam("country") String country) {
        University[] universities = universityService.getUniversitiesByCountry(country);
        return ResponseEntity.ok(universities);
    }

    @GetMapping("/search/all")
    public ResponseEntity<University[]> getAllUniversities() {
        University[] universities = universityService.getAllUniversities();
        return ResponseEntity.ok(universities);
    }
}