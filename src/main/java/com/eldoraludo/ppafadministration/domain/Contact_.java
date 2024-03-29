/*
 * (c) Copyright 2005-2012 JAXIO, www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-backend-jpa:src/main/java/project/domain/Entity_.e.vm.java
 */
package com.eldoraludo.ppafadministration.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Contact.class)
public abstract class Contact_ {

    // Raw attributes
    public static volatile SingularAttribute<Contact, Integer> id;
    public static volatile SingularAttribute<Contact, String> nom;
    public static volatile SingularAttribute<Contact, String> prenom;
    public static volatile SingularAttribute<Contact, String> numerotelephone1;
    public static volatile SingularAttribute<Contact, String> numerotelephone2;
    public static volatile SingularAttribute<Contact, String> email;
    public static volatile SingularAttribute<Contact, Boolean> actif;
    public static volatile SingularAttribute<Contact, String> note;
    public static volatile SingularAttribute<Contact, String> rue;
    public static volatile SingularAttribute<Contact, String> ville;
    public static volatile SingularAttribute<Contact, String> codepostal;
    public static volatile SingularAttribute<Contact, String> infosuppl;
    public static volatile SingularAttribute<Contact, Integer> version;
}