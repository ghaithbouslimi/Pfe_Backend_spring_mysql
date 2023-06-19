package com.example.backend.repositoryProduction;

import com.example.backend.Entity.LigneProduction;
import com.example.backend.Entity.Picklists;
import com.example.backend.Entity.Statut;
import com.example.backend.Entity.Us_Picklist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepUs_Picklist extends JpaRepository<Us_Picklist , Long> {
        List<Us_Picklist> findAllByIdpicklistAndLigneProduction(Picklists p, LigneProduction l);
         List<Us_Picklist> findAllByIdstatus(Statut s) ;

        }


