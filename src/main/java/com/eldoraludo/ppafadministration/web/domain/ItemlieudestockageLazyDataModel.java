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
import com.eldoraludo.ppafadministration.domain.Itemlieudestockage;
import com.eldoraludo.ppafadministration.repository.ItemlieudestockageRepository;
import com.eldoraludo.ppafadministration.web.domain.support.GenericLazyDataModel;

/**
 * Provides server-side pagination for search.
 *
 * @see http://jira.springframework.org/browse/SWF-1224 to avoid instanciate it as a var from your flow 
 */
public class ItemlieudestockageLazyDataModel extends GenericLazyDataModel<Itemlieudestockage> {
    private static final long serialVersionUID = 1L;

    @Inject
    transient private ItemlieudestockageRepository itemlieudestockageRepository;
    @Inject
    transient private ItemlieudestockageSearchForm itemlieudestockageSearchForm;

    /**
     * Prepare the search parameters and call the itemlieudestockageRepository finder.
     * Automatically called by PrimeFaces component.
     */
    @Override
    public List<Itemlieudestockage> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, String> filters) {
        SearchParameters sp = itemlieudestockageSearchForm.getSearchParameters();

        // ranges
        sp.clearRanges();
        sp.addRange(itemlieudestockageSearchForm.getDateRange());
        sp.addRange(itemlieudestockageSearchForm.getQuantiteentreRange());
        sp.addRange(itemlieudestockageSearchForm.getQuantitesortieRange());

        // entity selectors
        sp.clearEntitySelectors();
        sp.addEntitySelector(itemlieudestockageSearchForm.getLieudestockageSelector());
        sp.addEntitySelector(itemlieudestockageSearchForm.getItemSelector());

        Itemlieudestockage itemlieudestockage = itemlieudestockageSearchForm.getItemlieudestockage();
        setRowCount(itemlieudestockageRepository.findCount(itemlieudestockage, sp)); // total count so the paginator may display the total number of pages
        populateSearchParameters(sp, first, pageSize, sortField, sortOrder, filters); // load one page of data

        return itemlieudestockageRepository.find(itemlieudestockage, sp);
    }
}