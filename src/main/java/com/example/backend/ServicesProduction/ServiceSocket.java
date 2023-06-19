package com.example.backend.ServicesProduction;

import com.example.backend.Entity.Socket;
import com.example.backend.repositoryProduction.RepSocket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceSocket {

    @Autowired(required=true)
    private RepSocket repSocket ;

    public List<Socket> findAllSocket() { return repSocket.findAll() ; }
    public Socket saveSocket(Socket socket){
        return repSocket.save(socket) ;
    }
    public Socket updateSocket(Socket socket){
        return repSocket.save(socket);
    }
    public Socket findByid(Long id)
    {
        return repSocket.findById(id).get();
    }

    public void DeleteSocket(Long id)
    {
        Socket socket = findByid(id);
        repSocket.delete(socket);
    }

    public Optional<Socket> getOne(Long id)
    {
        return repSocket.findById(id);
    }

//    @schedule
    public Socket changeStatus(Long id ) {
        Socket s = repSocket.findById(id).get();
        switch (s.getEtat()) {
            case "enable":
                s.setEtat("desable");
            break;
            case "desable":
                s.setEtat("enable");
            break;
        }
        return repSocket.save(s);
    }


    public List<Socket> getByEtat (String etat ) {
        return repSocket.findAllByEtat(etat) ;
    }

   }

