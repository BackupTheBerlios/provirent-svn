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
package de.hsharz.provirent.persistence;

import org.apache.log4j.Logger;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Session;
import net.sf.hibernate.SessionFactory;
import net.sf.hibernate.cfg.Configuration;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import de.hsharz.provirent.objects.Actor;
import de.hsharz.provirent.objects.AudioFormat;
import de.hsharz.provirent.objects.Bill;
import de.hsharz.provirent.objects.Condition;
import de.hsharz.provirent.objects.Customer;
import de.hsharz.provirent.objects.Director;
import de.hsharz.provirent.objects.Dvd;
import de.hsharz.provirent.objects.Genre;
import de.hsharz.provirent.objects.Image;
import de.hsharz.provirent.objects.Language;
import de.hsharz.provirent.objects.Movie;
import de.hsharz.provirent.objects.MovieOrder;
import de.hsharz.provirent.objects.OrderItem;
import de.hsharz.provirent.objects.Payment;
import de.hsharz.provirent.objects.Person;
import de.hsharz.provirent.objects.Status;
import de.hsharz.provirent.objects.Subtitle;
import de.hsharz.provirent.objects.VideoFormat;

/**
 * @author Philipp Schneider
 *  
 */
public class HibernateUtil {
    /**
     * Logger for this class
     */
    private static final Logger logger = Logger.getLogger(HibernateUtil.class);

    private static Log log = LogFactory.getLog(HibernateUtil.class);

    private static final SessionFactory sessionFactory;
    static {
        try {
            //     Create the SessionFactory
            Configuration cfg = new Configuration();
            cfg
            .addClass(Movie.class).addClass(Actor.class)
            .addClass(AudioFormat.class).addClass(Condition.class)
            .addClass(Director.class).addClass(Dvd.class)
            .addClass(Genre.class).addClass(Language.class)
            .addClass(Status.class).addClass(Bill.class)
            .addClass(Subtitle.class).addClass(VideoFormat.class)
            .addClass(Customer.class).addClass(Image.class)
            .addClass(MovieOrder.class).addClass(OrderItem.class)
            .addClass(Person.class).addClass(Payment.class);


            sessionFactory = cfg.buildSessionFactory();
        } catch (Throwable ex) {
            log.error("Initial SessionFactory creation failed.", ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static final ThreadLocal session = new ThreadLocal();

    public static Session currentSession() throws HibernateException {
        if (logger.isDebugEnabled()) {
            logger.debug("currentSession() - start");
        }

        Session s = (Session) session.get();
        //     Open a new Session, if this Thread has none yet
        if (s == null) {
            s = sessionFactory.openSession();
            session.set(s);
        }

        if (logger.isDebugEnabled()) {
            logger.debug("currentSession() - end");
        }
        return s;
    }

    public static void closeSession() throws HibernateException {
        if (logger.isDebugEnabled()) {
            logger.debug("closeSession() - start");
        }

        Session s = (Session) session.get();
        session.set(null);
        if (s != null)
            s.close();

        if (logger.isDebugEnabled()) {
            logger.debug("closeSession() - end");
        }
    }

    
    
    
}