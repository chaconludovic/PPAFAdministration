/*
 * (c) Copyright 2005-2012 JAXIO, www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-backend-jpa:src/main/java/project/dao/support/SearchParameters.p.vm.java
 */
package com.eldoraludo.ppafadministration.dao.support;

import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Maps.newHashMap;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Root;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.eldoraludo.ppafadministration.domain.Identifiable;

/**
 * The SearchParameters is used to pass search parameters to the DAO layer. 
 * 
 * Its usage keeps 'find' method signatures in the DAO/Service layer simple.
 * 
 * A SearchParameters helps you drive your search in the following areas:
 * <ul>
 * <li>Configure the search mode (EQUALS, LIKE, ...)</li>
 * <li>Pagination: it allows you to limit your search results to a specific range.</li>
 * <li>Allow you to specify ORDER BY and ASC/DESC</li>
 * <li>Enable/Disable case sensitivity</li>
 * <li>Enable/Disable 2d level cache</li>
 * <li>LIKE search against all string values: simply set the searchPattern property</li>
 * <li>Named query: if you set a named query, it will be executed please read src/main/resources/META-INF/orm.xml</li>
 * </ul>
 * 
 * @see GenericDao
 * @see SearchMode
 * @see OrderBy
 * @see Range
 * @see NamedQueryUtil
 */
public class SearchParameters implements Serializable {
    static final private long serialVersionUID = 1L;

    private SearchMode searchMode = SearchMode.EQUALS;

    // named query related
    private String namedQuery;
    private Map<String, Object> parameters = newHashMap();

    private List<OrderBy> orders = newArrayList();

    // technical parameters
    private boolean caseSensitive = false;

    // Pagination
    private int maxResultsLimit = 500;
    private int maxResults = 500;
    private int firstResult = 0;

    // ranges
    private List<Range<?, ?>> ranges = newArrayList();

    // property selectors
    private List<PropertySelector<?, ?>> propertySelectors = newArrayList();

    // entity selectors
    private List<EntitySelector<?, ? extends Identifiable<?>, ?>> entitySelectors = newArrayList();

    // pattern to match against all strings.
    private String searchPattern;

    // cache
    private Boolean cacheable = true;
    private String cacheRegion;

    public SearchParameters() {
    }

    public SearchParameters(SearchMode searchMode) {
        Validate.notNull(searchMode, "searchMode must not be null");
        this.searchMode = searchMode;
    }

    // -----------------------------------
    // SearchMode
    // -----------------------------------

    public void setSearchMode(SearchMode searchMode) {
        Validate.notNull(searchMode, "searchMode must not be null");
        this.searchMode = searchMode;
    }

    /**
     * Returns the SearchMode. It defaults to SearchMode.EQUALS.
     * 
     * @param searchMode
     */
    public SearchMode getSearchMode() {
        return searchMode;
    }

    // -----------------------------------
    // Named query support
    // -----------------------------------

    /**
     * Returns true if a named query has been set, false otherwise. When it returns true, the DAO layer will call the namedQuery.
     */
    public boolean hasNamedQuery() {
        return StringUtils.isNotBlank(namedQuery);
    }

    /**
     * Set the named query to be used by the DAO layer. Null by default.
     * 
     * @param namedQuery
     *            the name of the namedQuery.
     */
    public void setNamedQuery(String namedQuery) {
        this.namedQuery = namedQuery;
    }

    /**
     * Return the name of the named query to be used by the DAO layer.
     */
    public String getNamedQuery() {
        return namedQuery;
    }

    public SearchParameters withNamedQuery(String namedQuery) {
        setNamedQuery(namedQuery);
        return this;
    }

    /**
     * Set the parameters for the named query.
     */
    public void setNamedQueryParameters(Map<String, Object> parameters) {
        Validate.notNull(parameters, "parameters must not be null");
        this.parameters = parameters;
    }

    /**
     * The parameters associated with the named query, if any.
     */
    public Map<String, Object> getNamedQueryParameters() {
        return parameters;
    }

    /**
     * Return the value of the passed parameter name.
     */
    public Object getNamedQueryParameter(String parameterName) {
        return parameters.get(parameterName);
    }

    // -----------------------------------
    // Search pattern support
    // -----------------------------------

