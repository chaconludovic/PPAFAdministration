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
import com.eldoraludo.ppafadministration.domain.Rolemembre;
import com.eldoraludo.ppafadministration.util.ValueGenerator;

/**
 * Helper class to create transient entities instance for testing purposes.
 * Simple properties are pre-filled with random values.
 */
@SuppressWarnings("unused")
@Named
@Singleton
public class RolemembreGenerator {

    /**
     * Returns a new Rolemembre instance filled with random values.
     */
    public Rolemembre getRolemembre() {
        Rolemembre rolemembre = new Rolemembre();

        // simple attributes follows
        rolemembre.setRolePpaf(ValueGenerator.getUniqueString(255));
        return rolemembre;
    }

}