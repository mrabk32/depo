/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ahmetbestamikose
 */
@Entity
@Table(name = "kullanicilar")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kullanicilar.findAll", query = "SELECT k FROM Kullanicilar k")
    , @NamedQuery(name = "Kullanicilar.findByKullaniciID", query = "SELECT k FROM Kullanicilar k WHERE k.kullaniciID = :kullaniciID")
    , @NamedQuery(name = "Kullanicilar.findByKemail", query = "SELECT k FROM Kullanicilar k WHERE k.kemail = :kemail")
    , @NamedQuery(name = "Kullanicilar.findByKsifre", query = "SELECT k FROM Kullanicilar k WHERE k.ksifre = :ksifre")
    , @NamedQuery(name = "Kullanicilar.findByKad", query = "SELECT k FROM Kullanicilar k WHERE k.kad = :kad")
    , @NamedQuery(name = "Kullanicilar.findByKsoyad", query = "SELECT k FROM Kullanicilar k WHERE k.ksoyad = :ksoyad")
    , @NamedQuery(name = "Kullanicilar.findByKtarih", query = "SELECT k FROM Kullanicilar k WHERE k.ktarih = :ktarih")
    , @NamedQuery(name = "Kullanicilar.findByKonay", query = "SELECT k FROM Kullanicilar k WHERE k.konay = :konay")})
public class Kullanicilar implements Serializable {

    /**
     * @return the girisKodu
     */
    public String getGirisKodu() {
        return girisKodu;
    }

    /**
     * @param girisKodu the girisKodu to set
     */
    public void setGirisKodu(String girisKodu) {
        this.girisKodu = girisKodu;
    }

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "kullaniciID")
    private Integer kullaniciID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 225)
    @Column(name = "kemail")
    private String kemail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 225)
    @Column(name = "ksifre")
    private String ksifre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 225)
    @Column(name = "kad")
    private String kad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 225)
    @Column(name = "ksoyad")
    private String ksoyad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ktarih")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ktarih;
    
    @Column(name = "girisKodu")
    private String girisKodu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "konay")
    private Integer konay;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kullanicifkID", fetch = FetchType.LAZY)
    private List<Yorumlar> yorumlarList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kfkID", fetch = FetchType.LAZY)
    private List<KullaniciOylari> kullaniciOylariList;

    public Kullanicilar() {
    }

    public Kullanicilar(Integer kullaniciID) {
        this.kullaniciID = kullaniciID;
    }

    public Kullanicilar(Integer kullaniciID, String kemail, String ksifre, String kad, String ksoyad, Date ktarih,String girisKodu) {
        this.kullaniciID = kullaniciID;
        this.kemail = kemail;
        this.ksifre = ksifre;
        this.kad = kad;
        this.ksoyad = ksoyad;
        this.ktarih = ktarih;
        this.girisKodu = girisKodu;
    }

    public Integer getKullaniciID() {
        return kullaniciID;
    }

    public void setKullaniciID(Integer kullaniciID) {
        this.kullaniciID = kullaniciID;
    }

    public String getKemail() {
        return kemail;
    }

    public void setKemail(String kemail) {
        this.kemail = kemail;
    }

    public String getKsifre() {
        return ksifre;
    }

    public void setKsifre(String ksifre) {
        this.ksifre = ksifre;
    }

    public String getKad() {
        return kad;
    }

    public void setKad(String kad) {
        this.kad = kad;
    }

    public String getKsoyad() {
        return ksoyad;
    }

    public void setKsoyad(String ksoyad) {
        this.ksoyad = ksoyad;
    }

    public Date getKtarih() {
        return ktarih;
    }

    public void setKtarih(Date ktarih) {
        this.ktarih = ktarih;
    }

    public Integer getKonay() {
        return konay;
    }

    public void setKonay(Integer konay) {
        this.konay = konay;
    }

    @XmlTransient
    public List<Yorumlar> getYorumlarList() {
        return yorumlarList;
    }

    public void setYorumlarList(List<Yorumlar> yorumlarList) {
        this.yorumlarList = yorumlarList;
    }

    @XmlTransient
    public List<KullaniciOylari> getKullaniciOylariList() {
        return kullaniciOylariList;
    }

    public void setKullaniciOylariList(List<KullaniciOylari> kullaniciOylariList) {
        this.kullaniciOylariList = kullaniciOylariList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kullaniciID != null ? kullaniciID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kullanicilar)) {
            return false;
        }
        Kullanicilar other = (Kullanicilar) object;
        if ((this.kullaniciID == null && other.kullaniciID != null) || (this.kullaniciID != null && !this.kullaniciID.equals(other.kullaniciID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.Kullanicilar[ kullaniciID=" + kullaniciID + " ]";
    }

   
}