package de.provirent.web.Form;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionError;

public class LoginForm extends ActionForm {

    protected String username ="";
    protected String password ="";

    public ActionErrors validate(ActionMapping actionMapping,
                                 HttpServletRequest httpServletRequest) {
        ActionErrors errors = new ActionErrors();
        if( username ==  null || username.length() < 1){
            errors.add(username, new ActionError("login.error.username.empty") );
        }
        if( password == null || password.length() < 1 ){
            errors.add(password, new ActionError("login.error.password.empty") );
        }

        return errors;
    }

    public void reset(ActionMapping actionMapping,
                      HttpServletRequest servletRequest) {
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
}
