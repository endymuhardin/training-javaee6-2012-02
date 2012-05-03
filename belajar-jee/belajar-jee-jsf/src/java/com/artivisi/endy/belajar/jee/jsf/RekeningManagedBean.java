/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artivisi.endy.belajar.jee.jsf;

import com.artivisi.endy.belajar.jee.banking.entity.Rekening;
import com.artivisi.endy.belajar.jee.banking.service.BankingServiceBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author student14
 */
@ManagedBean
@SessionScoped
public class RekeningManagedBean {

    @EJB private BankingServiceBean bankingServiceBean;
    private Rekening rekening = new Rekening();

    public Rekening getRekening() {
        return rekening;
    }

    public void setRekening(Rekening rekening) {
        this.rekening = rekening;
    }
    
    public String simpan(){
        bankingServiceBean.simpan(rekening);
        rekening = new Rekening();
        return "form?faces-redirect=true";
    }
    
    /**
     * Creates a new instance of RekeningManagedBean
     */
    public RekeningManagedBean() {
    }
}
