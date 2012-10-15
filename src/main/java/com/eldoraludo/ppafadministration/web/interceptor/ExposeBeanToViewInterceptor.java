/*
 * (c) Copyright 2005-2012 JAXIO, www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-jsf2-primefaces:src/main/java/interceptor/ExposeBeanToViewInterceptor.p.vm.java
 */
package com.eldoraludo.ppafadministration.web.interceptor;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.HandlerInterceptor;

import com.eldoraludo.ppafadministration.web.flow.FlowsMenuHandler;

/**
 * _HACK_: Expose the 'flowsMenuHandler' beans to non webflow views, that is to {@link org.springframework.faces.mvc.JsfView} such as 
 * homepage, error page etc. Otherwise this bean is not visible from the view and we cannot display the menu listing the active flows. 
 * <p>
 * Note: it does not intercept webflow requests.
 */
@Named
@Singleton
public class ExposeBeanToViewInterceptor implements HandlerInterceptor {

    @Inject
    private FlowsMenuHandler flowsMenuHandler;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException {
        request.setAttribute("flowsMenuHandler", flowsMenuHandler);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}