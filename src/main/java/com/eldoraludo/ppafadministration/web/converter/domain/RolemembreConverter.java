/*
 * (c) Copyright 2005-2012 JAXIO, www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-jsf2-primefaces:src/main/java/converter/EntityConverter.e.vm.java
 */
package com.eldoraludo.ppafadministration.web.converter.domain;

import javax.inject.Inject;
import org.springframework.stereotype.Component;
import com.eldoraludo.ppafadministration.domain.Rolemembre;
import com.eldoraludo.ppafadministration.repository.RolemembreRepository;
import com.eldoraludo.ppafadministration.web.converter.GenericJsfConverter;

/**
 * Responsible for creating Rolemembre JSF converters.
 * Each converter provides a 'print' method to convert an entity instance to a friendly string representation (readable by humans...).
 */
@Component
public class RolemembreConverter extends GenericJsfConverter<Rolemembre, Integer> {
    @Inject
    public RolemembreConverter(RolemembreRepository rolemembreRepository) {
        super(rolemembreRepository, Integer.class);
    }

    @Override
    public String print(Rolemembre rolemembre) {
        return rolemembre == null ? "" : "" + rolemembre.getRolePpaf();
    }
}