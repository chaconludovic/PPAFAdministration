/*
 * (c) Copyright 2005-2012 JAXIO, www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-backend-jpa:src/main/java/project/domain/Entity_.e.vm.java
 */
package com.eldoraludo.ppafadministration.domain;

import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import com.eldoraludo.ppafadministration.domain.Itemlieudestockage;
import com.eldoraludo.ppafadministration.domain.Membreppaf;

@StaticMetamodel(Lieudestockage.class)
public abstract class Lieudestockage_ {

    // Raw attributes
    public static volatile SingularAttribute<Lieudestockage, Integer> id;
    public static volatile SingularAttribute<Lieudestockage, String> nom;
    public static volatile SingularAttribute<Lieudestockage, String> rue;
    public static volatile SingularAttribute<Lieudestockage, String> ville;
    public static volatile SingularAttribute<Lieudestockage, String> codepostal;
    public static volatile SingularAttribute<Lieudestockage, String> infosuppl;
    public static volatile SingularAttribute<Lieudestockage, String> note;

    // Technical attributes for query by example
    public static volatile SingularAttribute<Lieudestockage, Integer> membreppafresponsableId;

    // Many to one
    public static volatile SingularAttribute<Lieudestockage, Membreppaf> membreppafresponsable;

    // One to many
    public static volatile ListAttribute<Lieudestockage, Itemlieudestockage> itemlieudestockages;
}