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
import com.eldoraludo.ppafadministration.domain.Frais;
import com.eldoraludo.ppafadministration.repository.FraisRepository;
import com.eldoraludo.ppafadministration.web.domain.support.GenericLazyDataModel;

/**
 * Provides server-side pagination for search.
 *
 * @see http://jira.springframework.org/browse/SWF-1224 to avoid instanciate it as a var from your flow 
 */
public class FraisLazyDataModel extends GenericLazyDataModel<Frais> {
    private static final long serialVersionUID = 1L;

    @Inject
    transient private FraisRepository fraisRepository;
    @Inject
    transient private FraisSearchForm fraisSearchForm;

    /**
     * Prepare the search parameters and call the fraisRepository finder.
     * Automatically called by PrimeFaces component.
     */
    @Override
    public List<Frais> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, String> filters) {
        SearchParameters sp = fraisSearchForm.getSearchParameters();

        // ranges
        sp.clearRanges();
        sp.addRange(fraisSearchForm.getMontantRange());
        sp.addRange(fraisSearchForm.getDateRange());

        // entity selectors
        sp.clearEntitySelectors();
        sp.addEntitySelector(fraisSearchForm.getMembreppafSelector());

        Frais frais = fraisSearchForm.getFrais();
        setRowCount(fraisRepository.findCount(frais, sp)); // total count so the paginator may display the total number of pages
        populateSearchParameters(sp, first, pageSize, sortField, sortOrder, filters); // load one page of data

        return fraisRepository.find(frais, sp);
    }
}