package com.entities;

import com.entities.Kullanicilar;
import com.entities.Urunler;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-29T22:19:32")
@StaticMetamodel(Yorumlar.class)
public class Yorumlar_ { 

    public static volatile SingularAttribute<Yorumlar, Date> ytarih;
    public static volatile SingularAttribute<Yorumlar, Urunler> urunfkID;
    public static volatile SingularAttribute<Yorumlar, Integer> yorumID;
    public static volatile SingularAttribute<Yorumlar, Kullanicilar> kullanicifkID;
    public static volatile SingularAttribute<Yorumlar, String> yorum;

}