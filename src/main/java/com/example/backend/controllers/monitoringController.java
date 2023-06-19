package com.example.backend.controllers;

import com.example.backend.ServicesProduction.monitoringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/monitoring")
public class monitoringController {
    @Autowired
    private monitoringService monitoringService ;
    @GetMapping("/{id}")
    public Boolean monitoring(@PathVariable("id") Long id )
    {

        //try {
           if( monitoringService.monitoring(id ))
           {
               return true ;

           } else {
               return false;

           }






    }
}
