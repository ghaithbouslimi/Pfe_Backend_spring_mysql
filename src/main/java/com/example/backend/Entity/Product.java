package com.example.backend.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    /*@EmbeddedId
   private MyDoubleKey id ;*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name="id_produit")
    private Long codeProduit ;

    private String seul ;
    private String  etat ;
    private String preparateur ;
    private String   dateCreation ;
    private String dateMaj ;
    private String designation ;
    private String hostname ;

    // typeproduit
    @ManyToOne
    @JoinColumn(name="id_typeProduit")
    private TypeProduit typeProduit ;
}
