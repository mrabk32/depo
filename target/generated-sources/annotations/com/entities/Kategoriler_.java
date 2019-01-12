package com.entities;

import com.entities.Markalar;
import com.entities.Urunler;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-29T22:19:32")
@StaticMetamodel(Kategoriler.class)
public class Kategoriler_ { 

    public static volatile SingularAttribute<Kategoriler, Integer> kategoriID;
    public static volatile SingularAttribute<Kategoriler, String> kategoriAdi;
    public static volatile ListAttribute<Kategoriler, Urunler> urunlerList;
    public static volatile ListAttribute<Kategoriler, Markalar> markalarList;

}