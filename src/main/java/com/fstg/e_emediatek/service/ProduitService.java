/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.e_emediatek.service;

import com.fstg.g_emediatek.bean.Produit;
import com.fstg.g_emediatek.bean.StringResponse;
import java.util.List;

/**
 *
 * @author alikhyatti
 */
public interface ProduitService {
    public void deleteProduit(long id);
    public Produit findById(Long id);
    public Produit findByCodeBarre(String codeBarre);
    public Produit findByDesignation(String designation);
    public List<Produit> findAll();
    public Produit save(Produit produit);
    public Produit updateProduit(Produit produit);
    public StringResponse demande(String codeBarre);
}
