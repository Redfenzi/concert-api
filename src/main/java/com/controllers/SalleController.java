package com.controllers;

import com.dtos.SalleDto;
import com.services.impl.SalleServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sales")
public class SalleController {

    private final SalleServiceImpl salleService;

    public SalleController(SalleServiceImpl salleService) {
        this.salleService = salleService;
    }

    @GetMapping
    public List<SalleDto> getSales(){
        return salleService.getAllSalles();
    }

    @GetMapping("/{id}")
    public SalleDto getSalle(@PathVariable Long id){
        return salleService.getSalleById(id);
    }

    @PostMapping("/addsalle")
    public SalleDto saveSalle(final @RequestBody SalleDto salleDto){

        return salleService.saveSalle(salleDto);
    }

    @DeleteMapping("/{id}")
    public Boolean deleteSalle(@PathVariable Long id){
        return salleService.deleteSalle(id);
    }
}
