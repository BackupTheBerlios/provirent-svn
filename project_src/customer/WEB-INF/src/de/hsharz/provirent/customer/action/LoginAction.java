package de.hsharz.provirent.customer.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import de.hsharz.provirent.customer.constant.StrutsConstant;
import de.hsharz.provirent.customer.form.LoginForm;
import de.hsharz.provirent.objects.Customer;
import de.hsharz.provirent.persistence.Database;

public class LoginAction extends Action {
  /**
   * Logger for this class
   */
	private static final Logger logger = Logger.getLogger(LoginAction.class);

	public ActionForward execute(
			ActionMapping mapping, ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
      	throws Exception {
    
		System.out.println("execute LoginAction");

		LoginForm lf = (LoginForm) form;
		
		boolean existUser = false;
		
		//	Laden von Benutzername und Passwort
		String aktUsername = lf.getUsername();
		String aktPassword = lf.getPassword();
		
		Customer user = null;
		
		List users = new ArrayList();
		
		users = Database.getUsersByLogin(aktUsername, aktPassword);
		
		Iterator it = users.iterator();
		
		//über die Benutzerliste iterieren
		while (it.hasNext()) {
			
			existUser = true;
			
			//Benutzer aus Liste laden
			user = (Customer) it.next();
		}
		
		//		wenn Benutzer nicht existiert
		if (!existUser) {
			
			//Eingabeformular laden
			return mapping.getInputForward();
			
		} else {
			
			request.getSession().setAttribute(StrutsConstant.SESSION_USER_KEY, user);
			
			return mapping.findForward(StrutsConstant.FWD_SUCCESS);
			
		}

  }

}
