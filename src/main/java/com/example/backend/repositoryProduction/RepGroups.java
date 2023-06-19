package com.example.backend.repositoryProduction;

import com.example.backend.Entity.Groups;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepGroups extends JpaRepository<Groups , Long> {
}
