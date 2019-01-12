package com.entities;

import com.entities.KullaniciOylari;
import com.entities.Yorumlar;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-29T22:19:32")
@StaticMetamodel(Kullanicilar.class)
public class Kullanicilar_ { 

    public static volatile SingularAttribute<Kullanicilar, String> ksifre;
    public static volatile SingularAttribute<Kullanicilar, Integer> konay;
    public static volatile SingularAttribute<Kullanicilar, String> kemail;
    public static volatile SingularAttribute<Kullanicilar, String> ksoyad;
    public static volatile ListAttribute<Kullanicilar, Yorumlar> yorumlarList;
    public static volatile ListAttribute<Kullanicilar, KullaniciOylari> kullaniciOylariList;
    public static volatile SingularAttribute<Kullanicilar, Date> ktarih;
    public static volatile SingularAttribute<Kullanicilar, Integer> kullaniciID;
    public static volatile SingularAttribute<Kullanicilar, String> kad;

}