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

import de.hsharz.provirent.objects.Actor;
import de.hsharz.provirent.objects.AudioFormat;
import de.hsharz.provirent.objects.Director;
import de.hsharz.provirent.objects.Genre;
import de.hsharz.provirent.objects.Image;
import de.hsharz.provirent.objects.Language;
import de.hsharz.provirent.objects.Movie;
import de.hsharz.provirent.objects.Subtitle;
import de.hsharz.provirent.objects.VideoFormat;

/**
 * @author Philipp Schneider
 *  
 */
public class TestMovie extends TestCase {
    /**
     * Logger for this class
     */
    private static final Logger logger = Logger.getLogger(TestMovie.class);

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
     * Creates a new Movie objects and saves it. All data will be create new.
     * 
     * @throws Exception
     */
    public void testCreateCompleteNewMovie() throws Exception {
        if (logger.isDebugEnabled()) {
            logger.debug("testCreateCompleteNewMovie() - start");
        }
        /*
         * //get new Session and begin Transaction Session s =
         * HibernateUtil.currentSession(); Transaction tx = null; try { tx =
         * s.beginTransaction();
         * 
         * try { //is DB open and connected assertTrue("Connected to Db? ",
         * s.isConnected()); assertTrue("Db Open? ", s.isOpen());
         * 
         * List movies = new ArrayList();
         * 
         * //create new movie objects Movie movie = new Movie();
         * movie.setDescription("A grieving mother, Telly Parada, " + "is
         * struggling to cope with the loss of her " +"9-year-old son. She is
         * stunned..."); movie.setRuntime(96); movie.setTitle("The Forgotten");
         * movie.setReleaseDate(Calendar.getInstance());
         * 
         * movie.setImages(new ArrayList()); //Image mainImage = new Image();
         * 
         * movie.setMainImage(new Image());
         * 
         * 
         * List objects = new ArrayList(); objects.add(new
         * Actor("Julianne","Moore")); objects.add(new Actor("Christopher",
         * "Kovaleski")); objects.add(new Actor("Matthew", "Pleszewicz")); for
         * (Iterator iter = objects.iterator(); iter.hasNext();) { s.save(
         * iter.next() ); } movie.setActors(objects);
         * 
         * objects = new ArrayList(); objects.add(new
         * Director("Joseph","Ruben")); for (Iterator iter = objects.iterator();
         * iter.hasNext();) { s.save( iter.next() ); }
         * movie.setDirector(objects);
         * 
         * objects = new ArrayList(); objects.add(new Genre("Thriller",""));
         * objects.add(new Genre("Drama","")); objects.add(new
         * Genre("Sci-Fi","")); objects.add(new Genre("Mystery","")); for
         * (Iterator iter = objects.iterator(); iter.hasNext();) { s.save(
         * iter.next() ); } movie.setGenres(objects);
         * 
         * objects = new ArrayList(); objects.add(new Language("Deutsch","de"));
         * objects.add(new Language("Englisch","en")); for (Iterator iter =
         * objects.iterator(); iter.hasNext();) { s.save( iter.next() ); }
         * movie.setLanguages(objects);
         * 
         * objects = new ArrayList(); objects.add( new AudioFormat("DTS Surround
         * Sound","")); objects.add( new AudioFormat("Surround Sound",""));
         * objects.add( new AudioFormat("Dolby","")); for (Iterator iter =
         * objects.iterator(); iter.hasNext();) { s.save( iter.next() ); }
         * movie.setAudioFormats(new ArrayList());
         * 
         * objects = new ArrayList(); objects.add(new Subtitle("Deutsch","de"));
         * objects.add(new Subtitle("Englisch","en")); for (Iterator iter =
         * objects.iterator(); iter.hasNext();) { s.save( iter.next() ); }
         * movie.setSubtitles(objects);
         * 
         * objects = new ArrayList(); objects.add( new VideoFormat("9:13",""));
         * objects.add( new VideoFormat("16:10", "")); for (Iterator iter =
         * objects.iterator(); iter.hasNext();) { s.save( iter.next() ); }
         * movie.setVideoFormats(new ArrayList());
         * 
         * //add movie to movie List movies.add(movie);
         * 
         * 
         * List ids = new ArrayList();
         * 
         * //save objects for (Iterator iter = movies.iterator();
         * iter.hasNext();) { Movie moviee = (Movie) iter.next();
         * ids.add((Integer) s.save(moviee));
         *  } s.flush();
         * 
         * for (int i =0;i < ids.size(); i++) {
         * 
         * int id = ((Integer)ids.get(i)).intValue();
         * 
         * //get Condition from Hibernate Movie dbc = (Movie) s.get(Movie.class,
         * new Integer(id)); assertNotNull("Can't get Movie" + id + " from DB",
         * dbc); if (dbc == null) { if (logger.isDebugEnabled()) {
         * logger.debug("testCreateCompleteNewMovie() Kein object mit id " + id +
         * "gefunden."); } return; } Movie mym = (Movie)movies.get(i); //are
         * both equal? assertEquals( "Select: Customer aus DB nicht gleich
         * meiner. DB: " + dbc + " My:" + mym, mym, dbc);
         * 
         * }//for
         * 
         * tx.commit();
         *  } catch (Exception e) { if (tx != null) { logger .error(
         * "testCreateCompleteNewMovie() - Something went wrong here; discard
         * all partial changes", e);
         *  // Something went wrong; discard all partial changes tx.rollback(); } }
         *  } catch (Exception e) { logger.error( "testCreateCompleteNewMovie() -
         * Error while trying to beginTransaction", e); throw e; } finally { //
         * No matter what, close the session HibernateUtil.closeSession(); }
         *  
         */

        if (logger.isDebugEnabled()) {
            logger.debug("testCreateCompleteNewMovie() - end");
        }
    }

