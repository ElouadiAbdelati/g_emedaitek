/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.g_emediatek.service.Impl;

import com.fstg.e_emediatek.service.JournalisationService;
import com.fstg.e_emediatek.service.ProduitService;
import com.fstg.g_emediatek.bean.Journalisation;
import com.fstg.g_emediatek.bean.Produit;
import com.fstg.g_emediatek.dao.JournalisationDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author alikhyatti
 */
@Service
public class JournalisationServiceImpl implements JournalisationService{
    @Autowired
    private JournalisationDao journalisationDao;
    @Autowired
    private ProduitService produitService;

    @Override
    public List<Journalisation> findAll() {

     return journalisationDao.findAll();
    }

    @Override
    public Journalisation findById(Long id) {
       return journalisationDao.findById(id).get();
    }

    @Override
    public Journalisation findByProduit(Produit produit) {
        produit=produitService.findByCodeBarre(produit.getCodeBarre());
       return journalisationDao.findByProduit(produit);
    }
 
    
}
