package com.example.backend.Entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "roles")
@Data
public class Role {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  //@Enumerated(EnumType.STRING)
  @Column(length = 20)
  private String name;



  public Role() {

  }



}