package com.snowmiku.universitysearchapi.service;

import com.snowmiku.universitysearchapi.model.University;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UniversityService {

    private final RestTemplate restTemplate;

    public UniversityService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public University[] getUniversitiesByCountry(String country) {
        String url = "http://universities.hipolabs.com/search?country=" + country;
        return restTemplate.getForObject(url, University[].class);
    }

    public University[] getAllUniversities() {
        String url = "http://universities.hipolabs.com/search";
        return restTemplate.getForObject(url, University[].class);
    }
}