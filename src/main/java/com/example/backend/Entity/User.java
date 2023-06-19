package com.example.backend.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.FetchType.EAGER;

@Entity
@Table(name = "users", 
    uniqueConstraints = { 
      @UniqueConstraint(columnNames = "username"),
      @UniqueConstraint(columnNames = "email") 
    })
@Data
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  @Size(max = 20)
  private String username;

  @NotBlank
  @Size(max = 50)
  @Email
  private String email;

  @NotBlank
  @Size(max = 120)
  private String password;
  private String numtel ;
  private String matricule ;

  public String getNumtel() {
    return numtel;
  }

  public void setNumtel(String numtel) {
    this.numtel = numtel;
  }

  public String getMatricule() {
    return matricule;
  }

  public void setMatricule(String matricule) {
    this.matricule = matricule;
  }

  @ManyToMany(fetch = EAGER,cascade = {
          //CascadeType.PERSIST,
          CascadeType.MERGE
  })
    @JoinTable(  name = "user_roles",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "role_id"))
  private Collection<Role> roles = new ArrayList<>();
//  @ManyToMany(fetch = EAGER,cascade = {
//          CascadeType.PERSIST,
//          CascadeType.MERGE)
//  @JoinTable(  name = "user_roles",
//        joinColumns = @JoinColumn(name = "user_id"),
//        inverseJoinColumns = @JoinColumn(name = "role_id"))
  //private Set<Role> roles = new HashSet<>();

  public User() {
  }

  public User(String username, String email, String password , String matricule , String numtel) {
    this.username = username;
    this.email = email;
    this.password = password;
    this.matricule =matricule ;
    this.numtel =numtel;

  }

  public User(String username, String email, String password, String numtel, String matricule, Collection<Role> roles) {

    this.username = username;
    this.email = email;
    this.password = password;
    this.numtel = numtel;
    this.matricule = matricule;
    this.roles = roles;
  }


}
