package org.apache.jsp.templates;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class main_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.Vector _jspx_dependants;

  static {
    _jspx_dependants = new java.util.Vector(2);
    _jspx_dependants.add("/WEB-INF/taglib/struts-tiles.tld");
    _jspx_dependants.add("/WEB-INF/taglib/struts-html.tld");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_tiles_getAsString_name_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_html_base_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_html_rewrite_page_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_tiles_insert_attribute_nobody;

  public java.util.List getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_tiles_getAsString_name_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_html_base_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_html_rewrite_page_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_tiles_insert_attribute_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_tiles_getAsString_name_nobody.release();
    _jspx_tagPool_html_base_nobody.release();
    _jspx_tagPool_html_rewrite_page_nobody.release();
    _jspx_tagPool_tiles_insert_attribute_nobody.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    JspFactory _jspxFactory = null;
    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      _jspxFactory = JspFactory.getDefaultFactory();
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n\r\n<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n<html>\r\n<head>\r\n  <title>");
      if (_jspx_meth_tiles_getAsString_0(_jspx_page_context))
        return;
      out.write("</title>\r\n  ");
      if (_jspx_meth_html_base_0(_jspx_page_context))
        return;
      out.write("\r\n  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\">\r\n  <link rel=\"stylesheet\" type=\"text/css\" href=\"");
      if (_jspx_meth_html_rewrite_0(_jspx_page_context))
        return;
      out.write("\" title=\"externe Styles\">\r\n</head>\r\n\r\n<body>\r\n<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\r\n  <tbody>\r\n    <tr>\r\n      <td width=\"10%\">&nbsp;</td>\r\n      <td>&nbsp;</td>\r\n      <td width=\"10%\">&nbsp;</td>\r\n    </tr>\r\n    <tr>\r\n      <td>&nbsp;</td>\r\n      <td>\r\n      <table align=\"center\" bgcolor=\"#c2d9c1\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\r\n        <tbody>\r\n          <tr>\r\n            <td colspan=\"7\" bgcolor=\"#000000\"><img src=\"images/1pxtrans.gif\" alt=\"\"></td>\r\n            <td style=\"background-image: url(images/border_r.gif);\"><img src=\"images/1pxtrans.gif\" height=\"1\" width=\"3\" alt=\"\"></td>\r\n          </tr>\r\n          <tr>\r\n            <td bgcolor=\"#000000\" width=\"1\"><img src=\"images/1pxtrans.gif\" alt=\"\"></td>\r\n            <td colspan=\"5\" height=\"70\">Logo</td>\r\n            <td bgcolor=\"#000000\" width=\"1\"><img src=\"images/1pxtrans.gif\" alt=\"\"></td>\r\n            <td style=\"background-image: url(images/border_r.gif);\"><img src=\"images/1pxtrans.gif\" width=\"3\" alt=\"\"></td>\r\n");
      out.write("          </tr>\r\n          <tr>\r\n            <td colspan=\"7\" bgcolor=\"#000000\"><img src=\"images/1pxtrans.gif\" alt=\"\"></td>\r\n            <td style=\"background-image: url(images/border_r.gif);\"><img src=\"images/1pxtrans.gif\" height=\"1\" width=\"3\" alt=\"\"></td>\r\n          </tr>\r\n          <tr>\r\n            <td bgcolor=\"#000000\" width=\"1\"><img src=\"images/1pxtrans.gif\" alt=\"\"></td>\r\n            <td colspan=\"5\" height=\"20\" valign=\"middle\">\r\n            <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\r\n              <tbody>\r\n                <tr>\r\n                  <td width=\"53%\">\r\n                    <!--head start-->\r\n                    <div align=\"left\">\r\n                      ");
      if (_jspx_meth_tiles_insert_0(_jspx_page_context))
        return;
      out.write("\r\n                    </div>\r\n                  </td>\r\n                  <td width=\"50%\">\r\n                    <div class=\"head_menue\" align=\"right\">\r\n                      <a href=\"\">&Uuml;bersicht</a>&nbsp;|&nbsp;<a href=\"\">Impressum</a>&nbsp;|&nbsp;<a href=\"\">Hilfe</a>&nbsp;\r\n                    </div>\r\n\r\n                    <!--head end-->\r\n                  </td>\r\n </tr>\r\n              </tbody>\r\n            </table>\r\n            </td>\r\n            <td bgcolor=\"#000000\" width=\"1\"><img src=\"images/1pxtrans.gif\" alt=\"\"></td>\r\n            <td style=\"background-image: url(images/border_r.gif);\"><img src=\"images/1pxtrans.gif\" width=\"3\" alt=\"\"></td>\r\n          </tr>\r\n          <tr>\r\n            <td colspan=\"7\" bgcolor=\"#000000\"><img src=\"images/1pxtrans.gif\" alt=\"\"></td>\r\n            <td style=\"background-image: url(images/border_r.gif);\"><img src=\"images/1pxtrans.gif\" height=\"1\" width=\"3\" alt=\"\"></td>\r\n          </tr>\r\n          <tr>\r\n            <td colspan=\"7\" bgcolor=\"#f9efd2\" height=\"2\"><img src=\"images/1pxtrans.gif\" alt=\"\"></td>\r\n");
      out.write("            <td bgcolor=\"#f9efd2\"><img src=\"images/1pxtrans.gif\" height=\"1\" width=\"3\" alt=\"\"></td>\r\n          </tr>\r\n          <tr>\r\n            <td colspan=\"3\" bgcolor=\"#000000\"><img src=\"images/1pxtrans.gif\" alt=\"\"></td>\r\n            <td colspan=\"1\" bgcolor=\"#f9efd2\" width=\"2\"><img src=\"images/1pxtrans.gif\" alt=\"\"></td>\r\n            <td colspan=\"3\" bgcolor=\"#000000\"><img src=\"images/1pxtrans.gif\" alt=\"\"></td>\r\n            <td style=\"background-image: url(images/border_r.gif);\"><img src=\"images/1pxtrans.gif\" height=\"1\" width=\"3\" alt=\"\"></td>\r\n          </tr>\r\n          <tr>\r\n            <td bgcolor=\"#000000\" width=\"1\"><img src=\"images/1pxtrans.gif\" alt=\"\"></td>\r\n            <td valign=\"top\">\r\n<!--menue start-->\r\n            <table class=\"menue_tbl\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n              <thead class=\"menue_tbl\"> <tr>\r\n                <th>Aktuelles</th>\r\n              </tr>\r\n              </thead> <tbody class=\"menue_tbl\">\r\n                <tr>\r\n                  <td class=\"menue_tbl\"><a href=\"#\" class=\"menue_tbl\">Neuheiten</a></td>\r\n");
      out.write("                </tr>\r\n                <tr>\r\n                  <td class=\"menue_tbl\"><a href=\"");
      if (_jspx_meth_tiles_getAsString_1(_jspx_page_context))
        return;
      out.write("\">Top 10 Monat</td>\r\n                </tr>\r\n                <tr>\r\n                  <td class=\"menue_tbl\"><a href=\"#\">Top 100 Jahr</a></td>\r\n                </tr>\r\n                <tr>\r\n                  <td class=\"menue_tbl\"><a href=\"#\">Vorschau</a></td>\r\n                </tr>\r\n              </tbody>\r\n            </table>\r\n            <br>\r\n            <table class=\"menue_suche\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n              <thead class=\"menue_tbl\"> <tr>\r\n                <th colspan=\"2\">Suche</th>\r\n              </tr>\r\n              </thead> <tbody>\r\n                <tr>\r\n                \t<td colspan=\"2\">\r\n                  \t\t<form id=\"search\" action=\"\" method=\"post\" name=\"SearchForm\">\r\n\t                  \t<input name=\"searchfor\" size=\"16\" type=\"text\">\r\n    \t            </td>\r\n    \t        </tr>\r\n    \t        <tr>\r\n\t\t\t\t\t<td>\r\n        \t            <select name=\"selectName\" size=\"1\" id=\"select_search\">\r\n\t\t                    <option value=\"0\">all</option>\r\n\t\t                    <option value=\"1\">Movie</option>\r\n");
      out.write("        \t\t            <option value=\"2\">Artist</option>\r\n                \t\t    <option value=\"3\">genre</option>\r\n\t                    </select>\r\n                    </td>\r\n                    <td>\r\n    \t                <input value=\"Suche\" id=\"submit_search\" type=\"submit\">\r\n    \t                </form>\r\n                  </td>\r\n                </tr>\r\n              </tbody>\r\n            </table>\r\n            <br>\r\n            <table class=\"menue_tbl\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n              <thead class=\"menue_tbl\"> <tr>\r\n                <th>Genre</th>\r\n              </tr>\r\n              </thead> <tbody  class=\"menue_tbl\">\r\n                <tr>\r\n                  <td class=\"menue_tbl\"><a href=\"#\"> Action </a></td>\r\n                </tr>\r\n                <tr>\r\n                  <td class=\"menue_tbl\"><a href=\"#\"> Drama </a></td>\r\n                </tr>\r\n                <tr>\r\n                  <td class=\"menue_tbl\"><a href=\"#\"> Comedy </a></td>\r\n                </tr>\r\n                <tr>\r\n                  <td class=\"menue_tbl\"><a href=\"#\"> Thriller </a></td>\r\n");
      out.write("                </tr>\r\n              </tbody>\r\n            </table>\r\n\r\n\r\n<!--menue end--> </td>\r\n            <td bgcolor=\"#000000\" width=\"1\"><img src=\"images/1pxtrans.gif\" alt=\"\"></td>\r\n            <td bgcolor=\"#f9efd2\" width=\"3\"><img src=\"images/1pxtrans.gif\" alt=\"\"></td>\r\n            <td bgcolor=\"#000000\" width=\"1\"><img src=\"images/1pxtrans.gif\" alt=\"\"></td>\r\n            <td valign=\"top\" width=\"85%\">\r\n<!--main start-->\r\n");
      if (_jspx_meth_tiles_insert_1(_jspx_page_context))
        return;
      out.write("\r\n\r\n&nbsp; <br>\r\n            <table style=\"width: 95%; text-align: left;\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" align=\"center\">\r\n              <tbody>\r\n                <tr>\r\n                  <td class=\"prev_page_browse\">&nbsp;&nbsp; <a href=\"\">&lt;&lt; zur&uuml;ck &lt;&lt;</a><br>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n                  <td class=\"overview_page_browse\" style=\"\">&nbsp;Seite 1 / 5 <br>\r\n                  <a href=\"\" class=\"single_page_browse\">1</a>&nbsp;&nbsp;\r\n                  <a href=\"\" class=\"single_page_browse\">2</a>&nbsp;&nbsp;\r\n                  <a href=\"\" class=\"single_page_browse\">3</a>&nbsp;&nbsp;\r\n                  <a href=\"\" class=\"single_page_browse\">4</a>&nbsp;&nbsp;\r\n                  <a href=\"\" class=\"single_page_browse\">5</a>&nbsp;&nbsp;\r\n                  </td>\r\n                  <td class=\"next_page_browse\">&nbsp;<a href=\"\">&gt;&gt; vor &gt;&gt;</a>&nbsp;&nbsp;<br>\r\n                  </td>\r\n                </tr>\r\n              </tbody>\r\n            </table>\r\n            <br>\r\n            <br>\r\n");
      out.write("            <br>\r\n\r\n\r\n&nbsp; <br>\r\n\r\n            <br>\r\n            <br>\r\n            <br>\r\n            <br>\r\n            <br>\r\n<!--main end--> </td>\r\n            <td bgcolor=\"#000000\" width=\"1\"><img src=\"images/1pxtrans.gif\" alt=\"\"></td>\r\n            <td style=\"background-image: url(images/border_r.gif);\"><img src=\"images/1pxtrans.gif\" width=\"3\" alt=\"\"></td>\r\n          </tr>\r\n          <tr>\r\n            <td colspan=\"3\" bgcolor=\"#000000\"><img src=\"images/1pxtrans.gif\" alt=\"\"></td>\r\n            <td colspan=\"1\" bgcolor=\"#f9efd2\" width=\"2\"><img src=\"images/1pxtrans.gif\" alt=\"\"></td>\r\n            <td colspan=\"3\" bgcolor=\"#000000\"><img src=\"images/1pxtrans.gif\" alt=\"\"></td>\r\n            <td style=\"background-image: url(images/border_r.gif);\"><img src=\"images/1pxtrans.gif\" height=\"1\" width=\"3\" alt=\"\"></td>\r\n          </tr>\r\n          <tr>\r\n            <td colspan=\"7\" bgcolor=\"#f9efd2\" height=\"2\"><img src=\"images/1pxtrans.gif\" alt=\"\"></td>\r\n            <td bgcolor=\"#f9efd2\"><img src=\"images/1pxtrans.gif\" height=\"1\" width=\"1\" alt=\"\"></td>\r\n");
      out.write("          </tr>\r\n          <tr>\r\n            <td colspan=\"7\" bgcolor=\"#000000\"><img src=\"images/1pxtrans.gif\" alt=\"\"></td>\r\n            <td style=\"background-image: url(images/border_r.gif);\"><img src=\"images/1pxtrans.gif\" height=\"1\" width=\"3\" alt=\"\"></td>\r\n          </tr>\r\n          <tr>\r\n            <td bgcolor=\"#000000\" width=\"1\"><img src=\"images/1pxtrans.gif\" alt=\"\"></td>\r\n            <td colspan=\"5\">\r\n            <div class=\"copyright\">&copy;\r\nRemo Griesch,\r\nStefan Forstner, Philipp Schneider<br>\r\n            </div>\r\n            </td>\r\n            <td bgcolor=\"#000000\" width=\"1\"><img src=\"images/1pxtrans.gif\" alt=\"\"></td>\r\n            <td style=\"background-image: url(images/border_r.gif);\"><img src=\"images/1pxtrans.gif\" width=\"3\" alt=\"\"></td>\r\n          </tr>\r\n          <tr>\r\n            <td colspan=\"7\" bgcolor=\"#000000\"><img src=\"images/1pxtrans.gif\" alt=\"\"></td>\r\n            <td style=\"background-image: url(images/border_r.gif);\"><img src=\"images/1pxtrans.gif\" height=\"1\" width=\"3\" alt=\"\"></td>\r\n          </tr>\r\n");
      out.write("          <tr>\r\n            <td colspan=\"7\" style=\"background-image: url(images/border.gif);\"><img src=\"border_bl.gif\" height=\"7\" alt=\"\"></td>\r\n            <td style=\"background-image: url(images/border_br.gif);\"><img src=\"images/1pxtrans.gif\" height=\"1\" width=\"3\" alt=\"\"></td>\r\n          </tr>\r\n        </tbody>\r\n      </table>\r\n      </td>\r\n      <td>&nbsp;</td>\r\n    </tr>\r\n    <tr>\r\n      <td>&nbsp;</td>\r\n      <td>&nbsp;</td>\r\n      <td>&nbsp;</td>\r\n    </tr>\r\n  </tbody>\r\n</table>\r\n\r\n\r\n\r\n</body>\r\n</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      if (_jspxFactory != null) _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_tiles_getAsString_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  tiles:getAsString
    org.apache.struts.taglib.tiles.GetAttributeTag _jspx_th_tiles_getAsString_0 = (org.apache.struts.taglib.tiles.GetAttributeTag) _jspx_tagPool_tiles_getAsString_name_nobody.get(org.apache.struts.taglib.tiles.GetAttributeTag.class);
    _jspx_th_tiles_getAsString_0.setPageContext(_jspx_page_context);
    _jspx_th_tiles_getAsString_0.setParent(null);
    _jspx_th_tiles_getAsString_0.setName("title");
    int _jspx_eval_tiles_getAsString_0 = _jspx_th_tiles_getAsString_0.doStartTag();
    if (_jspx_th_tiles_getAsString_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_tiles_getAsString_name_nobody.reuse(_jspx_th_tiles_getAsString_0);
    return false;
  }

  private boolean _jspx_meth_html_base_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:base
    org.apache.struts.taglib.html.BaseTag _jspx_th_html_base_0 = (org.apache.struts.taglib.html.BaseTag) _jspx_tagPool_html_base_nobody.get(org.apache.struts.taglib.html.BaseTag.class);
    _jspx_th_html_base_0.setPageContext(_jspx_page_context);
    _jspx_th_html_base_0.setParent(null);
    int _jspx_eval_html_base_0 = _jspx_th_html_base_0.doStartTag();
    if (_jspx_th_html_base_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_html_base_nobody.reuse(_jspx_th_html_base_0);
    return false;
  }

  private boolean _jspx_meth_html_rewrite_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:rewrite
    org.apache.struts.taglib.html.RewriteTag _jspx_th_html_rewrite_0 = (org.apache.struts.taglib.html.RewriteTag) _jspx_tagPool_html_rewrite_page_nobody.get(org.apache.struts.taglib.html.RewriteTag.class);
    _jspx_th_html_rewrite_0.setPageContext(_jspx_page_context);
    _jspx_th_html_rewrite_0.setParent(null);
    _jspx_th_html_rewrite_0.setPage("/style.css");
    int _jspx_eval_html_rewrite_0 = _jspx_th_html_rewrite_0.doStartTag();
    if (_jspx_th_html_rewrite_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_html_rewrite_page_nobody.reuse(_jspx_th_html_rewrite_0);
    return false;
  }

  private boolean _jspx_meth_tiles_insert_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  tiles:insert
    org.apache.struts.taglib.tiles.InsertTag _jspx_th_tiles_insert_0 = (org.apache.struts.taglib.tiles.InsertTag) _jspx_tagPool_tiles_insert_attribute_nobody.get(org.apache.struts.taglib.tiles.InsertTag.class);
    _jspx_th_tiles_insert_0.setPageContext(_jspx_page_context);
    _jspx_th_tiles_insert_0.setParent(null);
    _jspx_th_tiles_insert_0.setAttribute("head_login");
    int _jspx_eval_tiles_insert_0 = _jspx_th_tiles_insert_0.doStartTag();
    if (_jspx_th_tiles_insert_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_tiles_insert_attribute_nobody.reuse(_jspx_th_tiles_insert_0);
    return false;
  }

  private boolean _jspx_meth_tiles_getAsString_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  tiles:getAsString
    org.apache.struts.taglib.tiles.GetAttributeTag _jspx_th_tiles_getAsString_1 = (org.apache.struts.taglib.tiles.GetAttributeTag) _jspx_tagPool_tiles_getAsString_name_nobody.get(org.apache.struts.taglib.tiles.GetAttributeTag.class);
    _jspx_th_tiles_getAsString_1.setPageContext(_jspx_page_context);
    _jspx_th_tiles_getAsString_1.setParent(null);
    _jspx_th_tiles_getAsString_1.setName("top10month_link");
    int _jspx_eval_tiles_getAsString_1 = _jspx_th_tiles_getAsString_1.doStartTag();
    if (_jspx_th_tiles_getAsString_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_tiles_getAsString_name_nobody.reuse(_jspx_th_tiles_getAsString_1);
    return false;
  }

  private boolean _jspx_meth_tiles_insert_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  tiles:insert
    org.apache.struts.taglib.tiles.InsertTag _jspx_th_tiles_insert_1 = (org.apache.struts.taglib.tiles.InsertTag) _jspx_tagPool_tiles_insert_attribute_nobody.get(org.apache.struts.taglib.tiles.InsertTag.class);
    _jspx_th_tiles_insert_1.setPageContext(_jspx_page_context);
    _jspx_th_tiles_insert_1.setParent(null);
    _jspx_th_tiles_insert_1.setAttribute("contentbody");
    int _jspx_eval_tiles_insert_1 = _jspx_th_tiles_insert_1.doStartTag();
    if (_jspx_th_tiles_insert_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_tiles_insert_attribute_nobody.reuse(_jspx_th_tiles_insert_1);
    return false;
  }
}
