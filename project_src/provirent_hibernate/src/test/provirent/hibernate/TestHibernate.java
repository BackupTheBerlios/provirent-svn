/*
 * Created on 07.10.2004
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

import net.sf.hibernate.Session;
import net.sf.hibernate.SessionFactory;
import net.sf.hibernate.Transaction;
import net.sf.hibernate.cfg.Configuration;
import de.hsharz.provirent.objects.Actor;
import de.hsharz.provirent.objects.AudioFormat;
import de.hsharz.provirent.objects.Condition;
import de.hsharz.provirent.objects.Director;
import de.hsharz.provirent.objects.Dvd;
import de.hsharz.provirent.objects.Genre;
import de.hsharz.provirent.objects.Language;
import de.hsharz.provirent.objects.Movie;
import de.hsharz.provirent.objects.Status;
import de.hsharz.provirent.objects.Subtitle;
import de.hsharz.provirent.objects.VideoFormat;


/**
 * @author Philipp Schneider
 *  
 */
public class TestHibernate {

    public static void main(String args[]) throws Exception {
        TestHibernate th = new TestHibernate();
        //th.saveObjects();
        th.getObjects();
    }
    

        



    public void getObjects() throws Exception {
        Configuration config = new Configuration();

        // Tell it about the classes we want mapped, taking advantage
        // of
        // the way we've named their mapping documents.
        config.addClass(Movie.class).addClass(Actor.class)
        .addClass(AudioFormat.class).addClass(Condition.class)
        .addClass(Director.class).addClass(Dvd.class)
.addClass(Genre.class).addClass(Language.class)
.addClass(Status.class)
.addClass(Subtitle.class).addClass(VideoFormat.class);

        // Get the session factory we can use for persistence
        SessionFactory sessionFactory = config.buildSessionFactory();

        // Ask for a session using the JDBC information we've
        // configured
        Session session = sessionFactory.openSession();
        try {
            int id = 1;
            Dvd movie = (Dvd) session.get(Dvd.class, new Integer(id));
            if (movie == null) {
                System.out.println("Keine Dvd mit id " + id + "gefunden");
                return;
            }
            System.out.println("DVD gefunden: " + movie.toString());
            

        } finally {
            // No matter what, close the session
            session.close();
        }

        // Clean up after ourselves
        sessionFactory.close();
    }

