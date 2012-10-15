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
import com.eldoraludo.ppafadministration.domain.Suivicontact;
import com.eldoraludo.ppafadministration.dao.SuivicontactDao;

/**
 * Default implementation of the {@link SuivicontactRepository} interface.
 * Note: you may use multiple DAO from this layer.
 * @see SuivicontactRepository
 */
@Named("suivicontactRepository")
@Singleton
public class SuivicontactRepositoryImpl extends RepositoryImpl<Suivicontact, Integer> implements SuivicontactRepository {

    private static final Logger log = Logger.getLogger(SuivicontactRepositoryImpl.class);

    protected SuivicontactDao suivicontactDao;

    @Inject
    public void setSuivicontactDao(SuivicontactDao suivicontactDao) {
        this.suivicontactDao = suivicontactDao;
    }

    /**
     * Dao getter used by the {@link RepositoryImpl}.
     */
    @Override
    public GenericDao<Suivicontact, Integer> getDao() {
        return suivicontactDao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Suivicontact getNew() {
        return new Suivicontact();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Suivicontact getNewWithDefaults() {
        Suivicontact result = getNew();
        result.initDefaultValues();
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void delete(Suivicontact suivicontact) {
        if (suivicontact == null) {
            if (log.isDebugEnabled()) {
                log.debug("Skipping deletion for null model!");
            }

            return;
        }

        // remove the reference from the associated membreppaf
        if (suivicontact.getMembreppaf() != null) {
            suivicontact.getMembreppaf().removeSuivicontact(suivicontact);
        }

        // remove the reference from the associated contact
        if (suivicontact.getContact() != null) {
            suivicontact.getContact().removeSuivicontact(suivicontact);
        }

        super.delete(suivicontact);
    }
}