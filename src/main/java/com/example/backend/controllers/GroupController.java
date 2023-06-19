package com.example.backend.controllers;

import com.example.backend.Entity.Groups;
import com.example.backend.ServicesProduction.ServiceGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)

@RequestMapping("/api/group")
public class GroupController {

    @Autowired
    private ServiceGroup serviceGroup ;

    @GetMapping("/all")
    public List getall(){return serviceGroup.findAll();}

    @PostMapping("/create")
    public Groups post(@RequestBody Groups user)
    {
        return serviceGroup.save(user) ;
    }
    @PutMapping("/update")
    public Groups update(@RequestBody Groups user) {
        return serviceGroup.update(user);
    }


    @GetMapping("/group/{id}")
    public ResponseEntity<Groups> getByID
            (@PathVariable("id") Long id) {
        Optional<Groups> One = serviceGroup.getOne(id);

        if (One.isPresent()) {
            return new ResponseEntity<>(One.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") long id) {
        try {
            serviceGroup.Delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("/countGroup")
    private int count() {
        return serviceGroup.findAll().size();
    }
}
