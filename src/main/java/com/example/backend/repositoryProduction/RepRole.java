package com.example.backend.repositoryProduction;

import com.example.backend.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface RepRole extends JpaRepository<Role, Long> {
  // Optional<Role> findByNom(String name);
}
