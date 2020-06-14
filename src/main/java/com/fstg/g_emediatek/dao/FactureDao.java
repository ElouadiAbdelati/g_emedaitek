/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.g_emediatek.dao;

import com.fstg.g_emediatek.bean.Facture;
import java.util.Date;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

/**
 *
 * @author alikhyatti
 */
@Repository
public interface FactureDao extends JpaRepository<Facture, Long> {
    public Facture findByNumeroFacture(String numeroFacture);
    public Facture findByDateFacturation(Date dateFacturation);
   // @Procedure("saveFacture")
    @Query(nativeQuery = true,value="select saveFacture(?1,?2,?3) from dual")
    public Long saveFacture(String numeroFacture,Date date_facturation ,Long client);
    @Query(nativeQuery = true ,value = "select numero_facture from facture where id=(select max(id) from facture)")
    public String  findFactureByMaxId();
}
