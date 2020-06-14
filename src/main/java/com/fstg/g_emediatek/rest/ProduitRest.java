/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.g_emediatek.rest;


import com.fstg.e_emediatek.service.ProduitService;
import com.fstg.g_emediatek.bean.Produit;
import com.fstg.g_emediatek.bean.StringResponse;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author alikhyatti
 */
@RestController
@RequestMapping("/e-mediatek/produit")
@CrossOrigin("*")
public class ProduitRest {
    @Autowired
    public ProduitService produitService;
    
    @PostMapping(value = "/")
    public Produit save(@RequestBody Produit produit) {
        return produitService.save(produit);
    } 
    
    @DeleteMapping("/id/{id}")
    public void deleteProduit(@PathVariable long id) {
        produitService.deleteProduit(id);
    }

    @GetMapping("/id/{id}")
    public Produit findById(@PathVariable Long id) {
        return produitService.findById(id);
    }

    @GetMapping("/codeBarre/{codeBarre}")
    public Produit findByCodeBarre(@PathVariable String codeBarre) {
        return produitService.findByCodeBarre(codeBarre);
    }

    @GetMapping("/designation/{designation}")
    public Produit findByDesignation(@PathVariable String designation) {
        return produitService.findByDesignation(designation);
    }

    @GetMapping("/")
    public List<Produit> findAll() {
        return produitService.findAll();
    }
     @PostMapping("/update")
     public Produit updateProduit(@RequestBody Produit produit){
        return produitService.updateProduit(produit);
     }
    @RequestMapping(value = "/demande/{codeBarre}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public StringResponse demande(@PathVariable String codeBarre) {
        return produitService.demande(codeBarre);
    }
     
     
}
