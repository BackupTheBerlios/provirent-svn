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

import de.hsharz.provirent.objects.Actor;

/**
 * @author Philipp Schneider
 *
 */
public class TestActor extends TestCase {
    /**
     * Logger for this class
     */
    private static final Logger logger = Logger.getLogger(TestActor.class);

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

    public void testActor() throws Exception {
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
                List Actors = new ArrayList();

                Actor myd1 = new Actor("Johnny", "Depp");
                Actor myd2 = new Actor("Geoffrey", "Rush");
                Actor myd3 = new Actor("Gore", "Verbinski ");
                Actor myd4 = new Actor("Julianne", "Moore ");
                Actor myd5 = new Actor("Anthony", "Edwards ");
                Actor myd6 = new Actor("Matthew", "Pleszewicz ");
                Actor myd7 = new Actor("Christopher", "Kovaleski ");

                Actors.add(myd1);
                Actors.add(myd2);
                Actors.add(myd3);
                Actors.add(myd4);
                Actors.add(myd5);
                Actors.add(myd6);
                Actors.add(myd7);

                List ids = new ArrayList();

                //save objects
                for (Iterator iter = Actors.iterator(); iter.hasNext();) {
                    Actor dir = (Actor) iter.next();
                    ids.add((Integer) s.save(dir));

                }
                s.flush();

                tx.commit();

                for (int i = 0; i < ids.size(); i++) {
                    int id = ((Integer) ids.get(i)).intValue();
                    Actor myd = (Actor) Actors.get(i);

                    //get Actor from Hibernate
                    Actor dbd = (Actor) s.get(Actor.class, new Integer(id));
                    assertNotNull("Can't get Actor" + id + " from DB", dbd);
                    if (dbd == null) {
                        if (logger.isDebugEnabled()) {
                            logger.debug("testCreating()Kein object mit id "
                                    + id + "gefunden.");
                        }
                        return;
                    }
                    //are both equal?
                    assertEquals(
                            "Select: Actor aus DB nicht gleich meiner. DB: "
                                    + dbd + " My:" + myd, myd, dbd);

                    //Update

                    //delete the object
                    s.delete(myd);
                    s.flush();

                    dbd = myd = null;

                    Object obj = s.get(Actor.class, new Integer(id));

                    //should be null, because data deleted
                    assertNull("Deleted: Actor" + id + ", but still in DB", obj);

                    if (logger.isDebugEnabled()) {
                        logger
                                .debug("testCreating() - Actor aus DB gleich meiner? DB: "
                                        + dbd + " My:" + myd);
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
    }

    public void testSaveActor() throws Exception {
        if (logger.isDebugEnabled()) {
            logger.debug("testSaveActor() - start");
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
                List Actors = new ArrayList();

                Actor myd1 = new Actor("Johnny", "Depp");
                Actor myd2 = new Actor("Geoffrey", "Rush");
                Actor myd3 = new Actor("Gore", "Verbinski ");
                Actor myd4 = new Actor("Julianne", "Moore ");
                Actor myd5 = new Actor("Anthony", "Edwards ");
                Actor myd6 = new Actor("Matthew", "Pleszewicz ");
                Actor myd7 = new Actor("Christopher", "Kovaleski ");

                Actors.add(myd1);
                Actors.add(myd2);
                Actors.add(myd3);
                Actors.add(myd4);
                Actors.add(myd5);
                Actors.add(myd6);
                Actors.add(myd7);

                List ids = new ArrayList();

                //save objects
                for (Iterator iter = Actors.iterator(); iter.hasNext();) {
                    Actor dir = (Actor) iter.next();
                    ids.add((Integer) s.save(dir));

                }
                s.flush();

                tx.commit();

            } catch (Exception e) {
                if (tx != null) {
                    logger
                            .error(
                                    "testSaveActor() - Something went wrong here; discard all partial changes",
                                    e);

                    // Something went wrong; discard all partial changes
                    tx.rollback();
                }
        
            }

        } catch (Exception e) {
            logger.error(
                    "testSaveActor() - Error while trying to beginTransaction",
                    e);
            throw e;
        
        } finally {
            // No matter what, close the session
            HibernateUtil.closeSession();
        }

        

        if (logger.isDebugEnabled()) {
            logger.debug("testSaveActor() - end");
        }
    }

    /**
     * Constructor for TestActor.
     * @param arg0
     */
    public TestActor(String arg0) {
        super(arg0);
    }

}