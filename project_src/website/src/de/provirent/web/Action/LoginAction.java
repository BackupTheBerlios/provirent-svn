package de.provirent.web.Action;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import javax.servlet.http.HttpSession;

import de.provirent.web.Form.*;
import de.provirent.web.Constant;

public class LoginAction extends Action {


    private final String _username ="Phil";
    private final String _password = "123";

    public ActionForward execute(ActionMapping actionMapping,
                                 ActionForm actionForm,
                                 HttpServletRequest servletRequest,
                                 HttpServletResponse servletResponse) {
        LoginForm loginForm = (LoginForm) actionForm;


System.out.println("Teste login");
        loginForm.getUsername();
        loginForm.getPassword();
        if ( loginForm.getUsername().equals(_username) && loginForm.getPassword().equals(_password) ){

            HttpSession session = servletRequest.getSession();
            session.setAttribute(Constant.USER_KEY, actionForm);
           return actionMapping.findForward(Constant.FW_SUCCESS);
        }

        ActionErrors errors = new ActionErrors();
        errors.add(ActionErrors.GLOBAL_ERROR,
                   new ActionError("error.logon.invalid"));
        saveErrors(servletRequest,errors);
            // return to input page
            return (new ActionForward(actionMapping.getInput()));


    }


}
