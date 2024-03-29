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
import com.eldoraludo.ppafadministration.dao.FraisDao;
import com.eldoraludo.ppafadministration.dao.support.GenericDao;
import com.eldoraludo.ppafadministration.domain.Frais;

/**
 * JPA 2 Data Access Object for {@link com.eldoraludo.ppafadministration.domain.Frais}.
 * Note: do not use @Transactional in the DAO layer.
 */
@Named
@Singleton
public class FraisDao extends GenericDao<Frais, Integer> {
    public FraisDao() {
        super(Frais.class);
    }
}