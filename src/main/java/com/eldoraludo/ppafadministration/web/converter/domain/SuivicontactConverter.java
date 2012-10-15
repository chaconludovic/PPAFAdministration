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
import com.eldoraludo.ppafadministration.domain.Suivicontact;
import com.eldoraludo.ppafadministration.repository.SuivicontactRepository;
import com.eldoraludo.ppafadministration.web.converter.GenericJsfConverter;

/**
 * Responsible for creating Suivicontact JSF converters.
 * Each converter provides a 'print' method to convert an entity instance to a friendly string representation (readable by humans...).
 */
@Component
public class SuivicontactConverter extends GenericJsfConverter<Suivicontact, Integer> {
    @Inject
    public SuivicontactConverter(SuivicontactRepository suivicontactRepository) {
        super(suivicontactRepository, Integer.class);
    }

    @Override
    public String print(Suivicontact suivicontact) {
        return suivicontact == null ? "" : "" + suivicontact.getNote();
    }
}