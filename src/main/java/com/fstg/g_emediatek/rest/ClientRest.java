/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.g_emediatek.rest;


import com.fstg.e_emediatek.service.ClientService;
import com.fstg.g_emediatek.bean.Client;
import com.fstg.g_emediatek.bean.StringResponse;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author alikhyatti
 */
@RestController
@RequestMapping("/e-mediatek/client")
@CrossOrigin("*")
public class ClientRest {
     @Autowired
    public ClientService clientService;
    
     @PostMapping(value = "/")
    public Client save(@RequestBody Client client) {
        return clientService.save(client);
    }

    @GetMapping("/code/{code}")
    public Client findByCode(@PathVariable String code) {
        return clientService.findByCode(code);
    }
    
    @GetMapping("/id/{id}")
    public Client findById(@PathVariable Long id) {
        return clientService.findById(id);
    }
    
    @GetMapping("/")
    public List<Client> findAll() {
        return clientService.findAll();
    }

    @DeleteMapping(value = "/id/{id}")
    public void deleteClient(@PathVariable long id) {
        clientService.deleteClient(id);
    }

    @GetMapping("/nom/{nom}")
    public Client findByNom(@PathVariable String nom) {
        return clientService.findByNom(nom);
    }

    @GetMapping("/prenom/{prenom}")
    public Client findByPrenom(@PathVariable String prenom) {
        return clientService.findByPrenom(prenom);
    }

    @GetMapping("/email/{email}")
    public Client findByEmail(@PathVariable String email) {
        return clientService.findByEmail(email);
    }
    
    @PostMapping("/update")
    public Client updateClient(@RequestBody Client client) {
        return clientService.save(client);
    }
    
     @RequestMapping(value = "/sav/{code}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public StringResponse serviceSav(@PathVariable String code) {
        return clientService.serviceSav(code);
    }
    
}
