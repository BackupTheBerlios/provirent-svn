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
package test.provirent.hibernate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Calendar;

import junit.framework.TestCase;
import net.sf.hibernate.Session;
import net.sf.hibernate.Transaction;

import org.apache.log4j.Logger;

import de.hsharz.provirent.objects.Payment;

/**
 * @author Stefan Forstner
 *
 */
public class TestPayment extends TestCase {
    /**
     * Logger for this class
     */
    private static final Logger logger = Logger.getLogger(TestPayment.class);

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
    
    /*public void testGenre() throws Exception {
        if (logger.isDebugEnabled()) {
            logger.debug("testCreating() - start");
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

                //cretae new objects
                List Payments = new ArrayList();

                Payment myp1 = null;
                Payment myp2 = null;
                Payment myp3 = null;
                Payment myp4 = null;
                
                s.clear();

                for (int i = 1; i <= 10; i++) {
                    myp1 = new Payment("A", 2.00d, 4.00d, 8.00d);
                    myp2 = new Payment("B", 3.00d, 6.00d, 12.00d);
                    myp3 = new Payment("C", 4.00d, 8.00d, 14.00d);
                    myp4 = new Payment("D", 5.00d, 10.00d, 20.00d);
                    Payments.add(myp1);
                    Payments.add(myp2);
                    Payments.add(myp3);
                    Payments.add(myp4);
                }             
                

                List ids = new ArrayList();

                //save objects
                for (Iterator iter = Payments.iterator(); iter.hasNext();) {
                    Payment dir = (Payment) iter.next();
                    ids.add((Integer) s.save(dir));

                }
                s.flush();

                tx.commit();

                for (int i = 0; i < ids.size(); i++) {
                    int id = ((Integer) ids.get(i)).intValue();
                    Payment myp = (Payment) Payments.get(i);

                    //get Payment from Hibernate
                    Payment dbd = (Payment) s.get(Payment.class, new Integer(id));
                    assertNotNull("Can't get Payment" + id + " from DB", dbd);
                    if (dbd == null) {
                        if (logger.isDebugEnabled()) {
                            logger.debug("testCreating()Kein object mit id "
                                    + id + "gefunden.");
                        }
                        return;
                    }
                    //are both equal?
                    assertEquals(
                            "Select: Payment aus DB nicht gleich meiner. DB: "
                                    + dbd + " My:" + myp, myp, dbd);

                    //Update

                    //delete the object
                    s.delete(myp);
                    s.flush();

                    logger.debug("Lösche eins per Hand");
                    Payment o = new Payment();
                    o.setPaymentId(new Integer(0));
                    o.setName("");
                    o.setDuration1(0d);
                    o.setDuration2(0d);
                    o.setDuration3(0d);
                    o.setStartdate(null);
                    s.delete(o);
                    s.flush();
                    
                    
                    dbd = myp = null;

                    Object obj = s.get(Payment.class, new Integer(id));

                    //should be null, because data deleted
                    assertNull("Deleted: Payment" + id + ", but still in DB", obj);

                    if (logger.isDebugEnabled()) {
                        logger
                                .debug("testCreating() - Payment aus DB gleich meiner? DB: "
                                        + dbd + " My:" + myp);
                    }

                }

                tx.commit();

            } catch (Exception e) {
                if (tx != null) {
                    logger
                            .error(
                                    "testCreating() - Something went wrong here; discard all partial changes",
                                    e);

                    // Something went wrong; discard all partial changes
                    tx.rollback();
                }

            }

        } catch (Exception e) {
            logger.error(
                    "testCreating() - Error while trying to beginTransaction",
                    e);
            throw e;
        } finally {
            // No matter what, close the session
            HibernateUtil.closeSession();
        }


        if (logger.isDebugEnabled()) {
            logger.debug("testCreating() - end");
        }
    }*/

    public void testSavePayment() throws Exception {
        if (logger.isDebugEnabled()) {
            logger.debug("testSavePayment() - start");
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

                //create new objects
                List Payments = new ArrayList();
                Calendar date1 = Calendar.getInstance();
                date1.set(2004,11,12);
                Calendar date2 = Calendar.getInstance();
                date2.set(2004,11,30);
                Calendar date3 = Calendar.getInstance();
                date3.set(2005,1,16);
                Calendar date4 = Calendar.getInstance();
                date4.set(2005,11,8);
                Payment myp1 = new Payment("A", 2.00d, 4.00d, 8.00d,date1);
                Payment myp2 = new Payment("B", 3.00d, 6.00d, 12.00d,date2);
                Payment myp3 = new Payment("C", 4.00d, 8.00d, 14.00d,date3);
                Payment myp4 = new Payment("D", 5.00d, 10.00d, 20.00d,date4);

                
                Payments.add(myp1);
                Payments.add(myp2);
                Payments.add(myp3);
                Payments.add(myp4);

                List ids = new ArrayList();

                //save objects
                for (Iterator iter = Payments.iterator(); iter.hasNext();) {
                    Payment pay = (Payment) iter.next();
                    ids.add((Integer) s.save(pay));

                }
                s.flush();

                tx.commit();

            } catch (Exception e) {
                if (tx != null) {
                    logger
                            .error(
                                    "testSavePayment() - Something went wrong here; discard all partial changes",
                                    e);

                    // Something went wrong; discard all partial changes
                    tx.rollback();
                }
                throw e;
            }

        } catch (Exception e) {
            logger.error(
                    "testSavePayment() - Error while trying to beginTransaction",
                    e);
            throw e;
        } finally {
            // No matter what, close the session
            HibernateUtil.closeSession();
        }

        HibernateUtil.closeSession();

        if (logger.isDebugEnabled()) {
            logger.debug("testSavePayment() - end");
        }
    }

    /**
     * Constructor for TestGenre.
     * @param arg0
     */
    public TestPayment(String arg0) {
        super(arg0);
    }

}