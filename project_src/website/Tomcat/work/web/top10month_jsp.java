package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.apache.jasper.runtime.*;

public class top10month_jsp extends HttpJspBase {


  private static java.util.Vector _jspx_includes;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_tiles_insert_page_flush;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_tiles_put_value_name;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_tiles_put_type_name;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_logic_present_name;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_logic_iterate_name_id;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_bean_write_property_name;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_html_link_paramProperty_paramName_paramId_forward;

  public top10month_jsp() {
    _jspx_tagPool_tiles_insert_page_flush = new org.apache.jasper.runtime.TagHandlerPool();
    _jspx_tagPool_tiles_put_value_name = new org.apache.jasper.runtime.TagHandlerPool();
    _jspx_tagPool_tiles_put_type_name = new org.apache.jasper.runtime.TagHandlerPool();
    _jspx_tagPool_logic_present_name = new org.apache.jasper.runtime.TagHandlerPool();
    _jspx_tagPool_logic_iterate_name_id = new org.apache.jasper.runtime.TagHandlerPool();
    _jspx_tagPool_bean_write_property_name = new org.apache.jasper.runtime.TagHandlerPool();
    _jspx_tagPool_html_link_paramProperty_paramName_paramId_forward = new org.apache.jasper.runtime.TagHandlerPool();
  }

  public java.util.List getIncludes() {
    return _jspx_includes;
  }

