/*
 * (c) Copyright 2005-2012 JAXIO, www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-jsf2-primefaces:src/main/java/flow/FlowsMenuHandler.p.vm.java
 */
package com.eldoraludo.ppafadministration.web.flow;

import static com.google.common.collect.Lists.newArrayList;
import static org.apache.commons.lang.StringUtils.isNotEmpty;
import static org.apache.commons.lang.StringUtils.substringBefore;
import static org.apache.commons.lang.StringUtils.substringBeforeLast;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import org.primefaces.component.menuitem.MenuItem;
import org.primefaces.model.DefaultMenuModel;
import org.primefaces.model.MenuModel;
import org.springframework.webflow.conversation.impl.SessionBindingConversationManager;
import org.springframework.webflow.execution.RequestContext;
import org.springframework.webflow.execution.repository.impl.DefaultFlowExecutionRepository;
import org.springframework.webflow.executor.FlowExecutor;
import org.springframework.webflow.executor.FlowExecutorImpl;

import com.eldoraludo.ppafadministration.domain.Identifiable;

/**
 * Store the 'active flows'. This class is used from the xml flows to add/update meta-information about the current flow (label, current url).
 * It is used from the view to obtain the 'active flows' as a primefaces Menu.
 * 
 * Note: No annotation is used for this bean as it is a session bean defined as a scoped-proxy. See webflow.xml conf file.
 */
public class FlowsMenuHandler implements Serializable {
    static final private long serialVersionUID = 1L;

    private String defaultEndStateRedirect = "/index.html";
    private Integer maxExecutions = null; // leave it null, see setFlowExecutor below
    private List<FlowMenuEntry> flowMenuEntries = newArrayList();

    public void setDefaultEndStateRedirect(String defaultEndStateRedirect) {
        this.defaultEndStateRedirect = defaultEndStateRedirect;
    }

    public String getDefaultEndStateRedirect() {
        return defaultEndStateRedirect;
    }

    @Inject
    public void setFlowExecutor(FlowExecutor fe) {
        // _HACK_ to retrieve the "max-executions" param present in webflow.xml conf. It is used to manage our flow menu as a FIFO.
        // see https://jira.springsource.org/browse/SWF-1547
        SessionBindingConversationManager sbcm = (SessionBindingConversationManager) ((DefaultFlowExecutionRepository) ((FlowExecutorImpl) fe)
                .getExecutionRepository()).getConversationManager();
        maxExecutions = sbcm.getMaxConversations();
    }

    /**
     * Invoked from web flow listener
     */
    public void removeMenu(RequestContext context) {
        String flowId = getFlowModuleId(context);
        String flowExecutionId = getFlowExecutionId(context);
        flowMenuEntries.remove(getFlowMenuEntry(flowId, flowExecutionId));
    }

    // -----------------------------------------------
    // Invoked from spring web flow's XML script.
    // -----------------------------------------------
    public void updateMenu(RequestContext context, String label) {
        updateMenu(context, null, label);
    }

    public void updateMenu(RequestContext context, Serializable entityId, String label) {
        String flowId = getFlowModuleId(context);
        String flowExecutionId = getFlowExecutionId(context);

        FlowMenuEntry flowMenuEntry = getFlowMenuEntry(flowId, flowExecutionId);

        if (flowMenuEntry == null) {
            // add a new entry at the end of the list
            flowMenuEntry = new FlowMenuEntry(flowId, flowExecutionId);
            flowMenuEntries.add(flowMenuEntry);

            // check max execution and eventually remove the oldest menu entry.
            if (maxExecutionsExceeded()) {
                flowMenuEntries.remove(0);
            }
        }

        if (label != null) {
            label = flowId + ": " + label;
        } else {
            label = flowId;
        }

        flowMenuEntry.setLabel(label);
        String contextPath = context.getExternalContext().getContextPath();
        String url = null;
        if (contextPath == null) {
            url = context.getFlowExecutionUrl();
        } else {
            url = context.getFlowExecutionUrl().substring(contextPath.length());
        }
        flowMenuEntry.setFlowExecutionUrl(url);
        flowMenuEntry.setEntityId(entityId);
    }

    public String endStateRedirect(RequestContext context) {
        String flowId = getFlowModuleId(context);
        List<FlowMenuEntry> flowMenu = getFlowMenuEntries(flowId);

        if (flowMenu.isEmpty()) {
            return defaultEndStateRedirect;
        }

        return flowMenu.get(flowMenu.size() - 1).getFlowExecutionUrl();
    }

    /**
     * Used from your XML spring web flow script to determine if the passed entity is already present in the menu of the current flow id. If present, you should
     * not open twice the entity but instead redirect the user to the existing flow execution using the endStateRedirectToAlreadyOpenFlow method.
     * 
     * @param entity
     *            the entity that the user wants to 'open'
     * @return true if the passed entity is already open.
     * 
     * @see #endStateRedirectToAlreadyOpenFlow
     */
    public boolean isFlowAlreadyOpen(RequestContext context, Identifiable<?> entity) {
        String flowId = getFlowModuleId(context);

        for (FlowMenuEntry fme : getFlowMenuEntries(flowId)) {
            if (fme.getEntityId() != null && entity.getId() != null && fme.getEntityId().equals(entity.getId())) {
                return true;
            }
        }

        return false;
    }

