/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.g_emediatek.dao;

import com.fstg.g_emediatek.bean.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author alikhyatti
 */
@Repository
public interface ProduitDao extends JpaRepository<Produit, Long> {
    public Produit findByCodeBarre(String codeBarre);
    public Produit findByDesignation(String designation);
    @Query(nativeQuery = true,value = "select demande(?1) from dual")
    public String demande(String codeBarre);
}
