package com.example.backend.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Picklists {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_PickList;
    private  Long Num_pickList ;
    private String Magasin ;
    private Date dateCreation ;
    private Date DateMaj ;
    private String TypePicklist ;
    //code produit from table produit
    private Date Datelivraison ;
    private Date dateServi ;
    private int nb_US_servi ;
    private int nb_Us_Recept ;
    private String Hostname ;
    private String Observation ;
    private Long id_CauseServi ;
    private String printedServi ;
    private String demande_annulation ;
    private String demande_supp_par ;
    private String approb_supp_par ;
    private Date date_demande_suppression ;
    private Date date_approb_suppression ;
    private int nbUSReceptCond ;
    private String setEmp;

    @ManyToOne
    @JoinColumn(name="id_LigneProduction")
    //@JsonIgnore
    private LigneProduction ligneProduction;

    //id status from table statut
    @ManyToOne
    @JoinColumn(name="id_status")
        private Statut statut ;
}
