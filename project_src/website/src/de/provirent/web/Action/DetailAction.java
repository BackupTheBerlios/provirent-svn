package de.provirent.web.Action;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.Action;

import de.provirent.web.Constant;

public class DetailAction extends Action {
    public ActionForward execute(ActionMapping actionMapping,
                                 ActionForm actionForm,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {


        String parameter = request.getParameter(Constant.PARAM_DETAIL);

        if (parameter == null || parameter.length() < 1 ){
            // Parameter wurde nicht gefunden FEHLER
        }

        try {
            int id = Integer.parseInt(parameter);


        } catch (NumberFormatException ex) {
            //Parameter ist keine Zahl FEHLER

        }

        return actionMapping.getInputForward();
    }
}
