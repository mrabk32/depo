/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.beans.MainBean;
import com.entities.Admin;
import com.entities.Kategoriler;
import com.entities.KullaniciOylari;
import com.entities.Kullanicilar;
import com.entities.Markalar;
import com.entities.Urunler;
import com.entities.Yorumlar;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Random;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author ahmetbestamikose
 */
public class DatabaseController {
    public EntityManagerFactory emf = null;
    
    public EntityManager getEntityManager(){
        if(this.emf == null){
            this.emf = Persistence.createEntityManagerFactory("com.ahmetbestamikose_almalimi.com_war_1.0-SNAPSHOTPU");
        }
        EntityManager em = emf.createEntityManager();
        return em;
    }

    public List<Kategoriler> kategoriListesiCek(){
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        
        Query q = em.createNamedQuery("Kategoriler.findAll");
        
        List<Kategoriler> rs = q.getResultList();
        em.getTransaction().commit();
        return rs;
    }
    
    public String kategoriAdiCek(int kID){
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Kategoriler k = em.find(Kategoriler.class, kID);
        em.getTransaction().commit();
        return k.getKategoriAdi();
    }
    
    public List<Markalar> markaListesiCek(){
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Query q = em.createNamedQuery("Markalar.findAll");
        List<Markalar> rs = q.getResultList();
        em.getTransaction().commit();
        return rs;
    }
    
    public Kategoriler kategoriCek(int kID){
        EntityManager em =  getEntityManager();
        em.getTransaction().begin();
        Query q = em.createNamedQuery("Kategoriler.findByKategoriID");
        q.setParameter("kategoriID", kID);
        Kategoriler rk = (Kategoriler) q.getSingleResult();
        em.getTransaction().commit();
        return rk;
    }
    
//    public List<Urunler> urunListesiCek_Marka(int kategorifkID, int markafkID){
//        EntityManager em = getEntityManager();
//        em.getTransaction().begin();
//        Query q = em.createNamedQuery("Urunler.findByKategorifkID-markafkID");
//        List<Urunler> rl = q.getResultList();
//        em.getTransaction().commit();
//        return rl;
//    }
//    
//    public List<Urunler> urunListesiCek_Kategori(int kategorifkID){
//        EntityManager em = getEntityManager();
//        em.getTransaction().begin();
//        Query q = em.createNamedQuery("Urunler.findByKategorifkID");
//        List<Urunler> rl = q.getResultList();
//        em.getTransaction().commit();
//        return rl;
//    }
    
    public Urunler urunBilgisiCek(int urunID){
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Query q =  em.createQuery("SELECT u FROM Urunler u WHERE u.urunID = " + urunID);
        Urunler u = (Urunler) q.getSingleResult();
        em.getTransaction().commit();
        return u;
    }
    
