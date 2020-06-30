/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.g_emediatek.service.Impl;

import com.fstg.e_emediatek.service.FactureService;
import com.fstg.e_emediatek.service.LigneFactureService;
import com.fstg.g_emediatek.bean.Facture;
import com.fstg.g_emediatek.bean.LigneFacture;
import com.fstg.g_emediatek.dao.FactureDao;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author alikhyatti
 */
@Service
public class FactureServiceImpl implements FactureService {

    @Autowired
    private FactureDao factureDao;
   
    @Autowired
    private LigneFactureService ligneFactureService;
    

    @Override
    public Facture findByNumeroFacture(String numeroFacture) {
        return factureDao.findByNumeroFacture(numeroFacture);
    }

    @Override
    public Facture findByDateFacturation(Date dateFacturation) {
        return factureDao.findByDateFacturation(dateFacturation);
    }

    @Override
    public List<Facture> findAll() {
        return factureDao.findAll();
    }

    @Override
    public void deleteFacture(long id) {
        factureDao.deleteById(id);
    }

    @Override
    public Facture findById(long id) {
        return factureDao.findById(id).get();
    }

    @Override
    public void save(Facture facture) {
        factureDao.save(facture);
    }

    @Override
    public Facture saveFacture(Facture facture) {
        if (valideProduits(facture.getLigneFactures())) {
            long millis = System.currentTimeMillis();
            java.sql.Date date = new java.sql.Date(millis);
            facture.setDateFacturation(date);
            facture.setNumeroFacture(refereceFacture());
            facture = factureDao.save(facture);
            ligneFactureService.save(facture.getLigneFactures(), facture);
       
            return facture;
        }

        return null;
    }

    private String refereceFacture() {
        String ref = "";
        Facture facture = factureDao.findFactureByMaxId();
         if (facture == null) {
            ref = "F1";
        } else {
             int n = (Integer.parseInt(facture.getNumeroFacture().substring(1, facture.getNumeroFacture().length())) + 1);
            ref = "F" + n;
        }
        return ref;
    }

    private boolean valideProduits(List<LigneFacture> ligneFactures) {
        for (LigneFacture l : ligneFactures) {
            if ((l.getProduit().getQteStock() - l.getQteAchetee()) < 0) {
                return false;
            }
        }
        return true;
    }
 

}
