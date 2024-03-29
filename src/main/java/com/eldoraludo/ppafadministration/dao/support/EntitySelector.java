/*
 * (c) Copyright 2005-2012 JAXIO, www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-backend-jpa:src/main/java/project/dao/support/EntitySelector.p.vm.java
 */
package com.eldoraludo.ppafadministration.dao.support;

import java.io.Serializable;
import java.util.List;

import javax.persistence.metamodel.SingularAttribute;

import com.eldoraludo.ppafadministration.domain.Identifiable;

/**
 * Used to construct OR predicate for a single FK value. In other words you can search
 * all entities E having their x to one association value set to one of the selected values.
 * To ease the search we rely on the FK field, not the association itself. 
 */
public class EntitySelector<E, T extends Identifiable<TPK>, TPK extends Serializable> implements Serializable {
    private static final long serialVersionUID = 1L;

    private SingularAttribute<E, TPK> field;
    private List<T> selected;

    /**
     * @param field the property holding an foreign key.
     */
    public EntitySelector(SingularAttribute<E, TPK> field) {
        this.field = field;
    }

    public SingularAttribute<E, TPK> getField() {
        return field;
    }

    /**
     * Get the possible candidates for the x-to-one association.
     */
    public List<T> getSelected() {
        return selected;
    }

    /**
     * Set the possible candidates for the x-to-one association.
     */
    public void setSelected(List<T> selected) {
        this.selected = selected;
    }

    public boolean isNotEmpty() {
        return selected != null && !selected.isEmpty();
    }

    public void clearSelected() {
        if (selected != null) {
            selected.clear();
        }
    }
}