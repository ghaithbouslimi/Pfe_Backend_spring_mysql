package com.example.backend.controllers;

import com.example.backend.Entity.LigneProduction;
import com.example.backend.Entity.Picklists;
import com.example.backend.ServicesProduction.ServiceLigneProduction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/ligne")
public class LigneProductionController {

    @Autowired
    private ServiceLigneProduction serviceLigneProduction ;

    @GetMapping("/all")
    public List getAllligne(){
        return serviceLigneProduction.getAllLigneProduction();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LigneProduction> getSocketByID
            (@PathVariable("id") Long id) {
        Optional<LigneProduction> socketOne = serviceLigneProduction.getOne(id);

        if (socketOne.isPresent()) {
            return new ResponseEntity<>(socketOne.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/create")
    public LigneProduction save(@RequestBody LigneProduction ligne)
    {
        return serviceLigneProduction.saveLigneProduction(ligne);
    }


}


