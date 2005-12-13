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

public class LogoutAction extends Action{
  /**
   * Logger for this class
   */
  private static final Logger logger = Logger
      .getLogger(LogoutAction.class);

  public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

    HttpSession session = request.getSession(false);
    if(session != null) {
        session.removeAttribute(StrutsConstant.SESSION_USER_KEY);
        session.invalidate();
        logger.debug("Session vorhanden und zerstört");
    }
    
    
    return mapping.getInputForward();

  }

}
