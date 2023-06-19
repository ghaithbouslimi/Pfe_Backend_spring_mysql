package com.example.backend.controllers;

import com.example.backend.Entity.Socket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.Optional;
import java.util.List;
import com.example.backend.Entity.Picklists;
import com.example.backend.ServicesProduction.ServicePicklist;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/picklist")
public class PicklistController {
     
    @Autowired
    private ServicePicklist servicePicklist ; 

    @GetMapping("/all")
    public List getAllPicklist(){
        return servicePicklist.getAllPicklists(); 
    } 
    @PostMapping("/create")
    public Picklists postPicklist(@RequestBody Picklists picklists)
    {
        return servicePicklist.savePicklists(picklists);
    }
    @PutMapping("/update")
    public Picklists updatePicklist(@RequestBody Picklists picklists) {
       return servicePicklist.savePicklists(picklists);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Picklists> getSocketByID
            (@PathVariable("id") Long id) {
        Optional<Picklists> socketOne = servicePicklist.getOne(id);

        if (socketOne.isPresent()) {
            return new ResponseEntity<>(socketOne.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deletePicklist(@PathVariable("id") long id) {
        try {
            servicePicklist.deletePicklist(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadExcelFile(@RequestParam("file") MultipartFile file) {
        try {
            servicePicklist.saveExcelData(file);
            return ResponseEntity.status(HttpStatus.OK).body("File uploaded successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Error uploading file");
        }
    }
}
