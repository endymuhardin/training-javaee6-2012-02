/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artivisi.endy.belajar.jee.soap;

import com.artivisi.endy.belajar.jee.banking.entity.Nasabah;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author student14
 */
@WebService(serviceName = "NasabahWebService")
public class NasabahWebService {
    @EJB
    private com.artivisi.endy.belajar.jee.banking.service.BankingServiceBean ejbRef;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    /**
     * Web service operation
     */
    @WebMethod(operationName = "cariSemuaNasabah")
    public List cariSemuaNasabah(@WebParam(name = "start") Integer start, @WebParam(name = "rows") Integer rows) {
        //TODO write your implementation code here:
        return ejbRef.cariSemuaNasabah(start, rows);
    }
    
}
