package com.example.backend.ServicesProduction;

import com.example.backend.Entity.LigneProduction;
import com.example.backend.Entity.Picklists;
import com.example.backend.Entity.Statut;
import com.example.backend.Entity.Us_Picklist;
import com.example.backend.repositoryProduction.RepStatut;
import com.example.backend.repositoryProduction.RepUs_Picklist;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceUsPicklist {
    @Autowired(required = true)
    private RepUs_Picklist repUsPicklist;
    @Autowired(required = true)
    private RepStatut repStatut;

    public List<Us_Picklist> getAllUsPicklist(){
        return repUsPicklist.findAll();
    }

    public Us_Picklist createUsPicklist(Us_Picklist usPicklist){
        return  repUsPicklist.save(usPicklist);
    }

    public Us_Picklist findById(Long id){
        return repUsPicklist.findById(id).get();
    }

    public Us_Picklist update(Us_Picklist usPicklist){
        return repUsPicklist.save(usPicklist);
    }
    public void save(List<Us_Picklist>  US){
         repUsPicklist.saveAll(US);
    }

    public void delete(Long id){
        Us_Picklist usPicklist = findById(id);
        repUsPicklist.delete(usPicklist);
    }
    public List<Us_Picklist> findAllByIdpicklistAndLigneProduction(Picklists p, LigneProduction l){
        return repUsPicklist.findAllByIdpicklistAndLigneProduction(p,l);
    }
//
//


    public Optional<Us_Picklist> getOne(Long id)
    {
        return repUsPicklist.findById(id);
    }


    public List<Us_Picklist> findStatu(Statut s ){
        return repUsPicklist.findAllByIdstatus(s) ;
    }

    public Us_Picklist changeStatut (Long p) {
       Us_Picklist us = repUsPicklist.findById(p).get();
        Statut s = repStatut.getById(us.getIdstatus().getId_status());
         if (s.getId_status()==10){
             long longValue = 11;
             us.setIdstatus(repStatut.getById(longValue));
         }else {
             long longValue = 10;
             us.setIdstatus(repStatut.getById(longValue));
         }
         return repUsPicklist.save(us);
    }




}


