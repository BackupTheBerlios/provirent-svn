package de.provirent.web.Action;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.Action;
import javax.servlet.http.HttpSession;

import de.provirent.web.Constant;

public class LogoutAction extends Action {
    public ActionForward execute(ActionMapping actionMapping,
                                 ActionForm actionForm,
                                 HttpServletRequest servletRequest,
                                 HttpServletResponse servletResponse) {
        System.out.println("Versuche Session zu löschen");

        HttpSession session = servletRequest.getSession();
        // Remove user login

        session.removeAttribute(Constant.USER_KEY);

        return actionMapping.findForward("success");
    }
}
