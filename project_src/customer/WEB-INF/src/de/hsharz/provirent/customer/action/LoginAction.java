package de.hsharz.provirent.customer.action;

import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import de.hsharz.provirent.customer.constant.StrutsConstant;
import de.hsharz.provirent.customer.form.LoginForm;

public class LoginAction extends Action {
  /**
   * Logger for this class
   */
  private static final Logger logger = Logger
      .getLogger(LoginAction.class);

  public ActionForward execute(
      ActionMapping mapping, ActionForm form,
      HttpServletRequest request,
      HttpServletResponse response)
      throws Exception {
    System.out.println("execute LoginAction");

    LoginForm loginForm = (LoginForm) form;

    if (loginForm.getUsername().equals("phil")
        && loginForm.getPassword().equals("phil")) {
      
      request.getSession().setAttribute(StrutsConstant.SESSION_USER_KEY, new Object());
      
      return mapping
          .findForward(StrutsConstant.FWD_SUCCESS);
    } else {
      return mapping.getInputForward();
    }

  }

}