    public void saveObjects() throws Exception {
        // Create a configuration based on the properties file we've put
        // in the standard place.
        Configuration config = new Configuration();

        // Tell it about the classes we want mapped, taking advantage of
        // the way we've named their mapping documents.
        config.addClass(Movie.class).addClass(Actor.class)
        .addClass(AudioFormat.class).addClass(Condition.class)
        .addClass(Director.class).addClass(Dvd.class)
.addClass(Genre.class).addClass(Language.class)
.addClass(Status.class)
.addClass(Subtitle.class).addClass(VideoFormat.class);

        // Get the session factory we can use for persistence
        SessionFactory sessionFactory = config.buildSessionFactory();

        // Ask for a session using the JDBC information we've configured
        Session s = sessionFactory.openSession();
        Transaction tx = null;
        try {
            // Create some data and persist it
            tx = s.beginTransaction();
            
            Movie movie = new Movie();
            movie.setTitle("Fluch der Karibik");
            movie.setDescription("eine interaktive Geschichte eines Piraten");

            Actor actor1 = new Actor("Johnny", "Depp");
            Actor actor2 = new Actor("Geoffrey", "Rush");
            Actor actor3 = new Actor("Gore", "Verbinski ");
            Actor actor4 = new Actor("Julianne", "Moore ");
            Actor actor5 = new Actor("Anthony", "Edwards ");
            Actor actor6 = new Actor("Matthew", "Pleszewicz ");
            Actor actor7 = new Actor("Christopher", "Kovaleski ");
            s.save(actor1);
            s.save(actor2);
            s.save(actor3);
            s.save(actor4);
            s.save(actor5);
            s.save(actor6);
            s.save(actor7);
            s.flush();

            ArrayList actors = new ArrayList();
            actors.add(actor1);
            actors.add(actor2);
            movie.setActors(actors);
            
            

            Director d1 = new Director("Bibo","Bergeron");
            Director d2 = new Director("Vicky","Jenson");
            Director d3 = new Director("Jay","Russell");
            Director d4 = new Director("Joseph","Ruben");
            s.save(d1);
            s.save(d2);
            s.save(d3);
            s.save(d4);
            s.flush();

			movie.setDirector(new ArrayList());
            movie.getDirector().add(d1);

            Language l1 = new Language("Deutsch", "de");
            Language l2 = new Language("Englisch", "en");
            Language l3 = new Language("Franzoesisch", "fr");
            Language l4 = new Language("Spanisch", "es");
            Language l5 = new Language("Japanisch", "jp");
            s.save(l1);
            s.save(l2);
            s.save(l3);
            s.save(l4);
            s.save(l5);
            s.flush();

            
            
            
            
            Subtitle s1 = new Subtitle("Deutsch", "de");
            Subtitle s2 = new Subtitle("Englisch", "en");
            Subtitle s3 = new Subtitle("Franzoesisch", "fr");
            Subtitle s4 = new Subtitle("Spanisch", "es");
            Subtitle s5 = new Subtitle("Japanisch", "jp");        
            s.save(s1);
            s.save(s2);
            s.save(s3);
            s.save(s4);
            s.save(s5);
            s.flush();

            
            Genre g1 = new Genre("Action","");
            Genre g2 = new Genre("Abenteuer","");
            Genre g3 = new Genre("Dokumentation","");
            s.save(g1);
            s.save(g2);
            s.save(g3);
            s.flush();
       
            movie.setGenres(new ArrayList());
            movie.getGenres().add(g1);
            
            AudioFormat a1 = new AudioFormat("DTS Surround Sound","");
            AudioFormat a2 = new AudioFormat("Surround Sound","");
            AudioFormat a3 = new AudioFormat("Dolby","");
            AudioFormat a4 = new AudioFormat("Stereo","");
            s.save(a1);
            s.save(a2);
            s.save(a3);
            s.save(a4);
            s.flush();
             
            
            VideoFormat v1 = new VideoFormat("2.35:1","");
            s.save(v1);
            s.flush();
          
          
            s.save(movie);

            System.out.println("MovieID: " + movie.getMovieId());
            System.out.println("Movie Actors vor: " + movie.getActors());
            s.flush();
            System.out.println("Movie Actors nach: " + movie.getActors());


            

            Dvd dvd = new Dvd();
            dvd.setMovie(movie);
            
            Status status1 = new Status("ausleihbar","");
            Status status2 = new Status("verliehen","");
            Status status3 = new Status("in Bearbeitung","");
            s.save(status1);
            s.save(status2);
            s.save(status3);
            s.flush();

            dvd.setStatus(status1);
            
            Condition con1 = new Condition("neu","");
            Condition con2 = new Condition("leichte Kratzer","");
            Condition con3 = new Condition("mittlere Kratzer","");
            Condition con4 = new Condition("schwere Kratzer","");
            Condition con5 = new Condition("nicht lesbar","");
            s.save(con1);
            s.save(con2);
            s.save(con3);
            s.save(con4);
            s.save(con5);
            s.flush();
            
            dvd.setCondition(con1);
            dvd.setBarcode("01246682");
            
            s.save(dvd);
            s.flush();
            System.out.println("DVD ID: " + dvd.getDvdId());

            
            
            // We're done; make our changes permanent
            tx.commit();

        } catch (Exception e) {
            if (tx != null) {
                // Something went wrong; discard all partial changes
                tx.rollback();
            }
            throw e;
        } finally {
            // No matter what, close the session
            s.close();
        }

        // Clean up after ourselves
        sessionFactory.close();
    }

}