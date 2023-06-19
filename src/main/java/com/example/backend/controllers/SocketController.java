package com.example.backend.controllers;

import com.example.backend.Entity.Socket;
import com.example.backend.Entity.Statut;
import com.example.backend.Entity.Us_Picklist;
import com.example.backend.ServicesProduction.ServiceSocket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/socket")
public class SocketController {

    @Autowired(required = true)
    private ServiceSocket socketService ;

    @GetMapping("/all")
    public List getallsocket(){return socketService.findAllSocket();}

    @PostMapping("/create")
    public Socket postSocket(@RequestBody Socket socket)
    {
        return socketService.saveSocket(socket) ;
    }
    @PutMapping("/update")
    public Socket updateSocket(@RequestBody Socket socket) {
        return socketService.updateSocket(socket);
    }
//    @PutMapping("/change")
//    public Socket changeStatus(@RequestBody Socket socket) {
//        return socketService.changeStatus(socket);
//    }

    @GetMapping("/socket/{id}")
    public ResponseEntity<Socket> getSocketByID
            (@PathVariable("id") Long id) {
        Optional<Socket> socketOne = socketService.getOne(id);

        if (socketOne.isPresent()) {
            return new ResponseEntity<>(socketOne.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteSocket(@PathVariable("id") long id) {
        try {
            socketService.DeleteSocket(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/countSocket")
    private int count () {
        return socketService.findAllSocket().size();
    }

    @GetMapping("/chageStatut{idsocket}")
    public void changeStatut(@PathVariable Long  id_socket){
        socketService.changeStatus(id_socket);
    }

    @GetMapping("/findStatu/{etat}")
    public int findStatu(@PathVariable String etat)
    {
     return socketService.getByEtat(etat).size();
    }
    @GetMapping("/findListEnable/{etat}")
    public List<Socket> findListEnable(@PathVariable String etat)
    {
        return socketService.getByEtat(etat) ;
    }
   
}
