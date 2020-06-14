/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.g_emediatek.rest;


import com.fstg.e_emediatek.service.JournalisationService;
import com.fstg.g_emediatek.bean.Journalisation;
import com.fstg.g_emediatek.bean.Produit;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author alikhyatti
 */
@RestController
@RequestMapping("/e-mediatek/journalisation")
@CrossOrigin("*")
public class JournalisationRest {
     @Autowired
    public JournalisationService journalisationService;
    @GetMapping(value = "/")
    public List<Journalisation> findAll() {
        return journalisationService.findAll();
    }
    @GetMapping(value = "/id/{id}")
    public Journalisation findById(@PathVariable Long id) {
        return journalisationService.findById(id);
    }
     @PostMapping(value = "/produit")
    public Journalisation findByProduit(@RequestBody Produit produit) {
        return journalisationService.findByProduit(produit);
    }
    
    
}
