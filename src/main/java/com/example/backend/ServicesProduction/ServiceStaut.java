package com.example.backend.ServicesProduction;

import com.example.backend.Entity.Statut;
import com.example.backend.Entity.User;
import com.example.backend.repositoryProduction.RepStatut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceStaut {

    @Autowired
    private RepStatut repesorityStatut ;

    public List<Statut> getAllStatut()
    {
        return repesorityStatut.findAll();
    }
    public Statut saveSatut(Statut statut)
    {
        return repesorityStatut.save(statut);
    }
    public Statut updateStatut(Statut statut)
    {
        return repesorityStatut.save(statut);
    }
    public Statut findByid(Long id)
    {
        return repesorityStatut.findById(id).get();
    }

}