    public void kullaniciEkle(Kullanicilar kullanicilar){
        EntityManager em = getEntityManager();
        em.getTransaction().begin();

        em.persist(kullanicilar);
        em.getTransaction().commit();
        
        
    }
    protected String kodOlustur() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 5) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }
    public boolean aktivasyonKoduDogrulama(String email,String gelenAktivasyonKodu)
    {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Query q = em.createNamedQuery("Kullanicilar.findByKemail");
        q.setParameter("kemail", email);
        Kullanicilar gelenKullanici = (Kullanicilar) q.getResultList().get(0);
        String gercekAktivasyonKodu = gelenKullanici.getGirisKodu() ;
        if(gercekAktivasyonKodu.equals(gelenAktivasyonKodu))
        {
            Query query = em.createNativeQuery(
                "UPDATE kullanicilar SET "
                        + "girisKodu = '"+ kodOlustur() +"'"+
                         " WHERE kemail = '"+ email+"'");
            query.executeUpdate();
            em.getTransaction().commit();
            return true;
        }
        else
        {
            em.getTransaction().commit();
            return false;
        }
    }
    public boolean kayitliMi(String kemail)
    {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Query q = em.createNamedQuery("Kullanicilar.findByKemail");
        q.setParameter("kemail", kemail);
        int sayi = q.getResultList().size();
        em.getTransaction().commit();
        if(sayi == 0)
            return false;
        else
            return true;
        
    }
    public String sifreCek(String email)
    {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Query q = em.createNamedQuery("Kullanicilar.findByKemail");
        q.setParameter("kemail", email);
        Kullanicilar gelenKullanici = (Kullanicilar) q.getResultList().get(0);
        em.getTransaction().commit();
        return gelenKullanici.getKsifre();
        
    }
    public Kullanicilar sifreDogruMu(String kemail,String ksifre)
    {
        
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Query q = em.createNamedQuery("Kullanicilar.findByKemail");
        q.setParameter("kemail", kemail);
        Kullanicilar gelenKullanici = (Kullanicilar) q.getResultList().get(0);
        String gercekSifre = gelenKullanici.getKsifre();
        em.getTransaction().commit();
        if(gercekSifre.equals(ksifre))
        {
            return gelenKullanici;
        }
        else
            return null;
    }
    
    public void yorumEkle(Yorumlar yorum)
    {
        
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(yorum);
        em.getTransaction().commit();
        
    }
    
    public void oyEkle(KullaniciOylari oy)
    {
            String nereyeEklenecek ;
            if(oy.getOy() == 1)
            {
                nereyeEklenecek = "likeCount = likeCount";
            }
            else{
                nereyeEklenecek = "dislikeCount = dislikeCount";
            }
                
            EntityManager em = getEntityManager();
            em.getTransaction().begin();
            em.persist(oy);
            Query query = em.createNativeQuery(
                "UPDATE urunler SET "+nereyeEklenecek+" +1 " +
                "WHERE urunID = " + oy.getUfkID().getUrunID());
            query.executeUpdate();
            em.getTransaction().commit();
            
     }
    public void profilDüzenle(Kullanicilar kullanici)
    {
            EntityManager em = getEntityManager();
            em.getTransaction().begin();
            
            Query query = em.createNativeQuery(
                "UPDATE kullanicilar SET "
                        + "kemail = '"+ kullanici.getKemail() +"'"+
                        ", ksifre = '"+ kullanici.getKsifre() +"'"+
                        ", kad = '"+ kullanici.getKad() +"'"+
                        ", ksoyad = '"+ kullanici.getKsoyad() +"'"+
                        " WHERE kullaniciID = "+ kullanici.getKullaniciID());
            query.executeUpdate();
            em.getTransaction().commit();
            
    }
    
    public List<Urunler> urunArama(String arananMetin)
    {
        
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Query q =  em.createQuery("SELECT u FROM Urunler u WHERE u.baslik  LIKE '%" + arananMetin + "%'");
        int urunSayisi = q.getResultList().size();
        if(urunSayisi == 0)
        {
            em.getTransaction().commit();
            return null;
        }
        else
        {
            List<Urunler> bulunanUrunler = q.getResultList();
            em.getTransaction().commit();
            return bulunanUrunler;
        }
                    
        
        
        
        
    }
    
    public int findKullaniciIDByEmail(String kemail)
    {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Query q = em.createNamedQuery("Kullanicilar.findByKemail");
        q.setParameter("kemail", kemail);
        Kullanicilar k = (Kullanicilar) q.getResultList().get(0);
        int x = k.getKullaniciID();
        em.getTransaction().commit();
        return x;
    }
    
    public Admin adminKontrol(String girilenEmail2, String girilenSifre2){
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Query q = em.createNamedQuery("Admin.findByKullaniciAdi");
        q.setParameter("kullaniciAdi", girilenEmail2);
        Admin gelenAdmin = (Admin) q.getResultList().get(0);
        String gercekSifre = gelenAdmin.getSifre();
        em.getTransaction().commit();
        if(gercekSifre.equals(girilenSifre2)){
            return gelenAdmin;
        }
        else{
            return null;
        }
    }
    
    public List<Urunler> tumUrunleriGetir(){
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Query q = em.createNamedQuery("Urunler.findAll");
        List<Urunler> urunlerList = q.getResultList();
        em.getTransaction().commit();
        return urunlerList;
    }
    
    
    
    // Admin DB kategori-marka-urun ekleme islemleri
    
    public void kategoriEkleDB(Kategoriler kategori){
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(kategori);
        em.getTransaction().commit();
    }
    public void markaEkleDB(Markalar marka){
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(marka);
        em.getTransaction().commit();
    }
    public void urunEkleDB(Urunler urun){
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(urun);
        em.getTransaction().commit();
    }
    
    // Admin DB kategori-marka-urun guncelleme islemleri
    
    public void kategoriGuncelleDB(Kategoriler kategori){
        EntityManager em = getEntityManager();
            em.getTransaction().begin();
            
            Query query = em.createNativeQuery(
                "UPDATE kategoriler SET "
                        + "kategoriAdi = '"+ kategori.getKategoriAdi() +"'"+
                        " WHERE kategoriID = "+ kategori.getKategoriID());
            query.executeUpdate();
            em.getTransaction().commit();
            
    }
    public void markaGuncelleDB(Markalar marka){
        EntityManager em = getEntityManager();
            em.getTransaction().begin();
            
            Query query = em.createNativeQuery(
                "UPDATE markalar SET "
                        + "markaAdi = '"+ marka.getMarkaAdi() +"'"+
                        " WHERE markaID = "+ marka.getMarkaID());
            query.executeUpdate();
            em.getTransaction().commit();
    }
    public void urunGuncelleDB(Urunler urun){
        EntityManager em = getEntityManager();
            em.getTransaction().begin();
            
            Query query = em.createNativeQuery(
                "UPDATE urunler SET "
                        + "baslik = '"+ urun.getBaslik() +"'"+
                        ", aciklama = '"+ urun.getAciklama() +"'"+
                        ", fiyat = '"+ urun.getFiyat() +"'"+
                        ", imagePath = '"+ urun.getImagePath() +"'"+
                        " WHERE urunID = "+ urun.getUrunID());
            query.executeUpdate();
            em.getTransaction().commit();
    }
    
    // Admin DB kategori-marka-urun silme islemleri
    
    public void kategoriSilDB(Kategoriler kategori){
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.remove(kategori);
        em.getTransaction().commit();
    }
    public void markaSilDB(Markalar marka){
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.remove(marka);
        em.getTransaction().commit();
    }
    public void urunSilDB(Urunler urun){
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.remove(urun);
        em.getTransaction().commit();
    }
    
    // Admin DB yorum silme islemi
    
    public void yorumSilDB(Yorumlar yorum){
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        if (!em.contains(yorum)) {
            yorum = em.merge(yorum);
        }
        em.remove(yorum);
        
        em.getTransaction().commit();
    }       
}