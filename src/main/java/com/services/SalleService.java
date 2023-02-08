package com.services;

import com.dtos.DogDto;
import com.dtos.SalleDto;

import java.util.List;

public interface SalleService {

    SalleDto saveSalle(SalleDto salleDto);
    SalleDto getSalleById(Long salleId);
    boolean deleteSalle(Long salleId);
    List<SalleDto> getAllSalles();

}
