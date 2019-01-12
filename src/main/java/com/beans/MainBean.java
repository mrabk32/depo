/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beans;

import com.controller.DatabaseController;
import com.entities.Admin;
import com.entities.Kategoriler;
import com.entities.KullaniciOylari;
import com.entities.Kullanicilar;
import com.entities.Markalar;
import com.entities.Urunler;
import com.entities.Yorumlar;
import com.entities.ZiyaretciOylari;
import java.io.Console;
import java.io.IOException;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ahmetbestamikose
 */
@ManagedBean(name="MainBean")
@SessionScoped
public class MainBean implements Serializable {

    /**
     * @return the girilenAktivasyonKodu
     */
    public String getGirilenAktivasyonKodu() {
        return girilenAktivasyonKodu;
    }

    /**
     * @param girilenAktivasyonKodu the girilenAktivasyonKodu to set
     */
    public void setGirilenAktivasyonKodu(String girilenAktivasyonKodu) {
        this.girilenAktivasyonKodu = girilenAktivasyonKodu;
    }

    /**
     * @param girisYapGmail the girisYapGmail to set
     */
    public void setGirisYapGmail(String girisYapGmail) {
        this.girisYapGmail = girisYapGmail;
    }

    /**
     * @return the girisYapGmail
     */
    public String getGirisYapGmail() {
        return girisYapGmail;
    }

    /**
     * @param girisYapGmail the girisYapGmail to set
     */
   

    /**
     * @return the kategoriDuzenleText
     */
    public String getKategoriDuzenleText() {
        return kategoriDuzenleText;
    }

    /**
     * @param kategoriDuzenleText the kategoriDuzenleText to set
     */
    public void setKategoriDuzenleText(String kategoriDuzenleText) {
        this.kategoriDuzenleText = kategoriDuzenleText;
    }

    public String getYeniUrunResimYolu() {
        return yeniUrunResimYolu;
    }

    public void setYeniUrunResimYolu(String yeniUrunResimYolu) {
        this.yeniUrunResimYolu = yeniUrunResimYolu;
    }

    public String getYeniUrunBaslik() {
        return yeniUrunBaslik;
    }

    public void setYeniUrunBaslik(String yeniUrunBaslik) {
        this.yeniUrunBaslik = yeniUrunBaslik;
    }

    public String getYeniUrunAciklama() {
        return yeniUrunAciklama;
    }

    public void setYeniUrunAciklama(String yeniUrunAciklama) {
        this.yeniUrunAciklama = yeniUrunAciklama;
    }

    public String getYeniUrunFiyat() {
        return yeniUrunFiyat;
    }

    public void setYeniUrunFiyat(String yeniUrunFiyat) {
        this.yeniUrunFiyat = yeniUrunFiyat;
    }

    public Markalar getYeniMarka() {
        return yeniMarka;
    }

    public void setYeniMarka(Markalar yeniMarka) {
        this.yeniMarka = yeniMarka;
    }

    public Urunler getYeniUrun() {
        return yeniUrun;
    }

    public void setYeniUrun(Urunler yeniUrun) {
        this.yeniUrun = yeniUrun;
    }

    public String getGirisYapAemail() {
        return girisYapAemail;
    }

    public void setGirisYapAemail(String girisYapAemail) {
        this.girisYapAemail = girisYapAemail;
    }

    public String getGirisYapAsifre() {
        return girisYapAsifre;
    }

    public void setGirisYapAsifre(String girisYapAsifre) {
        this.girisYapAsifre = girisYapAsifre;
    }

    /**
     * @return the sifremiUnuttumMaili
     */
    public String getSifremiUnuttumMaili() {
        return sifremiUnuttumMaili;
    }

    /**
     * @param sifremiUnuttumMaili the sifremiUnuttumMaili to set
     */
    public void setSifremiUnuttumMaili(String sifremiUnuttumMaili) {
        this.sifremiUnuttumMaili = sifremiUnuttumMaili;
    }

    /**
     * @return the duzenleKad
     */
    public String getDuzenleKad() {
        return duzenleKad;
    }

    /**
     * @param duzenleKad the duzenleKad to set
     */
    public void setDuzenleKad(String duzenleKad) {
        this.duzenleKad = duzenleKad;
    }

    /**
     * @return the duzenleKsoyad
     */
    public String getDuzenleKsoyad() {
        return duzenleKsoyad;
    }

    /**
     * @param duzenleKsoyad the duzenleKsoyad to set
     */
    public void setDuzenleKsoyad(String duzenleKsoyad) {
        this.duzenleKsoyad = duzenleKsoyad;
    }

    /**
     * @return the duzenleKsifre
     */
    public String getDuzenleKsifre() {
        return duzenleKsifre;
    }

    /**
     * @param duzenleKsifre the duzenleKsifre to set
     */
    public void setDuzenleKsifre(String duzenleKsifre) {
        this.duzenleKsifre = duzenleKsifre;
    }

