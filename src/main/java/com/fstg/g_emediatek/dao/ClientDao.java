/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.g_emediatek.dao;


import com.fstg.g_emediatek.bean.Client;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author alikhyatti
 */
@Repository
public interface ClientDao extends JpaRepository<Client, Long>{
    public Client findByNom(String nom);
    public Client findByPrenom(String prenom);
    public Client findByCode(String code);
    public Client findByEmail(String email);
    @Query(nativeQuery = true,value = "select categorieClient(?1) from dual")
    public String serviceSav(String code);
    
}
