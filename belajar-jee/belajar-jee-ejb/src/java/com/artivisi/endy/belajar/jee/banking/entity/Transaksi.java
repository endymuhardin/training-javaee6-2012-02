/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artivisi.endy.belajar.jee.banking.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author student14
 */
@Entity
public class Transaksi implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name="tanggal_transaksi", nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date waktuTransaksi = new Date();

    @ManyToOne
    @JoinColumn(name="id_jenis_transaksi", nullable=false)
    private JenisTransaksi jenisTransaksi;
    
    @ManyToOne
    @JoinColumn(name="id_rekening_asal", nullable=false)
    private Rekening rekeningAsal;
    
    @ManyToOne
    @JoinColumn(name="id_rekening_tujuan")
    private Rekening rekeningTujuan;
    
    @Column(nullable=true)
    private BigDecimal nilai;
    
    @Column(nullable=false)
    @Enumerated(EnumType.STRING)
    private Balance balance;
    
    private String keterangan;

    public Balance getBalance() {
        return balance;
    }

    public void setBalance(Balance balance) {
        this.balance = balance;
    }

    public JenisTransaksi getJenisTransaksi() {
        return jenisTransaksi;
    }

    public void setJenisTransaksi(JenisTransaksi jenisTransaksi) {
        this.jenisTransaksi = jenisTransaksi;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public BigDecimal getNilai() {
        return nilai;
    }

    public void setNilai(BigDecimal nilai) {
        this.nilai = nilai;
    }

    public Rekening getRekeningAsal() {
        return rekeningAsal;
    }

    public void setRekeningAsal(Rekening rekeningAsal) {
        this.rekeningAsal = rekeningAsal;
    }

    public Rekening getRekeningTujuan() {
        return rekeningTujuan;
    }

    public void setRekeningTujuan(Rekening rekeningTujuan) {
        this.rekeningTujuan = rekeningTujuan;
    }

    public Date getWaktuTransaksi() {
        return waktuTransaksi;
    }

    public void setWaktuTransaksi(Date waktuTransaksi) {
        this.waktuTransaksi = waktuTransaksi;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transaksi)) {
            return false;
        }
        Transaksi other = (Transaksi) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.artivisi.endy.belajar.jee.banking.entity.Transaksi[ id=" + id + " ]";
    }
    
}
