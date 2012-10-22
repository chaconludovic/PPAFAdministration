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
import static org.hibernate.annotations.CacheConcurrencyStrategy.NONSTRICT_READ_WRITE;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;
import javax.validation.constraints.Size;
import org.apache.log4j.Logger;
import org.hibernate.annotations.Cache;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Basic tests for Rolemembre
 */
@SuppressWarnings("unused")
public class RolemembreTest {

    // test unique primary key
    @Test
    public void newInstanceHasNoPrimaryKey() {
        Rolemembre model = new Rolemembre();
        assertFalse(model.isIdSet());
    }

    @Test
    public void isIdSetReturnsTrue() {
        Rolemembre model = new Rolemembre();
        model.setId(ValueGenerator.getUniqueInteger());
        assertNotNull(model.getId());
        assertTrue(model.isIdSet());
    }

    // test columns methods

    @Test
    public void toStringNotNull() {
        Rolemembre model = new Rolemembre();
        assertNotNull(model.toString());
    }

    @Test
    public void equalsUsingBusinessKey() {
        Rolemembre model1 = new Rolemembre();
        Rolemembre model2 = new Rolemembre();
        String rolePpaf = ValueGenerator.getUniqueString(255);
        model1.setRolePpaf(rolePpaf);
        model2.setRolePpaf(rolePpaf);
        assertTrue(model1.equals(model2));
        assertTrue(model2.equals(model1));
        assertTrue(model1.hashCode() == model2.hashCode());
    }
}