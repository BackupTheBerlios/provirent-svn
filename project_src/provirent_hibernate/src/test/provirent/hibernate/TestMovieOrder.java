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

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import junit.framework.TestCase;
import net.sf.hibernate.Criteria;
import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Session;
import net.sf.hibernate.Transaction;
import net.sf.hibernate.expression.Expression;
import net.sf.hibernate.expression.Order;
import de.hsharz.provirent.objects.Customer;
import de.hsharz.provirent.objects.Dvd;
import de.hsharz.provirent.objects.MovieOrder;
import de.hsharz.provirent.objects.OrderItem;
import de.hsharz.provirent.objects.Payment;

/**
 * @author Philipp Schneider
 *
 */
public class TestMovieOrder extends TestCase {
    /**
     * Logger for this class
     */
    private static final Logger logger = Logger.getLogger(TestMovieOrder.class);

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
     * Constructor for TestOrder.
     * @param arg0
     */
    public TestMovieOrder(String arg0) {
        super(arg0);
    }

    public void testCreateMovieOrder() {

        Session s = null;
        Transaction tx = null;

        try {
            s = HibernateUtil.currentSession();
            tx = s.beginTransaction();

            List customers = s.find("from Customer as customer");
            assertNotNull(
                    "testCreateMovieOrder(): Can't get Customer from DB. Null",
                    customers);
            assertTrue(
                    "testCreateMovieOrder(): Can not find Customer in DB",
                    customers.size() > 0);
            
            List dvds = s.find("from Dvd as dvd");
            assertNotNull(
                    "testCreateMovieOrder(): Can't get Dvd from DB. Null",
                    dvds);
            assertTrue(
                    "testCreateMovieOrder(): Can not find Dvd in DB",
                    dvds.size() > 0);          
            
            //for each movie 
            for (int i = 0; i < customers.size(); i++) {

                Customer customer = (Customer) customers.get(i);


                MovieOrder movieOrder = new MovieOrder();
                movieOrder.setCustomer(customer);

                List orderItems = new ArrayList();

                
                for (int j = 0; j < 3; j++) {

                    OrderItem orderItem = new OrderItem();
                    orderItem.setCustomer(customer);
                    orderItem.setDuration(2);

                    
                    Dvd dvd = (Dvd)dvds.get(j % dvds.size());
                    orderItem.setDvd(dvd);
                    
                    orderItem.setOrderTime(Calendar.getInstance());
                    

                    
                    //get the Payment where the PaymentCategory are the one
                    //from dvd and the date is the highest
                    
                    List payment = s.createCriteria(Payment.class)
            				.addOrder(Order.desc("startdate"))
            				.setMaxResults(1)
            				.createAlias("PaymentCategory", "pc")
            				.add(Expression.eq("pc.name",dvd.getPaymentCategory().getName()))
            				.list();
                    assertNotNull(
                            "testCreateMovieOrder(): Can't get Payment from DB. Null",
                            payment);
                    assertTrue(
                            "testCreateMovieOrder(): Can not find Payment in DB",
                            payment.size() > 0);  
            		
                    
                    orderItem.setPayment((Payment)payment.get(0));

                    //this data is to be set when the dvd is beeing
                    //send to the customer
                    orderItem.setConditionSend(null);
                    orderItem.setSenderTime(null);

                    //this data is set when the dvd is beeig received
                    //from the customer
                    orderItem.setReceivingTime(null);
                    orderItem.setConditionReceiving(null);

                    //add to the List
                    orderItems.add(orderItem);
                }

                movieOrder.setMovieOrderItems(orderItems);

                //save the movieOrder
                logger.debug("MovieOrder: "+movieOrder);
                s.save(movieOrder);
                s.flush();
                tx.commit();
            }
        } catch (HibernateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}