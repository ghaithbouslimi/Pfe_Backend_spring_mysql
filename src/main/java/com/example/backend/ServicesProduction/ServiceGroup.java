package com.example.backend.ServicesProduction;

import com.example.backend.Entity.Groups;
import com.example.backend.Entity.Socket;
import com.example.backend.repositoryProduction.RepGroups;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceGroup {
    @Autowired
    private RepGroups repGroups ;

    public List<Groups> findAll() { return repGroups.findAll() ; }
    public Groups save(Groups group){
        return repGroups.save(group) ;
    }
    public Groups update(Groups group){
        return repGroups.save(group);
    }
    public Groups findByid(Long id)
    {
        return repGroups.findById(id).get();
    }

    public void Delete(Long id)
    {
        Groups group = findByid(id);
        repGroups.delete(group);
    }

    public Optional<Groups> getOne(Long id)
    {
        return repGroups.findById(id);
    }}
