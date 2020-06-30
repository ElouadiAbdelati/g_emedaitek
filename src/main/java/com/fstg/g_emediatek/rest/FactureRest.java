/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.g_emediatek.rest;

import com.fstg.e_emediatek.service.FactureService;
import com.fstg.g_emediatek.bean.Facture;
import com.fstg.g_emediatek.service.Util.DateUtil;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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
@RequestMapping("/e-mediatek/facture")
@CrossOrigin("*")
public class FactureRest {
    @Autowired
    public FactureService factureService;
    
    @PostMapping(value = "/")
    public Facture saveFacture(@RequestBody Facture facture) {
       return  factureService.saveFacture(facture);
    }
    
    @GetMapping("/numeroFacture/{numeroFacture}")
    public Facture findByNumeroFacture(@PathVariable String numeroFacture) {
        return factureService.findByNumeroFacture(numeroFacture);
    }
    
    @GetMapping("/dateFacturation/{dateFacturation}")
    public Facture findByDateFacturation(@PathVariable String dateFacturation) {
        return factureService.findByDateFacturation(DateUtil.parse(dateFacturation));
    }

    @GetMapping("/")
    public List<Facture> findAll() {
        return factureService.findAll();
    }

    @DeleteMapping(value = "/id/{id}")
    public void deleteFacture(@PathVariable long id) {
        factureService.deleteFacture(id);
    }

    @GetMapping("/id/{id}")
    public Facture findById(long id) {
        return factureService.findById(id);
    }
    
}
