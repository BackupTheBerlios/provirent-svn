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
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import junit.framework.TestCase;
import net.sf.hibernate.Session;
import net.sf.hibernate.Transaction;

import org.apache.log4j.Logger;

import de.hsharz.provirent.objects.Payment;
import de.hsharz.provirent.objects.PaymentCategory;

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
                List payments = new ArrayList();
                Calendar date1 = Calendar.getInstance();
                date1.set(2004, 11, 12);
                Calendar date2 = Calendar.getInstance();
                date2.set(2004, 11, 30);
                Calendar date3 = Calendar.getInstance();
                date3.set(2005, 1, 16);
                Calendar date4 = Calendar.getInstance();
                date4.set(2005, 11, 8);
                Calendar date5 = Calendar.getInstance();
                date5.set(2004, 10, 12);
                Calendar date6 = Calendar.getInstance();
                date6.set(2004, 10, 28);
                Calendar date7 = Calendar.getInstance();
                date7.set(2004, 10, 29);
                Calendar date8 = Calendar.getInstance();
                date8.set(2004, 10, 20);

                payments.add(new Payment(2.00d, 4.00d, 8.00d, date1, null));
                payments.add(new Payment(3.00d, 6.00d, 12.00d, date2, null));
                payments.add(new Payment(4.00d, 8.00d, 14.00d, date3, null));
                payments.add(new Payment(5.00d, 10.00d, 20.00d, date4, null));
                payments.add(new Payment(2.00d, 4.00d, 8.00d, date5, null));
                payments.add(new Payment(3.00d, 6.00d, 12.00d, date6, null));
                payments.add(new Payment(4.00d, 8.00d, 14.00d, date7, null));
                payments.add(new Payment(5.00d, 10.00d, 20.00d, date8, null));

                //get and set the paymentcategory
                //add Payment
                List categorys = s
                        .find("from PaymentCategory as paymentcategory");
                assertNotNull(
                        "testCreateDvd(): Can't get PaymentCategory from DB. Null",
                        categorys);
                assertTrue(
                        "testCreateDvd(): Can not find PaymentCategory in DB",
                        categorys.size() > 0);

                
                
                logger.debug("Test    Test");
                logger.debug("Cat"+categorys.size());
                logger.debug("pay"+payments.size());
                
                RandomRange randomRange;

                for (int i = 0; i < payments.size(); i++) {

                     
                    
                    randomRange = new RandomRange(0, (categorys.size() - 1));

                    logger.debug(i + " Randomnum:"
                            + randomRange.getNumbers(1).get(0));
                    
                    PaymentCategory prop = (PaymentCategory) categorys
                            .get(((Integer) randomRange.getNumbers(
                                    1 ).get(0)).intValue());

                    ((Payment) payments.get(i)).setPaymentCategory(prop);

                }

                //save objects
                for (Iterator iter = payments.iterator(); iter.hasNext();) {
                    Payment pay = (Payment) iter.next();

                    s.save(pay);

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
            logger
                    .error(
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