    /**
     * @return the duzenleKemail
     */
    public String getDuzenleKemail() {
        return duzenleKemail;
    }

    /**
     * @param duzenleKemail the duzenleKemail to set
     */
    public void setDuzenleKemail(String duzenleKemail) {
        this.duzenleKemail = duzenleKemail;
    }

    /**
     * @return the girisYapKemail
     */
    public String getGirisYapKemail() {
        return girisYapKemail;
    }

    /**
     * @param girisYapKemail the girisYapKemail to set
     */
    public void setGirisYapKemail(String girisYapKemail) {
        this.girisYapKemail = girisYapKemail;
    }

    /**
     * @return the girisYapKsifre
     */
    public String getGirisYapKsifre() {
        return girisYapKsifre;
    }

    /**
     * @param girisYapKsifre the girisYapKsifre to set
     */
    public void setGirisYapKsifre(String girisYapKsifre) {
        this.girisYapKsifre = girisYapKsifre;
    }

    /**
     * @return the mailBaslik
     */
    public String getMailBaslik() {
        return mailBaslik;
    }

    /**
     * @param mailBaslik the mailBaslik to set
     */
    public void setMailBaslik(String mailBaslik) {
        this.mailBaslik = mailBaslik;
    }

    /**
     * @return the mailMetin
     */
    public String getMailMetin() {
        return mailMetin;
    }

    /**
     * @param mailMetin the mailMetin to set
     */
    public void setMailMetin(String mailMetin) {
        this.mailMetin = mailMetin;
    }

    

    /**
     * @return the mailAdresi
     */
    public String getMailAdresi() {
        return mailAdresi;
    }

    /**
     * @param mailAdresi the mailAdresi to set
     */
    public void setMailAdresi(String mailAdresi) {
        this.mailAdresi = mailAdresi;
    }

    /**
     * @return the yorumMetni
     */
    public String getYorumMetni() {
        return yorumMetni;
    }

    /**
     * @param yorumMetni the yorumMetni to set
     */
    public void setYorumMetni(String yorumMetni) {
        this.yorumMetni = yorumMetni;
    }

    /**
     * @return the kayitliMi
     */
    public boolean isKayitliMi() {
        return kayitliMi;
    }

    /**
     * @param kayitliMi the kayitliMi to set
     */
    public void setKayitliMi(boolean kayitliMi) {
        this.kayitliMi = kayitliMi;
    }

    

    /**
     * @return the uyeOlKad
     */
    public String getUyeOlKad() {
        return uyeOlKad;
    }

    /**
     * @param uyeOlKad the uyeOlKad to set
     */
    public void setUyeOlKad(String uyeOlKad) {
        this.uyeOlKad = uyeOlKad;
    }
    
    

    public List<Urunler> getPupulerUrunler() {
        return pupulerUrunler;
    }

    public void setPupulerUrunler(List<Urunler> pupulerUrunler) {
        this.pupulerUrunler = pupulerUrunler;
    }
    
    public MainBean(){
    
    }
    
    private Admin admin;
    private Kategoriler kategoriler;
    private KullaniciOylari kullaniciOylari;
    private Kullanicilar yeniKullanici ;
    private Kullanicilar girisKullanici ;
    private Kullanicilar duzenleKullanici ;
    
    private Markalar markalar;
    private Urunler urunler;
    private Yorumlar yorumlar;
    private ZiyaretciOylari ziyaretciOylari;
    
    private String uyeOlKad ;
    private int kID = 0;
    private String uyeOlKsoyad ;
    private String uyeOlKemail ;
    private String uyeOlKsifre ;
    private boolean kayitliMi ;
    
    private String sifremiUnuttumMaili;
    
    private String girisYapKemail;
    private String girisYapKsifre;
    
    private String denemeKategoriText = "";
    
    private String duzenleKad ;
    private String duzenleKsoyad ;
    private String duzenleKsifre ;
    private String duzenleKemail ;
    
    private String girisYapGmail = "text";
    
    private String aranacakMetin; //arama kutusuna girilen metin burada tutulacak
    
    private String yorumMetni;
    
    private String mailAdresi;
    private String mailMetin;
    private String mailBaslik = "";
    
    private String girilenAktivasyonKodu = "";
                
    
    private List<Kategoriler> kategorilerList = null;
    private List<Markalar> markalarList = null;
    private List<Yorumlar> yorumlarList = null;
    private List<Urunler> urunlerList = null;
    
    private List<Urunler> tumUrunlerList = null;
    
    private List<Urunler> pupulerUrunler = null;
    private List<Urunler> top5Urun = null;
    private List<Urunler> arananUrunlerList = null;
    
    private Kategoriler selectedKategori = null;
    private Markalar selectedMarka = null;
    private Urunler selectedUrun = null;
    private Kullanicilar selectedKullanici = null;
    private Yorumlar selectedYorum = null;
    
