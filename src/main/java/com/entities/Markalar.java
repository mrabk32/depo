/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ahmetbestamikose
 */
@Entity
@Table(name = "markalar")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Markalar.findAll", query = "SELECT m FROM Markalar m")
    , @NamedQuery(name = "Markalar.findByMarkaID", query = "SELECT m FROM Markalar m WHERE m.markaID = :markaID")
    , @NamedQuery(name = "Markalar.findByMarkaAdi", query = "SELECT m FROM Markalar m WHERE m.markaAdi = :markaAdi")})
public class Markalar implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "markaID")
    private Integer markaID;
    @Size(max = 225)
    @Column(name = "markaAdi")
    private String markaAdi;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "markafkID", fetch = FetchType.LAZY)
    private List<Urunler> urunlerList;
    @JoinColumn(name = "kategoriID", referencedColumnName = "kategoriID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Kategoriler kategoriID;

    public Markalar() {
    }
    
    public Markalar(Integer markaID,Kategoriler k, String markaAdi){
        this.markaID = markaID;
        this.kategoriID = k;
        this.markaAdi = markaAdi;
    }

    public Markalar(Integer markaID) {
        this.markaID = markaID;
    }

    public Integer getMarkaID() {
        return markaID;
    }

    public void setMarkaID(Integer markaID) {
        this.markaID = markaID;
    }

    public String getMarkaAdi() {
        return markaAdi;
    }

    public void setMarkaAdi(String markaAdi) {
        this.markaAdi = markaAdi;
    }

    @XmlTransient
    public List<Urunler> getUrunlerList() {
        return urunlerList;
    }

    public void setUrunlerList(List<Urunler> urunlerList) {
        this.urunlerList = urunlerList;
    }

    public Kategoriler getKategoriID() {
        return kategoriID;
    }

    public void setKategoriID(Kategoriler kategoriID) {
        this.kategoriID = kategoriID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (markaID != null ? markaID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Markalar)) {
            return false;
        }
        Markalar other = (Markalar) object;
        if ((this.markaID == null && other.markaID != null) || (this.markaID != null && !this.markaID.equals(other.markaID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.Markalar[ markaID=" + markaID + " ]";
    }
    
}
