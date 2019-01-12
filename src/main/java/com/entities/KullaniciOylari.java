/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entities;

import java.io.Serializable;
import javax.persistence.Basic;
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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ahmetbestamikose
 */
@Entity
@Table(name = "kullaniciOylari")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "KullaniciOylari.findAll", query = "SELECT k FROM KullaniciOylari k")
    , @NamedQuery(name = "KullaniciOylari.findByKullaniciOylariID", query = "SELECT k FROM KullaniciOylari k WHERE k.kullaniciOylariID = :kullaniciOylariID")
    , @NamedQuery(name = "KullaniciOylari.findByOy", query = "SELECT k FROM KullaniciOylari k WHERE k.oy = :oy")
    ,   @NamedQuery(name = "KullaniciOylari.findByKfkID", query = "SELECT k FROM KullaniciOylari k WHERE k.kfkID = :kfkID")

})
public class KullaniciOylari implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "kullaniciOylariID")
    private Integer kullaniciOylariID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "oy")
    private int oy;
    @JoinColumn(name = "kfkID", referencedColumnName = "kullaniciID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Kullanicilar kfkID;
    @JoinColumn(name = "ufkID", referencedColumnName = "urunID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Urunler ufkID;

    public KullaniciOylari() {
    }

    public KullaniciOylari(Integer kullaniciOylariID) {
        this.kullaniciOylariID = kullaniciOylariID;
    }

    public KullaniciOylari(Integer kullaniciOylariID, int oy) {
        this.kullaniciOylariID = kullaniciOylariID;
        this.oy = oy;
    }

    public Integer getKullaniciOylariID() {
        return kullaniciOylariID;
    }

    public void setKullaniciOylariID(Integer kullaniciOylariID) {
        this.kullaniciOylariID = kullaniciOylariID;
    }

    public int getOy() {
        return oy;
    }

    public void setOy(int oy) {
        this.oy = oy;
    }

    public Kullanicilar getKfkID() {
        return kfkID;
    }

    public void setKfkID(Kullanicilar kfkID) {
        this.kfkID = kfkID;
    }

    public Urunler getUfkID() {
        return ufkID;
    }

    public void setUfkID(Urunler ufkID) {
        this.ufkID = ufkID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kullaniciOylariID != null ? kullaniciOylariID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof KullaniciOylari)) {
            return false;
        }
        KullaniciOylari other = (KullaniciOylari) object;
        if ((this.kullaniciOylariID == null && other.kullaniciOylariID != null) || (this.kullaniciOylariID != null && !this.kullaniciOylariID.equals(other.kullaniciOylariID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.KullaniciOylari[ kullaniciOylariID=" + kullaniciOylariID + " ]";
    }
    
}
