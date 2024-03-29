/*
 * (c) Copyright 2005-2012 JAXIO, www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-jsf2-primefaces:src/main/java/domain/Controller.e.vm.java
 */
package com.eldoraludo.ppafadministration.web.domain;

import static com.eldoraludo.ppafadministration.web.util.PrimeFacesUtil.forceClose;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import com.eldoraludo.ppafadministration.domain.Contact;
import com.eldoraludo.ppafadministration.repository.ContactRepository;
import com.eldoraludo.ppafadministration.web.converter.domain.ContactConverter;
import com.eldoraludo.ppafadministration.web.util.MessageUtil;

/**
 * Thin controller layer allowing you to do business validation and other conditional 
 * checks that are easier to implement in Java than in webflow's xml syntax.
 */
@Named
@Singleton
public class ContactController {
    private static final long serialVersionUID = 1L;

    @Inject
    private ContactRepository contactRepository;

    @Inject
    private MessageUtil messageUtil;

    @Inject
    private ContactConverter contactConverter;

    public Contact newIfNull(Contact contact) {
        if (contact != null) {
            return contact;
        }

        return contactRepository.getNewWithDefaults();
    }

    public boolean save(Contact contact) {
        contactRepository.save(contact);
        messageUtil.info("status_saved_ok", contactConverter.print(contact));
        return true;
    }

    public boolean saveAndClose(Contact contact) {
        contactRepository.save(contact);
        messageUtil.infoDelayed("status_saved_ok", contactConverter.print(contact));
        forceClose();
        return true;
    }

    public boolean delete(Contact contact) {
        String infoArg = contactConverter.print(contact);
        contactRepository.delete(contact);
        messageUtil.info("status_deleted_ok", infoArg);
        return true;
    }
}