package com.example.backend.repositoryProduction;

import com.example.backend.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepProduct extends JpaRepository<Product, Long> {
}
