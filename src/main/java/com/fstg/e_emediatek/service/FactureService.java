/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.e_emediatek.service;

import com.fstg.g_emediatek.bean.Facture;
import java.util.List;

/**
 *
 * @author alikhyatti
 */
public interface FactureService {
    public Facture findByNumeroFacture(String numeroFacture);
    public Facture findByDateFacturation(java.util.Date dateFacturation);
    public List<Facture> findAll();
    public void deleteFacture(long id);
    public Facture findById(long id);
    public void save(Facture facture);
    public int saveFacture(Facture facture);

}
