package com.zialdiansyah.online_cinema_ticket.service.impl;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zialdiansyah.online_cinema_ticket.dto.CityDTO;
import com.zialdiansyah.online_cinema_ticket.domain.City;
import com.zialdiansyah.online_cinema_ticket.repository.CityRepository;
import com.zialdiansyah.online_cinema_ticket.service.CityService;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepository cityRepository;

    @Override
    public List<CityDTO> getAllCities() {
        return cityRepository.findAll().stream()
            .map(this::convertToDTO)
            .collect(Collectors.toList());
    }

    private CityDTO convertToDTO(City city) {
        CityDTO dto = new CityDTO();
        dto.setCityId(city.getCityId());
        dto.setName(city.getName());
        return dto;
    }
}
