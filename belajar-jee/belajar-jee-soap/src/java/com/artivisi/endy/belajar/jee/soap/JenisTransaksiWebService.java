/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artivisi.endy.belajar.jee.soap;

import com.artivisi.endy.belajar.jee.banking.entity.JenisTransaksi;
import com.artivisi.endy.belajar.jee.banking.service.BankingServiceBean;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author student14
 */
@WebService(serviceName = "JenisTransaksiWebService")
public class JenisTransaksiWebService {
    @EJB
    private BankingServiceBean bankingServiceBean;

    /**
     * Web service operation
     */
    @WebMethod(operationName = "cariJenisTransaksiById")
    public JenisTransaksi cariJenisTransaksiById(@WebParam(name = "id") Long id) {
        return bankingServiceBean.cariJenisTransaksiById(id);
    }

    
}