    private String girisYapAemail = null;
    private String girisYapAsifre = null;
    
    
    private String kategoriEkleText ="";
    private String kategoriDuzenleText = "";
    
    
    private String yeniUrunResimYolu;
    private String yeniUrunBaslik;
    private String yeniUrunAciklama;
    private String yeniUrunFiyat;
    
    
    private Kategoriler yeniKategori;
    private Markalar yeniMarka;
    private Urunler yeniUrun;
    
    public String goHome(){
        return "index?faces-redirect=true";
    }
    public String goUrun(){
           return "urun?faces-redirect=true";
    }
    public String goGiris(){
        return "giris?faces-redirect=true";
    }
    public String goProfil(){
        return "profil?faces-redirect=true";
    }
    public String goDuzenle(){
        duzenleKad = this.getSelectedKullanici().getKad();
        duzenleKemail = this.getSelectedKullanici().getKemail();
        duzenleKsoyad = this.getSelectedKullanici().getKsoyad();
        duzenleKsifre = this.getSelectedKullanici().getKsifre();
        return "bilgileri-duzenle?faces-redirect=true";
    }
    public String goHakkimizda(){
        return "hakkimizda?faces-redirect=true";
    }
    public String goGizlilikGuvenlik(){
        return "gizlilik-ve-guvenlik?faces-redirect=true";
    }
    
    
    public String uyeOlSayfasinaGit(){
        return "uye-ol?faces-redirect=true";
    }
    public String sifremiUnuttumSayfasinaGit(){
        return "sifremi-unuttum?faces-redirect=true";
    }
    public String iletisimSayfasinaGit(){
        return "iletisim?faces-redirect=true";
    }
    public String goAdminGirisPage(){
        return "admin-giris?faces-redirect=true";
    }
    public String adminCikisYap(){
        admin = null;
        return "index?faces-redirect=true";
    }
    
    
    public void kategoriListesiGetir(){
        DatabaseController dc = new DatabaseController();
        this.setKategorilerList(dc.kategoriListesiCek());
//        String z = this.getKategorilerList().get(0).getKategoriAdi();
    }
    
    public String kategoriSayfasinaGit(int kID){
//        DatabaseController dc = new DatabaseController();
//        this.setSelectedKategori(dc.kategoriCek(kID));
//        this.setUrunlerList(this.getKategorilerList().get(kID-1).getUrunlerList());
        
        this.setSelectedKategori(this.getKategorilerList().get(kID));
        this.setUrunlerList(this.getKategorilerList().get(kID).getUrunlerList());
        this.setKategoriEkleText(selectedKategori.getKategoriAdi());
        this.setKategoriDuzenleText(selectedKategori.getKategoriAdi());
        
        return "kategori?faces-redirect=true";
    }
    public String markaSayfasinaGit(int kID, int mID){
//        DatabaseController dc = new DatabaseController();
//        this.setSelectedKategori(dc.kategoriCek(kID));
//        this.setSelectedMarka(this.getKategorilerList().get(kID-1).getMarkalarList().get(mID));
//        this.setUrunlerList(this.getSelectedMarka().getUrunlerList());
        
        this.setSelectedKategori(this.getKategorilerList().get(kID));
        this.setSelectedMarka(this.getSelectedKategori().getMarkalarList().get(mID));
        this.setUrunlerList(this.getSelectedMarka().getUrunlerList());
        this.yeniUrunAciklama = null;
        this.yeniUrunBaslik = null;
        this.yeniUrunFiyat = null;
        this.yeniUrunResimYolu = null;
        return "marka?faces-redirect=true";
    }
    public String urunSayfasinaGit(int uID){
        DatabaseController dc = new DatabaseController();
        this.setSelectedUrun(dc.urunBilgisiCek(uID));
        this.setSelectedMarka(this.getSelectedUrun().getMarkafkID());
        this.setYorumlarList(this.getSelectedUrun().getYorumlarList());
        this.yeniUrunAciklama = this.getSelectedUrun().getAciklama();
        this.yeniUrunBaslik = this.getSelectedUrun().getBaslik();
        this.yeniUrunFiyat = String.valueOf(this.getSelectedUrun().getFiyat());
        this.setYeniUrunBaslik(this.getSelectedUrun().getBaslik());
        this.yeniUrunResimYolu = this.getSelectedUrun().getImagePath();
        return "urun?faces-redirect=true";
    }
//    public String urunSayfasinaGit(int kID, int mID,int uID){
//        this.setSelectedKategori(this.getKategorilerList().get(kID-1));
//        this.setSelectedMarka(this.getSelectedKategori().getMarkalarList().get(mID-1));
//        this.setUrunlerList(this.getSelectedMarka().getUrunlerList());
//        this.setSelectedUrun(this.getUrunlerList().get(uID));
//        return "urun?faces-redirect=true";
//    }
//    public String urunSayfasinaGit2(int kID, int uID){
//        this.setSelectedKategori(this.getKategorilerList().get(kID));
//        this.setUrunlerList(this.getKategorilerList().get(kID).getUrunlerList());
//        this.setSelectedUrun(this.getUrunlerList().get(uID));
//        return "urun?faces-redirect=true";
//    }
    
    
    public String kategoriAdiGetir(int kID){
        
        return this.getKategorilerList().get(kID).getKategoriAdi();
    }
    public String markaAdiGetir(int kID, int mID){
        return this.getKategorilerList().get(kID).getMarkalarList().get(mID).getMarkaAdi();
    }
    
