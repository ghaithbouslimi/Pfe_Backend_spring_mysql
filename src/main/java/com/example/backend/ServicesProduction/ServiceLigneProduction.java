package com.example.backend.ServicesProduction;

import com.example.backend.Entity.LigneProduction;
import com.example.backend.repositoryProduction.RepProduction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceLigneProduction {

    @Autowired
    private RepProduction RepLigneProduction ;

    public List<LigneProduction> getAllLigneProduction()
    {
        return RepLigneProduction.findAll();
    }

    public Optional<LigneProduction> getOne(Long id)
    {
        return RepLigneProduction.findById(id);
    }
    public LigneProduction findByid(Long id)
    {
        return RepLigneProduction.findById(id).get();
    }

    public LigneProduction saveLigneProduction(LigneProduction ligneProduction)
    {
        return RepLigneProduction.save(ligneProduction);
    }
    public LigneProduction updateLigneProduction(LigneProduction ligneProduction)
    {
        return RepLigneProduction.save(ligneProduction);
    }

    public boolean exsitById(Long id )
    {
        return RepLigneProduction.existsById(id);
    }
    public void DeleteLigneProduction(Long id)
    {
        LigneProduction ligneProduction = findByid(id);
        RepLigneProduction.delete(ligneProduction);
    }
}
