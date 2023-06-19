package com.example.backend.ServicesProduction;

import com.example.backend.Entity.Role;
import com.example.backend.Entity.User;
import com.example.backend.repositoryProduction.RepRole;
import com.example.backend.repositoryProduction.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceRole {

    @Autowired
    private RoleRepository repRole ;

    public List<Role> getAll() { return repRole.findAll() ; } ;
    public Role save (Role role ) {return repRole.save(role) ; }
    public Role update (Role role ) {return repRole.save(role) ; }
    public Role findByid(Long id)
    {
        return repRole.findById(id).get();
    }

    public void Delete(Long id)
    {
        Role role = findByid(id);
        repRole.delete(role);
    }

    public Optional<Role> getOne(Long id)
    {
        return repRole.findById(id);
    }


}
