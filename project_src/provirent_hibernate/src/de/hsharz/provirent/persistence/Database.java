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
import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Session;
import net.sf.hibernate.Transaction;
import net.sf.hibernate.expression.Disjunction;
import net.sf.hibernate.expression.Expression;

import org.apache.log4j.Logger;

import de.hsharz.provirent.objects.AudioFormat;
import de.hsharz.provirent.objects.Condition;
import de.hsharz.provirent.objects.Director;
import de.hsharz.provirent.objects.Genre;
import de.hsharz.provirent.objects.Language;
import de.hsharz.provirent.objects.Status;
import de.hsharz.provirent.objects.Subtitle;
import de.hsharz.provirent.objects.VideoFormat;
import de.hsharz.provirent.objects.Actor;


/**
 * @author Philipp Schneider
 *
 */
public class Database {
    /**
     * Logger for this class
     */
    private static final Logger logger = Logger.getLogger(Database.class);


    public static void initDB() {
        try {
            HibernateUtil.currentSession();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            try {
                HibernateUtil.closeSession();
            } catch (HibernateException e1) {
                e1.printStackTrace();
            }
        }
        
    }
    
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
    public static Object saveObject(Object o) throws DataBaseException{
        if (logger.isDebugEnabled()) {
            logger
                    .debug("saveObject(Object o = " + o
                            + ") - start");
        }
        int exception =0;
        
        Session s = null;
        Transaction tx = null;
  
            try {
                //get new Session and begin Transaction
                s = HibernateUtil.currentSession();
                tx = s.beginTransaction();
                try{
                    s.saveOrUpdate(o);
                } catch (HibernateException e) {
                    logger.error("saveObject(). Fehler beim Speichern/Updaten "
                            +"des Objectes:"+o+" Exception: "+e);
                    exception = 1;
                }
                s.flush();
               
                tx.commit();
                
            } catch (HibernateException e) {
                //exception = 2;
                logger
                .error(
                        "saveObject() - Something went wrong here; discard all partial changes",
                        e);
                
                if (tx != null) {
                    try {
                        // Something went wrong; discard all partial changes
                        tx.rollback();
                    } catch (HibernateException e1) {
                        e1.printStackTrace();
                    }
                }    

            } finally {
                try {
                    // No matter what, close the session
                    HibernateUtil.closeSession();
                } catch (HibernateException e1) {
                    
                    logger.error("saveObject() - Could not Close the Session", e1);
                    
                }
            }

            if (exception > 0) {
                throw new DataBaseException("exception");
            }
            
        if (logger.isDebugEnabled()) {
            logger.debug("saveObject(VideoFormat) - end");
        }
        return o;
    }
    
  
    
