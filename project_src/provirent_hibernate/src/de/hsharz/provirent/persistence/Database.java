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

import java.util.ArrayList;
import java.util.List;

import net.sf.hibernate.Criteria;
import net.sf.hibernate.Hibernate;
import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Session;
import net.sf.hibernate.Transaction;
import net.sf.hibernate.expression.Disjunction;
import net.sf.hibernate.expression.Expression;

import org.apache.log4j.Logger;

import de.hsharz.provirent.objects.*;



/**
 * @author Philipp Schneider
 *
 */
public class Database {
    /**
     * Logger for this class
     */
    private static final Logger logger = Logger.getLogger(Database.class);


    /**
     * This method gets all Directors from the database.
     * searches for firstname or lastname or id
     * @param filter 
     * @return List of Director objects, or an empty List
     */
    public static List getDirectors(final String filter){
        if (logger.isDebugEnabled()) {
            logger.debug("getDirectors() - start. String filter= "+filter);
        }
        //init the returnlist
        List returnlist = new ArrayList();

        Session s = null;
        Transaction tx = null;
        try {
            //get new Session and begin Transaction
            s = HibernateUtil.currentSession();
            tx = s.beginTransaction();

            try {
                
                //init the criteria
                Criteria criteria = s.createCriteria(Director.class);
                //any of the criteria 
                Disjunction any = Expression.disjunction();

                //if filter not empty
                if (filter != null && !filter.equalsIgnoreCase("")) {
                    any.add(Expression.like("lastName", "%"+filter+"%"));
                    any.add(Expression.like("firstName", "%"+filter+"%"));
                    
                    //maybe we are searching for the id?
                    try {
                        any.add(Expression.eq("directorId", new Integer(Integer.parseInt(filter))));
                    } catch (Exception e) {
                    }
                    
                }
                //add all criteria
                criteria.add(any);
                //get the results
                returnlist = criteria.list();


            } catch (Exception e) {
                if (tx != null) {
                    logger
                            .error(
                                    "getDirectors() - Something went wrong here; discard all partial changes",
                                    e);

                    // Something went wrong; discard all partial changes
                    tx.rollback();
                }

		                
            }

        } catch (Exception e) {
            logger.error(
                    "getDirectors() - Error while trying to do Transaction",
                    e);
            returnlist = new ArrayList();
        } finally {
            try {
                // No matter what, close the session
                HibernateUtil.closeSession();
            } catch (HibernateException e1) {
                logger.error("getDirectors() - Could not Close the Session", e1);
            }
        }

        if (logger.isDebugEnabled()) {
            logger.debug("getDirectors() - end");
        }
        return returnlist;
        

    }

    
    
    
    
