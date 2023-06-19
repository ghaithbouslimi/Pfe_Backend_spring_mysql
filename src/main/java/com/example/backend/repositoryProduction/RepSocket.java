package com.example.backend.repositoryProduction;

import com.example.backend.Entity.Socket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepSocket extends JpaRepository<Socket, Long> {

    List<Socket> findAllByEtat(String etat) ;
}
