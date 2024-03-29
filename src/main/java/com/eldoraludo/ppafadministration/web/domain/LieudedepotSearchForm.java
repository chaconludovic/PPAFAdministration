/*
 * (c) Copyright 2005-2012 JAXIO, www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-jsf2-primefaces:src/main/java/domain/SearchForm.e.vm.java
 */
package com.eldoraludo.ppafadministration.web.domain;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import com.eldoraludo.ppafadministration.domain.Lieudedepot;
import com.eldoraludo.ppafadministration.web.domain.support.SearchFormBase;

/**
 * Simple parameters holder for lieudedepot search.
 */
@Component
@Scope("session")
public class LieudedepotSearchForm extends SearchFormBase {
    private static final long serialVersionUID = 1L;

    private Lieudedepot lieudedepot = new Lieudedepot();

    public Lieudedepot getLieudedepot() {
        return lieudedepot;
    }
}