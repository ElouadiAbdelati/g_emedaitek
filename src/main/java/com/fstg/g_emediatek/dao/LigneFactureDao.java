/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.g_emediatek.dao;


import com.fstg.g_emediatek.bean.Facture;
import com.fstg.g_emediatek.bean.LigneFacture;
import com.fstg.g_emediatek.bean.Produit;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author alikhyatti
 */
@Repository
public interface LigneFactureDao extends JpaRepository<LigneFacture, Long>{
    public List<LigneFacture> findByFacture(Facture facture);
    public LigneFacture findByQteAchetee(double qteAchetee);
    public LigneFacture findByProduit(Produit produit);
    @Query(nativeQuery = true,value="select saveLigneFacture(?1,?2,?3) from dual")
    public Long saveLigneFacture(double qteAchetee,Long facture, Long produit);
}
