/*
 * (c) Copyright 2005-2012 JAXIO, www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-backend-jpa:src/main/java/project/dao/DAOImpl.e.vm.java
 */
package com.eldoraludo.ppafadministration.dao;

import javax.inject.Named;
import javax.inject.Singleton;
import com.eldoraludo.ppafadministration.dao.VenteDao;
import com.eldoraludo.ppafadministration.dao.support.GenericDao;
import com.eldoraludo.ppafadministration.domain.Vente;

/**
 * JPA 2 Data Access Object for {@link com.eldoraludo.ppafadministration.domain.Vente}.
 * Note: do not use @Transactional in the DAO layer.
 */
@Named
@Singleton
public class VenteDao extends GenericDao<Vente, Integer> {
    public VenteDao() {
        super(Vente.class);
    }
}