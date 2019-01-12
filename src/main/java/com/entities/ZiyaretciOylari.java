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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ahmetbestamikose
 */
@Entity
@Table(name = "ziyaretciOylari")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ZiyaretciOylari.findAll", query = "SELECT z FROM ZiyaretciOylari z")
    , @NamedQuery(name = "ZiyaretciOylari.findByZiyaretciOylariID", query = "SELECT z FROM ZiyaretciOylari z WHERE z.ziyaretciOylariID = :ziyaretciOylariID")
    , @NamedQuery(name = "ZiyaretciOylari.findByZiyaretciIP", query = "SELECT z FROM ZiyaretciOylari z WHERE z.ziyaretciIP = :ziyaretciIP")
    , @NamedQuery(name = "ZiyaretciOylari.findByOy", query = "SELECT z FROM ZiyaretciOylari z WHERE z.oy = :oy")})
public class ZiyaretciOylari implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ziyaretciOylariID")
    private Integer ziyaretciOylariID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 225)
    @Column(name = "ziyaretciIP")
    private String ziyaretciIP;
    @Basic(optional = false)
    @NotNull
    @Column(name = "oy")
    private int oy;
    @JoinColumn(name = "ufkID", referencedColumnName = "urunID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Urunler ufkID;

    public ZiyaretciOylari() {
    }

    public ZiyaretciOylari(Integer ziyaretciOylariID) {
        this.ziyaretciOylariID = ziyaretciOylariID;
    }

    public ZiyaretciOylari(Integer ziyaretciOylariID, String ziyaretciIP, int oy) {
        this.ziyaretciOylariID = ziyaretciOylariID;
        this.ziyaretciIP = ziyaretciIP;
        this.oy = oy;
    }

    public Integer getZiyaretciOylariID() {
        return ziyaretciOylariID;
    }

    public void setZiyaretciOylariID(Integer ziyaretciOylariID) {
        this.ziyaretciOylariID = ziyaretciOylariID;
    }

    public String getZiyaretciIP() {
        return ziyaretciIP;
    }

    public void setZiyaretciIP(String ziyaretciIP) {
        this.ziyaretciIP = ziyaretciIP;
    }

    public int getOy() {
        return oy;
    }

    public void setOy(int oy) {
        this.oy = oy;
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
        hash += (ziyaretciOylariID != null ? ziyaretciOylariID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ZiyaretciOylari)) {
            return false;
        }
        ZiyaretciOylari other = (ZiyaretciOylari) object;
        if ((this.ziyaretciOylariID == null && other.ziyaretciOylariID != null) || (this.ziyaretciOylariID != null && !this.ziyaretciOylariID.equals(other.ziyaretciOylariID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.ZiyaretciOylari[ ziyaretciOylariID=" + ziyaretciOylariID + " ]";
    }
    
}
