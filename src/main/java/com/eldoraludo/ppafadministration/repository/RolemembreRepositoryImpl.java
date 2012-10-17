/*
 * (c) Copyright 2005-2012 JAXIO, www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-backend-jpa:src/main/java/project/repository/RepositoryImpl.e.vm.java
 */
package com.eldoraludo.ppafadministration.repository;

import static org.apache.commons.lang.StringUtils.isNotEmpty;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import javax.inject.Named;
import javax.inject.Singleton;
import org.springframework.transaction.annotation.Transactional;

import com.eldoraludo.ppafadministration.dao.support.GenericDao;
import com.eldoraludo.ppafadministration.repository.support.RepositoryImpl;
import com.eldoraludo.ppafadministration.domain.Rolemembre;
import com.eldoraludo.ppafadministration.dao.RolemembreDao;

/**
 * Default implementation of the {@link RolemembreRepository} interface.
 * Note: you may use multiple DAO from this layer.
 * @see RolemembreRepository
 */
@Named("rolemembreRepository")
@Singleton
public class RolemembreRepositoryImpl extends RepositoryImpl<Rolemembre, Integer> implements RolemembreRepository {

    @SuppressWarnings("unused")
    private static final Logger log = Logger.getLogger(RolemembreRepositoryImpl.class);

    protected RolemembreDao rolemembreDao;

    @Inject
    public void setRolemembreDao(RolemembreDao rolemembreDao) {
        this.rolemembreDao = rolemembreDao;
    }

    /**
     * Dao getter used by the {@link RepositoryImpl}.
     */
    @Override
    public GenericDao<Rolemembre, Integer> getDao() {
        return rolemembreDao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Rolemembre getNew() {
        return new Rolemembre();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Rolemembre getNewWithDefaults() {
        Rolemembre result = getNew();
        result.initDefaultValues();
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public Rolemembre get(Rolemembre model) {
        if (model == null) {
            return null;
        }

        if (model.isIdSet()) {
            return super.get(model);
        }

        if (!isNotEmpty(model.getRole())) {
            Rolemembre result = getByRole(model.getRole());
            if (result != null) {
                return result;
            }
        }

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public Rolemembre getByRole(String _role) {
        Rolemembre rolemembre = new Rolemembre();
        rolemembre.setRole(_role);
        return findUniqueOrNone(rolemembre);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void deleteByRole(String role) {
        delete(getByRole(role));
    }
}