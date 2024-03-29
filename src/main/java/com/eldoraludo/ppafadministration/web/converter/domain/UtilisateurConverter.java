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
import com.eldoraludo.ppafadministration.domain.Utilisateur;
import com.eldoraludo.ppafadministration.repository.UtilisateurRepository;
import com.eldoraludo.ppafadministration.web.converter.GenericJsfConverter;

/**
 * Responsible for creating Utilisateur JSF converters.
 * Each converter provides a 'print' method to convert an entity instance to a friendly string representation (readable by humans...).
 */
@Component
public class UtilisateurConverter extends GenericJsfConverter<Utilisateur, Integer> {
    @Inject
    public UtilisateurConverter(UtilisateurRepository utilisateurRepository) {
        super(utilisateurRepository, Integer.class);
    }

    @Override
    public String print(Utilisateur utilisateur) {
        return utilisateur == null ? "" : "" + utilisateur.getUsername() + "/" + utilisateur.getPassword() + "/" + utilisateur.getEmail();
    }
}