    public void populerUrunlerList(){
        DatabaseController dc = new DatabaseController();
        this.setTumUrunlerList(dc.tumUrunleriGetir());
        Urunler urunFlag = null;
        Urunler urunBuyuk = null;
        for(int i=0; i < this.getTumUrunlerList().size() - 1 ; i++){
            for(int j = i + 1; j < this.getTumUrunlerList().size(); j++){
                if(toplamOy(this.getTumUrunlerList().get(j)) >= toplamOy(this.tumUrunlerList.get(i))){
                    urunBuyuk = this.getTumUrunlerList().get(j);
                    urunFlag = this.getTumUrunlerList().get(i);
                    this.getTumUrunlerList().set(i, urunBuyuk);
                    this.getTumUrunlerList().set(j, urunFlag);
                }
            }
        }
        this.setPupulerUrunler(this.getTumUrunlerList().subList(0, 15));
        
        
        }
    public int toplamOy(Urunler gelenUrun){
        int toplamOySayisi = gelenUrun.getDislikeCount() + gelenUrun.getLikeCount();
        return toplamOySayisi;
        
    }
    
    public void top5UrunList(){
//        this.setTop5Urun(this.getKategorilerList().get(3).getMarkalarList().get(2).getUrunlerList());
//        this.getTop5Urun().add(this.getKategorilerList().get(2).getMarkalarList().get(1).getUrunlerList().get(2));
//        this.getTop5Urun().add(this.getKategorilerList().get(2).getMarkalarList().get(1).getUrunlerList().get(1));
        
        DatabaseController dc = new DatabaseController();
        this.setTumUrunlerList(dc.tumUrunleriGetir());
        Urunler urunFlag = null;
        Urunler urunBuyuk = null;
        for(int i=0; i < this.getTumUrunlerList().size() - 1 ; i++){
            for(int j = i + 1; j < this.getTumUrunlerList().size(); j++){
                if(yuzdeHesapla(this.getTumUrunlerList().get(j)) >= yuzdeHesapla(this.tumUrunlerList.get(i))){
                    urunBuyuk = this.getTumUrunlerList().get(j);
                    urunFlag = this.getTumUrunlerList().get(i);
                    this.getTumUrunlerList().set(i, urunBuyuk);
                    this.getTumUrunlerList().set(j, urunFlag);
                }
            }
        }
        this.setTop5Urun(this.getTumUrunlerList().subList(0, 5));
        urunleriYaz();
    }
    
    public float yuzdeHesapla(Urunler urunGelen){
        int likeSayisi = urunGelen.getLikeCount();
        int dislikeSayisi = urunGelen.getDislikeCount();
        int toplamOySayisi = likeSayisi + dislikeSayisi;
        float yuzde;
        if(toplamOySayisi != 0){
            yuzde = ((float)(likeSayisi) / (toplamOySayisi))*100;
        }
        else{
            yuzde = 0;
        }
        return yuzde;
    }
    public void urunleriYaz(){
        for(int i=0; i< this.getTumUrunlerList().size(); i++){
            System.out.println(this.getTumUrunlerList().get(i).getBaslik() + "  :  " + yuzdeHesapla(this.getTumUrunlerList().get(i)) );
        }
    }
    
    
    public String kullaciOlustur(){
        if(uyeOlKad.trim().length() <= 0 || 
                uyeOlKemail.trim().length() <= 0 || 
                uyeOlKsoyad.trim().length() <= 0  ||
                uyeOlKsifre.trim().length() <=0
                  )
        {
            return "uye-ol.xhtml?faces-redirect=true";
        }
        
        DatabaseController dbc = new DatabaseController();
        LocalDateTime localDateTime = LocalDateTime.now();
        Date date = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
        
        yeniKullanici = new Kullanicilar(0, uyeOlKemail.trim() , uyeOlKsifre.trim() , uyeOlKad.trim(), uyeOlKsoyad.trim(), date,kodOlustur());
        
        kayitliMi  = dbc.kayitliMi(yeniKullanici.getKemail());
        if(kayitliMi)
        {
            return "uye-ol.xhtml?faces-redirect=true";
        }
        else
        {
            
            dbc.kullaniciEkle(yeniKullanici);
            aktivasyonMailAt(yeniKullanici.getKemail(),yeniKullanici.getGirisKodu());
            girisKullanici = new Kullanicilar();
            girisKullanici = yeniKullanici;
            return "aktivasyonGir.xhtml?faces-redirect=true";
            
            /*selectedKullanici=yeniKullanici;
            int x = dbc.findKullaniciIDByEmail(uyeOlKemail);
            this.getSelectedKullanici().setKullaniciID(x);
            uyeOlKemail = null;
            uyeOlKsifre = null;
            uyeOlKad = null;
            uyeOlKsoyad = null;
            return "index.xhtml?faces-redirect=true";
        */
            }
        
            
        
    }
    public String aktivasyonDogrula(){
        DatabaseController dbc = new DatabaseController();
        boolean kodDogruMu = dbc.aktivasyonKoduDogrulama(getGirisKullanici().getKemail(), getGirilenAktivasyonKodu());
        if(kodDogruMu)
        {
            setSelectedKullanici(getGirisKullanici());
            return "index.xhtml?faces-redirect=true";
        }
        else
            return "";
    }
   
