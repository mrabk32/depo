package com.entities;

import com.entities.Kategoriler;
import com.entities.KullaniciOylari;
import com.entities.Markalar;
import com.entities.Yorumlar;
import com.entities.ZiyaretciOylari;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-29T22:19:32")
@StaticMetamodel(Urunler.class)
public class Urunler_ { 

    public static volatile SingularAttribute<Urunler, String> aciklama;
    public static volatile SingularAttribute<Urunler, Integer> urunID;
    public static volatile SingularAttribute<Urunler, String> imagePath;
    public static volatile SingularAttribute<Urunler, Integer> fiyat;
    public static volatile SingularAttribute<Urunler, Integer> dislikeCount;
    public static volatile SingularAttribute<Urunler, Integer> likeCount;
    public static volatile ListAttribute<Urunler, Yorumlar> yorumlarList;
    public static volatile ListAttribute<Urunler, ZiyaretciOylari> ziyaretciOylariList;
    public static volatile ListAttribute<Urunler, KullaniciOylari> kullaniciOylariList;
    public static volatile SingularAttribute<Urunler, Markalar> markafkID;
    public static volatile SingularAttribute<Urunler, String> baslik;
    public static volatile SingularAttribute<Urunler, Kategoriler> kategorifkID;

}