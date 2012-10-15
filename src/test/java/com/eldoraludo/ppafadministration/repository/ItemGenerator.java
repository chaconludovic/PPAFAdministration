/*
 * (c) Copyright 2005-2012 JAXIO, www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-backend-jpa:src/test/java/service/ModelGenerator.e.vm.java
 */
package com.eldoraludo.ppafadministration.repository;

import javax.inject.Named;
import javax.inject.Singleton;
import com.eldoraludo.ppafadministration.domain.Item;
import com.eldoraludo.ppafadministration.util.ValueGenerator;

/**
 * Helper class to create transient entities instance for testing purposes.
 * Simple properties are pre-filled with random values.
 */
@SuppressWarnings("unused")
@Named
@Singleton
public class ItemGenerator {

    /**
     * Returns a new Item instance filled with random values.
     */
    public Item getItem() {
        Item item = new Item();

        // simple attributes follows
        item.setNom("a");
        item.setReference("a");
        item.setNote("a");
        return item;
    }

}