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

import net.sf.hibernate.*;
import net.sf.hibernate.cfg.Configuration;

import java.sql.Time;
import java.util.Date;

import de.hsharz.provirent.objects.*;

/**
 * @author Philipp Schneider
 *
 */
public class TestHibernate {




      public static void main(String args[]) throws Exception {
        // Create a configuration based on the properties file we've put
        // in the standard place.
        Configuration config = new Configuration();

        // Tell it about the classes we want mapped, taking advantage of
        // the way we've named their mapping documents.
        config.addClass(Movie.class);

        // Get the session factory we can use for persistence
        SessionFactory sessionFactory = config.buildSessionFactory();

        // Ask for a session using the JDBC information we've configured
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            // Create some data and persist it
            tx = session.beginTransaction();

            Movie movie = new Movie("Fluch der Karibik", "Piranten Film", 180, new Date());
            
            session.save(movie);

            System.out.println("MovieID: " + movie.getMovieId() );
            
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
               session.close();
          }

          // Clean up after ourselves
          sessionFactory.close();
       }
    
    
    
    
}
