package test.provirent.hibernate;

import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import junit.framework.TestCase;
import net.sf.hibernate.Session;
import net.sf.hibernate.Transaction;

import org.apache.log4j.Logger;

import de.hsharz.provirent.objects.Condition;
import de.hsharz.provirent.objects.Customer;
import de.hsharz.provirent.objects.Person;
/*
 * Created on 09.10.2004
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

/**
 * @author Philipp Schneider
 *
 */
public class TestCustomer extends TestCase {
    /**
     * Logger for this class
     */
    private static final Logger logger = Logger.getLogger(TestCustomer.class);

    /*
     * @see TestCase#setUp()
     */
    protected void setUp() throws Exception {
        if (logger.isDebugEnabled()) {
            logger.debug("setUp() - start");
        }

        super.setUp();

        if (logger.isDebugEnabled()) {
            logger.debug("setUp() - end");
        }
    }

    /*
     * @see TestCase#tearDown()
     */
    protected void tearDown() throws Exception {
        if (logger.isDebugEnabled()) {
            logger.debug("tearDown() - start");
        }

        super.tearDown();

        if (logger.isDebugEnabled()) {
            logger.debug("tearDown() - end");
        }
    }

    /**
     * Constructor for TestCustomer.
     * @param arg0
     */
    public TestCustomer(String arg0) {
        super(arg0);
    }
    

    
    public void testCustomer() throws Exception{
        if (logger.isDebugEnabled()) {
            logger.debug("testCustomer() - start");
        }

        //get new Session and begin Transaction
        Session s = HibernateUtil.currentSession();
        Transaction tx = null;
        try {
            tx = s.beginTransaction();

            try {
                //is DB open and connected
                assertTrue("Connected to Db? ", s.isConnected());
                assertTrue("Db Open? ", s.isOpen());

                List customer = new ArrayList();
                
                //create new objects

                Customer c = new Customer();
                c.setUserName("kunde1");
                c.setPassword("kunde1");
                c.setHiddenQuestion(" ");
                c.setHiddenAnswer(" ");

                
                Date birth = new Date();
                birth.setMonth(4);
                birth.setYear(1981);
                birth.setDate(14);
                
                Calendar birthday = Calendar.getInstance();
                birthday.setTime(birth);
                
                c.setDayOfBirth(birthday);
                
                
                Person person = new Person();
                person.setFirstName("Philipp");
                person.setLastName("Schneider");
                person.setStreet("Kastanienring");
                person.setStreetNumber("16");
                person.setCity("Leipzig");
                person.setZipCode("04316");
                person.setCountry("Deutschland");
                person.setSalutation("Herr");
                person.setEmailAddress("egal@phil-schneider.de");
                
                c.setPerson(person);
                
                customer.add(c);

                List ids = new ArrayList();

                //save objects
                for (Iterator iter = customer.iterator(); iter.hasNext();) {
                    Customer custe = (Customer) iter.next();
                    ids.add((Integer) s.save(custe));

                }
                s.flush();

                
                int id = c.getCustomerId().intValue();
                //get Condition from Hibernate
                Customer dbc = (Customer) s.get(Customer.class, new Integer(id));
                assertNotNull("Can't get Customer" + id + " from DB", dbc);
                if (dbc == null) {
                    if (logger.isDebugEnabled()) {
                        logger.debug("testCustomer() Kein object mit id "
                                + id + "gefunden.");
                    }
                    return;
                }
                //are both equal?
                assertEquals(
                        "Select: Customer aus DB nicht gleich meiner. DB: "
                                + dbc + " My:" + c, c, dbc); 

                //Update

                //delete the object
                s.delete(c);
                s.flush();
                
                dbc = c = null;

                Object obj = s.get(Customer.class, new Integer(id));

                //should be null, because data deleted
                assertNull("Deleted: Customer ID:" + id + ", but still in DB", obj);

                
                tx.commit();

                System.out.println("Customer der gespeichert wurde: " + customer.toString());
                
            } catch (Exception e) {
                if (tx != null) {
                    logger
                            .error(
                                    "TestCreatingCustomer() - Something went wrong here; discard all partial changes",
                                    e);

                    // Something went wrong; discard all partial changes
                    tx.rollback();
                }
            }

        } catch (Exception e) {
            logger.error(
                    "TestCreatingCustomer() - Error while trying to beginTransaction",
                    e);
            throw e;
        } finally {
            // No matter what, close the session
            HibernateUtil.closeSession();
        }
        
        
        
        if (logger.isDebugEnabled()) {
            logger.debug("TestCreatingCustomer() - end");
        }
    }
    
    
}
