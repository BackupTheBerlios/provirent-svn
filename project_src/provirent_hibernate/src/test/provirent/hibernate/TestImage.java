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

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import junit.framework.TestCase;
import net.sf.hibernate.Session;
import net.sf.hibernate.Transaction;

import org.apache.log4j.Logger;

import de.hsharz.provirent.objects.Image;

/**
 * @author Philipp Schneider
 *
 */
public class TestImage extends TestCase {
    /**
     * Logger for this class
     */
    private static final Logger logger = Logger.getLogger(TestImage.class);

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

    public void testImage() throws Exception {
        if (logger.isDebugEnabled()) {
            logger.debug("testCreating() - start");
        }
        /*

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
                List Images = new ArrayList();

                Image myd1 = new Image();
                myd1.setImageFile(new byte[] { 1, 2, 3, 4 });
                myd1.setImageFileDescription("Bild 1");
                myd1.setImageFileName("image1.jpg");
                myd1.setImageFileSize(123);

                Image myd2 = new Image();
                myd2.setImageFile(new byte[] { 5, 6, 7, 8 });
                myd2.setImageFileDescription("Bild 2");
                myd2.setImageFileName("image2.jpg");
                myd2.setImageFileSize(123);

                Image myd3 = new Image();
                myd3.setImageFile(new byte[] { 9, 10, 11, 12 });
                myd3.setImageFileDescription("Bild 3");
                myd3.setImageFileName("image3.jpg");
                myd3.setImageFileSize(123);

                Image myd4 = new Image();
                myd4.setImageFile(new byte[] { 13, 14, 15, 16 });
                myd4.setImageFileDescription("Bild 4");
                myd4.setImageFileName("image4.jpg");
                myd4.setImageFileSize(123);

                Images.add(myd1);
                Images.add(myd2);
                Images.add(myd3);
                Images.add(myd4);

                List ids = new ArrayList();

                //save objects
                for (Iterator iter = Images.iterator(); iter.hasNext();) {
                    Image dir = (Image) iter.next();
                    ids.add((Integer) s.save(dir));

                }
                s.flush();

                tx.commit();

                for (int i = 0; i < ids.size(); i++) {
                    int id = ((Integer) ids.get(i)).intValue();
                    Image myd = (Image) Images.get(i);

                    //get Image from Hibernate
                    Image dbd = (Image) s.get(Image.class, new Integer(id));
                    assertNotNull("Can't get Image" + id + " from DB", dbd);
                    if (dbd == null) {
                        if (logger.isDebugEnabled()) {
                            logger.debug("testCreating()Kein object mit id "
                                    + id + "gefunden.");
                        }
                        return;
                    }
                    //are both equal?
                    assertEquals(
                            "Select: Image aus DB nicht gleich meiner. DB: "
                                    + dbd + " My:" + myd, myd, dbd);

                    //Update

                    //delete the object
                    s.delete(myd);
                    s.flush();

                    dbd = myd = null;

                    Object obj = s.get(Image.class, new Integer(id));

                    //should be null, because data deleted
                    assertNull("Deleted: Image" + id + ", but still in DB", obj);

                    if (logger.isDebugEnabled()) {
                        logger
                                .debug("testCreating() - Image aus DB gleich meiner? DB: "
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
        */

        if (logger.isDebugEnabled()) {
            logger.debug("testCreating() - end");
        }
    }

    public void testSaveImage() throws Exception {
        if (logger.isDebugEnabled()) {
            logger.debug("testSaveImage() - start");
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
                List Images = new ArrayList();
                File file = new File(this.getClass()
                        .getResource("logo.gif").getFile());
                
                InputStream is = new  FileInputStream(file);

                long length = file.length();
                
                byte[] bytes = new byte[(int)length];

                // Read in the bytes
                int offset = 0;
                int numRead = 0;
                while (offset < bytes.length
                        && (numRead = is.read(bytes, offset, bytes.length
                                - offset)) >= 0) {
                    offset += numRead;
                }

                is.close();                
                
                System.out.println("bytes länge "+bytes.length );
                
                Image myd1 = new Image();
                myd1.setImageFile(bytes);
                myd1.setImageFileDescription("Bild 1");
                myd1.setImageFileName("image1.jpg");
                myd1.setImageFileSize(123);

                Image myd2 = new Image();
                myd2.setImageFile(bytes);
                myd2.setImageFileDescription("Bild 2");
                myd2.setImageFileName("image2.jpg");
                myd2.setImageFileSize(123);

                Image myd3 = new Image();
                myd3.setImageFile(bytes);
                myd3.setImageFileDescription("Bild 3");
                myd3.setImageFileName("image3.jpg");
                myd3.setImageFileSize(123);

                Image myd4 = new Image();
                myd4.setImageFile(bytes);
                myd4.setImageFileDescription("Bild 4");
                myd4.setImageFileName("image4.jpg");
                myd4.setImageFileSize(123);

                Images.add(myd1);
                Images.add(myd2);
                Images.add(myd3);
                Images.add(myd4);

                List ids = new ArrayList();

                //save objects
                for (Iterator iter = Images.iterator(); iter.hasNext();) {
                    Image dir = (Image) iter.next();
                    ids.add((Integer) s.save(dir));

                }
                s.flush();

                tx.commit();

            } catch (Exception e) {
                if (tx != null) {
                    logger
                            .error(
                                    "testSaveImage() - Something went wrong here; discard all partial changes",
                                    e);

                    // Something went wrong; discard all partial changes
                    tx.rollback();
                }

            }

        } catch (Exception e) {
            logger.error(
                    "testSaveImage() - Error while trying to beginTransaction",
                    e);
            throw e;
        } finally {
            // No matter what, close the session
            HibernateUtil.closeSession();
        }

        if (logger.isDebugEnabled()) {
            logger.debug("testSaveImage() - end");
        }
    }

    /**
     * Constructor for TestImage.
     * @param arg0
     */
    public TestImage(String arg0) {
        super(arg0);
    }

}