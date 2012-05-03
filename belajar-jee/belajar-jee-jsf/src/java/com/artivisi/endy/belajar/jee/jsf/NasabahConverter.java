/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artivisi.endy.belajar.jee.jsf;

import com.artivisi.endy.belajar.jee.banking.entity.Nasabah;
import com.artivisi.endy.belajar.jee.banking.service.BankingServiceBean;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author student14
 */
@FacesConverter(forClass=Nasabah.class)
public class NasabahConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        try {
            Long id = Long.valueOf(value);
            String namaEjb = "java:global/belajar-jee/belajar-jee-ejb/BankingServiceBean";
            
            InitialContext ctx = new InitialContext();
            
            BankingServiceBean bankingServiceBean = (BankingServiceBean) ctx.lookup(namaEjb);  
            return bankingServiceBean.cariNasabahById(id);
        } catch (NamingException ex) {
            Logger.getLogger(NasabahConverter.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Nasabah n = (Nasabah) value;
        return n.getId().toString();
    }
    
}
