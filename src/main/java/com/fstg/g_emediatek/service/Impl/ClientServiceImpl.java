/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.g_emediatek.service.Impl;

import com.fstg.e_emediatek.service.ClientService;
import com.fstg.g_emediatek.bean.Client;
import com.fstg.g_emediatek.bean.StringResponse;
import com.fstg.g_emediatek.dao.ClientDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author alikhyatti
 */
@Service
public class ClientServiceImpl implements ClientService{
    @Autowired
    public ClientDao clientDao;
    
     @Override
     public Client save(Client client) {
        return clientDao.save(client);
    }

    @Override
    public Client findByCode(String code) {
        return clientDao.findByCode(code);
    }

    @Override
    public Client findById(Long id) {
        return clientDao.findById(id).get();
    }
    
    @Override
    public List<Client> findAll() {
        return clientDao.findAll();
    }

    @Transactional
    @Override
    public void deleteClient(long id) {
        clientDao.deleteById(id);
    }

    @Override
    public Client findByNom(String nom) {
        return clientDao.findByNom(nom);
    }

    @Override
    public Client findByPrenom(String prenom) {
        return clientDao.findByPrenom(prenom);
    }

    @Override
    public Client findByEmail(String email) {
        return clientDao.findByEmail(email);
    }

    @Override
    public Client updateClient(Client client) {
        return clientDao.save(client);
    }

    @Override
    public StringResponse serviceSav(String code) {
         StringResponse categorie=new StringResponse();
        categorie.setResponse(clientDao.serviceSav(code));
        if(categorie.getResponse()==null){
            categorie.setResponse("Potentiel");
        }
        return categorie;
      }

    

    
}