  public void _jspDestroy() {
    _jspx_tagPool_tiles_insert_page_flush.release();
    _jspx_tagPool_tiles_put_value_name.release();
    _jspx_tagPool_tiles_put_type_name.release();
    _jspx_tagPool_logic_present_name.release();
    _jspx_tagPool_logic_iterate_name_id.release();
    _jspx_tagPool_bean_write_property_name.release();
    _jspx_tagPool_html_link_paramProperty_paramName_paramId_forward.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    JspFactory _jspxFactory = null;
    javax.servlet.jsp.PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;


    try {
      _jspxFactory = JspFactory.getDefaultFactory();
      response.setContentType("text/html;charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      /* ----  tiles:insert ---- */
      org.apache.struts.taglib.tiles.InsertTag _jspx_th_tiles_insert_0 = (org.apache.struts.taglib.tiles.InsertTag) _jspx_tagPool_tiles_insert_page_flush.get(org.apache.struts.taglib.tiles.InsertTag.class);
      _jspx_th_tiles_insert_0.setPageContext(pageContext);
      _jspx_th_tiles_insert_0.setParent(null);
      _jspx_th_tiles_insert_0.setPage("/templates/main.jsp");
      _jspx_th_tiles_insert_0.setFlush(true);
      int _jspx_eval_tiles_insert_0 = _jspx_th_tiles_insert_0.doStartTag();
      if (_jspx_eval_tiles_insert_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\r\n");
          if (_jspx_meth_tiles_put_0(_jspx_th_tiles_insert_0, pageContext))
            return;
          out.write("\r\n");
          if (_jspx_meth_tiles_put_1(_jspx_th_tiles_insert_0, pageContext))
            return;
          out.write("\r\n\r\n");
          /* ----  tiles:put ---- */
          org.apache.struts.taglib.tiles.PutTag _jspx_th_tiles_put_2 = (org.apache.struts.taglib.tiles.PutTag) _jspx_tagPool_tiles_put_type_name.get(org.apache.struts.taglib.tiles.PutTag.class);
          _jspx_th_tiles_put_2.setPageContext(pageContext);
          _jspx_th_tiles_put_2.setParent(_jspx_th_tiles_insert_0);
          _jspx_th_tiles_put_2.setName("contentbody");
          _jspx_th_tiles_put_2.setType("string");
          int _jspx_eval_tiles_put_2 = _jspx_th_tiles_put_2.doStartTag();
          if (_jspx_eval_tiles_put_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_tiles_put_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              javax.servlet.jsp.tagext.BodyContent _bc = pageContext.pushBody();
              out = _bc;
              _jspx_th_tiles_put_2.setBodyContent(_bc);
              _jspx_th_tiles_put_2.doInitBody();
            }
            do {
              out.write("\r\n\r\n\r\n\r\n");
              /* ----  logic:present ---- */
              org.apache.struts.taglib.logic.PresentTag _jspx_th_logic_present_0 = (org.apache.struts.taglib.logic.PresentTag) _jspx_tagPool_logic_present_name.get(org.apache.struts.taglib.logic.PresentTag.class);
              _jspx_th_logic_present_0.setPageContext(pageContext);
              _jspx_th_logic_present_0.setParent(_jspx_th_tiles_put_2);
              _jspx_th_logic_present_0.setName("SearchResults");
              int _jspx_eval_logic_present_0 = _jspx_th_logic_present_0.doStartTag();
              if (_jspx_eval_logic_present_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n");
                  out.write("<!--top browse start -->\r\n            ");
                  out.write("<table style=\"width: 95%; text-align: left;\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" align=\"center\">\r\n              ");
                  out.write("<tbody>\r\n                ");
                  out.write("<tr>\r\n                  ");
                  out.write("<td class=\"prev_page_browse\">&nbsp;&nbsp; ");
                  out.write("<a href=\"\">&lt;&lt; zur&uuml;ck &lt;&lt;");
                  out.write("</a>");
                  out.write("<br>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t");
                  out.write("</td>\r\n                  ");
                  out.write("<td class=\"overview_page_browse\" style=\"\">&nbsp;Seite 1 / 5 ");
                  out.write("<br>\r\n                  ");
                  out.write("</td>\r\n                  ");
                  out.write("<td class=\"next_page_browse\">&nbsp;");
                  out.write("<a href=\"\">&gt;&gt; vor &gt;&gt;");
                  out.write("</a>&nbsp;&nbsp;");
                  out.write("<br>\r\n                  ");
                  out.write("</td>\r\n                ");
                  out.write("</tr>\r\n              ");
                  out.write("</tbody>\r\n            ");
                  out.write("</table>\r\n");
                  out.write("<!--top browse end -->\r\n\r\n  ");
                  /* ----  logic:iterate ---- */
                  org.apache.struts.taglib.logic.IterateTag _jspx_th_logic_iterate_0 = (org.apache.struts.taglib.logic.IterateTag) _jspx_tagPool_logic_iterate_name_id.get(org.apache.struts.taglib.logic.IterateTag.class);
                  _jspx_th_logic_iterate_0.setPageContext(pageContext);
                  _jspx_th_logic_iterate_0.setParent(_jspx_th_logic_present_0);
                  _jspx_th_logic_iterate_0.setId("movie");
                  _jspx_th_logic_iterate_0.setName("SearchResults");
                  int _jspx_eval_logic_iterate_0 = _jspx_th_logic_iterate_0.doStartTag();
                  if (_jspx_eval_logic_iterate_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                    java.lang.Object movie = null;
                    if (_jspx_eval_logic_iterate_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                      javax.servlet.jsp.tagext.BodyContent _bc = pageContext.pushBody();
                      out = _bc;
                      _jspx_th_logic_iterate_0.setBodyContent(_bc);
                      _jspx_th_logic_iterate_0.doInitBody();
                    }
                    movie = (java.lang.Object) pageContext.findAttribute("movie");
                    do {
                      out.write("\r\n\r\n    ");
                      out.write("<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\r\n      ");
                      out.write("<tbody>\r\n        ");
                      out.write("<tr>\r\n          ");
                      out.write("<td align=\"center\" width=\"20%\">");
                      out.write("<img style=\"width: 75px; height: 75px;\" src=\"\" alt=\"\" border=\"0\">\r\n          ");
                      out.write("</td>\r\n          ");
                      out.write("<td>\r\n            ");
                      out.write("<span class=\"list_title\">");
                      if (_jspx_meth_bean_write_0(_jspx_th_logic_iterate_0, pageContext))
                        return;
                      out.write("</span>\r\n            ");
                      out.write("<span class=\"list_summary\">");
                      if (_jspx_meth_bean_write_1(_jspx_th_logic_iterate_0, pageContext))
                        return;
                      out.write("\r\n              ");
                      if (_jspx_meth_html_link_0(_jspx_th_logic_iterate_0, pageContext))
                        return;
                      out.write("\r\n            ");
                      out.write("</span>\r\n          ");
                      out.write("</td>\r\n          ");
                      out.write("<td width=\"10%\">\r\n            ");
                      out.write("<a href=\"#\">Bestellen");
                      out.write("</a>\r\n          ");
                      out.write("</td>\r\n        ");
                      out.write("</tr>\r\n      ");
                      out.write("</tbody>\r\n    ");
                      out.write("</table>\r\n  ");
                      int evalDoAfterBody = _jspx_th_logic_iterate_0.doAfterBody();
                      movie = (java.lang.Object) pageContext.findAttribute("movie");
                      if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                        break;
                    } while (true);
                    if (_jspx_eval_logic_iterate_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                      out = pageContext.popBody();
                  }
                  if (_jspx_th_logic_iterate_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  _jspx_tagPool_logic_iterate_name_id.reuse(_jspx_th_logic_iterate_0);
                  out.write("\r\n\r\n\r\n  ");
                  out.write("<!--bottom browse start -->\r\n            ");
                  out.write("<table style=\"width: 95%; text-align: left;\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" align=\"center\">\r\n              ");
                  out.write("<tbody>\r\n                ");
                  out.write("<tr>\r\n                  ");
                  out.write("<td class=\"prev_page_browse\">&nbsp;&nbsp; ");
                  out.write("<a href=\"\">&lt;&lt; zur&uuml;ck &lt;&lt;");
                  out.write("</a>");
                  out.write("<br>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t");
                  out.write("</td>\r\n                  ");
                  out.write("<td class=\"overview_page_browse\" style=\"\">&nbsp;Seite 1 / 5 ");
                  out.write("<br>\r\n                  ");
                  out.write("<a href=\"\" class=\"single_page_browse\">1");
                  out.write("</a>&nbsp;&nbsp;\r\n                  ");
                  out.write("<a href=\"\" class=\"single_page_browse\">2");
                  out.write("</a>&nbsp;&nbsp;\r\n                  ");
                  out.write("<a href=\"\" class=\"single_page_browse\">3");
                  out.write("</a>&nbsp;&nbsp;\r\n                  ");
                  out.write("<a href=\"\" class=\"single_page_browse\">4");
                  out.write("</a>&nbsp;&nbsp;\r\n                  ");
                  out.write("<a href=\"\" class=\"single_page_browse\">5");
                  out.write("</a>&nbsp;&nbsp;\r\n                  ");
                  out.write("</td>\r\n                  ");
                  out.write("<td class=\"next_page_browse\">&nbsp;");
                  out.write("<a href=\"\">&gt;&gt; vor &gt;&gt;");
                  out.write("</a>&nbsp;&nbsp;");
                  out.write("<br>\r\n                  ");
                  out.write("</td>\r\n                ");
                  out.write("</tr>\r\n              ");
                  out.write("</tbody>\r\n            ");
                  out.write("</table>\r\n");
                  out.write("<!--bottom browse end -->\r\n\r\n");
                  int evalDoAfterBody = _jspx_th_logic_present_0.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_logic_present_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              _jspx_tagPool_logic_present_name.reuse(_jspx_th_logic_present_0);
              out.write("\r\n");
              int evalDoAfterBody = _jspx_th_tiles_put_2.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_tiles_put_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = pageContext.popBody();
          }
          if (_jspx_th_tiles_put_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          _jspx_tagPool_tiles_put_type_name.reuse(_jspx_th_tiles_put_2);
          out.write("\r\n\r\n");
          int evalDoAfterBody = _jspx_th_tiles_insert_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_tiles_insert_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      _jspx_tagPool_tiles_insert_page_flush.reuse(_jspx_th_tiles_insert_0);
      out.write("\r\n");
    } catch (Throwable t) {
      out = _jspx_out;
      if (out != null && out.getBufferSize() != 0)
        out.clearBuffer();
      if (pageContext != null) pageContext.handlePageException(t);
    } finally {
      if (_jspxFactory != null) _jspxFactory.releasePageContext(pageContext);
    }
  }

  private boolean _jspx_meth_tiles_put_0(javax.servlet.jsp.tagext.Tag _jspx_th_tiles_insert_0, javax.servlet.jsp.PageContext pageContext)
          throws Throwable {
    JspWriter out = pageContext.getOut();
    /* ----  tiles:put ---- */
    org.apache.struts.taglib.tiles.PutTag _jspx_th_tiles_put_0 = (org.apache.struts.taglib.tiles.PutTag) _jspx_tagPool_tiles_put_value_name.get(org.apache.struts.taglib.tiles.PutTag.class);
    _jspx_th_tiles_put_0.setPageContext(pageContext);
    _jspx_th_tiles_put_0.setParent(_jspx_th_tiles_insert_0);
    _jspx_th_tiles_put_0.setName("title");
    _jspx_th_tiles_put_0.setValue("PROfessional VIdeo RENTalStore");
    int _jspx_eval_tiles_put_0 = _jspx_th_tiles_put_0.doStartTag();
    if (_jspx_th_tiles_put_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_tiles_put_value_name.reuse(_jspx_th_tiles_put_0);
    return false;
  }

  private boolean _jspx_meth_tiles_put_1(javax.servlet.jsp.tagext.Tag _jspx_th_tiles_insert_0, javax.servlet.jsp.PageContext pageContext)
          throws Throwable {
    JspWriter out = pageContext.getOut();
    /* ----  tiles:put ---- */
    org.apache.struts.taglib.tiles.PutTag _jspx_th_tiles_put_1 = (org.apache.struts.taglib.tiles.PutTag) _jspx_tagPool_tiles_put_value_name.get(org.apache.struts.taglib.tiles.PutTag.class);
    _jspx_th_tiles_put_1.setPageContext(pageContext);
    _jspx_th_tiles_put_1.setParent(_jspx_th_tiles_insert_0);
    _jspx_th_tiles_put_1.setName("top10month_link");
    _jspx_th_tiles_put_1.setValue("top10.jsp");
    int _jspx_eval_tiles_put_1 = _jspx_th_tiles_put_1.doStartTag();
    if (_jspx_th_tiles_put_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_tiles_put_value_name.reuse(_jspx_th_tiles_put_1);
    return false;
  }

  private boolean _jspx_meth_bean_write_0(javax.servlet.jsp.tagext.Tag _jspx_th_logic_iterate_0, javax.servlet.jsp.PageContext pageContext)
          throws Throwable {
    JspWriter out = pageContext.getOut();
    /* ----  bean:write ---- */
    org.apache.struts.taglib.bean.WriteTag _jspx_th_bean_write_0 = (org.apache.struts.taglib.bean.WriteTag) _jspx_tagPool_bean_write_property_name.get(org.apache.struts.taglib.bean.WriteTag.class);
    _jspx_th_bean_write_0.setPageContext(pageContext);
    _jspx_th_bean_write_0.setParent(_jspx_th_logic_iterate_0);
    _jspx_th_bean_write_0.setName("movie");
    _jspx_th_bean_write_0.setProperty("title");
    int _jspx_eval_bean_write_0 = _jspx_th_bean_write_0.doStartTag();
    if (_jspx_th_bean_write_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_bean_write_property_name.reuse(_jspx_th_bean_write_0);
    return false;
  }

  private boolean _jspx_meth_bean_write_1(javax.servlet.jsp.tagext.Tag _jspx_th_logic_iterate_0, javax.servlet.jsp.PageContext pageContext)
          throws Throwable {
    JspWriter out = pageContext.getOut();
    /* ----  bean:write ---- */
    org.apache.struts.taglib.bean.WriteTag _jspx_th_bean_write_1 = (org.apache.struts.taglib.bean.WriteTag) _jspx_tagPool_bean_write_property_name.get(org.apache.struts.taglib.bean.WriteTag.class);
    _jspx_th_bean_write_1.setPageContext(pageContext);
    _jspx_th_bean_write_1.setParent(_jspx_th_logic_iterate_0);
    _jspx_th_bean_write_1.setName("movie");
    _jspx_th_bean_write_1.setProperty("describ");
    int _jspx_eval_bean_write_1 = _jspx_th_bean_write_1.doStartTag();
    if (_jspx_th_bean_write_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_bean_write_property_name.reuse(_jspx_th_bean_write_1);
    return false;
  }

  private boolean _jspx_meth_html_link_0(javax.servlet.jsp.tagext.Tag _jspx_th_logic_iterate_0, javax.servlet.jsp.PageContext pageContext)
          throws Throwable {
    JspWriter out = pageContext.getOut();
    /* ----  html:link ---- */
    org.apache.struts.taglib.html.LinkTag _jspx_th_html_link_0 = (org.apache.struts.taglib.html.LinkTag) _jspx_tagPool_html_link_paramProperty_paramName_paramId_forward.get(org.apache.struts.taglib.html.LinkTag.class);
    _jspx_th_html_link_0.setPageContext(pageContext);
    _jspx_th_html_link_0.setParent(_jspx_th_logic_iterate_0);
    _jspx_th_html_link_0.setForward("logout");
    _jspx_th_html_link_0.setParamId("id");
    _jspx_th_html_link_0.setParamProperty("id");
    _jspx_th_html_link_0.setParamName("movie");
    int _jspx_eval_html_link_0 = _jspx_th_html_link_0.doStartTag();
    if (_jspx_eval_html_link_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_html_link_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        javax.servlet.jsp.tagext.BodyContent _bc = pageContext.pushBody();
        out = _bc;
        _jspx_th_html_link_0.setBodyContent(_bc);
        _jspx_th_html_link_0.doInitBody();
      }
      do {
        out.write("\r\n                &gt;&gt;mehr&lt;&lt;\r\n              ");
        int evalDoAfterBody = _jspx_th_html_link_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_html_link_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
        out = pageContext.popBody();
    }
    if (_jspx_th_html_link_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_html_link_paramProperty_paramName_paramId_forward.reuse(_jspx_th_html_link_0);
    return false;
  }
}
