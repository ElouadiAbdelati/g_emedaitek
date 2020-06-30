/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.g_emediatek.dao;


import com.fstg.g_emediatek.bean.Journalisation;
import com.fstg.g_emediatek.bean.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author alikhyatti
 */
@Repository
public interface JournalisationDao extends JpaRepository<Journalisation, Long>{
       public Journalisation findByProduit(Produit produit);
       
}
