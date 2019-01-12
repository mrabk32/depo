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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
@Table(name = "urunler")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Urunler.findAll", query = "SELECT u FROM Urunler u")
    , @NamedQuery(name = "Urunler.findByUrunID", query = "SELECT u FROM Urunler u WHERE u.urunID = :urunID")
    , @NamedQuery(name = "Urunler.findByBaslik", query = "SELECT u FROM Urunler u WHERE u.baslik = :baslik")
    , @NamedQuery(name = "Urunler.findByFiyat", query = "SELECT u FROM Urunler u WHERE u.fiyat = :fiyat")
    , @NamedQuery(name = "Urunler.findByLikeCount", query = "SELECT u FROM Urunler u WHERE u.likeCount = :likeCount")
    , @NamedQuery(name = "Urunler.findByDislikeCount", query = "SELECT u FROM Urunler u WHERE u.dislikeCount = :dislikeCount")
    , @NamedQuery(name = "Urunler.findByImagePath", query = "SELECT u FROM Urunler u WHERE u.imagePath = :imagePath")})
public class Urunler implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "urunID")
    private Integer urunID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 225)
    @Column(name = "baslik")
    private String baslik;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "aciklama")
    private String aciklama;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fiyat")
    private int fiyat;
    @Column(name = "likeCount")
    private Integer likeCount;
    @Column(name = "dislikeCount")
    private Integer dislikeCount;
    @Size(max = 225)
    @Column(name = "imagePath")
    private String imagePath;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ufkID", fetch = FetchType.LAZY)
    private List<ZiyaretciOylari> ziyaretciOylariList;
    @JoinColumn(name = "kategorifkID", referencedColumnName = "kategoriID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Kategoriler kategorifkID;
    @JoinColumn(name = "markafkID", referencedColumnName = "markaID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Markalar markafkID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "urunfkID", fetch = FetchType.LAZY)
    private List<Yorumlar> yorumlarList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ufkID", fetch = FetchType.LAZY)
    private List<KullaniciOylari> kullaniciOylariList;

    public Urunler() {
        
    }

    public Urunler(Integer urunID) {
        this.urunID = urunID;
    }

    public Urunler(Integer urunID, String baslik, String aciklama, int fiyat) {
        this.urunID = urunID;
        this.baslik = baslik;
        this.aciklama = aciklama;
        this.fiyat = fiyat;
        
        
    }
    
    public Urunler(Integer urunID, Kategoriler kategori, Markalar marka, String baslik, String aciklama, Integer fiyat,Integer like,Integer dislike,String imagePath){
        this.urunID = urunID;
        this.kategorifkID = kategori;
        this.markafkID = marka;
        this.baslik = baslik;
        this.aciklama = aciklama;
        this.fiyat = fiyat;
        this.likeCount = like;
        this.dislikeCount = dislike;
        this.imagePath = imagePath;
    }

    public Integer getUrunID() {
        return urunID;
    }

    public void setUrunID(Integer urunID) {
        this.urunID = urunID;
    }

    public String getBaslik() {
        return baslik;
    }

    public void setBaslik(String baslik) {
        this.baslik = baslik;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    public int getFiyat() {
        return fiyat;
    }

    public void setFiyat(int fiyat) {
        this.fiyat = fiyat;
    }

    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    public Integer getDislikeCount() {
        return dislikeCount;
    }

    public void setDislikeCount(Integer dislikeCount) {
        this.dislikeCount = dislikeCount;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @XmlTransient
    public List<ZiyaretciOylari> getZiyaretciOylariList() {
        return ziyaretciOylariList;
    }

    public void setZiyaretciOylariList(List<ZiyaretciOylari> ziyaretciOylariList) {
        this.ziyaretciOylariList = ziyaretciOylariList;
    }

    public Kategoriler getKategorifkID() {
        return kategorifkID;
    }

    public void setKategorifkID(Kategoriler kategorifkID) {
        this.kategorifkID = kategorifkID;
    }

    public Markalar getMarkafkID() {
        return markafkID;
    }

    public void setMarkafkID(Markalar markafkID) {
        this.markafkID = markafkID;
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
        hash += (urunID != null ? urunID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Urunler)) {
            return false;
        }
        Urunler other = (Urunler) object;
        if ((this.urunID == null && other.urunID != null) || (this.urunID != null && !this.urunID.equals(other.urunID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.Urunler[ urunID=" + urunID + " ]";
    }
    
}