    /**
     * Creates a new Movie Objects, tries to get all data like Actor from db
     * 
     * @throws Exception
     */
    public void testCreateDBMovie() throws Exception {
        if (logger.isDebugEnabled()) {
            logger.debug("testCreateDBMovie() - start");
        }

        //get new Session and begin Transaction
        Session s = HibernateUtil.currentSession();
        Transaction tx = null;

        RandomRange random;
        List randomNum = new ArrayList();
        try {
            tx = s.beginTransaction();

            try {
                //is DB open and connected
                assertTrue("Connected to Db? ", s.isConnected());
                assertTrue("Db Open? ", s.isOpen());

                logger.debug("Erstelle Movie Objekt");

                List data = new ArrayList();
                data
                        .add(new String[] {
                                "The Forgotten",
                                "96",
                                "A grieving mother, Telly Parada, is struggling to cope with the loss of her 9-year-old son. She is stunned...",
                                "Forgotten_main.jpg", "Forgotten_1.jpg",
                                "Forgotten_2.jpg" });
                data
                        .add(new String[] {
                                "Ocean's Twelve",
                                "128",
                                "With Tess (Roberts) and Rusty (Pitt) at his side, Daniel Ocean (Clooney) must find one more conspirator before he can pull off heists in three different European cities -- Paris, Rome, and Amsterdam.",
                                "Twelve_main.jpg", "Twelve_1.jpg",
                                "Twelve_2.jpg", "Twelve_3.jpg" });
                data
                        .add(new String[] {
                                "Blade: Trinity",
                                "156",
                                "Framed by the Vampire Nation for a series of brutal murders, the Daywalker (Snipes) finds allies in a group of vampire hunters, the Nightstalkers, and together they wage a battle that leads all the way to Dracula himself.",
                                "Blade_main.jpg", "Blade_1.jpg", "Blade_2.jpg",
                                "Blade_3.jpg" });
                data
                        .add(new String[] {
                                "National Treasure",
                                "126",
                                "Benjamin Franklin Gates (Cage) descends from a family of treasure-seekers who've all hunted for the same thing: a war chest hidden by the Founding Fathers prior to the Revolutionary War. Ben's close to discovering its whereabouts, as is his competition, though the FBI is also hip to the hunt.",
                                "Treasure_main.jpg", "Treasure_1.jpg",
                                "Treasure_2.jpg", "Treasure_3.jpg",
                                "Treasure_4.jpg" });
                data
                        .add(new String[] {
                                "Christmas with the Kranks",
                                "92",
                                "Upon receiving a last-minute call from their daughter, Luther and Nora Krank (Allen and Curtis) ditch their vacation plans and scramble to get their home in shape to celebrate Christmas.",
                                "Kranks_main.jpg", "Kranks_1.jpg",
                                "Kranks_2.jpg" });
                data
                        .add(new String[] {
                                "The Polar Express",
                                "215",
                                "A boy's belief in Santa Claus is restored on Christmas Eve when a steam train pulls up in front of his house and whisks him away to the North Pole.",
                                "Polar_main.jpg", "Polar_1.jpg", "Polar_2.jpg",
                                "Polar_3.jpg" });
                data
                        .add(new String[] {
                                "The Incredibles",
                                "186",
                                "Years after their last assignment, a husband and wife superhero team, who currently maintain a ho-hum suburban existence, respond a cryptic communiqué from a remote island base.",
                                "Incredibles_main.jpg", "Incredibles_1.jpg",
                                "Incredibles_2.jpg" });
                data
                        .add(new String[] {
                                "Closer",
                                "145",
                                "Two couples are drawn together by undeniable attraction and a series of chance encounters.",
                                "closer_main.jpg", "closer_1.jpg",
                                "closer_2.jpg", "closer_3.jpg" });

                for (int k = 0; k < data.size(); k++) {

                    String[] sdata = (String[]) data.get(k);
                    //create new movie objects
                    Movie movie = new Movie();
                    //set simple properties
                    movie.setTitle(sdata[0]);
                    movie.setDescription(sdata[2]);
                    movie.setRuntime(Integer.parseInt(sdata[1]));

                    Calendar cal = Calendar.getInstance();
                    cal.set(Calendar.HOUR, 0);
                    cal.set(Calendar.MINUTE, 0);
                    cal.set(Calendar.SECOND, 0);
                    cal.set(Calendar.MILLISECOND, 0);
                    movie.setReleaseDate(cal);

                    //try to get Actors from db
                    List dbprops = s.find("from Actor as actor");
                    assertNotNull(
                            "testCreateDBMovie(): Can't get Actors from DB. Null",
                            dbprops);
                    assertTrue(
                            "testCreateDBMovie(): Can not find Actors in DB",
                            dbprops.size() > 0);

                    int anzahl = 2;
                    List movieprops = new ArrayList();
                    random = new RandomRange(0, (dbprops.size() - 1));
                    randomNum = random.getNumbers(anzahl);
                    for (int i = 0; i < anzahl; i++) {
                        Actor actor = (Actor) dbprops.get(((Integer) randomNum
                                .get(i)).intValue());
                        movieprops.add(actor);
                    }
                    movie.setActors(movieprops);

                    List objects = new ArrayList();

                    //try to get Directors from db
                    dbprops = s.find("from Director as director");
                    assertNotNull(
                            "testCreateDBMovie(): Can't get Directors from DB. Null",
                            dbprops);
                    assertTrue(
                            "testCreateDBMovie(): Can not find Directors in DB",
                            dbprops.size() > 0);

                    anzahl = 1;
                    movieprops = new ArrayList();
                    random = new RandomRange(0, (dbprops.size() - 1));
                    randomNum = random.getNumbers(anzahl);

                    for (int i = 0; i < anzahl; i++) {
                        Director prop = (Director) dbprops
                                .get(((Integer) randomNum.get(i)).intValue());
                        movieprops.add(prop);
                    }
                    movie.setDirector(movieprops);

                    //try to get Genre from db
                    dbprops = s.find("from Genre as genre");
                    assertNotNull(
                            "testCreateDBMovie(): Can't get Genre from DB. Null",
                            dbprops);
                    assertTrue("testCreateDBMovie(): Can not find Genre in DB",
                            dbprops.size() > 0);

                    logger.debug("Anzahl Genres: " + dbprops.size());

                    anzahl = 3;
                    movieprops = new ArrayList();
                    random = new RandomRange(0, (dbprops.size() - 1));
                    randomNum = random.getNumbers(anzahl);

                    for (int i = 0; i < anzahl; i++) {
                        Genre prop = (Genre) dbprops.get(((Integer) randomNum
                                .get(i)).intValue());
                        movieprops.add(prop);
                    }
                    movie.setGenres(movieprops);

                    
                    //set MainImage
                    if( HibernateUtil.getImagename(sdata[3],s) != null){
                        movie.setMainImage(HibernateUtil.getImagename(sdata[3],s));
                    }

                    //set other Images
                    movieprops = new ArrayList();
                    for (int i = 4; i < sdata.length; i++) {
                        
                        if(HibernateUtil.getImagename(sdata[i],s) != null) {
                            movieprops.add(HibernateUtil.getImagename(sdata[i],s));
                        }
         
                    }
                    movie.setImages(movieprops);

                    
                    logger.debug("Speichere Movie Objekt");

                    if (k == 3) continue;
                    s.save(movie);
                    s.flush();
                    logger.debug("ID: "+movie.getMovieId());
                    tx.commit();


                }



            } catch (Exception e) {
                if (tx != null) {
                    logger
                            .error(
                                    "testCreateCompleteNewMovie() - Something went wrong here; discard all partial changes",
                                    e);

                    // Something went wrong; discard all partial changes
                    tx.rollback();
                }
            }

        } catch (Exception e) {
            logger
                    .error(
                            "testCreateCompleteNewMovie() - Error while trying to beginTransaction",
                            e);
            throw e;
        } finally {
            // No matter what, close the session
            HibernateUtil.closeSession();
        }

        if (logger.isDebugEnabled()) {
            logger.debug("testCreateCompleteNewMovie() - end");
        }
    }

    

    
    /**
     * Constructor for TestMovie.
     * @param arg0
     */
    public TestMovie(String arg0) {
        super(arg0);
    }

}