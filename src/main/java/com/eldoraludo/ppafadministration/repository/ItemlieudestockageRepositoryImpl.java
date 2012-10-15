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
import com.eldoraludo.ppafadministration.domain.Itemlieudestockage;
import com.eldoraludo.ppafadministration.dao.ItemlieudestockageDao;

/**
 * Default implementation of the {@link ItemlieudestockageRepository} interface.
 * Note: you may use multiple DAO from this layer.
 * @see ItemlieudestockageRepository
 */
@Named("itemlieudestockageRepository")
@Singleton
public class ItemlieudestockageRepositoryImpl extends RepositoryImpl<Itemlieudestockage, Integer> implements ItemlieudestockageRepository {

    private static final Logger log = Logger.getLogger(ItemlieudestockageRepositoryImpl.class);

    protected ItemlieudestockageDao itemlieudestockageDao;

    @Inject
    public void setItemlieudestockageDao(ItemlieudestockageDao itemlieudestockageDao) {
        this.itemlieudestockageDao = itemlieudestockageDao;
    }

    /**
     * Dao getter used by the {@link RepositoryImpl}.
     */
    @Override
    public GenericDao<Itemlieudestockage, Integer> getDao() {
        return itemlieudestockageDao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Itemlieudestockage getNew() {
        return new Itemlieudestockage();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Itemlieudestockage getNewWithDefaults() {
        Itemlieudestockage result = getNew();
        result.initDefaultValues();
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void delete(Itemlieudestockage itemlieudestockage) {
        if (itemlieudestockage == null) {
            if (log.isDebugEnabled()) {
                log.debug("Skipping deletion for null model!");
            }

            return;
        }

        // remove the reference from the associated lieudestockage
        if (itemlieudestockage.getLieudestockage() != null) {
            itemlieudestockage.getLieudestockage().removeItemlieudestockage(itemlieudestockage);
        }

        // remove the reference from the associated item
        if (itemlieudestockage.getItem() != null) {
            itemlieudestockage.getItem().removeItemlieudestockage(itemlieudestockage);
        }

        super.delete(itemlieudestockage);
    }
}