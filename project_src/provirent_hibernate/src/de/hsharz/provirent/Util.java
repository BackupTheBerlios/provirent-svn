/*
 * Created on 01.11.2004
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
package de.hsharz.provirent;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.util.Calendar;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;

import de.hsharz.provirent.persistence.DataBaseException;

/**
 * @author Philipp Schneider
 *  
 */
public class Util {
    /**
     * Logger for this class
     */
    private static final Logger logger = Logger.getLogger(Util.class);

    private static final String MAIL_SERVER = "phil-schneider.de";

    private static final String MAIL_PORT = "";

    private static final String MAIL_USER = "web2_103p9";

    private static final String MAIL_PASS = "jboss14";

    public Util() {

    }

    public static void sendemail(final String toEmail, final String toName,
            final String subject, final String plainText, final String htmlText)
            throws MessagingException, UnsupportedEncodingException {

        Properties props = new Properties();
        Session session = Session.getDefaultInstance(props, null);
        MimeMessage message = new MimeMessage(session);

        message.setContent(htmlText, "text/html");
        message.setContent(plainText, "text/plain");
        message.setSubject(subject);

        Address address = new InternetAddress(
                "provirent-test@phil-schneider.de", "Provirent test");
        message.setFrom(address);
        message.setReplyTo(new Address[] { address });

        Address toaddress = new InternetAddress(toEmail, toName);
        message.addRecipient(Message.RecipientType.TO, toaddress);

        message.saveChanges(); // implicit with send()
        Transport transport = session.getTransport("smtp");
        transport.connect(MAIL_SERVER, MAIL_USER, MAIL_PASS);
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();

    }

    public static String createHash(final String s) {

        try {
            byte[] encryptbyte = MessageDigest.getInstance("SHA-1").digest(
                    s.getBytes());
            StringBuffer sb = new StringBuffer();

            //create a StringBuffer for the hash
            for (int i = 0; i < encryptbyte.length; i++) {
                sb.append(Integer.toHexString(encryptbyte[i] & 0xff));
            }

            return new String(sb);

        } catch (Exception ex) {
            logger.error("Fehler beim HashCode erstellen.", ex);
            return null;
        }
    }

    public static void main(String[] args) {
        Util h = new Util();

    }

    /**
     * @param text
     * @return
     */
    public static Calendar getDateByText(String textdate) throws DataBaseException {
        StringTokenizer tokenizer = new StringTokenizer(textdate, ".");
        Vector vec = new Vector();
        while (tokenizer.hasMoreTokens()) {
           vec.add(tokenizer.nextToken());
        }
        
        if (vec.size() != 3) {
            return null;     
        } else {
            String days = (String) vec.get(0);
            String months = (String) vec.get(1);
            String years = (String) vec.get(2);
            Calendar date = Calendar.getInstance();
            date.set(Integer.parseInt(years), Integer.parseInt(months), 
                     Integer.parseInt(days));
            return date;
        }
    }
}