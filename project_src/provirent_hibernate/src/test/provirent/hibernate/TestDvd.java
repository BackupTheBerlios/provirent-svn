package test.provirent.hibernate;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;
import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Session;
import net.sf.hibernate.Transaction;

import org.apache.log4j.Logger;

import de.hsharz.provirent.objects.AudioFormat;
import de.hsharz.provirent.objects.Dvd;
import de.hsharz.provirent.objects.Language;
import de.hsharz.provirent.objects.Movie;
import de.hsharz.provirent.objects.Subtitle;
import de.hsharz.provirent.objects.VideoFormat;

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
public class TestDvd extends TestCase {
    /**
     * Logger for this class
     */
    private static final Logger logger = Logger.getLogger(TestDvd.class);

    /*
     * @see TestCase#setUp()
     */
    protected void setUp() throws Exception {
        super.setUp();
    }

    /*
     * @see TestCase#tearDown()
     */
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Constructor for TestDvd.
     * 
     * @param arg0
     */
    public TestDvd(String arg0) {
        super(arg0);
    }

    public void testCreateDvd() {
        if (logger.isDebugEnabled()) {
            logger.debug("testCreateDvd() - start");
        }

        Session s = null;
        Transaction tx = null;

        RandomRange randomRange;
        List random;
        List dbprops;
        int anzahl = 0;
        List dvdprops;

        try {
            s= HibernateUtil.currentSession();
            tx = s.beginTransaction();
            if (false)
                throw new HibernateException("");

            //is DB open and connected
            assertTrue("Connected to Db? ", s.isConnected());
            assertTrue("Db Open? ", s.isOpen());

            //create a DVD for EACH Movie
            //try to get Languages from db
            List movies = s.find("from Movie as movie");
            assertNotNull("testCreateDvd(): Can't get Movie from DB. Null",
                    movies);
            assertTrue("testCreateDvd(): Can not find Movie in DB", movies
                    .size() > 0);

            for (int i = 0; i < movies.size(); i++) {

                Movie movie = (Movie) movies.get(i);

                List properties = new ArrayList();
                properties.add(new String[] { "neu", "ausleihbar" });
                properties.add(new String[] { "neu", "verliehen" });
                properties.add(new String[] { "leichte Kratzer", "ausleihbar" });
                properties.add(new String[] { "mittlere Kratzer", "ausleihbar" });
                properties.add(new String[] { "leichte Kratzer", "verliehen" });
                properties.add(new String[] { "mittlere Kratzer", "verliehen" });
                
                
                
                for (int j = 0; j < properties.size(); j++) {

                    //create new object
                    Dvd dvd = new Dvd();

                    //set the movie
                    dvd.setMovie(movie);

                    //set the random barcode
                    randomRange = new RandomRange(1205, 4523682);
                    dvd.setBarcode(randomRange.getNumbers(1).get(0) + "");

                    //set the condition
                    if (HibernateUtil.getCondition( ((String[])properties.get(j))[0], s) != null) {
                        dvd.setCondition(HibernateUtil.getCondition(((String[])properties.get(j))[0], s));
                    } else {
                        fail("Konnte keine Condition neu aus DB bekommen");
                    }

                    //set the status
                    if (HibernateUtil.getStatus( ((String[])properties.get(j))[1], s) != null) {
                        dvd.setStatus(HibernateUtil.getStatus(((String[])properties.get(j))[1], s));
                    } else {
                        fail("Konnte keinen Status ausleihbar aus DB bekommen");
                    }

                    //try to get Languages from db
                    dbprops = s.find("from Language as language");
                    assertNotNull(
                            "testCreateDvd(): Can't get Languages from DB. Null",
                            dbprops);
                    assertTrue("testCreateDvd(): Can not find Languages in DB",
                            dbprops.size() > 0);

                    anzahl = 2;
                    dvdprops = new ArrayList();
                    randomRange = new RandomRange(0, (dbprops.size() - 1));
                    random = randomRange.getNumbers(anzahl);

                    for (int k = 0; k < anzahl; k++) {
                        Language prop = (Language) dbprops
                                .get(((Integer) random.get(k)).intValue());
                        dvdprops.add(prop);
                    }
                    dvd.setLanguages(dvdprops);

                    //try to get Subtitle from db
                    dbprops = s.find("from Subtitle as subtitle");
                    assertNotNull(
                            "testCreateDvd(): Can't get Subtitle from DB. Null",
                            dbprops);
                    assertTrue("testCreateDvd(): Can not find Subtitle in DB",
                            dbprops.size() > 0);

                    anzahl = 2;
                    dvdprops = new ArrayList();
                    randomRange = new RandomRange(0, (dbprops.size() - 1));
                    random = randomRange.getNumbers(anzahl);

                    for (int k = 0; k < anzahl; k++) {
                        Subtitle prop = (Subtitle) dbprops
                                .get(((Integer) random.get(k)).intValue());
                        dvdprops.add(prop);
                    }
                    dvd.setSubtitles(dvdprops);

                    //try to get AudioFormat from db
                    dbprops = s.find("from AudioFormat as audioFormat");
                    assertNotNull(
                            "testCreateDvd(): Can't get AudioFormat from DB. Null",
                            dbprops);
                    assertTrue(
                            "testCreateDvd(): Can not find AudioFormat in DB",
                            dbprops.size() > 0);

                    anzahl = 2;
                    dvdprops = new ArrayList();
                    randomRange = new RandomRange(0, (dbprops.size() - 1));
                    random = randomRange.getNumbers(anzahl);

                    for (int k = 0; k < anzahl; k++) {
                        AudioFormat prop = (AudioFormat) dbprops
                                .get(((Integer) random.get(k)).intValue());
                        dvdprops.add(prop);
                    }
                    dvd.setAudioFormats(dvdprops);

                    //try to get VideoFormat from db
                    dbprops = s.find("from VideoFormat as videoFormat");
                    assertNotNull(
                            "testCreateDvd(): Can't get VideoFormat from DB. Null",
                            dbprops);
                    assertTrue(
                            "testCreateDvd(): Can not find VideoFormat in DB",
                            dbprops.size() > 0);

                    anzahl = 2;
                    dvdprops = new ArrayList();
                    randomRange = new RandomRange(0, (dbprops.size() - 1));
                    random = randomRange.getNumbers(anzahl);

                    for (int k = 0; k < anzahl; k++) {
                        VideoFormat prop = (VideoFormat) dbprops
                                .get(((Integer) random.get(k)).intValue());
                        dvdprops.add(prop);
                    }
                    dvd.setVideoFormats(dvdprops);

                    //save the dvd
                    logger.debug(i+" "+j+" DVD:"+dvd);
                    s.save(dvd);
                }
            }
            tx.commit();
            
        } catch (HibernateException hex) {
            fail("Fehler beim Session oder Transaction aufbau");
            logger.error("Fehler beim Session oder Transaction aufbau", hex);

        } finally {
            try {
                // No matter what, close the session
                HibernateUtil.closeSession();
            } catch (HibernateException e) {
                logger.error("testCreateDvd()", e);

                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        if (logger.isDebugEnabled()) {
            logger.debug("testCreateDvd() - end");
        }
    }
}