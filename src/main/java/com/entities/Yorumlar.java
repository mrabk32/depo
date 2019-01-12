/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ahmetbestamikose
 */
@Entity
@Table(name = "yorumlar")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Yorumlar.findAll", query = "SELECT y FROM Yorumlar y")
    , @NamedQuery(name = "Yorumlar.findByYorumID", query = "SELECT y FROM Yorumlar y WHERE y.yorumID = :yorumID")
    , @NamedQuery(name = "Yorumlar.findByYtarih", query = "SELECT y FROM Yorumlar y WHERE y.ytarih = :ytarih")})
public class Yorumlar implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "yorumID")
    private Integer yorumID;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "yorum")
    private String yorum;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ytarih")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ytarih;
    @JoinColumn(name = "urunfkID", referencedColumnName = "urunID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Urunler urunfkID;
    @JoinColumn(name = "kullanicifkID", referencedColumnName = "kullaniciID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Kullanicilar kullanicifkID;

    public Yorumlar() {
    }

    public Yorumlar(Integer yorumID) {
        this.yorumID = yorumID;
    }

    public Yorumlar(Integer yorumID, String yorum, Date ytarih) {
        this.yorumID = yorumID;
        this.yorum = yorum;
        this.ytarih = ytarih;
    }
    public Yorumlar(Integer yorumID, Urunler urunfkID, Kullanicilar kullanicifkID, String yorum, Date ytarih){
        this.yorumID = yorumID;
        this.urunfkID = urunfkID;
        this.kullanicifkID = kullanicifkID;
        this.yorum = yorum;
        this.ytarih = ytarih;
    }

    public Integer getYorumID() {
        return yorumID;
    }

    public void setYorumID(Integer yorumID) {
        this.yorumID = yorumID;
    }

    public String getYorum() {
        return yorum;
    }

    public void setYorum(String yorum) {
        this.yorum = yorum;
    }

    public Date getYtarih() {
        return ytarih;
    }

    public void setYtarih(Date ytarih) {
        this.ytarih = ytarih;
    }

    public Urunler getUrunfkID() {
        return urunfkID;
    }

    public void setUrunfkID(Urunler urunfkID) {
        this.urunfkID = urunfkID;
    }

    public Kullanicilar getKullanicifkID() {
        return kullanicifkID;
    }

    public void setKullanicifkID(Kullanicilar kullanicifkID) {
        this.kullanicifkID = kullanicifkID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (yorumID != null ? yorumID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Yorumlar)) {
            return false;
        }
        Yorumlar other = (Yorumlar) object;
        if ((this.yorumID == null && other.yorumID != null) || (this.yorumID != null && !this.yorumID.equals(other.yorumID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.Yorumlar[ yorumID=" + yorumID + " ]";
    }
    
}
