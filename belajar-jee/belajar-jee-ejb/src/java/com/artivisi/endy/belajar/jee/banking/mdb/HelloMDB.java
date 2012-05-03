/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artivisi.endy.belajar.jee.banking.mdb;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 *
 * @author student14
 */
@MessageDriven(mappedName = "jms/DemoQueue", activationConfig = {
    @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class HelloMDB implements MessageListener {
    
    public HelloMDB() {
    }
    
    @Override
    public void onMessage(Message message) {
        try {
            System.out.println("Terima message "+message.getClass());
            TextMessage msg = (TextMessage) message;
            System.out.println("Isi message : "+msg.getText());
        } catch (JMSException ex) {
            Logger.getLogger(HelloMDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
