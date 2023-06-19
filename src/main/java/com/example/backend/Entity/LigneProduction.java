package com.example.backend.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LigneProduction {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_LigneProduction ;
    private  int codeLigneProduction ;
    private Long id_UniteFabrication ;
    private String etat ;
    private String observation ;
    private String RobotTraitement ;
    private Date dateCreation ;
    private Date dateMaj ;
    private String hostname ;
    private String boucle ;
    private String forced ;
    private String ProduitForced ;
    //id socket from table socket
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name="socket_production",
            joinColumns = @JoinColumn(name = "id_LigneProduction") ,
            inverseJoinColumns = @JoinColumn(name = "id_socket")
    )
    private List<Socket> socket = new ArrayList<>() ;

    // picklists
    /*@OneToMany(mappedBy = "id_PickList")
    @JsonIgnore
    private List<Picklists> picklists ;*/
}
