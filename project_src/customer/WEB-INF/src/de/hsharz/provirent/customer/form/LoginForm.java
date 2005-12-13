package de.hsharz.provirent.customer.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class LoginForm extends ActionForm{
  /**
   * Logger for this class
   */
  private static final Logger logger = Logger
      .getLogger(LoginForm.class);

  private String username = "";

  private String password = "";
  
  public String getUsername() {
      return this.username;
  }

  public String getPassword() {
      return this.password;
  }

  public void setUsername(String username) {
      this.username = username;
  }

  public void setPassword(String password) {
      this.password = password;
  }

  public void reset(ActionMapping mp, HttpServletRequest rq) {
      
      if ( rq.getParameter("username") == null || rq.getParameter("username") == "" ){
          username  = "";
      } else {
          username  = rq.getParameter("username");
      }

      password = "";

  }

  public ActionErrors validate(ActionMapping mp, HttpServletRequest rq) {

      ActionErrors errors = new ActionErrors();

      if(username == null || username.length() < 1) {
          errors
                  .add("username", new ActionMessage(
                          "error.main.login.username.required"));
      }
      if(password == null || password.length() < 1) {
          errors
                  .add("password", new ActionMessage(
                          "error.main.login.password.required"));
      }

      return errors;
  }

}
