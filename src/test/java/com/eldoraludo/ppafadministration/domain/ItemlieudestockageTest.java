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
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.TemporalType.DATE;
import static org.hibernate.annotations.CacheConcurrencyStrategy.NONSTRICT_READ_WRITE;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Transient;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.apache.log4j.Logger;
import org.hibernate.annotations.Cache;
import com.eldoraludo.ppafadministration.domain.Item;
import com.eldoraludo.ppafadministration.domain.Lieudestockage;

/**
 * Basic tests for Itemlieudestockage
 */
@SuppressWarnings("unused")
public class ItemlieudestockageTest {

    // test unique primary key
    @Test
    public void newInstanceHasNoPrimaryKey() {
        Itemlieudestockage model = new Itemlieudestockage();
        assertFalse(model.isIdSet());
    }

    @Test
    public void isIdSetReturnsTrue() {
        Itemlieudestockage model = new Itemlieudestockage();
        model.setId(ValueGenerator.getUniqueInteger());
        assertNotNull(model.getId());
        assertTrue(model.isIdSet());
    }

    // test columns methods

    //-------------------------------------------------------------
    // Many to One:  Itemlieudestockage.lieudestockageId ==> Lieudestockage.id
    //-------------------------------------------------------------

    @Test
    public void manyToOne_setLieudestockage() {
        Itemlieudestockage many = new Itemlieudestockage();

        // init
        Lieudestockage one = new Lieudestockage();

        one.setId(ValueGenerator.getUniqueInteger());
        many.setLieudestockage(one);

        // make sure it is propagated properly
        assertNotNull(many.getLieudestockageId());
        assertEquals(one, many.getLieudestockage());
        assertSame(many.getLieudestockageId(), one.getId());
        // now set it to back to null
        many.setLieudestockage(null);

        // make sure null is propagated properly
        assertNull(many.getLieudestockage());

        // make sure it is propagated on fk column as well
        assertNull(many.getLieudestockageId());
    }

    @Test
    public void manyToOne_setItem() {
        Itemlieudestockage many = new Itemlieudestockage();

        // init
        Item one = new Item();

        one.setId(ValueGenerator.getUniqueInteger());
        many.setItem(one);

        // make sure it is propagated properly
        assertNotNull(many.getItemId());
        assertEquals(one, many.getItem());
        assertSame(many.getItemId(), one.getId());
        // now set it to back to null
        many.setItem(null);

        // make sure null is propagated properly
        assertNull(many.getItem());

        // make sure it is propagated on fk column as well
        assertNull(many.getItemId());
    }

    @Test
    public void toStringNotNull() {
        Itemlieudestockage model = new Itemlieudestockage();
        assertNotNull(model.toString());
    }

    @Test
    public void equalsUsingPk() {
        Itemlieudestockage model1 = new Itemlieudestockage();
        Itemlieudestockage model2 = new Itemlieudestockage();

        Integer id = ValueGenerator.getUniqueInteger();
        model1.setId(id);
        model2.setId(id);

        model1.setDate(new Date());
        model2.setDate(new Date());

        model1.setQuantiteentre(1);
        model2.setQuantiteentre(1);

        model1.setQuantitesortie(1);
        model2.setQuantitesortie(1);

        model1.setNote("a");
        model2.setNote("a");

        model1.setVersion(1);
        model2.setVersion(1);
        assertTrue(model1.isIdSet());
        assertTrue(model2.isIdSet());
        assertTrue(model1.hashCode() == model2.hashCode());
        assertTrue(model1.equals(model2));
        assertTrue(model2.equals(model1));
    }
}