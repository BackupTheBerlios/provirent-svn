package test.provirent.hibernate;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import junit.framework.TestCase;
import net.sf.hibernate.Criteria;
import net.sf.hibernate.Session;
import net.sf.hibernate.Transaction;
import net.sf.hibernate.expression.Disjunction;
import net.sf.hibernate.expression.Expression;

import org.apache.log4j.Logger;

import de.hsharz.provirent.objects.Customer;
import de.hsharz.provirent.objects.Person;
import de.hsharz.provirent.objects.Subtitle;
import de.hsharz.provirent.persistence.HibernateUtil;
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
    

    

    
    /*
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
                c.setUserPassword("kunde1");
                c.setHiddenQuestion(" ");
                c.setHiddenAnswer(" ");

                
                
                
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

                Calendar birthday = Calendar.getInstance();
                birthday.set(Calendar.DAY_OF_MONTH,14);
                birthday.set(Calendar.MONTH,3); //April
                birthday.set(Calendar.YEAR,1981 );
             
                person.setDayOfBirth(birthday);
                
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
                int personid = c.getPerson().getPersonId().intValue();
                
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

                logger.debug("Customer: "+dbc+ "Person: "+dbc.getPerson());

                //delete the object
                s.delete(c);
                s.flush();
                
                dbc = c = null;

                Object obj = s.get(Customer.class, new Integer(id));

                //should be null, because data deleted
                assertNull("Deleted: Customer ID:" + id + ", but still in DB", obj);


                obj = s.get(Person.class, new Integer(personid));

                //should be null, because data deleted
                assertNull("Deleted Customer, but Person is still there: Customer ID:" 
                        + id + " Personid: "+ personid + ", but still in DB", obj);
                
                
                
                tx.commit();

                System.out.println("Customer der gespeichert wurde: " + customer.toString());
                
            } catch (Exception e) {
                if (tx != null) {
                    logger
                            .error(
                                    "testCustomer() - Something went wrong here; discard all partial changes",
                                    e);

                    // Something went wrong; discard all partial changes
                    tx.rollback();
                }
            }

        } catch (Exception e) {
            logger.error(
                    "testCustomer() - Error while trying to beginTransaction",
                    e);
            throw e;
        } finally {
            // No matter what, close the session
            HibernateUtil.closeSession();
        }
        
        
        
        if (logger.isDebugEnabled()) {
            logger.debug("testCustomer() - end");
        }
    }*/

    public void testCreateCustomer() throws Exception{
        if (logger.isDebugEnabled()) {
            logger.debug("testCreateCustomer() - start");
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
                c.setUserPassword("kunde1");
                c.setHiddenQuestion(" ");
                c.setHiddenAnswer(" ");

                Person person = new Person();
                person.setFirstName("Philipp");
                person.setLastName("Schneider");
                person.setStreet("Kastanienring");
                person.setStreetNumber("16");
                person.setCity("Leipzig");
                person.setZipCode("04316");
                person.setCountry("Deutschland");
                person.setSalutation("Herr");
                person.setEmailAddress("kunde2-provirent@phil-schneider.de");

                Calendar birthday = Calendar.getInstance();
                birthday.set(Calendar.DAY_OF_MONTH,10);
                birthday.set(Calendar.MONTH,8); 
                birthday.set(Calendar.YEAR,1988 );
             
                person.setDayOfBirth(birthday);
                
                
                c.setPerson(person);
                customer.add(c);

                //second Customer
                c = new Customer();
                c.setUserName("kunde2");
                c.setUserPassword("kunde2");
                c.setHiddenQuestion(" ");
                c.setHiddenAnswer(" ");

                person = new Person();
                person.setFirstName("Max");
                person.setLastName("Meier");
                person.setStreet("Kohlgartenstr.");
                person.setStreetNumber("67");
                person.setCity("Wernigerode");
                person.setZipCode("38855");
                person.setCountry("Deutschland");
                person.setSalutation("Herr");
                person.setEmailAddress("kunde2-provirent@phil-schneider.de");

                birthday = Calendar.getInstance();
                birthday.set(Calendar.DAY_OF_MONTH,2);
                birthday.set(Calendar.MONTH,2); 
                birthday.set(Calendar.YEAR,1954 );
                
                c.setPerson(person);
                customer.add(c);
                
       
                //third Customer
                c = new Customer();
                c.setUserName("kunde3");
                c.setUserPassword("kunde3");
                c.setHiddenQuestion(" ");
                c.setHiddenAnswer(" ");

                person = new Person();
                person.setFirstName("Thomas");
                person.setLastName("Pech");
                person.setStreet("Riebeck.");
                person.setStreetNumber("7a");
                person.setCity("Leipzig");
                person.setZipCode("04317");
                person.setCountry("Deutschland");
                person.setSalutation("Herr");
                person.setEmailAddress("kunde3-provirent@phil-schneider.de");

                birthday = Calendar.getInstance();
                birthday.set(Calendar.DAY_OF_MONTH,10);
                birthday.set(Calendar.MONTH,8); 
                birthday.set(Calendar.YEAR,1988 );
                
                c.setPerson(person);
                customer.add(c);
              
                
                List ids = new ArrayList();

                //save objects
                for (Iterator iter = customer.iterator(); iter.hasNext();) {
                    Customer custe = (Customer) iter.next();
                    ids.add((Integer) s.save(custe));

                }
                s.flush();

                for (int i =0;i < ids.size(); i++) {
                    
                    int id = ((Integer)ids.get(i)).intValue();
                    
                    //get Condition from Hibernate
                    Customer dbc = (Customer) s.get(Customer.class, new Integer(id));
                    assertNotNull("Can't get Customer" + id + " from DB", dbc);
                    if (dbc == null) {
                        if (logger.isDebugEnabled()) {
                            logger.debug("testCreateCustomer() Kein object mit id "
                                    + id + "gefunden.");
                        }
                        return;
                    }
                    logger.debug("Customer: "+dbc+" Person:"+dbc.getPerson());
                    
                    Customer myc = (Customer)customer.get(i);
                    //are both equal?
                    assertEquals(
                            "Select: Customer aus DB nicht gleich meiner. DB: "
                                    + dbc + " My:" + myc, myc, dbc); 

                }
                
                tx.commit();
                
            } catch (Exception e) {
                if (tx != null) {
                    logger
                            .error(
                                    "testCreateCustomer() - Something went wrong here; discard all partial changes",
                                    e);

                    // Something went wrong; discard all partial changes
                    tx.rollback();
                }
            }

        } catch (Exception e) {
            logger.error(
                    "testCreateCustomer() - Error while trying to beginTransaction",
                    e);
            throw e;
        } finally {
            // No matter what, close the session
            HibernateUtil.closeSession();
        }
        
        
        
        if (logger.isDebugEnabled()) {
            logger.debug("testCreateCustomer() - end");
        }
    }
    
  
    
    public void testSelectCustomer() throws Exception {
        if (logger.isDebugEnabled()) {
            logger.debug("testSelectCustomer() - start");
        }

	    Session s = HibernateUtil.currentSession();
	
	    
        Criteria criteria = s.createCriteria(Customer.class);
        List returnlist = criteria.list();
	    
        
        for (int i = 0; i < returnlist.size(); i++) {
            Customer customer = (Customer)returnlist.get(i);
            assertNotNull("Customer "+i+" Objekt ist null",customer);
            assertNotNull("Customer "+i+" Person ist null",customer.getPerson());
            logger.debug("Customer "+i+": "+customer+" Person: "+customer.getPerson());
            s.delete(customer);
        }
	    s.flush();
	    returnlist = criteria.list();
	    logger.debug("Anzahl Customer nach Löschen: "+returnlist.size());
	    
	    criteria = s.createCriteria(Person.class);
	    returnlist = criteria.list();
	    logger.debug("Anzahl Personen nach Löschen: "+returnlist.size());
	    
	
        if (logger.isDebugEnabled()) {
            logger.debug("testSelectCustomer() - end");
        }
    }
    
}
