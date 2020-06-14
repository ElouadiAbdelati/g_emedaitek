/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.e_emediatek.service;

import com.fstg.g_emediatek.bean.Client;
import com.fstg.g_emediatek.bean.StringResponse;
import java.util.List;

/**
 *
 * @author alikhyatti
 */
public interface ClientService {
    public Client findByNom(String nom);
    public Client findByPrenom(String prenom);
    public Client findByCode(String code);
    public Client findByEmail(String email);
    public List<Client> findAll();
    public Client save(Client client);
    public void deleteClient(long id);
    public Client findById(Long id);
    public Client updateClient(Client client);
    public StringResponse serviceSav(String code);

}
