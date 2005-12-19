package de.hsharz.provirent.customer.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;



import de.hsharz.provirent.customer.constant.StrutsConstant;
import de.hsharz.provirent.objects.Actor;



public class GenreAction extends Action{
  /**
   * Logger for this class
   */
  private static final Logger logger = Logger
      .getLogger(GenreAction.class);

  public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    //System.out.println("execute von genreAction");
    
    List list = new ArrayList();
    System.out.println("execute von genreAction");
    System.out.println("mapping.getPath: "+mapping.getPath());
    System.out.println("mapping.getParameter(): "+mapping.getParameter());
    Actor actor = new Actor(mapping.getPath(),mapping.getParameter());
    list.add(actor);
    
    Actor actor1 = new Actor("Thomas","Mann");
    list.add(actor1);
    Actor actor2 = new Actor("Dieter","Bohlen");
    list.add(actor2);
    Actor actor3 = new Actor("Henry","Schneide");
    list.add(actor3);
    Actor actor4 = new Actor("Dagmar","Fischern");
    list.add(actor4);
    Actor actor5 = new Actor("Heinrich","Schulze");
    list.add(actor5);
    
    request.getSession().setAttribute(StrutsConstant.SESSION_GENRELIST_KEY, list);

    return mapping.findForward(StrutsConstant.FWD_SUCCESS);

  }

}
