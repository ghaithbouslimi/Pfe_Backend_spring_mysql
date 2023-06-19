package com.example.backend.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Us_Picklist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsPickliste;
    private String numUS;
    //@Column(nullable = false)
    private int quantite ;
    private String source ;
   private String hostname;
    private String   majpar ;
//    @JsonFormat(pattern = "dd/mm/yy HH:mm:ss")
//    @Temporal(TemporalType.TIMESTAMP)
    private Date datecreation ;
//    @JsonFormat(pattern = "dd/mm/yy HH:mm:ss")
//    @Temporal(TemporalType.TIMESTAMP)
    private  Date datemaj ;
    @ManyToOne
    @JoinColumn(name="id_status")
    private Statut idstatus ;
    @ManyToOne
    @JoinColumn(name="id_picklist")
    private Picklists idpicklist ;
    @ManyToOne
    @JoinColumn(name="ligneProduction")
    private LigneProduction ligneProduction;

    @ManyToOne
    @JoinColumn(name="num_us")
    private InformationUs informationUs ;


}
