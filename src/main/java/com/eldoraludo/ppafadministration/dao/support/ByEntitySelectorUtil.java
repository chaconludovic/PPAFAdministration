/*
 * (c) Copyright 2005-2012 JAXIO, www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-backend-jpa:src/main/java/project/dao/support/ByEntitySelectorUtil.p.vm.java
 */
package com.eldoraludo.ppafadministration.dao.support;

import static com.google.common.collect.Lists.newArrayList;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.eldoraludo.ppafadministration.domain.Identifiable;

/**
 * Helper to create a predicate out of {@link EntitySelector}s.
 */
public class ByEntitySelectorUtil {

    public static <E> Predicate byEntitySelectors(Root<E> root, CriteriaBuilder builder, final List<EntitySelector<?, ? extends Identifiable<?>, ?>> selectors) {
        List<Predicate> predicates = newArrayList();

        for (EntitySelector<?, ? extends Identifiable<?>, ?> s : selectors) {
            @SuppressWarnings("unchecked")
            EntitySelector<E, ? extends Identifiable<?>, ?> selector = (EntitySelector<E, ? extends Identifiable<?>, ?>) s;

            if (selector.isNotEmpty()) {
                List<Predicate> selectorPredicates = newArrayList();

                for (Identifiable<?> selection : selector.getSelected()) {
                    selectorPredicates.add(builder.equal(root.get(selector.getField()), selection.getId()));
                }
                predicates.add(JpaUtil.orPredicate(selectorPredicates, builder));
            }
        }
        return JpaUtil.andPredicate(predicates, builder);
    }
}