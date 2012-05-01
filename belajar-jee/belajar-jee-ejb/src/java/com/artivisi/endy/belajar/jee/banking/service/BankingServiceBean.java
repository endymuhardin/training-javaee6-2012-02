/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artivisi.endy.belajar.jee.banking.service;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author student14
 */
@Stateless
@LocalBean
public class BankingServiceBean {
    @PersistenceContext(unitName = "belajar-jee-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
}