    /**
     * Redirect the user to the flow execution that corresponds to the passed entity. Before calling this method you must first check that
     * isFlowAlreadyOpen(entity) returns true.
     * 
     * @param entity
     *            the entity that the user wants to 'open'
     * @return the URL of the flow execution that corresponds to the passed entity.
     */
    public String endStateRedirectToAlreadyOpenFlow(RequestContext context, Identifiable<?> entity) {
        String flowId = getFlowModuleId(context);

        for (FlowMenuEntry fme : getFlowMenuEntries(flowId)) {
            if (fme.getEntityId() != null && entity.getId() != null && fme.getEntityId().equals(entity.getId())) {
                return fme.getFlowExecutionUrl();
            }
        }

        throw new IllegalStateException("developper likely error: have you checked that the flow is already open before invoking this method?");
    }

    // -----------------------------------------------
    // Invoked from the view
    // -----------------------------------------------

    public int getMenuModelCount() {
        return flowMenuEntries.size();
    }

    /**
     * Returns the menu holding active flows...
     */
    public MenuModel getMenuModel() {
        return getMenuModel(null);
    }

    /**
     * Returns the menu holding active flows...
     * @param context the flowRequestContext so we can disable the current flow in the menu.
     */
    public MenuModel getMenuModel(RequestContext context) {
        String flowId = null;
        String flowExecutionId = null;

        if (context != null) {
            flowId = getFlowModuleId(context);
            flowExecutionId = getFlowExecutionId(context);
        } // else: from pure mvc view, it is null

        MenuModel model = new DefaultMenuModel();

        for (FlowMenuEntry flowMenuEntry : getFlowMenuEntries()) {
            MenuItem htmlMenuItem = new MenuItem();
            htmlMenuItem.setValue(flowMenuEntry.getLabel());
            htmlMenuItem.setUrl(flowMenuEntry.getFlowExecutionUrl());

            if (flowMenuEntry.getFlowId().equals(flowId) && flowMenuEntry.getFlowExecutionId().equals(flowExecutionId)) {
                htmlMenuItem.setDisabled(true);
            } else {
                htmlMenuItem.setDisabled(false);
            }

            model.addMenuItem(htmlMenuItem);
        }

        return model;
    }

    // -----------------------------------------------
    // Internal helpers
    // -----------------------------------------------

    /**
     * Returns the base of the flow id. If the flow id is "account/select", it returns "account".
     */
    private String getFlowModuleId(RequestContext context) {
        return substringBefore(context.getActiveFlow().getId(), "/");
    }

    /**
     * Return the execution id, for example: 'e4'.
     */
    private String getFlowExecutionId(RequestContext context) {
        return substringBeforeLast(context.getRequestParameters().get("execution"), "s");
    }

    private class FlowMenuEntry implements Serializable {
        static final private long serialVersionUID = 1L;

        private String flowId;
        private String flowExecutionId;

        private String label; // may be null
        private String flowExecutionUrl;
        private Serializable entityId;

        public FlowMenuEntry(String flowId, String flowExecutionId) {
            this.flowId = flowId;
            this.flowExecutionId = flowExecutionId;
        }

        public String getFlowId() {
            return flowId;
        }

        public String getFlowExecutionId() {
            return flowExecutionId;
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        public boolean isLabelSet() {
            return isNotEmpty(label);
        }

        public String getFlowExecutionUrl() {
            return flowExecutionUrl;
        }

        public void setFlowExecutionUrl(String flowExecutionUrl) {
            this.flowExecutionUrl = flowExecutionUrl;
        }

        public void setEntityId(Serializable entityId) {
            this.entityId = entityId;
        }

        public Serializable getEntityId() {
            return entityId;
        }

        @Override
        public String toString() {
            return flowId + ":" + flowExecutionId + ":" + label + ":" + flowExecutionUrl;
        }
    }

    private boolean maxExecutionsExceeded() {
        return maxExecutions > 0 && flowMenuEntries.size() > maxExecutions;
    }

    private FlowMenuEntry getFlowMenuEntry(String flowId, String flowExecutionId) {
        for (FlowMenuEntry fme : flowMenuEntries) {
            if (fme.getFlowId().equals(flowId) && fme.getFlowExecutionId().equals(flowExecutionId)) {
                return fme;
            }
        }
        return null;
    }

    public List<FlowMenuEntry> getFlowMenuEntries() {
        List<FlowMenuEntry> result = newArrayList();
        for (FlowMenuEntry fme : flowMenuEntries) {
            if (fme.isLabelSet()) {
                result.add(fme);
            }
        }

        return result;
    }

    public List<FlowMenuEntry> getFlowMenuEntries(String flowId) {
        List<FlowMenuEntry> result = newArrayList();
        for (FlowMenuEntry fme : flowMenuEntries) {
            if (fme.getFlowId().equals(flowId) && fme.isLabelSet()) {
                result.add(fme);
            }
        }

        return result;
    }
}