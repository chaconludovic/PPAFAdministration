/*
 * (c) Copyright 2005-2012 JAXIO, www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-backend-jpa:src/main/java/project/repository/RepositoryImpl.e.vm.java
 */
package com.eldoraludo.ppafadministration.repository;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import javax.inject.Named;
import javax.inject.Singleton;
import org.springframework.transaction.annotation.Transactional;

import com.eldoraludo.ppafadministration.dao.support.GenericDao;
import com.eldoraludo.ppafadministration.repository.support.RepositoryImpl;
import com.eldoraludo.ppafadministration.domain.Frais;
import com.eldoraludo.ppafadministration.dao.FraisDao;

/**
 * Default implementation of the {@link FraisRepository} interface.
 * Note: you may use multiple DAO from this layer.
 * @see FraisRepository
 */
@Named("fraisRepository")
@Singleton
public class FraisRepositoryImpl extends RepositoryImpl<Frais, Integer> implements FraisRepository {

    private static final Logger log = Logger.getLogger(FraisRepositoryImpl.class);

    protected FraisDao fraisDao;

    @Inject
    public void setFraisDao(FraisDao fraisDao) {
        this.fraisDao = fraisDao;
    }

    /**
     * Dao getter used by the {@link RepositoryImpl}.
     */
    @Override
    public GenericDao<Frais, Integer> getDao() {
        return fraisDao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Frais getNew() {
        return new Frais();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Frais getNewWithDefaults() {
        Frais result = getNew();
        result.initDefaultValues();
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void delete(Frais frais) {
        if (frais == null) {
            if (log.isDebugEnabled()) {
                log.debug("Skipping deletion for null model!");
            }

            return;
        }

        // remove the reference from the associated membreppaf
        if (frais.getMembreppaf() != null) {
            frais.getMembreppaf().removeFrais(frais);
        }

        super.delete(frais);
    }
}