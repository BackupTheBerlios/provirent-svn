package de.provirent.web.Form;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionError;

public class SearchForm extends ActionForm {
    private String searchfor;
    private String selectName;

    public String getSearchfor() {
        return searchfor;
    }

    public void setSearchfor(String searchfor) {
        this.searchfor = searchfor;
    }

    public void setSelectName(String selectName) {
        this.selectName = selectName;
    }

    public String getSelectName() {
        return selectName;
    }

    public ActionErrors validate(ActionMapping actionMapping,
                                 HttpServletRequest httpServletRequest) {
           ActionErrors errors = new ActionErrors();

           if (searchfor == null || searchfor.length() < 1){
               errors.add("searchfor",new ActionError("search.error.searchfor.empty"));
           }

           if (selectName == null || selectName.length() < 1){
    errors.add("selectName",new ActionError("search.error.selectName.empty"));
}


        return errors;
    }

    public void reset(ActionMapping actionMapping,
                      HttpServletRequest servletRequest) {
    }
}
