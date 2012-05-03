/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artivisi.endy.belajar.jee.banking.service;

import com.artivisi.endy.belajar.jee.banking.entity.JenisTransaksi;
import com.artivisi.endy.belajar.jee.banking.entity.Nasabah;
import com.artivisi.endy.belajar.jee.banking.entity.Rekening;
import java.util.List;
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

    public void simpan(Nasabah n){
        if(n.getId() == null) {
            em.persist(n);
        } else {
            em.merge(n);
        }
    }
    
    public void hapus(Nasabah n){
        Nasabah nx = em.find(Nasabah.class, n.getId());
        em.remove(nx);
    }
    
    public Nasabah cariNasabahById(Long id){
        return em.find(Nasabah.class, id);
    }
    
    public Long hitungSemuaNasabah(){
        return (Long) em.createQuery("select count(n) from Nasabah n")
                .getSingleResult();
    }
    
    public List<Nasabah> cariSemuaNasabah(Integer start, Integer rows){
        return em.createQuery("select n from Nasabah n order by n.nama")
                .setFirstResult(start)
                .setMaxResults(rows)
                .getResultList();
    }

    public void simpan(JenisTransaksi jenisTransaksi) {
        if(jenisTransaksi.getId() == null){
            em.persist(jenisTransaksi);
        } else {
            em.merge(jenisTransaksi);
        }
    }
    
    public void simpan(Rekening rekening) {
        if(rekening.getId() == null){
            em.persist(rekening);
        } else {
            em.merge(rekening);
        }
    }

    public JenisTransaksi cariJenisTransaksiById(Long id) {
        return em.find(JenisTransaksi.class, id);
    }
}
