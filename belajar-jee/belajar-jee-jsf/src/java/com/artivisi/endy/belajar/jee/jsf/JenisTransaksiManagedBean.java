/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artivisi.endy.belajar.jee.jsf;

import com.artivisi.endy.belajar.jee.banking.entity.JenisTransaksi;
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
public class JenisTransaksiManagedBean {
    @EJB
    private BankingServiceBean bankingServiceBean;

    private JenisTransaksi jenisTransaksi = new JenisTransaksi();

    public JenisTransaksi getJenisTransaksi() {
        return jenisTransaksi;
    }

    public void setJenisTransaksi(JenisTransaksi jenisTransaksi) {
        this.jenisTransaksi = jenisTransaksi;
    }
    
    public String simpan(){
        bankingServiceBean.simpan(jenisTransaksi);
        jenisTransaksi = new JenisTransaksi();
        return "form?faces-redirect=true";
    }
    
    /**
     * Creates a new instance of JenisTransaksiManagedBean
     */
    public JenisTransaksiManagedBean() {
    }
}
