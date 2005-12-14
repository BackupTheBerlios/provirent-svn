/*
 * Created on 23.11.2004
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

import java.sql.*;
import java.lang.*;
import java.io.*;
import java.util.*;
import java.security.MessageDigest;

/**
 * @author Philipp Schneider
 *
 */
public class Sha {

    public void doIt() throws IOException,
    java.security.NoSuchAlgorithmException{
        //Deine
        //String password = "f53nu1ki";
        //String sha1     = "65aa257d16685el8ac4aef8fb9529aafc744b13";

        //Meine
        String password = "f53nu1ki";
        String sha1 = "65aa257d16685e18ac4aef8fb9529aafc744b13";

        //String password = "admin";
        //String sha1     = "d033e22ae348aeb566fc214aec3585c4da997";

        MessageDigest md = MessageDigest.getInstance("SHA-1");
        byte[] encryptbyte = md.digest(password.getBytes());
        StringBuffer sb = new StringBuffer();

        //create a StringBuffer for the hash
        for (int i = 0; i < encryptbyte.length; i++) {
            sb.append(Integer.toHexString(encryptbyte[i] & 0xff));
        }

        //System.out.println(sha1);
        //System.out.println(sb);

        if (sha1.equalsIgnoreCase(new String(sb))){
            System.out.println("ok");
        } else {
            System.out.println("Falsch");
        }
        
        
    }
    
    public static void main(String[] args) throws IOException,
            java.security.NoSuchAlgorithmException {

        Sha sha = new Sha();
        for (int i = 0; i < 100; i++) {
            sha.doIt();
        }
        sha.doIt();


    }

}