    /**
     * This method gets all VideoFormats from the database.
     * searches for firstname or lastname or id
     * @param filter 
     * @return List of Director objects, or an empty List
     */
    public static List getVideoFormat(final String filter){
        if (logger.isDebugEnabled()) {
            logger.debug("getVideoFormat() - start. String filter= "+filter);
        }
        //init the returnlist
        List returnlist = new ArrayList();

        Session s = null;
        Transaction tx = null;
        try {
            //get new Session and begin Transaction
            s = HibernateUtil.currentSession();
            tx = s.beginTransaction();

            try {
                
                //init the criteria
                Criteria criteria = s.createCriteria(VideoFormat.class);
                //any of the criteria 
                Disjunction any = Expression.disjunction();

                //if filter not empty
                if (filter != null && !filter.equalsIgnoreCase("")) {
                    any.add(Expression.like("name", "%"+filter+"%"));
                    any.add(Expression.like("shortname", "%"+filter+"%"));
                    
                    //maybe we are searching for the id?
                    try {
                        any.add(Expression.eq("videoFormatId", new Integer(Integer.parseInt(filter))));
                    } catch (Exception e) {
                    }
                    
                }
                //add all criteria
                criteria.add(any);
                //get the results
                returnlist = criteria.list();


            } catch (Exception e) {
                if (tx != null) {
                    logger
                            .error(
                                    "getVideoFormat() - Something went wrong here; discard all partial changes",
                                    e);

                    // Something went wrong; discard all partial changes
                    tx.rollback();
                }

		                
            }

        } catch (Exception e) {
            logger.error(
                    "getVideoFormat() - Error while trying to do Transaction",
                    e);
            returnlist = new ArrayList();
        } finally {
            try {
                // No matter what, close the session
                HibernateUtil.closeSession();
            } catch (HibernateException e1) {
                logger.error("getVideoFormat() - Could not Close the Session", e1);
            }
        }

        if (logger.isDebugEnabled()) {
            logger.debug("getVideoFormat() - end");
        }
        return returnlist;
        

    }

    
    public static VideoFormat getSingleVideoFormat(final int id){
        if (logger.isDebugEnabled()) {
            logger.debug("getSingleVideoFormat() - start. int filter= "+id);
        }
        //init the returnlist
        VideoFormat returnobject = null;

        Session s = null;
        Transaction tx = null;
        try {
            //get new Session and begin Transaction
            s = HibernateUtil.currentSession();
            tx = s.beginTransaction();

            try {

                returnobject = (VideoFormat)s.get(VideoFormat.class, new Integer(id));
                


            } catch (Exception e) {
                if (tx != null) {
                    logger
                            .error(
                                    "getSingleVideoFormat() - Something went wrong here; discard all partial changes",
                                    e);

                    // Something went wrong; discard all partial changes
                    tx.rollback();
                }

		                
            }

        } catch (Exception e) {
            logger.error(
                    "getSingleVideoFormat() - Error while trying to do Transaction",
                    e);
            
        } finally {
            try {
                // No matter what, close the session
                HibernateUtil.closeSession();
            } catch (HibernateException e1) {
                logger.error("getSingleVideoFormat() - Could not Close the Session", e1);
            }
        }

        if (logger.isDebugEnabled()) {
            logger.debug("getSingleVideoFormat() - end");
        }
        return returnobject;
        

    }
    
    
    /**
     * This method gets all AudioFormats from the database.
     * searches for firstname or lastname or id
     * @param filter 
     * @return List of Director objects, or an empty List
     */
    public static List getAudioFormat(final String filter){
        if (logger.isDebugEnabled()) {
            logger.debug("getAudioFormat() - start. String filter= "+filter);
        }
        //init the returnlist
        List returnlist = new ArrayList();

        Session s = null;
        Transaction tx = null;
        try {
            //get new Session and begin Transaction
            s = HibernateUtil.currentSession();
            tx = s.beginTransaction();

            try {
                
                //init the criteria
                Criteria criteria = s.createCriteria(AudioFormat.class);
                //any of the criteria 
                Disjunction any = Expression.disjunction();

                //if filter not empty
                if (filter != null && !filter.equalsIgnoreCase("")) {
                    any.add(Expression.like("name", "%"+filter+"%"));
                    any.add(Expression.like("shortname", "%"+filter+"%"));
                    
                    //maybe we are searching for the id?
                    try {
                        any.add(Expression.eq("audioFormatId", new Integer(Integer.parseInt(filter))));
                    } catch (Exception e) {
                    }
                    
                }
                //add all criteria
                criteria.add(any);
                //get the results
                returnlist = criteria.list();


            } catch (Exception e) {
                if (tx != null) {
                    logger
                            .error(
                                    "getAudioFormat() - Something went wrong here; discard all partial changes",
                                    e);

                    // Something went wrong; discard all partial changes
                    tx.rollback();
                }

		                
            }

        } catch (Exception e) {
            logger.error(
                    "getAudioFormat() - Error while trying to do Transaction",
                    e);
            returnlist = new ArrayList();
        } finally {
            try {
                // No matter what, close the session
                HibernateUtil.closeSession();
            } catch (HibernateException e1) {
                logger.error("getAudioFormat() - Could not Close the Session", e1);
            }
        }

        if (logger.isDebugEnabled()) {
            logger.debug("getAudioFormat() - end");
        }
        return returnlist;
        

    }

     /**
     * Constructor for TestActor.
     * @param arg0
     */
    public Database(String arg0) {

    }

}