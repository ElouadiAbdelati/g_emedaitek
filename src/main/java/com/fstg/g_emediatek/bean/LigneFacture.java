/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.g_emediatek.bean;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author pc
 */
@Entity
public class LigneFacture implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
 private double qteAchetee;
    @ManyToOne
    private Facture facture;
    @ManyToOne
    private Produit produit;

    public LigneFacture() {
    }

    public LigneFacture(Long id, double qteAchetee, Facture facture, Produit produit) {
        this.id = id;
        this.qteAchetee = qteAchetee;
        this.facture = facture;
        this.produit = produit;
    }
    
    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    
   

    public double getQteAchetee() {
        return qteAchetee;
    }

    public void setQteAchetee(double qteAchetee) {
        this.qteAchetee = qteAchetee;
    }

    public Facture getFacture() {
        return facture;
    }

    public void setFacture(Facture facture) {
        this.facture = facture;
    }
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LigneFacture)) {
            return false;
        }
        LigneFacture other = (LigneFacture) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fstg.g_emediatek.bean.LigneFacture[ id=" + id + " ]";
    }
    
}
