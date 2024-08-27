package com.snowmiku.universitysearchapi.service;

import com.snowmiku.universitysearchapi.pojo.UniversityDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UniversityService {
    UniversityDTO[] getAllUniversities();
    UniversityDTO[] getUniversitiesByCountries(List<String> countries);
}
