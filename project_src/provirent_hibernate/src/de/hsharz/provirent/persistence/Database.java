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

import de.hsharz.provirent.objects.Director;



/**
 * @author Philipp Schneider
 *
 */
public class Database {
    /**
     * Logger for this class
     */
    private static final Logger logger = Logger.getLogger(Database.class);


    public static List getDirectors(final String filter){
        if (logger.isDebugEnabled()) {
            logger.debug("getDirectors() - start. String filter= "+filter);
        }

        List returnlist = new ArrayList();
        //get new Session and begin Transaction
        Session s = null;
        Transaction tx = null;
        try {
            s = HibernateUtil.currentSession();
            tx = s.beginTransaction();

            try {
                
                Criteria criteria = s.createCriteria(Director.class);
                Disjunction any = Expression.disjunction();
                
                
                
                if (filter == null || filter.equalsIgnoreCase("")) {
                	
                } else {
                    any.add(Expression.like("lastName", "%"+filter+"%"));
                    any.add(Expression.like("firstName", "%"+filter+"%"));
                    
                    try {
                        any.add(Expression.eq("directorId", new Integer(Integer.parseInt(filter))));
                    } catch (Exception e) {
                    }
                    
                }

                criteria.add(any);
                returnlist = criteria.list();

                
                
                tx.commit();

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
                    "getDirectors() - Error while trying to beginTransaction",
                    e);
            returnlist = new ArrayList();
        } finally {
            try {
                // No matter what, close the session
                HibernateUtil.closeSession();
            } catch (HibernateException e1) {
                logger.error("getDirectors()", e1);

                // TODO Auto-generated catch block

            }
        }

        if (logger.isDebugEnabled()) {
            logger.debug("getDirectors() - end");
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