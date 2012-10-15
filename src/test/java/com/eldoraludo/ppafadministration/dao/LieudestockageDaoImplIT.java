/*
 * (c) Copyright 2005-2012 JAXIO, www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-backend-jpa:src/test/java/dao/DaoImplIT.e.vm.java
 */
package com.eldoraludo.ppafadministration.dao;

import java.util.Set;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

import static com.google.common.collect.Sets.newHashSet;
import static org.fest.assertions.Assertions.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.eldoraludo.ppafadministration.domain.Lieudestockage;
import com.eldoraludo.ppafadministration.repository.LieudestockageGenerator;
import com.eldoraludo.ppafadministration.dao.LieudestockageDao;

/**
 * Integration test on LieudestockageDaoImpl
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring/applicationContext-test.xml" })
@Transactional
public class LieudestockageDaoImplIT {
    @SuppressWarnings("unused")
    private static final Logger log = Logger.getLogger(LieudestockageDaoImplIT.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Inject
    private LieudestockageDao lieudestockageDao;

    @Inject
    private LieudestockageGenerator lieudestockageGenerator;

    @Test
    @Rollback
    public void saveAndGet() {
        Lieudestockage lieudestockage = lieudestockageGenerator.getLieudestockage();

        // add it to a Set before saving (force equals/hashcode)
        Set<Lieudestockage> set = newHashSet(lieudestockage, lieudestockage);
        assertThat(set).hasSize(1);

        lieudestockageDao.save(lieudestockage);
        entityManager.flush();

        // reload it from cache and check equality
        Lieudestockage model = new Lieudestockage();
        model.setId(lieudestockage.getId());
        assertThat(lieudestockage).isEqualTo(lieudestockageDao.get(model));

        // clear cache to force reload from db
        entityManager.clear();

        // since you use a business key, equality must be preserved.
        assertThat(lieudestockage).isEqualTo(lieudestockageDao.get(model));
    }
}