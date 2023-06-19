package com.example.backend.controllers;

import com.example.backend.Entity.LigneProduction;
import com.example.backend.Entity.Picklists;
import com.example.backend.Entity.Statut;
import com.example.backend.Entity.Us_Picklist;
import com.example.backend.ServicesProduction.ServiceLigneProduction;
import com.example.backend.ServicesProduction.ServicePicklist;
import com.example.backend.ServicesProduction.ServiceStaut;
import com.example.backend.ServicesProduction.ServiceUsPicklist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/uspicklist")
public class UsPicklistController {

    @Autowired(required = true)
    private ServiceUsPicklist serviceUsPicklist ;
    @Autowired(required = true)
    private ServiceLigneProduction serviceLigneProduction ;
    @Autowired(required = true)
    private ServicePicklist servicePicklist ;
    @Autowired(required = false)
    private ServiceStaut serviceStaut ;


    @GetMapping("/{id}")
    public ResponseEntity<Us_Picklist> geByID
            (@PathVariable("id") Long id) {
        Optional<Us_Picklist> socketOne = serviceUsPicklist.getOne(id);

        if (socketOne.isPresent()) {
            return new ResponseEntity<>(socketOne.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/all")
    public List<Us_Picklist> getAll(){
        return serviceUsPicklist.getAllUsPicklist();
    }
//    @GetMapping("/consomme")
//    public List<Us_Picklist> getAllConsomme(){
//        return serviceUsPicklist.getUsConsomme();
//    }

    @PostMapping("/create")
    public Us_Picklist create( @RequestBody Us_Picklist usPicklist){
        return serviceUsPicklist.createUsPicklist(usPicklist);
    }
    @PutMapping("/update")
    public Us_Picklist update(@RequestBody Us_Picklist usPicklist){
        return serviceUsPicklist.createUsPicklist(usPicklist);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<HttpStatus> deleteUsPicklist(@PathVariable("id") long id) {
        try {
            serviceUsPicklist.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/findbypandl")
    public List<Us_Picklist> findAllByIdpicklistAndLigneProduction(@RequestBody Picklists picklists, @RequestBody LigneProduction ligneProduction){
        return serviceUsPicklist.findAllByIdpicklistAndLigneProduction(picklists,ligneProduction);
    }

    @GetMapping("/find/{idPicklist}/{idLigne}")
    public List<Us_Picklist> findAllByIdpicklistAndLigneProduction(@PathVariable Long idPicklist,
                                                                  @PathVariable Long idLigne){
        Picklists p = servicePicklist.findByid(idPicklist);
        LigneProduction l = serviceLigneProduction.findByid(idLigne);
        return  serviceUsPicklist.findAllByIdpicklistAndLigneProduction(p,l);
    }

    @GetMapping("/findStatu/{idstatus}")
    public int findStatu(@PathVariable int idstatus)
    {
        long longValue = idstatus;
        Statut s = serviceStaut.findByid(longValue) ;
         return serviceUsPicklist.findStatu(s).size() ;
    }
    @GetMapping("/getListNonConsomme/{idstatus}")
    public List getListNonConsomme(@PathVariable int idstatus)
    {
        long longValue = idstatus;
        Statut s = serviceStaut.findByid(longValue) ;
        return serviceUsPicklist.findStatu(s) ;
    }


    @GetMapping("/countUS")
    public int CountUs() {
         return serviceUsPicklist.getAllUsPicklist().size() ;
    }

    @GetMapping("/changeStatut/{idUsPickliste}")
    public void changeStatut(@PathVariable Long idUsPickliste){
         serviceUsPicklist.changeStatut(idUsPickliste);
    }




}
