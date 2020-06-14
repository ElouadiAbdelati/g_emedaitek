/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.g_emediatek.service.Impl;

import com.fstg.e_emediatek.service.ClientService;
import com.fstg.e_emediatek.service.FactureService;
import com.fstg.e_emediatek.service.LigneFactureService;
import com.fstg.e_emediatek.service.ProduitService;
import com.fstg.g_emediatek.bean.Facture;
import com.fstg.g_emediatek.bean.LigneFacture;
import com.fstg.g_emediatek.bean.Produit;
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
    private ClientService clinetService;
    @Autowired
    private LigneFactureService ligneFactureService;
    @Autowired
    private ProduitService produitService;

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
    public int saveFacture(Facture facture) {
        facture.setClient(clinetService.findByCode(facture.getClient().getCode()));
        if (valideProduits(facture.getLigneFactures())) {
            long millis = System.currentTimeMillis();
            java.sql.Date date = new java.sql.Date(millis);
            facture.setDateFacturation(date);
            System.out.println("date  " + facture.getDateFacturation());
            facture.setNumeroFacture(refereceFacture());
            System.out.println("reft  " + facture.getNumeroFacture());
             factureDao.save(facture);
            ligneFactureService.save(facture.getLigneFactures(),facture);
            return 1;
        }

        return -1;
    }

    private String refereceFacture() {
        String ref="";
        String facture = factureDao.findFactureByMaxId();
        if (facture=="") {
            ref = "F1";
        } else {
            int n = (Integer.parseInt(facture.substring(1, facture.length())) + 1);
            ref = "F" + n;
        }
        return ref;
    }

    private boolean valideProduits(List<LigneFacture> ligneFactures) {
        for (LigneFacture l : ligneFactures) {
            l.setProduit(produitService.findByCodeBarre(l.getProduit().getCodeBarre()));
            if ((l.getProduit().getQteStock() - l.getQteAchetee()) < 0) {
                return false;
            }
        }
        return true;
    }

}
