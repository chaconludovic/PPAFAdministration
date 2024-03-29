/*
 * (c) Copyright 2005-2012 JAXIO, www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-jsf2-primefaces:src/main/java/util/MessageBundle.p.vm.java
 */
package com.eldoraludo.ppafadministration.web.util;

import java.util.Enumeration;
import java.util.ResourceBundle;

import org.springframework.context.MessageSource;

import com.eldoraludo.ppafadministration.util.ResourcesUtil;

/**
 * This ResourceBundle is set in faces-config.xml under 'msg' var.
 * <p>
 * Implementation uses Spring {@link MessageSource}.
 * <p>
 * From your JSF2 pages, you may use <code>#{msg.property_key}</code>.
 * <p>
 * _HACK_ as it is a tricky JSF/Spring integration point.
 */
public class MessageBundle extends ResourceBundle {

    @Override
    public Enumeration<String> getKeys() {
        return ResourcesUtil.getInstance().getAsResourceBundle().getKeys();
    }

    @Override
    protected Object handleGetObject(String key) {
        return ResourcesUtil.getInstance().getAsResourceBundle().getObject(key);
    }
}