/*
 * Created on 07.10.2004
 *
 * Copyright (c) 2004/2005, Remo Griesch/Stefan Forstner/Philipp Schneider
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * - Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 * - Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 * - Neither the name of the Remo Griesch/Stefan Forstner/Philipp Schneider nor
 * the names of its contributors may be used to endorse or promote products
 * derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *
 */
package test.provirent.hibernate;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import net.sf.hibernate.Session;
import net.sf.hibernate.SessionFactory;
import net.sf.hibernate.Transaction;
import net.sf.hibernate.cfg.Configuration;
import de.hsharz.provirent.objects.*;


/**
 * @author Philipp Schneider
 *  
 */
public class TestCustomerOld {

    public static void main(String args[]) throws Exception {
        TestCustomerOld th = new TestCustomerOld();
        //th.saveObjects();
        th.getObjects();
    }
    

        



    public void getObjects() throws Exception {
        Configuration config = new Configuration();

        // Tell it about the classes we want mapped, taking advantage
        // of
        // the way we've named their mapping documents.
        config.addClass(Customer.class).addClass(Person.class);

        // Get the session factory we can use for persistence
        SessionFactory sessionFactory = config.buildSessionFactory();

        // Ask for a session using the JDBC information we've
        // configured
        Session session = sessionFactory.openSession();
        try {
            int id = 1;
            Customer object = (Customer) session.get(Customer.class, new Integer(id));
            if (object == null) {
                System.out.println("Kein object mit id " + id + "gefunden");
                return;
            }
            System.out.println("Object gefunden: " + object.toString());
            
            session.delete(object);
            session.flush();
            System.out.println("Object in DB gelöscht." );

            
            Object object1 =  session.get(Person.class, new Integer(id));
            if (object1 == null) {
                System.out.println("Keine Person mit id " + id + "gefunden");
                return;
            }
            System.out.println("Person gefunden: " + ((Person)object1).toString());
            
            
        } finally {
            // No matter what, close the session
            session.close();
        }

        // Clean up after ourselves
        sessionFactory.close();
    }

    public void saveObjects() throws Exception {
        // Create a configuration based on the properties file we've put
        // in the standard place.
        Configuration config = new Configuration();

        // Tell it about the classes we want mapped, taking advantage of
        // the way we've named their mapping documents.
        config.addClass(Customer.class).addClass(Person.class);

        // Get the session factory we can use for persistence
        SessionFactory sessionFactory = config.buildSessionFactory();

        // Ask for a session using the JDBC information we've configured
        Session s = sessionFactory.openSession();
        Transaction tx = null;
        try {
            // Create some data and persist it
            tx = s.beginTransaction();

            Person p = new Person();
            p.setFirstName("Philipp");
            p.setLastName("Schneider");
            p.setStreet("Kastanienring");
            p.setStreetNumber("16");
            p.setCity("Leipzig");
            p.setZipCode("04316");
            p.setCountry("Deutschland");
            p.setSalutation("Herr");
            p.setEmailAddress("egal@aol.com");
            
            //s.save(p);
            //System.out.println("Person id: " +p.getPersonId() );
            
            Customer c = new Customer();
            c.setPerson(p);
            c.setUserName("boelkstoff");
            c.setPassword("egal");
            c.setHiddenQuestion("Wer");
            c.setHiddenAnswer("ich");
            
            s.save(c);
            s.flush();
            
            System.out.println("Customer id: " +c.getCustomerId() );
            System.out.println("Customer id: " +c.getDayOfRegistration() );
            System.out.println("Person id: " +p.getPersonId() );
            
            
            // We're done; make our changes permanent
            tx.commit();

        } catch (Exception e) {
            if (tx != null) {
                // Something went wrong; discard all partial changes
                tx.rollback();
            }
            throw e;
        } finally {
            // No matter what, close the session
            HibernateUtil.closeSession();
        }

        // Clean up after ourselves
        sessionFactory.close();
    }

}