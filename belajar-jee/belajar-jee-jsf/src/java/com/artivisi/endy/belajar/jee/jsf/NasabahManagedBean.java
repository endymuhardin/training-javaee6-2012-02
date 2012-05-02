/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artivisi.endy.belajar.jee.jsf;

import com.artivisi.endy.belajar.jee.banking.entity.Nasabah;
import com.artivisi.endy.belajar.jee.banking.service.BankingServiceBean;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author student14
 */
@ManagedBean
@SessionScoped
public class NasabahManagedBean {
    @EJB
    private BankingServiceBean bankingServiceBean;
    
    private Integer jumlahRequest = 0;
    private Nasabah nasabah = new Nasabah();

    public Nasabah getNasabah() {
        return nasabah;
    }

    public void setNasabah(Nasabah nasabah) {
        this.nasabah = nasabah;
    }

    
    
    /**
     * Creates a new instance of NasabahManagedBean
     */
    public NasabahManagedBean() {
    }
    
    public List<Nasabah> getDaftarNasabah(){
        return bankingServiceBean.cariSemuaNasabah(0, 100);
    }
    
    public String simpan(){
        jumlahRequest++;
        System.out.println("Tombol simpan sudah ditekan sebanyak "
                +jumlahRequest+" kali");
        
        // simpan object nasabah ke database
        bankingServiceBean.simpan(nasabah);
        
        // setelah simpan, reset menjadi object kosong lagi
        nasabah = new Nasabah();
        
        return "list?faces-redirect=true";
    }
}
