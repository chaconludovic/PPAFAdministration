/*
 * (c) Copyright 2005-2012 JAXIO, www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-backend-jpa:src/main/java/project/domain/Entity_.e.vm.java
 */
package com.eldoraludo.ppafadministration.domain;

import java.util.Date;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import com.eldoraludo.ppafadministration.domain.Contact;
import com.eldoraludo.ppafadministration.domain.Item;
import com.eldoraludo.ppafadministration.domain.Lieudedepot;
import com.eldoraludo.ppafadministration.domain.Membreppaf;

@StaticMetamodel(Vente.class)
public abstract class Vente_ {

    // Raw attributes
    public static volatile SingularAttribute<Vente, Integer> id;
    public static volatile SingularAttribute<Vente, Date> date;
    public static volatile SingularAttribute<Vente, Date> datedencaissement;
    public static volatile SingularAttribute<Vente, Integer> quantite;
    public static volatile SingularAttribute<Vente, Double> prixtotal;
    public static volatile SingularAttribute<Vente, Double> fraisdeport;
    public static volatile SingularAttribute<Vente, String> numerodefacture;
    public static volatile SingularAttribute<Vente, String> modedereglement;
    public static volatile SingularAttribute<Vente, String> informationreglement;
    public static volatile SingularAttribute<Vente, String> note;

    // Technical attributes for query by example
    public static volatile SingularAttribute<Vente, Integer> itemId;
    public static volatile SingularAttribute<Vente, Integer> contactId;
    public static volatile SingularAttribute<Vente, Integer> lieudedepotId;
    public static volatile SingularAttribute<Vente, Integer> membreppafId;

    // Many to one
    public static volatile SingularAttribute<Vente, Item> item;
    public static volatile SingularAttribute<Vente, Membreppaf> membreppaf;
    public static volatile SingularAttribute<Vente, Lieudedepot> lieudedepot;
    public static volatile SingularAttribute<Vente, Contact> contact;
}