/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.g_emediatek.rest;


import com.fstg.e_emediatek.service.LigneFactureService;
import com.fstg.g_emediatek.bean.Facture;
import com.fstg.g_emediatek.bean.LigneFacture;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author alikhyatti
 */
@RestController
@RequestMapping("/e-mediatek/ligne-facture")
@CrossOrigin("*")
public class LigneFactureRest {
    @Autowired
    public LigneFactureService ligneFactureService;
    
    @PostMapping(value = "/")
    public void save(@RequestBody LigneFacture ligneFacture) {
        ligneFactureService.save(ligneFacture);
    }
    
    @GetMapping("/")
    public List<LigneFacture> findAll() {
        return ligneFactureService.findAll();
    }

    @DeleteMapping(value = "/id/{id}")
    public void deleteLigneFacture(long id) {
        ligneFactureService.deleteLigneFacture(id);
    }

    @GetMapping("/id/{id}")
    public LigneFacture findById(long id) {
        return ligneFactureService.findById(id);
    }
     @PostMapping("/facture")
    public List<LigneFacture> findByFacture(@RequestBody Facture facture) {
        return ligneFactureService.findByFacture(facture);
    }

    @GetMapping("/qteAchetee/{qteAchetee}")
    public LigneFacture findByQteAchetee(double qteAchetee) {
        return ligneFactureService.findByQteAchetee(qteAchetee);
    }

//    public LigneFacture findByProduit(Produit produit) {
//        return ligneFactureService.findByProduit(produit);
//    }
    

}
