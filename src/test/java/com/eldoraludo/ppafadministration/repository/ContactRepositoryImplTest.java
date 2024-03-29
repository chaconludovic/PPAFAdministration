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

import com.eldoraludo.ppafadministration.domain.Contact;
import com.eldoraludo.ppafadministration.repository.ContactRepositoryImpl;
import com.eldoraludo.ppafadministration.dao.ContactDao;
import com.eldoraludo.ppafadministration.dao.support.SearchParameters;

/**
 * Unit test on ContactRepositoryImpl
 */
public class ContactRepositoryImplTest {

    private ContactRepositoryImpl contactRepositoryImpl;
    private ContactDao contactDao;

    @Before
    public void setUp() {
        // called before each test.
        contactRepositoryImpl = new ContactRepositoryImpl();
        contactDao = mock(ContactDao.class);
        contactRepositoryImpl.setContactDao(contactDao);
    }

    @Test
    public void testFindUniqueOrNoneCaseNone() {
        Contact none = null;

        when(contactDao.findUniqueOrNone(any(Contact.class), any(SearchParameters.class))).thenReturn(none);

        Contact result = contactRepositoryImpl.findUniqueOrNone(new Contact());

        assertThat(result).isNull();
        verify(contactDao, times(1)).findUniqueOrNone(any(Contact.class), any(SearchParameters.class));
    }

    @Test
    public void testFindUniqueOrNoneCaseUnique() {
        Contact unique = new Contact();

        when(contactDao.findUniqueOrNone(any(Contact.class), any(SearchParameters.class))).thenReturn(unique);

        Contact result = contactRepositoryImpl.findUniqueOrNone(new Contact());

        assertThat(result).isNotNull();
        verify(contactDao, times(1)).findUniqueOrNone(any(Contact.class), any(SearchParameters.class));
    }

    @SuppressWarnings("unchecked")
    @Test(expected = NonUniqueResultException.class)
    public void testFindUniqueOrNoneCaseMultiple() {
        when(contactDao.findUniqueOrNone(any(Contact.class), any(SearchParameters.class))).thenThrow(NonUniqueResultException.class);

        contactRepositoryImpl.findUniqueOrNone(new Contact());
    }

    @SuppressWarnings("unchecked")
    @Test(expected = NoResultException.class)
    public void testFindUniqueCaseNone() {
        when(contactDao.findUnique(any(Contact.class), any(SearchParameters.class))).thenThrow(NoResultException.class);

        contactRepositoryImpl.findUnique(new Contact());
    }

    @Test
    public void testFindUniqueCaseUnique() {
        Contact unique = new Contact();

        when(contactDao.findUnique(any(Contact.class), any(SearchParameters.class))).thenReturn(unique);

        Contact result = contactRepositoryImpl.findUnique(new Contact());

        assertThat(result).isNotNull();
        verify(contactDao, times(1)).findUnique(any(Contact.class), any(SearchParameters.class));
    }

    @SuppressWarnings("unchecked")
    @Test(expected = NonUniqueResultException.class)
    public void testFindUniqueCaseMultiple() {
        when(contactDao.findUnique(any(Contact.class), any(SearchParameters.class))).thenThrow(NonUniqueResultException.class);

        contactRepositoryImpl.findUnique(new Contact());
    }
}