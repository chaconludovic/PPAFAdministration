/*
 * (c) Copyright 2005-2012 JAXIO, www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-backend-jpa:src/main/java/project/repository/Repository.e.vm.java
 */
package com.eldoraludo.ppafadministration.repository;

import com.eldoraludo.ppafadministration.domain.Item;
import com.eldoraludo.ppafadministration.repository.support.Repository;

/**
 * The ItemRepository is a data-centric service for the {@link Item} entity.
 * It provides the expected methods to get/delete a {@link Item} instance
 * plus some methods to perform searches.
 * <p>
 * Search logic is driven by 2 kinds of parameters: a {@link Item} instance used
 * as a properties holder against which the search will be performed and a {@link SearchParameters}
 * instance from where you can control your search options including the usage
 * of named queries.
 */
public interface ItemRepository extends Repository<Item, Integer> {
}