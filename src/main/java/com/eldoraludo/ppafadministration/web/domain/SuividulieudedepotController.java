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

import com.eldoraludo.ppafadministration.domain.Suividulieudedepot;
import com.eldoraludo.ppafadministration.repository.SuividulieudedepotRepository;
import com.eldoraludo.ppafadministration.web.converter.domain.SuividulieudedepotConverter;
import com.eldoraludo.ppafadministration.web.util.MessageUtil;

/**
 * Thin controller layer allowing you to do business validation and other conditional 
 * checks that are easier to implement in Java than in webflow's xml syntax.
 */
@Named
@Singleton
public class SuividulieudedepotController {
    private static final long serialVersionUID = 1L;

    @Inject
    private SuividulieudedepotRepository suividulieudedepotRepository;

    @Inject
    private MessageUtil messageUtil;

    @Inject
    private SuividulieudedepotConverter suividulieudedepotConverter;

    public Suividulieudedepot newIfNull(Suividulieudedepot suividulieudedepot) {
        if (suividulieudedepot != null) {
            return suividulieudedepot;
        }

        return suividulieudedepotRepository.getNewWithDefaults();
    }

    public boolean save(Suividulieudedepot suividulieudedepot) {
        suividulieudedepotRepository.save(suividulieudedepot);
        messageUtil.info("status_saved_ok", suividulieudedepotConverter.print(suividulieudedepot));
        return true;
    }

    public boolean saveAndClose(Suividulieudedepot suividulieudedepot) {
        suividulieudedepotRepository.save(suividulieudedepot);
        messageUtil.infoDelayed("status_saved_ok", suividulieudedepotConverter.print(suividulieudedepot));
        forceClose();
        return true;
    }

    public boolean delete(Suividulieudedepot suividulieudedepot) {
        String infoArg = suividulieudedepotConverter.print(suividulieudedepot);
        suividulieudedepotRepository.delete(suividulieudedepot);
        messageUtil.info("status_deleted_ok", infoArg);
        return true;
    }
}