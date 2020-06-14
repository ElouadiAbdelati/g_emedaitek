/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.e_emediatek.service;

import com.fstg.g_emediatek.bean.Facture;
import com.fstg.g_emediatek.bean.LigneFacture;
import com.fstg.g_emediatek.bean.Produit;
import java.util.List;

/**
 *
 * @author alikhyatti
 */
public interface LigneFactureService {
   public List<LigneFacture> findByFacture(Facture facture);
    public LigneFacture findByQteAchetee(double qteAchetee);
    public LigneFacture findByProduit(Produit produit);
    public List<LigneFacture> findAll();
    public void deleteLigneFacture(long id);
    public LigneFacture findById(long id);
    public Long save(LigneFacture ligneFacture);
    public void save(List<LigneFacture> ligneFactures,Facture facture);

}
