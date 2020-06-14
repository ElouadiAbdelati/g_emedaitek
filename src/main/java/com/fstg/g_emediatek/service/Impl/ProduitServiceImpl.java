/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.g_emediatek.service.Impl;


import com.fstg.e_emediatek.service.ProduitService;
import com.fstg.g_emediatek.bean.Produit;
import com.fstg.g_emediatek.bean.StringResponse;
import com.fstg.g_emediatek.dao.ProduitDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author alikhyatti
 */
@Service
public class ProduitServiceImpl implements ProduitService {

    @Autowired
    public ProduitDao produitDao;
    
    @Override
    public void deleteProduit(long id) {
        produitDao.deleteById(id);
    }

    @Override
    public Produit findById(Long id) {
        return produitDao.findById(id).get();
    }

    @Override
    public Produit findByCodeBarre(String codeBarre) {
        return produitDao.findByCodeBarre(codeBarre);
    }

    @Override
    public Produit findByDesignation(String designation) {
        return produitDao.findByDesignation(designation);
    }

    @Override
    public List<Produit> findAll() {
        return produitDao.findAll();
    }

    @Override
    public Produit save(Produit produit) {
      return  produitDao.save(produit);
    }

    @Override
    public Produit updateProduit(Produit produit) {
          return produitDao.save(produit);
    }

    @Override
    public StringResponse demande(String codeBarre) {
     
        StringResponse demande=new StringResponse();
        demande.setResponse( produitDao.demande(codeBarre));
        return demande;
       
    }
    
}
