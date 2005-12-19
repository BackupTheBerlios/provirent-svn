package de.hsharz.provirent.customer.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class NullForm extends ActionForm{
  /**
   * Logger for this class
   */
  private static final Logger logger = Logger
      .getLogger(NullForm.class);


  public void reset(ActionMapping mp, HttpServletRequest rq) {
      

  }

  public ActionErrors validate(ActionMapping mp, HttpServletRequest rq) {

    return new ActionErrors();

      
  }

}
