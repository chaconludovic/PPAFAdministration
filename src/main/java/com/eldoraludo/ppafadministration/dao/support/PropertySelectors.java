/*
 * (c) Copyright 2005-2012 JAXIO, www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-backend-jpa:src/main/java/project/dao/support/PropertySelectors.p.vm.java
 */
package com.eldoraludo.ppafadministration.dao.support;

import javax.persistence.metamodel.SingularAttribute;

/**
 * Convenient type safe {@link PropertySelector}s. 
 */
public class PropertySelectors {

    @SuppressWarnings("serial")
    public static class BooleanSelector<E> extends PropertySelector<E, Boolean> {
        public BooleanSelector(SingularAttribute<E, Boolean> field) {
            super(field);
        }

        public static <E> BooleanSelector<E> newBooleanSelector(SingularAttribute<E, Boolean> field) {
            return new BooleanSelector<E>(field);
        }
    }

}