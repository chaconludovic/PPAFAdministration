/*
 * (c) Copyright 2005-2012 JAXIO, www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-jsf2-primefaces:src/main/java/domain/support/SearchFormBase.p.vm.java
 */
package com.eldoraludo.ppafadministration.web.domain.support;

import java.io.Serializable;

import com.eldoraludo.ppafadministration.dao.support.SearchParameters;
import com.eldoraludo.ppafadministration.dao.support.SearchMode;

public abstract class SearchFormBase implements Serializable {
    private static final long serialVersionUID = 1L;

    private SearchParameters sp = new SearchParameters(SearchMode.ANYWHERE);

    /**
     * The default search parameters.
     */
    public SearchParameters getSearchParameters() {
        return sp;
    }
}
