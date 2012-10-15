/*
 * (c) Copyright 2005-2012 JAXIO, www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-backend-jpa:src/test/java/domain/ModelTest.e.vm.java
 */
package com.eldoraludo.ppafadministration.domain;

import java.io.*;
import java.util.*;

import static org.junit.Assert.*;
import org.junit.Test;

import com.eldoraludo.ppafadministration.util.*;
import static javax.persistence.CascadeType.ALL;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.FetchType.LAZY;
import static org.hibernate.annotations.CacheConcurrencyStrategy.NONSTRICT_READ_WRITE;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.apache.log4j.Logger;
import org.hibernate.annotations.Cache;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import com.eldoraludo.ppafadministration.domain.Frais;
import com.eldoraludo.ppafadministration.domain.Rolemembre;
import com.eldoraludo.ppafadministration.domain.Suivicontact;
import com.eldoraludo.ppafadministration.domain.Suividulieudedepot;
import com.eldoraludo.ppafadministration.domain.Utilisateur;
import com.eldoraludo.ppafadministration.domain.Vente;

/**
 * Basic tests for Membreppaf
 */
@SuppressWarnings("unused")
public class MembreppafTest {

    // test unique primary key
    @Test
    public void newInstanceHasNoPrimaryKey() {
        Membreppaf model = new Membreppaf();
        assertFalse(model.isIdSet());
    }

    @Test
    public void isIdSetReturnsTrue() {
        Membreppaf model = new Membreppaf();
        model.setId(ValueGenerator.getUniqueInteger());
        assertNotNull(model.getId());
        assertTrue(model.isIdSet());
    }

    // test columns methods

    //-------------------------------------------------------------
    // Many to One:  Membreppaf.rolemembreId ==> Rolemembre.id
    //-------------------------------------------------------------

    @Test
    public void manyToOne_setRolemembre() {
        Membreppaf many = new Membreppaf();

        // init
        Rolemembre one = new Rolemembre();

        one.setId(ValueGenerator.getUniqueInteger());
        many.setRolemembre(one);

        // make sure it is propagated properly
        assertNotNull(many.getRolemembreId());
        assertEquals(one, many.getRolemembre());
        assertSame(many.getRolemembreId(), one.getId());
        // now set it to back to null
        many.setRolemembre(null);

        // make sure null is propagated properly
        assertNull(many.getRolemembre());

        // make sure it is propagated on fk column as well
        assertNull(many.getRolemembreId());
    }

    //-------------------------------------------------------------
    // One to Many: SimpleOneToMany MEMBREPPAF.ID ==> UTILISATEUR.membrePPAF_id
    //-------------------------------------------------------------

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // utilisateur.utilisateur <-- membreppaf.membreppafs
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    @Test
    public void oneToMany_addUtilisateur() {
        Membreppaf one = new Membreppaf();
        Utilisateur many = new Utilisateur();

        // init
        one.addUtilisateur(many);

        // make sure it is propagated
        assertTrue(one.containsUtilisateur(many));
        assertTrue(one.equals(many.getMembreppaf()));

        // now set it to null
        one.removeUtilisateur(many);

        // make sure null is propagated
        assertFalse(one.containsUtilisateur(many));
        assertNull(many.getMembreppaf());
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // suivicontact.suivicontact <-- membreppaf.membreppafs
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    @Test
    public void oneToMany_addSuivicontact() {
        Membreppaf one = new Membreppaf();
        Suivicontact many = new Suivicontact();

        // init
        one.addSuivicontact(many);

        // make sure it is propagated
        assertTrue(one.containsSuivicontact(many));
        assertTrue(one.equals(many.getMembreppaf()));

        // now set it to null
        one.removeSuivicontact(many);

        // make sure null is propagated
        assertFalse(one.containsSuivicontact(many));
        assertNull(many.getMembreppaf());
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // suividulieudedepot.suividulieudedepot <-- membreppaf.membreppafs
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    @Test
    public void oneToMany_addSuividulieudedepot() {
        Membreppaf one = new Membreppaf();
        Suividulieudedepot many = new Suividulieudedepot();

        // init
        one.addSuividulieudedepot(many);

        // make sure it is propagated
        assertTrue(one.containsSuividulieudedepot(many));
        assertTrue(one.equals(many.getMembreppaf()));

        // now set it to null
        one.removeSuividulieudedepot(many);

        // make sure null is propagated
        assertFalse(one.containsSuividulieudedepot(many));
        assertNull(many.getMembreppaf());
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // vente.vente <-- membreppaf.membreppafs
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    @Test
    public void oneToMany_addVente() {
        Membreppaf one = new Membreppaf();
        Vente many = new Vente();

        // init
        one.addVente(many);

        // make sure it is propagated
        assertTrue(one.containsVente(many));
        assertTrue(one.equals(many.getMembreppaf()));

        // now set it to null
        one.removeVente(many);

        // make sure null is propagated
        assertFalse(one.containsVente(many));
        assertNull(many.getMembreppaf());
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // frais.frais <-- membreppaf.membreppafs
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    @Test
    public void oneToMany_addFrais() {
        Membreppaf one = new Membreppaf();
        Frais many = new Frais();

        // init
        one.addFrais(many);

        // make sure it is propagated
        assertTrue(one.containsFrais(many));
        assertTrue(one.equals(many.getMembreppaf()));

        // now set it to null
        one.removeFrais(many);

        // make sure null is propagated
        assertFalse(one.containsFrais(many));
        assertNull(many.getMembreppaf());
    }

    @Test
    public void toStringNotNull() {
        Membreppaf model = new Membreppaf();
        assertNotNull(model.toString());
    }

    @Test
    public void equalsUsingPk() {
        Membreppaf model1 = new Membreppaf();
        Membreppaf model2 = new Membreppaf();

        Integer id = ValueGenerator.getUniqueInteger();
        model1.setId(id);
        model2.setId(id);

        model1.setNom("a");
        model2.setNom("a");

        model1.setPrenom("a");
        model2.setPrenom("a");

        model1.setNumerotelephone1("a");
        model2.setNumerotelephone1("a");

        model1.setNumerotelephone2("a");
        model2.setNumerotelephone2("a");

        model1.setEmail("dummy@dummy.com");
        model2.setEmail("dummy@dummy.com");

        model1.setActif(true);
        model2.setActif(true);

        model1.setNote("a");
        model2.setNote("a");

        model1.setRue("a");
        model2.setRue("a");

        model1.setVille("a");
        model2.setVille("a");

        model1.setCodepostal("a");
        model2.setCodepostal("a");

        model1.setInfosuppl("a");
        model2.setInfosuppl("a");
        assertTrue(model1.isIdSet());
        assertTrue(model2.isIdSet());
        assertTrue(model1.hashCode() == model2.hashCode());
        assertTrue(model1.equals(model2));
        assertTrue(model2.equals(model1));
    }
}