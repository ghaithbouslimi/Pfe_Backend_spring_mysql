package com.example.backend.controllers;

import com.example.backend.Entity.Groups;
import com.example.backend.Entity.Role;
import com.example.backend.ServicesProduction.ServiceRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)

@RequestMapping("/api/role")
public class RoleController {

   @Autowired
   private ServiceRole serviceRole ;
    @GetMapping("/all")
    public List getall(){return serviceRole.getAll();}

    @PostMapping("/create")
    public Role post(@RequestBody Role role)
    {
        return serviceRole.save(role) ;
    }
    @PutMapping("/update")
    public Role update(@RequestBody Role role) {
        return serviceRole.update(role);
    }


    @GetMapping("/role/{id}")
    public ResponseEntity<Role> getByID
            (@PathVariable("id") Long id) {
        Optional<Role> One = serviceRole.getOne(id);

        if (One.isPresent()) {
            return new ResponseEntity<>(One.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Long id) {
        try {
            serviceRole.Delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