    public String girisYap()
    {
        DatabaseController dbc = new DatabaseController();
        
        this.kayitliMi = dbc.kayitliMi(this.girisYapKemail);
        if(this.kayitliMi)
        {
            this.setGirisKullanici(dbc.sifreDogruMu(this.girisYapKemail,this.girisYapKsifre));
            if(this.getGirisKullanici() != null)
            {
                aktivasyonMailAt(this.getGirisKullanici().getKemail(),this.getGirisKullanici().getGirisKodu());
                this.setGirilenAktivasyonKodu("");
                return "aktivasyonGir.xhtml?faces-redirect=true";
            }
            else
                return "sifremi-unuttum.xhtml?faces-redirect=true";
        }
        else
            return "giris.xhtml?faces-redirect=true";
    }
    public String sifremiUnuttum()
    {
        DatabaseController dbc = new DatabaseController();
        kayitliMi = dbc.kayitliMi(sifremiUnuttumMaili);
        if (kayitliMi) {
            sifreMailAt(sifremiUnuttumMaili);
            sifremiUnuttumMaili = null;
            return "sifremi-unuttum.xhtml?faces-redirect=true";
        }
        else
            return "sifremi-unuttum.xhtml?faces-redirect=true";
    }
                
    
    
    public String cikisYap()
    {
        this.setSelectedKullanici(null);
        this.setDuzenleKullanici(null);
        
        return "index.xhtml?faces-redirect=true";
    }
    
