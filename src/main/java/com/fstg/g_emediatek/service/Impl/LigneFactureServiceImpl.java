/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.g_emediatek.service.Impl;


import com.fstg.e_emediatek.service.LigneFactureService;
import com.fstg.e_emediatek.service.ProduitService;
import com.fstg.g_emediatek.bean.Facture;
import com.fstg.g_emediatek.bean.LigneFacture;
import com.fstg.g_emediatek.bean.Produit;
import com.fstg.g_emediatek.dao.LigneFactureDao;
import java.util.List;
import org.eclipse.persistence.exceptions.DatabaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author alikhyatti
 */
@Service
public class LigneFactureServiceImpl implements LigneFactureService{

    @Autowired
    public LigneFactureDao ligneFactureDao;
    @Autowired
    private ProduitService produitService;
    
    @Override
    public List<LigneFacture> findAll() {
        return ligneFactureDao.findAll();
    }

    @Override
    public void deleteLigneFacture(long id) {
        ligneFactureDao.deleteById(id);
    }

    @Override
    public LigneFacture findById(long id) {
        return ligneFactureDao.findById(id).get();
    }

    @Override
    public List<LigneFacture> findByFacture(Facture facture) {
        return ligneFactureDao.findByFacture(facture);
    }

    @Override
    public LigneFacture findByQteAchetee(double qteAchetee) {
        return ligneFactureDao.findByQteAchetee(qteAchetee);
    }

    @Override
    public LigneFacture findByProduit(Produit produit) {
        return ligneFactureDao.findByProduit(produit);
    }

    @Override
    public Long save(LigneFacture ligneFacture) {
       return ligneFactureDao.saveLigneFacture(ligneFacture.getQteAchetee(),ligneFacture.getFacture().getId(),ligneFacture.getProduit().getId());
    }

    @Override
    public void save(List<LigneFacture> ligneFactures, Facture facture) {
        try {
    
        for(LigneFacture l:ligneFactures){
            l.setFacture(facture);
            ligneFactureDao.save(l);
           // save(l);
        }
      }catch(DatabaseException e){
            System.out.println(e.getMessage());
      }
    
  }
}
