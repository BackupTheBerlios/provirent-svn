package test.provirent.hibernate;

import java.util.ArrayList;

import junit.framework.TestCase;
import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Session;
import net.sf.hibernate.Transaction;

import org.apache.log4j.Logger;

import de.hsharz.provirent.objects.Condition;
import de.hsharz.provirent.objects.Dvd;
import de.hsharz.provirent.objects.Movie;
import de.hsharz.provirent.objects.Status;

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
	 * @param arg0
	 */
	public TestDvd(String arg0) {
		super(arg0);
	}

	
	public void testCreateDvd(){
	    
        Session s = null;
        Transaction tx = null;
        RandomRange random;
        
	    
	    try{
	        //s= HibernateUtil.currentSession();
	        //tx = s.beginTransaction();
	        if(false)
	            throw new HibernateException("");
	        
            //is DB open and connected
            //assertTrue("Connected to Db? ", s.isConnected());
            //assertTrue("Db Open? ", s.isOpen());
	        
            
            Dvd dvd = new Dvd();
            
            
            random = new RandomRange(1205, 4523682);
            
            dvd.setBarcode(random.getNumbers(1).get(0)+"");
            
            if (HibernateUtil.getCondition("neu",s) != null){
                dvd.setCondition(HibernateUtil.getCondition("neu",s));
            } else {
                fail("Konnte keine Condition neu aus DB bekommen");
            }
            
            if (HibernateUtil.getStatus("ausleihbar",s) != null){
                dvd.setStatus(HibernateUtil.getStatus("ausleihbar",s));
            } else {
                fail("Konnte keinen Status ausleihbar aus DB bekommen");
            }
            
            
            dvd.setMovie(new Movie());
            
            
            dvd.setLanguages(new ArrayList());
            dvd.setSubtitles(new ArrayList());
            
            dvd.setAudioFormats(new ArrayList());
            dvd.setVideoFormats(new ArrayList());
	        
	        
	    }  catch (HibernateException hex){
	        fail("Fehler beim Session oder Transaction aufbau");
	        logger.error("Fehler beim Session oder Transaction aufbau",hex);
	        
    } finally {
        try {
            // No matter what, close the session
            HibernateUtil.closeSession();
        } catch (HibernateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
	    
	}
}