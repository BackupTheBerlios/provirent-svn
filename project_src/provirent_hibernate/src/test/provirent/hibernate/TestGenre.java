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

import de.hsharz.provirent.objects.Genre;

/**
 * @author Philipp Schneider
 *
 */
public class TestGenre extends TestCase {
    /**
     * Logger for this class
     */
    private static final Logger logger = Logger.getLogger(TestGenre.class);

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
    /*
    public void testGenre() throws Exception {
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
                List Genres = new ArrayList();

                Genre myd1 = null;
                Genre myd2 = null;
                Genre myd3 = null;
                Genre myd4 = null;
                
                s.clear();

                for (int i = 1; i <= 10; i++) {
                    myd1 = new Genre("Action","");
                    myd2 = new Genre("Abenteuer","");
                    myd3 = new Genre("Dokumentation","");
                    myd4 = new Genre("Horror","");
                    Genres.add(myd1);
                    Genres.add(myd2);
                    Genres.add(myd3);
                    Genres.add(myd4);
                }             
                

                List ids = new ArrayList();

                //save objects
                for (Iterator iter = Genres.iterator(); iter.hasNext();) {
                    Genre dir = (Genre) iter.next();
                    ids.add((Integer) s.save(dir));

                }
                s.flush();

                tx.commit();

                for (int i = 0; i < ids.size(); i++) {
                    int id = ((Integer) ids.get(i)).intValue();
                    Genre myd = (Genre) Genres.get(i);

                    //get Genre from Hibernate
                    Genre dbd = (Genre) s.get(Genre.class, new Integer(id));
                    assertNotNull("Can't get Genre" + id + " from DB", dbd);
                    if (dbd == null) {
                        if (logger.isDebugEnabled()) {
                            logger.debug("testCreating()Kein object mit id "
                                    + id + "gefunden.");
                        }
                        return;
                    }
                    //are both equal?
                    assertEquals(
                            "Select: Genre aus DB nicht gleich meiner. DB: "
                                    + dbd + " My:" + myd, myd, dbd);

                    //Update

                    //delete the object
                    s.delete(myd);
                    s.flush();

                    logger.debug("Lösche eins per Hand");
                    Genre o = new Genre();
                    o.setGenreId(new Integer(0));
                    o.setName("");
                    o.setShortname("");
                    s.delete(o);
                    s.flush();
                    
                    
                    dbd = myd = null;

                    Object obj = s.get(Genre.class, new Integer(id));

                    //should be null, because data deleted
                    assertNull("Deleted: Genre" + id + ", but still in DB", obj);

                    if (logger.isDebugEnabled()) {
                        logger
                                .debug("testCreating() - Genre aus DB gleich meiner? DB: "
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
    }*/

    public void testSaveGenre() throws Exception {
        if (logger.isDebugEnabled()) {
            logger.debug("testSaveGenre() - start");
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
                List Genres = new ArrayList();

                Genre myd1 = new Genre("Action","");
                Genre myd2 = new Genre("Abenteuer","");
                Genre myd3 = new Genre("Dokumentation","");
                Genre myd4 = new Genre("Horror","");

                Genres.add(myd1);
                Genres.add(myd2);
                Genres.add(myd3);
                Genres.add(myd4);

                List ids = new ArrayList();

                //save objects
                for (Iterator iter = Genres.iterator(); iter.hasNext();) {
                    Genre dir = (Genre) iter.next();
                    ids.add((Integer) s.save(dir));

                }
                s.flush();

                tx.commit();

            } catch (Exception e) {
                if (tx != null) {
                    logger
                            .error(
                                    "testSaveGenre() - Something went wrong here; discard all partial changes",
                                    e);

                    // Something went wrong; discard all partial changes
                    tx.rollback();
                }
                throw e;
            }

        } catch (Exception e) {
            logger.error(
                    "testSaveGenre() - Error while trying to beginTransaction",
                    e);
            throw e;
        } finally {
            // No matter what, close the session
            HibernateUtil.closeSession();
        }

        HibernateUtil.closeSession();

        if (logger.isDebugEnabled()) {
            logger.debug("testSaveGenre() - end");
        }
    }

    /**
     * Constructor for TestGenre.
     * @param arg0
     */
    public TestGenre(String arg0) {
        super(arg0);
    }

}