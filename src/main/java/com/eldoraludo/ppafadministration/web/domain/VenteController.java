/*
 * (c) Copyright 2005-2012 JAXIO, www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-jsf2-primefaces:src/main/java/domain/Controller.e.vm.java
 */
package com.eldoraludo.ppafadministration.web.domain;

import static com.eldoraludo.ppafadministration.web.util.PrimeFacesUtil.forceClose;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import com.eldoraludo.ppafadministration.domain.Vente;
import com.eldoraludo.ppafadministration.repository.VenteRepository;
import com.eldoraludo.ppafadministration.web.converter.domain.VenteConverter;
import com.eldoraludo.ppafadministration.web.util.MessageUtil;

/**
 * Thin controller layer allowing you to do business validation and other conditional 
 * checks that are easier to implement in Java than in webflow's xml syntax.
 */
@Named
@Singleton
public class VenteController {
    private static final long serialVersionUID = 1L;

    @Inject
    private VenteRepository venteRepository;

    @Inject
    private MessageUtil messageUtil;

    @Inject
    private VenteConverter venteConverter;

    public Vente newIfNull(Vente vente) {
        if (vente != null) {
            return vente;
        }

        return venteRepository.getNewWithDefaults();
    }

    public boolean save(Vente vente) {
        venteRepository.save(vente);
        messageUtil.info("status_saved_ok", venteConverter.print(vente));
        return true;
    }

    public boolean saveAndClose(Vente vente) {
        venteRepository.save(vente);
        messageUtil.infoDelayed("status_saved_ok", venteConverter.print(vente));
        forceClose();
        return true;
    }

    public boolean delete(Vente vente) {
        String infoArg = venteConverter.print(vente);
        venteRepository.delete(vente);
        messageUtil.info("status_deleted_ok", infoArg);
        return true;
    }
}