    /**
     * When it returns true, it indicates to the DAO layer to use the passed searchPattern on all string properties.
     */
    public boolean hasSearchPattern() {
        return StringUtils.isNotBlank(searchPattern);
    }

    /**
     * Set the pattern which may contains wildcards (ex: "e%r%ka" ). The passed searchPattern is used by the DAO layer on all string properties. Null by
     * default.
     */
    public void setSearchPattern(String searchPattern) {
        this.searchPattern = searchPattern;
    }

    /**
     * Returns the search pattern to be used by the DAO layer.
     */
    public String getSearchPattern() {
        return searchPattern;
    }

    public SearchParameters withSearchPattern(String searchPattern) {
        setSearchPattern(searchPattern);
        return this;
    }

    // -----------------------------------
    // Case sensitiveness support
    // -----------------------------------

    /**
     * Set the case sensitiveness. Defaults to false.
     * 
     * @param caseSensitive
     */
    public void setCaseSensitive(boolean caseSensitive) {
        this.caseSensitive = caseSensitive;
    }

    public boolean isCaseSensitive() {
        return caseSensitive;
    }

    public boolean isCaseInsensitive() {
        return !caseSensitive;
    }

    // -----------------------------------
    // Order by support
    // -----------------------------------

    public boolean hasOrders() {
        return !orders.isEmpty();
    }

    public List<OrderBy> getOrders() {
        return orders;
    }

    public void addOrderBy(OrderBy orderBy) {
        Validate.notNull(orderBy, "orderBy must not be null");
        orders.add(orderBy);
    }

    public void clearOrders() {
        orders.clear();
    }

    public <E> List<Order> getJpaOrders(Root<E> root, CriteriaBuilder builder) {
        List<Order> jpaOrders = newArrayList();

        for (OrderBy ob : orders) {
            if (ob.isOrderDesc()) {
                jpaOrders.add(builder.desc(root.get(ob.getColumn())));
            } else {
                jpaOrders.add(builder.asc(root.get(ob.getColumn())));
            }
        }
        return jpaOrders;
    }

    // -----------------------------------
    // Search by range support
    // -----------------------------------

    public List<Range<?, ?>> getRanges() {
        return ranges;
    }

    public void addRange(Range<?, ?> range) {
        ranges.add(range);
    }

    public void clearRanges() {
        ranges.clear();
    }

    // -----------------------------------
    // Search by property selector support
    // -----------------------------------

    public List<PropertySelector<?, ?>> getPropertySelectors() {
        return propertySelectors;
    }

    public void addPropertySelector(PropertySelector<?, ?> propertySelector) {
        propertySelectors.add(propertySelector);
    }

    public void clearPropertySelectors() {
        propertySelectors.clear();
    }

    // -----------------------------------
    // Search by entity selector support
    // -----------------------------------

    public List<EntitySelector<?, ? extends Identifiable<?>, ?>> getEntitySelectors() {
        return entitySelectors;
    }

    public void addEntitySelector(EntitySelector<?, ? extends Identifiable<?>, ?> entitySelector) {
        entitySelectors.add(entitySelector);
    }

    public void clearEntitySelectors() {
        entitySelectors.clear();
    }

    // -----------------------------------
    // Pagination support
    // -----------------------------------

    public void setMaxResults(int maxResults) {
        Validate.isTrue(maxResults > 0, "maxResults must be > 0");
        this.maxResults = Math.min(maxResults, maxResultsLimit);
    }

    public int getMaxResults() {
        return maxResults;
    }

    public void setFirstResult(int firstResult) {
        Validate.isTrue(firstResult >= 0, "firstResult must be >= 0");
        this.firstResult = firstResult;
    }

    public int getFirstResult() {
        return firstResult;
    }

    // -----------------------------------
    // Caching support
    // -----------------------------------

    /**
     * Default to true.
     */
    public void setCacheable(boolean cacheable) {
        this.cacheable = cacheable;
    }

    public boolean isCacheable() {
        return cacheable;
    }

    public boolean hasCacheRegion() {
        return StringUtils.isNotBlank(cacheRegion);
    }

    public void setCacheRegion(String cacheRegion) {
        this.cacheRegion = cacheRegion;
    }

    public String getCacheRegion() {
        return cacheRegion;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}