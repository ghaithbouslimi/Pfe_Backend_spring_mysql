package com.example.backend.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Groups {
    @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idGroup;
    private String name ;
    private String people ;
}
