/*
 * (c) Copyright 2005-2012 JAXIO, www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-backend-jpa:src/main/java/project/repository/Repository.e.vm.java
 */
package com.eldoraludo.ppafadministration.repository;

import com.eldoraludo.ppafadministration.domain.Rolemembre;
import com.eldoraludo.ppafadministration.repository.support.Repository;

/**
 * The RolemembreRepository is a data-centric service for the {@link Rolemembre} entity.
 * It provides the expected methods to get/delete a {@link Rolemembre} instance
 * plus some methods to perform searches.
 * <p>
 * Search logic is driven by 2 kinds of parameters: a {@link Rolemembre} instance used
 * as a properties holder against which the search will be performed and a {@link SearchParameters}
 * instance from where you can control your search options including the usage
 * of named queries.
 */
public interface RolemembreRepository extends Repository<Rolemembre, Integer> {

    /**
     * Return the persistent instance of {@link Rolemembre} with the given unique property value role,
     * or null if there is no such persistent instance.
     *
     * @param role the unique value
     * @return the corresponding {@link Rolemembre} persistent instance or null
     */
    Rolemembre getByRole(String role);

    /**
     * Delete a {@link Rolemembre} using the unique column role
     *
     * @param role the unique value
     */
    void deleteByRole(String role);
}