    public String yorumYap()
    {
        LocalDateTime localDateTime = LocalDateTime.now();
        Date date = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
        DatabaseController dbc = new DatabaseController();
        selectedYorum = new Yorumlar(0, yorumMetni.trim(), date);
        selectedYorum.setKullanicifkID(selectedKullanici);
        selectedYorum.setUrunfkID(selectedUrun);                
        dbc.yorumEkle(selectedYorum);
        yorumMetni = " ";
        this.getYorumlarList().add(selectedYorum);
        this.selectedYorum = null;
        return "urun.xhtml?faces-redirect=true";
        
    }
    public String alIslemi()
    {
        if(selectedKullanici == null){
            return "giris?faces-redirect=true";
        }
        else{
            DatabaseController dbc = new DatabaseController();
            kullaniciOylari = new KullaniciOylari(0, 1);
            kullaniciOylari.setKfkID(selectedKullanici);
            kullaniciOylari.setUfkID(selectedUrun);
            dbc.oyEkle(kullaniciOylari);
            this.selectedUrun.setLikeCount(this.getSelectedUrun().getLikeCount() + 1);
            return "urun.xhtml?faces-redirect=true";
        }
    }
    public String almaIslemi()
    {
        if(selectedKullanici == null){
            return "giris?faces-redirect=true";
        }
        else{
            DatabaseController dbc = new DatabaseController();
            kullaniciOylari = new KullaniciOylari(0, 0);
            kullaniciOylari.setKfkID(selectedKullanici);
            kullaniciOylari.setUfkID(selectedUrun);
            dbc.oyEkle(kullaniciOylari);
            this.selectedUrun.setDislikeCount(this.getSelectedUrun().getDislikeCount()+ 1);
            return "urun.xhtml?faces-redirect=true";
        }
    }
    
    
    public  String iletisimMailAt(){
             final String username = "almalimiserver@gmail.com";
             final String password = "kucukertas1996";
             Properties properties = new Properties();
             properties.put("mail.smtp.auth", "true");
             properties.put("mail.smtp.starttls.enable", "true");
             properties.put("mail.smtp.host", "smtp.gmail.com");
             properties.put("mail.smtp.port", "587");
 
             Session session = Session.getInstance(properties,
                           new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                           return new PasswordAuthentication(username, password);
                    }
             }); 
             try {
 
                    Message message = new MimeMessage(session);
                    message.setFrom(new InternetAddress(getMailAdresi()));
                    message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(username));
                    message.setSubject(getMailBaslik().toUpperCase());
                    message.setText(getMailAdresi()+"'den gelen mail konusu ve içeriği:\n\n"+getMailBaslik().toUpperCase()+"\n\n"+getMailMetin()); 
                    Transport.send(message);
                    mailAdresi = "";
                    mailBaslik = "";
                    mailMetin = "";
                    return "index.xhtml?faces-redirect=true";
                    
 
             } catch (MessagingException ex) {
                    throw new RuntimeException(ex);
             }
       }
    
    private void sifreMailAt(String mail) {
       DatabaseController dbc = new DatabaseController();
       String sifre = dbc.sifreCek(mail);
    // [START simple_example]
    Properties props = new Properties();
    Session session = Session.getDefaultInstance(props, null);

    try {
      Message msg = new MimeMessage(session);
      msg.setFrom(new InternetAddress("almalimiserver@gmail.com", "almalimi.com"));
      msg.addRecipient(Message.RecipientType.TO,
                       new InternetAddress(mail, "Değerli üyemiz"));
      msg.setSubject("şifreniz aşağıda yer almaktadır:");
      msg.setText(sifre);
      Transport.send(msg);
        System.out.println("mail gönderma başarılı");
    } catch (AddressException e) {
        System.out.println(e);
        // ...
    } catch (MessagingException e) {
        System.out.println(e);
        // ...
    } catch (UnsupportedEncodingException e) {
        System.out.println(e);
        // ...
    }
    // [END simple_example]
    }
    
    public String bilgileriDuzenle()
    {
        DatabaseController dbc = new DatabaseController();
        this.setDuzenleKullanici(new Kullanicilar(selectedKullanici.getKullaniciID(), duzenleKemail.trim(), duzenleKsifre.trim(), duzenleKad.trim(), duzenleKsoyad.trim(), null,selectedKullanici.getGirisKodu()));
        this.selectedKullanici = this.getDuzenleKullanici();
        this.setSelectedKullanici(this.getDuzenleKullanici());
        dbc.profilDüzenle(this.getDuzenleKullanici());
        return "index.xhtml?faces-redirect=true";

    }

    public String aramaIslemi()
    {
        DatabaseController dbc = new DatabaseController();
//            List<Urunler> bulunanUrunler = dbc.urunArama(getAranacakMetin().trim());
        this.setArananUrunlerList(dbc.urunArama(this.getAranacakMetin().trim()));
        aranacakMetin="";
        return "arama-sayfasi.xhtml?faces-redirect=true";
    }

    public String adminGirisYap(){
        DatabaseController dc = new DatabaseController();
        this.setAdmin(dc.adminKontrol(getGirisYapAemail(), getGirisYapAsifre()));
        if(admin == null){
            return "admin-giris?faces-redirect=true";
        }
        else{
            return "index?faces-redirect=true";
        }
    }
    
    // Admin kategori-marka-urun ekleme islemleri
    
    public String kategoriEkle(){
        if(this.getKategoriEkleText().length() <= 0){
            return "index?faces-redirect=true";
        }
        DatabaseController dc = new DatabaseController();
        
        setYeniKategori(new Kategoriler(0, this.getKategoriEkleText()));
        dc.kategoriEkleDB(yeniKategori);
        this.setKategoriEkleText(null);
        this.yeniKategori = null;
        return "index?faces-redirect=true";
    }
    public String markaEkle(){
        if(this.getKategoriEkleText().length() <= 0){
            return "index?faces-redirect=true";
        }
        DatabaseController dc = new DatabaseController();
        setYeniMarka(new Markalar(0,this.getSelectedKategori(), this.getKategoriEkleText()));
        dc.markaEkleDB(this.getYeniMarka());
        this.setKategoriEkleText(null);
        this.yeniMarka = null;
        return "index?faces-redirect=true";
    }
    public String urunEkle(){
        if(this.yeniUrunResimYolu.length() <= 0 || this.yeniUrunBaslik.length() <= 0 
                || this.yeniUrunAciklama.length() <= 0 || this.yeniUrunFiyat.length() <= 0){
            return "index?faces-redirect=true";
        }
        DatabaseController dc = new DatabaseController();
        setYeniUrun(new Urunler(0, this.getSelectedKategori(), this.getSelectedMarka(), this.getYeniUrunBaslik(), this.getYeniUrunAciklama(), Integer.parseInt(this.getYeniUrunFiyat()), 0, 0, this.getYeniUrunResimYolu()));
        dc.urunEkleDB(this.getYeniUrun());
        this.yeniUrun = null;
        this.yeniUrunAciklama = null;
        this.yeniUrunBaslik = null;
        this.yeniUrunFiyat = null;
        this.yeniUrunResimYolu = null;
        return "index?faces-redirect=true";
    }
    
    // Admin kategori-marka-urun guncelleme islemleri
    
    public String kategoriGuncelle(){
//        if(this.getKategoriEkleText().length() <= 0){
//            return "index?faces-redirect=true";
//        }
        DatabaseController dc = new DatabaseController();
        setYeniKategori(new Kategoriler(this.getSelectedKategori().getKategoriID(),this.kategoriDuzenleText));
        dc.kategoriGuncelleDB(yeniKategori);
        this.kategoriDuzenleText = "";
        kategoriListesiGetir();
        yeniKategori = null;
        return "giris?faces-redirect=true";
    }
    public String markaGuncelle(){
        if(this.getKategoriEkleText().length() <= 0){
            return "index?faces-redirect=true";
        }
        DatabaseController dc = new DatabaseController();
        setYeniMarka(new Markalar(this.getSelectedMarka().getMarkaID(), this.getSelectedKategori(), this.getKategoriEkleText()));
        dc.markaGuncelleDB(this.getYeniMarka());
        this.setKategoriEkleText(null);
        yeniMarka = null;
        return "index?faces-redirect=true";
    }
    public String urunGuncelle(){
        if(this.yeniUrunResimYolu.length() <= 0 || this.yeniUrunBaslik.length() <= 0 
                || this.yeniUrunAciklama.length() <= 0 || this.yeniUrunFiyat.length() <= 0){
            return "index?faces-redirect=true";
        }
        DatabaseController dc = new DatabaseController();
        setYeniUrun(new Urunler(this.getSelectedUrun().getUrunID(), this.getSelectedKategori(), this.getSelectedMarka(), this.getYeniUrunBaslik(), this.getYeniUrunAciklama(), Integer.valueOf(this.getYeniUrunFiyat()), this.selectedUrun.getLikeCount(), this.getSelectedUrun().getDislikeCount(), this.yeniUrunResimYolu));
        dc.urunGuncelleDB(this.getYeniUrun());
        yeniUrun = null;
        
        return "index?faces-redirect=true";
    }
    
    // Admin kategori-marka-urun silme islemleri
    
    public void kategoriSil(){
        DatabaseController dc = new DatabaseController();
        dc.kategoriSilDB(this.selectedKategori);
    }
    public void markaSil(){
        DatabaseController dc = new DatabaseController();
        dc.markaSilDB(this.selectedMarka);
    }
    public void urunSil(){
        DatabaseController dc = new DatabaseController();
        dc.urunSilDB(this.selectedUrun);
    }
    
    // Admin yorum silme islemi
    
    public void yorumSil(Yorumlar yorum){
        DatabaseController dc = new DatabaseController();
        dc.yorumSilDB(yorum);
        
    }
    public void girisYapGmailGoster(String kelime)
    {
        System.out.println(kelime);
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
    
    private void aktivasyonMailAt(String kemail, String girisKodu) {
         
       ;
    // [START simple_example]
    Properties props = new Properties();
    Session session = Session.getDefaultInstance(props, null);

    try {
      Message msg = new MimeMessage(session);
      msg.setFrom(new InternetAddress("almalimiserver@gmail.com", "almalimi.com"));
      msg.addRecipient(Message.RecipientType.TO,
                       new InternetAddress(kemail, "Değerli üyemiz"));
      msg.setSubject("doğrulama kodunuz aşağıda yer almaktadır:");
      msg.setText(girisKodu);
      Transport.send(msg);
        System.out.println("mail gönderma başarılı");
    } catch (AddressException e) {
        System.out.println(e);
        // ...
    } catch (MessagingException e) {
        System.out.println(e);
        // ...
    } catch (UnsupportedEncodingException e) {
        System.out.println(e);
        // ...
    }
    // [END simple_example]
    
    }
    
    
    
    
    
    

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public Kategoriler getKategoriler() {
        return kategoriler;
    }

    public void setKategoriler(Kategoriler kategoriler) {
        this.kategoriler = kategoriler;
    }

    public KullaniciOylari getKullaniciOylari() {
        return kullaniciOylari;
    }

    public void setKullaniciOylari(KullaniciOylari kullaniciOylari) {
        this.kullaniciOylari = kullaniciOylari;
    }

    public Kullanicilar getYeniKullanici() {
        return yeniKullanici;
    }

    public void setYeniKullanici(Kullanicilar yeniKullanici) {
        this.yeniKullanici = yeniKullanici;
    }

    public Markalar getMarkalar() {
        return markalar;
    }

    public void setMarkalar(Markalar markalar) {
        this.markalar = markalar;
    }

    public Urunler getUrunler() {
        return urunler;
    }

    public void setUrunler(Urunler urunler) {
        this.urunler = urunler;
    }

    public Yorumlar getYorumlar() {
        return yorumlar;
    }

    public void setYorumlar(Yorumlar yorumlar) {
        this.yorumlar = yorumlar;
    }

    public ZiyaretciOylari getZiyaretciOylari() {
        return ziyaretciOylari;
    }

    public void setZiyaretciOylari(ZiyaretciOylari ziyaretciOylari) {
        this.ziyaretciOylari = ziyaretciOylari;
    }

    public List<Kategoriler> getKategorilerList() {
        return kategorilerList;
    }

    public void setKategorilerList(List<Kategoriler> kategorilerList) {
        this.kategorilerList = kategorilerList;
    }

    public List<Markalar> getMarkalarList() {
        return markalarList;
    }

    public void setMarkalarList(List<Markalar> markalarList) {
        this.markalarList = markalarList;
    }

    public List<Yorumlar> getYorumlarList() {
        return yorumlarList;
    }

    public void setYorumlarList(List<Yorumlar> yorumlarList) {
        this.yorumlarList = yorumlarList;
    }

    public List<Urunler> getUrunlerList() {
        return urunlerList;
    }

    public void setUrunlerList(List<Urunler> urunlerList) {
        this.urunlerList = urunlerList;
    }

    public List<Urunler> getTop5Urun() {
        return top5Urun;
    }

    public void setTop5Urun(List<Urunler> top5Urun) {
        this.top5Urun = top5Urun;
    }

    public Kategoriler getSelectedKategori() {
        return selectedKategori;
    }

    public void setSelectedKategori(Kategoriler selectedKategori) {
        this.selectedKategori = selectedKategori;
    }

    public Markalar getSelectedMarka() {
        return selectedMarka;
    }

    public void setSelectedMarka(Markalar selectedMarka) {
        this.selectedMarka = selectedMarka;
    }

    public Urunler getSelectedUrun() {
        return selectedUrun;
    }

    public void setSelectedUrun(Urunler selectedUrun) {
        this.selectedUrun = selectedUrun;
    }

    public Kullanicilar getSelectedKullanici() {
        return selectedKullanici;
    }

    public void setSelectedKullanici(Kullanicilar selectedKullanici) {
        this.selectedKullanici = selectedKullanici;
    }

    public Yorumlar getSelectedYorum() {
        return selectedYorum;
    }

    public void setSelectedYorum(Yorumlar selectedYorum) {
        this.selectedYorum = selectedYorum;
    }

    /**
     * @return the uyeOlKsoyad
     */
    public String getUyeOlKsoyad() {
        return uyeOlKsoyad;
    }

    /**
     * @param uyeOlKsoyad the uyeOlKsoyad to set
     */
    public void setUyeOlKsoyad(String uyeOlKsoyad) {
        this.uyeOlKsoyad = uyeOlKsoyad;
    }

    /**
     * @return the uyeOlKemail
     */
    public String getUyeOlKemail() {
        return uyeOlKemail;
    }

    /**
     * @param uyeOlKemail the uyeOlKemail to set
     */
    public void setUyeOlKemail(String uyeOlKemail) {
        this.uyeOlKemail = uyeOlKemail;
    }

    /**
     * @return the uyeOlKsifre
     */
    public String getUyeOlKsifre() {
        return uyeOlKsifre;
    }

    /**
     * @param uyeOlKsifre the uyeOlKsifre to set
     */
    public void setUyeOlKsifre(String uyeOlKsifre) {
        this.uyeOlKsifre = uyeOlKsifre;
    }

    public String getAranacakMetin() {
        return aranacakMetin;
    }

    public void setAranacakMetin(String aranacakMetin) {
        this.aranacakMetin = aranacakMetin;
    }

    public List<Urunler> getArananUrunlerList() {
        return arananUrunlerList;
    }

    public void setArananUrunlerList(List<Urunler> arananUrunlerList) {
        this.arananUrunlerList = arananUrunlerList;
    }

    public Kullanicilar getGirisKullanici() {
        return girisKullanici;
    }

    public void setGirisKullanici(Kullanicilar girisKullanici) {
        this.girisKullanici = girisKullanici;
    }

    public Kullanicilar getDuzenleKullanici() {
        return duzenleKullanici;
    }

    public void setDuzenleKullanici(Kullanicilar duzenleKullanici) {
        this.duzenleKullanici = duzenleKullanici;
    }

    public List<Urunler> getTumUrunlerList() {
        return tumUrunlerList;
    }

    public void setTumUrunlerList(List<Urunler> tumUrunlerList) {
        this.tumUrunlerList = tumUrunlerList;
    }

    public String getKategoriEkleText() {
        return kategoriEkleText;
    }

    public void setKategoriEkleText(String kategoriEkleText) {
        this.kategoriEkleText = kategoriEkleText;
    }

    public Kategoriler getYeniKategori() {
        return yeniKategori;
    }

    public void setYeniKategori(Kategoriler yeniKategori) {
        this.yeniKategori = yeniKategori;
    }

    public String getDenemeKategoriText() {
        return denemeKategoriText;
    }

    public void setDenemeKategoriText(String denemeKategoriText) {
        this.denemeKategoriText = denemeKategoriText;
    }

    

    

    

    
    
}