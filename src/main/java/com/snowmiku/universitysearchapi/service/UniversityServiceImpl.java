package com.snowmiku.universitysearchapi.service;

import com.snowmiku.universitysearchapi.pojo.UniversityDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

@Service
public class UniversityServiceImpl implements UniversityService {

    @Value("${university.url}")
    private String url;
    private final RestTemplate restTemplate;
    private final ExecutorService threadPool;

    public UniversityServiceImpl(RestTemplate restTemplate, ExecutorService threadPool) {
        this.restTemplate = restTemplate;
        this.threadPool = threadPool;
    }

    public UniversityDTO[] getUniversitiesByCountries(List<String> countries) {
        List<CompletableFuture<UniversityDTO[]>> futures = countries.stream()
                .map(country -> CompletableFuture.supplyAsync(
                        () -> restTemplate.getForObject(url + "?country=" + country, UniversityDTO[].class),
                        threadPool))
                .toList();

        List<UniversityDTO> tempList = futures.stream()
                .map(CompletableFuture::join)
                .flatMap(java.util.Arrays::stream)
                .toList();

        return tempList.toArray(new UniversityDTO[0]);
    }

    public UniversityDTO[] getAllUniversities() {
        return restTemplate.getForObject(url, UniversityDTO[].class);
    }
}