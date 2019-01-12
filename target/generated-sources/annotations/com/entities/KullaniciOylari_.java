package com.entities;

import com.entities.Kullanicilar;
import com.entities.Urunler;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-29T22:19:32")
@StaticMetamodel(KullaniciOylari.class)
public class KullaniciOylari_ { 

    public static volatile SingularAttribute<KullaniciOylari, Urunler> ufkID;
    public static volatile SingularAttribute<KullaniciOylari, Kullanicilar> kfkID;
    public static volatile SingularAttribute<KullaniciOylari, Integer> oy;
    public static volatile SingularAttribute<KullaniciOylari, Integer> kullaniciOylariID;

}