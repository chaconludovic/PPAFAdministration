/*
 * (c) Copyright 2005-2012 JAXIO, www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-jsf2-primefaces:src/main/java/domain/SearchForm.e.vm.java
 */
package com.eldoraludo.ppafadministration.web.domain;

import static com.eldoraludo.ppafadministration.dao.support.EntitySelectors.MembreppafSelector.newMembreppafSelector;
import static com.eldoraludo.ppafadministration.dao.support.Ranges.RangeDate.newRangeDate;
import static com.eldoraludo.ppafadministration.dao.support.Ranges.RangeDouble.newRangeDouble;
import static com.eldoraludo.ppafadministration.domain.Frais_.date;
import static com.eldoraludo.ppafadministration.domain.Frais_.membreppafId;
import static com.eldoraludo.ppafadministration.domain.Frais_.montant;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import com.eldoraludo.ppafadministration.dao.support.EntitySelectors.MembreppafSelector;
import com.eldoraludo.ppafadministration.dao.support.Ranges.RangeDate;
import com.eldoraludo.ppafadministration.dao.support.Ranges.RangeDouble;
import com.eldoraludo.ppafadministration.domain.Frais;
import com.eldoraludo.ppafadministration.web.domain.support.SearchFormBase;

/**
 * Simple parameters holder for frais search.
 */
@Component
@Scope("session")
public class FraisSearchForm extends SearchFormBase {
    private static final long serialVersionUID = 1L;

    private Frais frais = new Frais();
    private RangeDouble<Frais> montantRange = newRangeDouble(montant);
    private RangeDate<Frais> dateRange = newRangeDate(date);
    private MembreppafSelector<Frais> membreppafSelector = newMembreppafSelector(membreppafId);

    public Frais getFrais() {
        return frais;
    }

    // Ranges, used from the view.
    public RangeDouble<Frais> getMontantRange() {
        return montantRange;
    }

    public RangeDate<Frais> getDateRange() {
        return dateRange;
    }

    // Selectors for x-to-one associations
    public MembreppafSelector<Frais> getMembreppafSelector() {
        return membreppafSelector;
    }
}