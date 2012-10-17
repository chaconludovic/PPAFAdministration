/*
 * (c) Copyright 2005-2012 JAXIO, www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-backend-jpa:src/main/java/project/domain/Entity_.e.vm.java
 */
package com.eldoraludo.ppafadministration.domain;

import java.util.Date;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import com.eldoraludo.ppafadministration.domain.Lieudedepot;
import com.eldoraludo.ppafadministration.domain.Membreppaf;

@StaticMetamodel(Suividulieudedepot.class)
public abstract class Suividulieudedepot_ {

    // Raw attributes
    public static volatile SingularAttribute<Suividulieudedepot, Integer> id;
    public static volatile SingularAttribute<Suividulieudedepot, Date> date;
    public static volatile SingularAttribute<Suividulieudedepot, String> note;
    public static volatile SingularAttribute<Suividulieudedepot, Integer> version;

    // Technical attributes for query by example
    public static volatile SingularAttribute<Suividulieudedepot, Integer> membreppafId;
    public static volatile SingularAttribute<Suividulieudedepot, Integer> lieudedepotId;

    // Many to one
    public static volatile SingularAttribute<Suividulieudedepot, Membreppaf> membreppaf;
    public static volatile SingularAttribute<Suividulieudedepot, Lieudedepot> lieudedepot;
}