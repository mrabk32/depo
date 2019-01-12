package com.entities;

import com.entities.Kategoriler;
import com.entities.Urunler;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-29T22:19:32")
@StaticMetamodel(Markalar.class)
public class Markalar_ { 

    public static volatile SingularAttribute<Markalar, Kategoriler> kategoriID;
    public static volatile ListAttribute<Markalar, Urunler> urunlerList;
    public static volatile SingularAttribute<Markalar, String> markaAdi;
    public static volatile SingularAttribute<Markalar, Integer> markaID;

}