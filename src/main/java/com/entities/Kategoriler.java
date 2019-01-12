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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ahmetbestamikose
 */
@Entity
@Table(name = "kategoriler")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kategoriler.findAll", query = "SELECT k FROM Kategoriler k")
    , @NamedQuery(name = "Kategoriler.findByKategoriID", query = "SELECT k FROM Kategoriler k WHERE k.kategoriID = :kategoriID")
    , @NamedQuery(name = "Kategoriler.findByKategoriAdi", query = "SELECT k FROM Kategoriler k WHERE k.kategoriAdi = :kategoriAdi")})
public class Kategoriler implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "kategoriID")
    private Integer kategoriID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 225)
    @Column(name = "kategoriAdi")
    private String kategoriAdi;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kategorifkID", fetch = FetchType.LAZY)
    private List<Urunler> urunlerList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kategoriID", fetch = FetchType.LAZY)
    private List<Markalar> markalarList;

    public Kategoriler() {
    }

    public Kategoriler(Integer kategoriID) {
        this.kategoriID = kategoriID;
    }

    public Kategoriler(Integer kategoriID, String kategoriAdi) {
        this.kategoriID = kategoriID;
        this.kategoriAdi = kategoriAdi;
    }

    public Integer getKategoriID() {
        return kategoriID;
    }

    public void setKategoriID(Integer kategoriID) {
        this.kategoriID = kategoriID;
    }

    public String getKategoriAdi() {
        return kategoriAdi;
    }

    public void setKategoriAdi(String kategoriAdi) {
        this.kategoriAdi = kategoriAdi;
    }

    @XmlTransient
    public List<Urunler> getUrunlerList() {
        return urunlerList;
    }

    public void setUrunlerList(List<Urunler> urunlerList) {
        this.urunlerList = urunlerList;
    }

    @XmlTransient
    public List<Markalar> getMarkalarList() {
        return markalarList;
    }

    public void setMarkalarList(List<Markalar> markalarList) {
        this.markalarList = markalarList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kategoriID != null ? kategoriID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kategoriler)) {
            return false;
        }
        Kategoriler other = (Kategoriler) object;
        if ((this.kategoriID == null && other.kategoriID != null) || (this.kategoriID != null && !this.kategoriID.equals(other.kategoriID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.Kategoriler[ kategoriID=" + kategoriID + " ]";
    }
    
}
