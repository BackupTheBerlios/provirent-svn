/*
 * Created on 26.10.2004
 * 
 * Copyright (c) 2004/2005, Remo Griesch/Stefan Forstner/Philipp Schneider All
 * rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *  - Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer. - Redistributions in
 * binary form must reproduce the above copyright notice, this list of
 * conditions and the following disclaimer in the documentation and/or other
 * materials provided with the distribution. - Neither the name of the Remo
 * Griesch/Stefan Forstner/Philipp Schneider nor the names of its contributors
 * may be used to endorse or promote products derived from this software without
 * specific prior written permission.
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
package de.hsharz.provirent.strutstest;

import javax.servlet.http.*;
import org.apache.struts.action.*;

public final class DatenFormBean extends ActionForm {

    private String username = null;

    private String password = null;

    private String action = null;

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public String getAction() {
        return this.action;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public void reset(ActionMapping mp, HttpServletRequest rq) {
        username = null;
        password = null;
        action = null;
    }

    public ActionErrors validate(ActionMapping mp, HttpServletRequest rq) {
        ActionErrors errors = null;
        if (!"Weiter".equals(action)) {
            username = null;
            password = null;
        } else {
            if (username == null || username.length() < 1) {
                if (errors == null)
                    errors = new ActionErrors();
                errors.add("username", new ActionError(
                        "error.username.required"));
            }
            if (password == null || password.length() < 1) {
                if (errors == null)
                    errors = new ActionErrors();
                errors.add("password", new ActionError(
                        "error.password.required"));
            }
        }
        return errors;
    }

}