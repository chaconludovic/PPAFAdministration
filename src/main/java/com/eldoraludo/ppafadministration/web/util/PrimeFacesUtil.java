/*
 * (c) Copyright 2005-2012 JAXIO, www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-jsf2-primefaces:src/main/java/util/PrimeFacesUtil.p.vm.java
 */
package com.eldoraludo.ppafadministration.web.util;

import javax.inject.Named;
import javax.inject.Singleton;
import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.primefaces.context.RequestContext;

import com.eldoraludo.ppafadministration.domain.Identifiable;

/**
 * Use this bean to execute JavaScript on client side.
 */
@Named
@Singleton
public class PrimeFacesUtil {
    /**
     * Controls the 'ask for save' primefaces dialog on the client side from the server side if the entity manager is dirty or the entity is new
     */
    static public void showAskForSaveDialog(EntityManager entityManager, Identifiable<?> entity) {
        RequestContext rc = RequestContext.getCurrentInstance();
        if ((entity != null && !entity.isIdSet()) || ((Session) entityManager.getDelegate()).isDirty()) {
            rc.execute("askForSaveDialog.show(); APP.focusAskForSaveDialog()");
        } else {
            rc.execute("APP.menu.forceClose()");
        }
    }

    /**
     * Set a callback that instruct the client to silently request a forceClose transition.
     * Note: 'event' (i.e. 'transition' without 'to' in webflow) cannot by definition transition to another state.
     * However, there are some cases where you would like your 'event' to behave like a 'transition'.
     * To simulate an 'event' with a 'to', the trick is to tell the client to request silently (from the user point of view)
     * the transition you are interested in.
     */
    static public void forceClose() {
        RequestContext.getCurrentInstance().execute("APP.menu.forceClose()");
    }
}
