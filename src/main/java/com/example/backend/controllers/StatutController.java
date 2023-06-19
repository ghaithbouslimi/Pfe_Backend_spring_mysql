package com.example.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.example.backend.Entity.Statut;
import com.example.backend.ServicesProduction.ServiceStaut;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/statut")
public class StatutController {

    @Autowired 
    private ServiceStaut serviceStaut ; 

    @GetMapping("/all")
    private List <Statut> getAllStatut(){
        return serviceStaut.getAllStatut();
    }

    @PostMapping("/create")
    public Statut postStatut( @RequestBody Statut statut)
    {
        return serviceStaut.saveSatut(statut); 
    }
}
