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

import junit.framework.TestCase;
import net.sf.hibernate.Session;
import net.sf.hibernate.Transaction;

import org.apache.log4j.Logger;

import de.hsharz.provirent.objects.PaymentCategory;

/**
 * @author Stefan Forstner
 *
 */
public class TestPaymentCategory extends TestCase {
    /**
     * Logger for this class
     */
    private static final Logger logger = Logger.getLogger(TestPaymentCategory.class);

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
  

    public void testSavePaymentCategory() throws Exception {
        if (logger.isDebugEnabled()) {
            logger.debug("testSavePaymentCategory() - start");
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
                List paymentsCategorys = new ArrayList();

                
                paymentsCategorys.add(new PaymentCategory("A"));
                paymentsCategorys.add(new PaymentCategory("B"));
                paymentsCategorys.add(new PaymentCategory("C"));
                paymentsCategorys.add(new PaymentCategory("D"));
                paymentsCategorys.add(new PaymentCategory("E"));
    

                //save objects
                for (Iterator iter = paymentsCategorys.iterator(); iter.hasNext();) {
                    PaymentCategory pay = (PaymentCategory) iter.next();
                    
                    s.save(pay);

                }
                s.flush();

                tx.commit();

            } catch (Exception e) {
                if (tx != null) {
                    logger
                            .error(
                                    "testSavePaymentCategory() - Something went wrong here; discard all partial changes",
                                    e);

                    // Something went wrong; discard all partial changes
                    tx.rollback();
                }
                throw e;
            }

        } catch (Exception e) {
            logger.error(
                    "testSavePaymentCategory() - Error while trying to beginTransaction",
                    e);
            throw e;
        } finally {
            // No matter what, close the session
            HibernateUtil.closeSession();
        }

        HibernateUtil.closeSession();

        if (logger.isDebugEnabled()) {
            logger.debug("testSavePaymentCategory() - end");
        }
    }

    /**
     * Constructor for TestGenre.
     * @param arg0
     */
    public TestPaymentCategory(String arg0) {
        super(arg0);
    }

}