package com.example.backend.controllers;

import com.example.backend.Entity.Socket;
import com.example.backend.Entity.User;
import com.example.backend.ServicesProduction.ServiceUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private ServiceUsers serviceUsers ;

    @GetMapping("/all")
    public List getallsocket(){return serviceUsers.getAll();}

    @PostMapping("/create")
    public User post(@RequestBody User user)
    {
        return serviceUsers.save(user) ;
    }
    @PutMapping("/update")
    public User update(@RequestBody User user) {
        return serviceUsers.update(user);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable Long userId, @RequestBody User updatedUser) {
        User updated = serviceUsers.updateUser(userId, updatedUser);
        return ResponseEntity.ok(updated);
    }
    @GetMapping("/user/{id}")
    public ResponseEntity<User> getByID
            (@PathVariable("id") Long id) {
        Optional<User> One = serviceUsers.getOne(id);

        if (One.isPresent()) {
            return new ResponseEntity<>(One.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") long id) {
        try {
            serviceUsers.Delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/countUser")
    private int count() {
        return serviceUsers.getAll().size();
    }
}

