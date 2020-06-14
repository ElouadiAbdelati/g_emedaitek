/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.e_emediatek.service;

import com.fstg.g_emediatek.bean.Client;
import com.fstg.g_emediatek.bean.Journalisation;
import com.fstg.g_emediatek.bean.Produit;
import java.util.List;

/**
 *
 * @author alikhyatti
 */
public interface JournalisationService {
    public List<Journalisation> findAll();
    public Journalisation findById(Long id);
    public Journalisation findByProduit(Produit produit);


}
