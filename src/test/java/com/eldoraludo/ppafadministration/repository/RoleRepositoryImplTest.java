/*
 * (c) Copyright 2005-2012 JAXIO, www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-backend-jpa:src/test/java/service/ServiceImplTest.e.vm.java
 */
package com.eldoraludo.ppafadministration.repository;

import static org.fest.assertions.Assertions.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import javax.persistence.NonUniqueResultException;
import javax.persistence.NoResultException;

import org.junit.Before;
import org.junit.Test;

import com.eldoraludo.ppafadministration.domain.Role;
import com.eldoraludo.ppafadministration.repository.RoleRepositoryImpl;
import com.eldoraludo.ppafadministration.dao.RoleDao;
import com.eldoraludo.ppafadministration.dao.support.SearchParameters;

/**
 * Unit test on RoleRepositoryImpl
 */
public class RoleRepositoryImplTest {

    private RoleRepositoryImpl roleRepositoryImpl;
    private RoleDao roleDao;

    @Before
    public void setUp() {
        // called before each test.
        roleRepositoryImpl = new RoleRepositoryImpl();
        roleDao = mock(RoleDao.class);
        roleRepositoryImpl.setRoleDao(roleDao);
    }

    @Test
    public void testFindUniqueOrNoneCaseNone() {
        Role none = null;

        when(roleDao.findUniqueOrNone(any(Role.class), any(SearchParameters.class))).thenReturn(none);

        Role result = roleRepositoryImpl.findUniqueOrNone(new Role());

        assertThat(result).isNull();
        verify(roleDao, times(1)).findUniqueOrNone(any(Role.class), any(SearchParameters.class));
    }

    @Test
    public void testFindUniqueOrNoneCaseUnique() {
        Role unique = new Role();

        when(roleDao.findUniqueOrNone(any(Role.class), any(SearchParameters.class))).thenReturn(unique);

        Role result = roleRepositoryImpl.findUniqueOrNone(new Role());

        assertThat(result).isNotNull();
        verify(roleDao, times(1)).findUniqueOrNone(any(Role.class), any(SearchParameters.class));
    }

    @SuppressWarnings("unchecked")
    @Test(expected = NonUniqueResultException.class)
    public void testFindUniqueOrNoneCaseMultiple() {
        when(roleDao.findUniqueOrNone(any(Role.class), any(SearchParameters.class))).thenThrow(NonUniqueResultException.class);

        roleRepositoryImpl.findUniqueOrNone(new Role());
    }

    @SuppressWarnings("unchecked")
    @Test(expected = NoResultException.class)
    public void testFindUniqueCaseNone() {
        when(roleDao.findUnique(any(Role.class), any(SearchParameters.class))).thenThrow(NoResultException.class);

        roleRepositoryImpl.findUnique(new Role());
    }

    @Test
    public void testFindUniqueCaseUnique() {
        Role unique = new Role();

        when(roleDao.findUnique(any(Role.class), any(SearchParameters.class))).thenReturn(unique);

        Role result = roleRepositoryImpl.findUnique(new Role());

        assertThat(result).isNotNull();
        verify(roleDao, times(1)).findUnique(any(Role.class), any(SearchParameters.class));
    }

    @SuppressWarnings("unchecked")
    @Test(expected = NonUniqueResultException.class)
    public void testFindUniqueCaseMultiple() {
        when(roleDao.findUnique(any(Role.class), any(SearchParameters.class))).thenThrow(NonUniqueResultException.class);

        roleRepositoryImpl.findUnique(new Role());
    }
}