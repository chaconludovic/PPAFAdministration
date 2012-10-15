/*
 * (c) Copyright 2005-2012 JAXIO, www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-jsf2-primefaces:src/main/java/domain/LazyDataModel.e.vm.java
 */
package com.eldoraludo.ppafadministration.web.domain;

import java.util.List;
import java.util.Map;
import javax.inject.Inject;

import org.primefaces.model.SortOrder;

import com.eldoraludo.ppafadministration.dao.support.SearchParameters;
import com.eldoraludo.ppafadministration.domain.Contact;
import com.eldoraludo.ppafadministration.repository.ContactRepository;
import com.eldoraludo.ppafadministration.web.domain.support.GenericLazyDataModel;

/**
 * Provides server-side pagination for search.
 *
 * @see http://jira.springframework.org/browse/SWF-1224 to avoid instanciate it as a var from your flow 
 */
public class ContactLazyDataModel extends GenericLazyDataModel<Contact> {
    private static final long serialVersionUID = 1L;

    @Inject
    transient private ContactRepository contactRepository;
    @Inject
    transient private ContactSearchForm contactSearchForm;

    /**
     * Prepare the search parameters and call the contactRepository finder.
     * Automatically called by PrimeFaces component.
     */
    @Override
    public List<Contact> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, String> filters) {
        SearchParameters sp = contactSearchForm.getSearchParameters();

        // property selectors
        sp.clearPropertySelectors();
        sp.addPropertySelector(contactSearchForm.getActifSelector());

        Contact contact = contactSearchForm.getContact();
        setRowCount(contactRepository.findCount(contact, sp)); // total count so the paginator may display the total number of pages
        populateSearchParameters(sp, first, pageSize, sortField, sortOrder, filters); // load one page of data

        return contactRepository.find(contact, sp);
    }
}