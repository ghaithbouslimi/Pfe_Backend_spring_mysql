package com.example.backend.repositoryProduction;

import com.example.backend.Entity.LigneProduction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepProduction extends JpaRepository<LigneProduction , Long> {
}
