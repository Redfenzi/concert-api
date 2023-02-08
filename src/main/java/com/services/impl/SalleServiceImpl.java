package com.services.impl;

import com.dtos.DogDto;
import com.dtos.SalleDto;
import com.entities.Dog;
import com.entities.Salle;
import com.repositories.SalleRepository;
import com.services.SalleService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service("salleService")
public class SalleServiceImpl implements SalleService {

    private final SalleRepository salleRepository;

    public SalleServiceImpl(SalleRepository salleRepository) {
        this.salleRepository = salleRepository;
    }

    @Override
    public SalleDto saveSalle(SalleDto salleDto) {
        // Converts the dto to the salle entity
        Salle salle = salleDtoToEntity(salleDto);
        // Save the salle entity
        salle = salleRepository.save(salle);
        // Return the new dto
        return salleEntityToDto(salle);
    }

    @Override
    public SalleDto getSalleById(Long salleId) {
        Salle salle = salleRepository.findById(salleId).orElseThrow(() -> new EntityNotFoundException("Id salle introuvable"));
        return salleEntityToDto(salle);
    }

    @Override
    public boolean deleteSalle(Long salleId) {
        salleRepository.deleteById(salleId);
        return true;
    }

    @Override
    public List<SalleDto> getAllSalles() {
        List<SalleDto> salleDtos = new ArrayList<>();
        List<Salle> salles = salleRepository.findAll();
        salles.forEach(salle -> {
            salleDtos.add(salleEntityToDto(salle));
        });
        return salleDtos;
    }

    /**
     * Map dog dto to dog entity
     */
private SalleDto salleEntityToDto(Salle salle){
        SalleDto salleDto = new SalleDto();
        salleDto.setNom(salle.getNom());
        salleDto.setCapacite(salle.getCapacite());
        return salleDto;
    }

    /**
     * Map dog entity to dog dto
     */
    private Salle salleDtoToEntity(SalleDto salleDto){
        Salle salle = new Salle();
        salle.setNom(salleDto.getNom());
        salle.setCapacite(salleDto.getCapacite());
        return salle;
    }
}
