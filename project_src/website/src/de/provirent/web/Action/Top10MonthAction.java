package de.provirent.web.Action;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.Action;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

import de.provirent.web.objects.DTOMovieShort;

public class Top10MonthAction extends Action {
    public ActionForward execute(ActionMapping actionMapping,
                                 ActionForm actionForm,
                                 HttpServletRequest servletRequest,
                                 HttpServletResponse servletResponse) {

        List results = new ArrayList();

        for (int i = 1; i < 10; i++) {
            results.add(new DTOMovieShort("Titel" + i, "Beschreibung " + i, i+""));
        }

        HttpSession session = servletRequest.getSession();
        session.setAttribute("SearchResults", results);

        return actionMapping.getInputForward();

    }
}