    public static void deleteObject(Object o) throws DataBaseException{
        if (logger.isDebugEnabled()) {
            logger.debug("deleteObject(Object o = " + o + ") - start");
        }
        int exception =0;
        
        Session s = null;
        Transaction tx = null;
  
            try {
                //get new Session and begin Transaction
                s = HibernateUtil.currentSession();
                tx = s.beginTransaction();
                
                try{
                    s.delete(o);
                
                } catch (HibernateException e) {
                    logger.error("saveObject(). Fehler beim Speichern/Updaten "
                            + "des Objectes:" + o + " Exception: " + e);
                    exception = 1;
                }
               
                

                //s.flush();
                
                tx.commit();
                
                o= null;
                
            } catch (HibernateException e) {
                exception = 2;
                logger.error("Message "+  e.getMessages().toString()); 
                logger
                        .error(
                                "deleteObject(Object) - Something went wrong here; discard all partial changes",
                                e);
                if (tx != null) {
                    try {
                        // Something went wrong; discard all partial changes
                        tx.rollback();
                    } catch (HibernateException e1) {
                        e1.printStackTrace();
                    }
                }    

            } finally {
                try {
                    // No matter what, close the session
                    HibernateUtil.closeSession();
                } catch (HibernateException e1) {
                    
                    logger
                            .error(
                                    "deleteObject(Object) - Could not Close the Session",
                                    e1);
                    
                }
            }

            if (exception > 0) {
                throw new DataBaseException("exception");
            }
            
        if (logger.isDebugEnabled()) {
            logger.debug("deleteObject(Object) - end");
        }
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
        
        try {
            //get new Session and begin Transaction
            s = HibernateUtil.currentSession();
                
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

                returnobject = (VideoFormat)s.get(VideoFormat.class, new Integer(id));

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

        try {
            //get new Session and begin Transaction
            s = HibernateUtil.currentSession();
                
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
	 * This method gets all Genres from the database.
	 * searches for firstname or lastname or id
	 * @param filter 
	 * @return List of Director objects, or an empty List
	 */
	public static List getGenre(final String filter){
	    if (logger.isDebugEnabled()) {
	        logger.debug("getGenre() - start. String filter= "+filter);
	    }
	    //init the returnlist
	    List returnlist = new ArrayList();
	
	    Session s = null;
	    
	    try {
	        //get new Session and begin Transaction
	        s = HibernateUtil.currentSession();
	            
	            //init the criteria
	            Criteria criteria = s.createCriteria(Genre.class);
	            //any of the criteria 
	            Disjunction any = Expression.disjunction();
	
	            //if filter not empty
	            if (filter != null && !filter.equalsIgnoreCase("")) {
	                any.add(Expression.like("name", "%"+filter+"%"));
	                any.add(Expression.like("shortname", "%"+filter+"%"));
	                
	                //maybe we are searching for the id?
	                try {
	                    any.add(Expression.eq("genreId", new Integer(Integer.parseInt(filter))));
	                } catch (Exception e) {
	                }
	                
	            }
	            //add all criteria
	            criteria.add(any);
	            //get the results
	            returnlist = criteria.list();
	
	
	
	
	    } catch (Exception e) {
	        logger.error(
	                "getGenre() - Error while trying to do Transaction",
	                e);
	        returnlist = new ArrayList();
	    } finally {
	        try {
	            // No matter what, close the session
	            HibernateUtil.closeSession();
	        } catch (HibernateException e1) {
	            logger.error("getGenre() - Could not Close the Session", e1);
	        }
	    }
	
	    if (logger.isDebugEnabled()) {
	        logger.debug("getGenre() - end");
	    }
	    return returnlist;
	    
	
	}
	
	
	public static Genre getSingleGenre(final int id){
	    if (logger.isDebugEnabled()) {
	        logger.debug("getSingleGenre() - start. int filter= "+id);
	    }
	    //init the returnlist
	    Genre returnobject = null;
	
	    Session s = null;
	    Transaction tx = null;
	    try {
	        //get new Session and begin Transaction
	        s = HibernateUtil.currentSession();
	
	            returnobject = (Genre)s.get(Genre.class, new Integer(id));
	
	    } catch (Exception e) {
	        logger.error(
	                "getSingleGenre() - Error while trying to do Transaction",
	                e);
	        
	    } finally {
	        try {
	            // No matter what, close the session
	            HibernateUtil.closeSession();
	        } catch (HibernateException e1) {
	            logger.error("getSingleGenre() - Could not Close the Session", e1);
	        }
	    }
	
	    if (logger.isDebugEnabled()) {
	        logger.debug("getSingleGenre() - end");
	    }
	    return returnobject;
	    
	
	}
	
	/**
	 * This method gets all Languages from the database.
	 * searches for firstname or lastname or id
	 * @param filter 
	 * @return List of Director objects, or an empty List
	 */
	public static List getLanguage(final String filter){
	    if (logger.isDebugEnabled()) {
	        logger.debug("getLanguage() - start. String filter= "+filter);
	    }
	    //init the returnlist
	    List returnlist = new ArrayList();
	
	    Session s = null;
	    
	    try {
	        //get new Session and begin Transaction
	        s = HibernateUtil.currentSession();
	            
	            //init the criteria
	            Criteria criteria = s.createCriteria(Language.class);
	            //any of the criteria 
	            Disjunction any = Expression.disjunction();
	
	            //if filter not empty
	            if (filter != null && !filter.equalsIgnoreCase("")) {
	                any.add(Expression.like("name", "%"+filter+"%"));
	                any.add(Expression.like("shortname", "%"+filter+"%"));
	                
	                //maybe we are searching for the id?
	                try {
	                    any.add(Expression.eq("languageId", new Integer(Integer.parseInt(filter))));
	                } catch (Exception e) {
	                }
	                
	            }
	            //add all criteria
	            criteria.add(any);
	            //get the results
	            returnlist = criteria.list();
	
	
	
	
	    } catch (Exception e) {
	        logger.error(
	                "getLanguage() - Error while trying to do Transaction",
	                e);
	        returnlist = new ArrayList();
	    } finally {
	        try {
	            // No matter what, close the session
	            HibernateUtil.closeSession();
	        } catch (HibernateException e1) {
	            logger.error("getLanguage() - Could not Close the Session", e1);
	        }
	    }
	
	    if (logger.isDebugEnabled()) {
	        logger.debug("getLanguage() - end");
	    }
	    return returnlist;
	    
	
	}
	
	
	public static Language getSingleLanguage(final int id){
	    if (logger.isDebugEnabled()) {
	        logger.debug("getSingleLanguage() - start. int filter= "+id);
	    }
	    //init the returnlist
	    Language returnobject = null;
	
	    Session s = null;
	    Transaction tx = null;
	    try {
	        //get new Session and begin Transaction
	        s = HibernateUtil.currentSession();
	
	            returnobject = (Language)s.get(Language.class, new Integer(id));
	
	    } catch (Exception e) {
	        logger.error(
	                "getSingleLanguage() - Error while trying to do Transaction",
	                e);
	        
	    } finally {
	        try {
	            // No matter what, close the session
	            HibernateUtil.closeSession();
	        } catch (HibernateException e1) {
	            logger.error("getSingleLanguage() - Could not Close the Session", e1);
	        }
	    }
	
	    if (logger.isDebugEnabled()) {
	        logger.debug("getSingleLanguage() - end");
	    }
	    return returnobject;
	    
	
	}

	/**
	 * This method gets all Actor from the database.
	 * searches for firstname or lastname or id
	 * @param filter 
	 * @return List of Director objects, or an empty List
	 */
	public static List getActor(final String filter){
	    if (logger.isDebugEnabled()) {
	        logger.debug("getActor() - start. String filter= "+filter);
	    }
	    //init the returnlist
	    List returnlist = new ArrayList();
	
	    Session s = null;
	    
	    try {
	        //get new Session and begin Transaction
	        s = HibernateUtil.currentSession();
	            
	            //init the criteria
	            Criteria criteria = s.createCriteria(Actor.class);
	            //any of the criteria 
	            Disjunction any = Expression.disjunction();
	
	            //if filter not empty
	            if (filter != null && !filter.equalsIgnoreCase("")) {
	                any.add(Expression.like("firstName", "%"+filter+"%"));
	                any.add(Expression.like("lastName", "%"+filter+"%"));
	                
	                //maybe we are searching for the id?
	                try {
	                    any.add(Expression.eq("actorId", new Integer(Integer.parseInt(filter))));
	                } catch (Exception e) {
	                }
	                
	            }
	            //add all criteria
	            criteria.add(any);
	            //get the results
	            returnlist = criteria.list();
	
	
	
	
	    } catch (Exception e) {
	        logger.error(
	                "getActor() - Error while trying to do Transaction",
	                e);
	        returnlist = new ArrayList();
	    } finally {
	        try {
	            // No matter what, close the session
	            HibernateUtil.closeSession();
	        } catch (HibernateException e1) {
	            logger.error("getActor() - Could not Close the Session", e1);
	        }
	    }
	
	    if (logger.isDebugEnabled()) {
	        logger.debug("getActor() - end");
	    }
	    return returnlist;
	    	
	}
	
	
	public static Actor getSingleActor(final int id){
	    if (logger.isDebugEnabled()) {
	        logger.debug("getSingleActor() - start. int filter= "+id);
	    }
	    //init the returnlist
	    Actor returnobject = null;
	
	    Session s = null;
	    Transaction tx = null;
	    try {
	        //get new Session and begin Transaction
	        s = HibernateUtil.currentSession();
	
	            returnobject = (Actor)s.get(Actor.class, new Integer(id));
	
	    } catch (Exception e) {
	        logger.error(
	                "getSingleActor() - Error while trying to do Transaction",
	                e);
	        
	    } finally {
	        try {
	            // No matter what, close the session
	            HibernateUtil.closeSession();
	        } catch (HibernateException e1) {
	            logger.error("getSingleActor() - Could not Close the Session", e1);
	        }
	    }
	
	    if (logger.isDebugEnabled()) {
	        logger.debug("getSingleActor() - end");
	    }
	    return returnobject;
	    	
	}
	
	/**
	 * This method gets all Subtitles from the database.
	 * searches for name or shortname or id
	 * @param filter 
	 * @return List of Subtitle objects, or an empty List
	 */
	public static List getSubtitle(final String filter){
	    if (logger.isDebugEnabled()) {
	        logger.debug("getSubtitle() - start. String filter= "+filter);
	    }
	    //init the returnlist
	    List returnlist = new ArrayList();
	
	    Session s = null;
	    
	    try {
	        //get new Session and begin Transaction
	        s = HibernateUtil.currentSession();
	            
	            //init the criteria
	            Criteria criteria = s.createCriteria(Subtitle.class);
	            //any of the criteria 
	            Disjunction any = Expression.disjunction();
	
	            //if filter not empty
	            if (filter != null && !filter.equalsIgnoreCase("")) {
	                any.add(Expression.like("name", "%"+filter+"%"));
	                any.add(Expression.like("shortname", "%"+filter+"%"));
	                
	                //maybe we are searching for the id?
	                try {
	                    any.add(Expression.eq("subtitleId", new Integer(Integer.parseInt(filter))));
	                } catch (Exception e) {
	                }
	                
	            }
	            //add all criteria
	            criteria.add(any);
	            //get the results
	            returnlist = criteria.list();
	
	
	
	
	    } catch (Exception e) {
	        logger.error(
	                "getSubtitle() - Error while trying to do Transaction",
	                e);
	        returnlist = new ArrayList();
	    } finally {
	        try {
	            // No matter what, close the session
	            HibernateUtil.closeSession();
	        } catch (HibernateException e1) {
	            logger.error("getSubtitle() - Could not Close the Session", e1);
	        }
	    }
	
	    if (logger.isDebugEnabled()) {
	        logger.debug("getSubtitle() - end");
	    }
	    return returnlist;
	    
	
	}
	
	
	public static Subtitle getSingleSubtitle(final int id){
	    if (logger.isDebugEnabled()) {
	        logger.debug("getSingleSubtitle() - start. int filter= "+id);
	    }
	    //init the returnlist
	    Subtitle returnobject = null;
	
	    Session s = null;
	    Transaction tx = null;
	    try {
	        //get new Session and begin Transaction
	        s = HibernateUtil.currentSession();
	
	            returnobject = (Subtitle)s.get(Subtitle.class, new Integer(id));
	
	    } catch (Exception e) {
	        logger.error(
	                "getSingleSubtitle() - Error while trying to do Transaction",
	                e);
	        
	    } finally {
	        try {
	            // No matter what, close the session
	            HibernateUtil.closeSession();
	        } catch (HibernateException e1) {
	            logger.error("getSingleSubtitle() - Could not Close the Session", e1);
	        }
	    }
	
	    if (logger.isDebugEnabled()) {
	        logger.debug("getSingleSubtitle() - end");
	    }
	    return returnobject;
	    
	
	}
	
	/**
	 * This method gets all Status from the database.
	 * searches for name or shortname or id
	 * @param filter 
	 * @return List of Status objects, or an empty List
	 */
	public static List getStatus(final String filter){
	    if (logger.isDebugEnabled()) {
	        logger.debug("getStatus() - start. String filter= "+filter);
	    }
	    //init the returnlist
	    List returnlist = new ArrayList();
	
	    Session s = null;
	    
	    try {
	        //get new Session and begin Transaction
	        s = HibernateUtil.currentSession();
	            
	            //init the criteria
	            Criteria criteria = s.createCriteria(Status.class);
	            //any of the criteria 
	            Disjunction any = Expression.disjunction();
	
	            //if filter not empty
	            if (filter != null && !filter.equalsIgnoreCase("")) {
	                any.add(Expression.like("statusName", "%"+filter+"%"));
	                any.add(Expression.like("statusShortname", "%"+filter+"%"));
	                
	                //maybe we are searching for the id?
	                try {
	                    any.add(Expression.eq("statusId", new Integer(Integer.parseInt(filter))));
	                } catch (Exception e) {
	                }
	                
	            }
	            //add all criteria
	            criteria.add(any);
	            //get the results
	            returnlist = criteria.list();
	
	
	
	
	    } catch (Exception e) {
	        logger.error(
	                "getStatus() - Error while trying to do Transaction",
	                e);
	        returnlist = new ArrayList();
	    } finally {
	        try {
	            // No matter what, close the session
	            HibernateUtil.closeSession();
	        } catch (HibernateException e1) {
	            logger.error("getStatus() - Could not Close the Session", e1);
	        }
	    }
	
	    if (logger.isDebugEnabled()) {
	        logger.debug("getStatus() - end");
	    }
	    return returnlist;
	    
	
	}
	
	
	public static Status getSingleStatus(final int id){
	    if (logger.isDebugEnabled()) {
	        logger.debug("getSingleStatus() - start. int filter= "+id);
	    }
	    //init the returnlist
	    Status returnobject = null;
	
	    Session s = null;
	    Transaction tx = null;
	    try {
	        //get new Session and begin Transaction
	        s = HibernateUtil.currentSession();
	
	            returnobject = (Status)s.get(Status.class, new Integer(id));
	
	    } catch (Exception e) {
	        logger.error(
	                "getSingleStatus() - Error while trying to do Transaction",
	                e);
	        
	    } finally {
	        try {
	            // No matter what, close the session
	            HibernateUtil.closeSession();
	        } catch (HibernateException e1) {
	            logger.error("getSingleStatus() - Could not Close the Session", e1);
	        }
	    }
	
	    if (logger.isDebugEnabled()) {
	        logger.debug("getSingleStatus() - end");
	    }
	    return returnobject;
	    
	
	}
	
    /**
	 * This method gets all Conditions from the database.
	 * searches for name or shortname or id
	 * @param filter 
	 * @return List of Condition objects, or an empty List
	 */
	public static List getCondition(final String filter){
	    if (logger.isDebugEnabled()) {
	        logger.debug("getCondition() - start. String filter= "+filter);
	    }
	    //init the returnlist
	    List returnlist = new ArrayList();
	
	    Session s = null;
	    
	    try {
	        //get new Session and begin Transaction
	        s = HibernateUtil.currentSession();
	            
	            //init the criteria
	            Criteria criteria = s.createCriteria(Condition.class);
	            //any of the criteria 
	            Disjunction any = Expression.disjunction();
	
	            //if filter not empty
	            if (filter != null && !filter.equalsIgnoreCase("")) {
	                any.add(Expression.like("conditionName", "%"+filter+"%"));
	                any.add(Expression.like("conditionshortname", "%"+filter+"%"));
	                
	                //maybe we are searching for the id?
	                try {
	                    any.add(Expression.eq("conditionId", new Integer(Integer.parseInt(filter))));
	                } catch (Exception e) {
	                }
	                
	            }
	            //add all criteria
	            criteria.add(any);
	            //get the results
	            returnlist = criteria.list();
	
	
	
	
	    } catch (Exception e) {
	        logger.error(
	                "getCondition() - Error while trying to do Transaction",
	                e);
	        returnlist = new ArrayList();
	    } finally {
	        try {
	            // No matter what, close the session
	            HibernateUtil.closeSession();
	        } catch (HibernateException e1) {
	            logger.error("getCondition() - Could not Close the Session", e1);
	        }
	    }
	
	    if (logger.isDebugEnabled()) {
	        logger.debug("getCondition() - end");
	    }
	    return returnlist;
	    
	
	}
	
	
	public static Condition getSingleCondition(final int id){
	    if (logger.isDebugEnabled()) {
	        logger.debug("getSingleCondition() - start. int filter= "+id);
	    }
	    //init the returnlist
	    Condition returnobject = null;
	
	    Session s = null;
	    Transaction tx = null;
	    try {
	        //get new Session and begin Transaction
	        s = HibernateUtil.currentSession();
	
	            returnobject = (Condition)s.get(Condition.class, new Integer(id));
	
	    } catch (Exception e) {
	        logger.error(
	                "getSingleCondition() - Error while trying to do Transaction",
	                e);
	        
	    } finally {
	        try {
	            // No matter what, close the session
	            HibernateUtil.closeSession();
	        } catch (HibernateException e1) {
	            logger.error("getSingleCondition() - Could not Close the Session", e1);
	        }
	    }
	
	    if (logger.isDebugEnabled()) {
	        logger.debug("getSingleCondition() - end");
	    }
	    return returnobject;
	    
	
	}

	/**
	 * This method gets all Directors from the database.
	 * searches for firstname or lastname or id
	 * @param filter 
	 * @return List of Director objects, or an empty List
	 */
	public static List getDirector(final String filter){
	    if (logger.isDebugEnabled()) {
	        logger.debug("getDirector() - start. String filter= "+filter);
	    }
	    //init the returnlist
	    List returnlist = new ArrayList();
	
	    Session s = null;
	    
	    try {
	        //get new Session and begin Transaction
	        s = HibernateUtil.currentSession();
	            
	            //init the criteria
	            Criteria criteria = s.createCriteria(Director.class);
	            //any of the criteria 
	            Disjunction any = Expression.disjunction();
	
	            //if filter not empty
	            if (filter != null && !filter.equalsIgnoreCase("")) {
	                any.add(Expression.like("firstName", "%"+filter+"%"));
	                any.add(Expression.like("lastName", "%"+filter+"%"));
	                
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
	        logger.error(
	                "getDirector() - Error while trying to do Transaction",
	                e);
	        returnlist = new ArrayList();
	    } finally {
	        try {
	            // No matter what, close the session
	            HibernateUtil.closeSession();
	        } catch (HibernateException e1) {
	            logger.error("getDirector() - Could not Close the Session", e1);
	        }
	    }
	
	    if (logger.isDebugEnabled()) {
	        logger.debug("getDirector() - end");
	    }
	    return returnlist;
	    	
	}
	
	
	public static Director getSingleDirector(final int id){
	    if (logger.isDebugEnabled()) {
	        logger.debug("getSingleDirector() - start. int filter= "+id);
	    }
	    //init the returnlist
	    Director returnobject = null;
	
	    Session s = null;
	    Transaction tx = null;
	    try {
	        //get new Session and begin Transaction
	        s = HibernateUtil.currentSession();
	
	            returnobject = (Director)s.get(Director.class, new Integer(id));
	
	    } catch (Exception e) {
	        logger.error(
	                "getSingleDirector() - Error while trying to do Transaction",
	                e);
	        
	    } finally {
	        try {
	            // No matter what, close the session
	            HibernateUtil.closeSession();
	        } catch (HibernateException e1) {
	            logger.error("getSingleDirector() - Could not Close the Session", e1);
	        }
	    }
	
	    if (logger.isDebugEnabled()) {
	        logger.debug("getSingleDirector() - end");
	    }
	    return returnobject;
	    	
	}
	
	
	/**
     * Constructor for TestActor.
     * @param arg0
     */
    public Database(String arg0) {

    }

}
