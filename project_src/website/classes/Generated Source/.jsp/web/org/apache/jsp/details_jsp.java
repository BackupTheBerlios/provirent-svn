package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class details_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.Vector _jspx_dependants;

  static {
    _jspx_dependants = new java.util.Vector(2);
    _jspx_dependants.add("/WEB-INF/taglib/struts-tiles.tld");
    _jspx_dependants.add("/WEB-INF/taglib/struts-logic.tld");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_tiles_insert_page_flush;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_tiles_put_value_name_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_tiles_put_type_name;

  public java.util.List getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_tiles_insert_page_flush = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_tiles_put_value_name_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_tiles_put_type_name = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_tiles_insert_page_flush.release();
    _jspx_tagPool_tiles_put_value_name_nobody.release();
    _jspx_tagPool_tiles_put_type_name.release();
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

      out.write("\r\n\r\n\r\n");
      if (_jspx_meth_tiles_insert_0(_jspx_page_context))
        return;
      out.write("\r\n\r\n\r\n\r\n");
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

  private boolean _jspx_meth_tiles_insert_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  tiles:insert
    org.apache.struts.taglib.tiles.InsertTag _jspx_th_tiles_insert_0 = (org.apache.struts.taglib.tiles.InsertTag) _jspx_tagPool_tiles_insert_page_flush.get(org.apache.struts.taglib.tiles.InsertTag.class);
    _jspx_th_tiles_insert_0.setPageContext(_jspx_page_context);
    _jspx_th_tiles_insert_0.setParent(null);
    _jspx_th_tiles_insert_0.setPage("/templates/main.jsp");
    _jspx_th_tiles_insert_0.setFlush(true);
    int _jspx_eval_tiles_insert_0 = _jspx_th_tiles_insert_0.doStartTag();
    if (_jspx_eval_tiles_insert_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n\r\n");
        if (_jspx_meth_tiles_put_0(_jspx_th_tiles_insert_0, _jspx_page_context))
          return true;
        out.write('\r');
        out.write('\n');
        if (_jspx_meth_tiles_put_1(_jspx_th_tiles_insert_0, _jspx_page_context))
          return true;
        out.write("\r\n\r\n");
        if (_jspx_meth_tiles_put_2(_jspx_th_tiles_insert_0, _jspx_page_context))
          return true;
        out.write("\r\n\r\n");
        if (_jspx_meth_tiles_put_3(_jspx_th_tiles_insert_0, _jspx_page_context))
          return true;
        out.write('\r');
        out.write('\n');
        int evalDoAfterBody = _jspx_th_tiles_insert_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_tiles_insert_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_tiles_insert_page_flush.reuse(_jspx_th_tiles_insert_0);
    return false;
  }

  private boolean _jspx_meth_tiles_put_0(javax.servlet.jsp.tagext.JspTag _jspx_th_tiles_insert_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  tiles:put
    org.apache.struts.taglib.tiles.PutTag _jspx_th_tiles_put_0 = (org.apache.struts.taglib.tiles.PutTag) _jspx_tagPool_tiles_put_value_name_nobody.get(org.apache.struts.taglib.tiles.PutTag.class);
    _jspx_th_tiles_put_0.setPageContext(_jspx_page_context);
    _jspx_th_tiles_put_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_tiles_insert_0);
    _jspx_th_tiles_put_0.setName("title");
    _jspx_th_tiles_put_0.setValue("Top 10");
    int _jspx_eval_tiles_put_0 = _jspx_th_tiles_put_0.doStartTag();
    if (_jspx_th_tiles_put_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_tiles_put_value_name_nobody.reuse(_jspx_th_tiles_put_0);
    return false;
  }

  private boolean _jspx_meth_tiles_put_1(javax.servlet.jsp.tagext.JspTag _jspx_th_tiles_insert_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  tiles:put
    org.apache.struts.taglib.tiles.PutTag _jspx_th_tiles_put_1 = (org.apache.struts.taglib.tiles.PutTag) _jspx_tagPool_tiles_put_value_name_nobody.get(org.apache.struts.taglib.tiles.PutTag.class);
    _jspx_th_tiles_put_1.setPageContext(_jspx_page_context);
    _jspx_th_tiles_put_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_tiles_insert_0);
    _jspx_th_tiles_put_1.setName("top10month_link");
    _jspx_th_tiles_put_1.setValue("top10.jsp");
    int _jspx_eval_tiles_put_1 = _jspx_th_tiles_put_1.doStartTag();
    if (_jspx_th_tiles_put_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_tiles_put_value_name_nobody.reuse(_jspx_th_tiles_put_1);
    return false;
  }

  private boolean _jspx_meth_tiles_put_2(javax.servlet.jsp.tagext.JspTag _jspx_th_tiles_insert_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  tiles:put
    org.apache.struts.taglib.tiles.PutTag _jspx_th_tiles_put_2 = (org.apache.struts.taglib.tiles.PutTag) _jspx_tagPool_tiles_put_type_name.get(org.apache.struts.taglib.tiles.PutTag.class);
    _jspx_th_tiles_put_2.setPageContext(_jspx_page_context);
    _jspx_th_tiles_put_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_tiles_insert_0);
    _jspx_th_tiles_put_2.setName("head_login");
    _jspx_th_tiles_put_2.setType("string");
    int _jspx_eval_tiles_put_2 = _jspx_th_tiles_put_2.doStartTag();
    if (_jspx_eval_tiles_put_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_tiles_put_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_tiles_put_2.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_tiles_put_2.doInitBody();
      }
      do {
        out.write("\r\n  <span class=\"pref\">Meine Daten&nbsp;</span>\r\n  <span class=\"pref\"><a href=\"basket.jsp\">Warenkorb</a></span>\r\n");
        int evalDoAfterBody = _jspx_th_tiles_put_2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_tiles_put_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
        out = _jspx_page_context.popBody();
    }
    if (_jspx_th_tiles_put_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_tiles_put_type_name.reuse(_jspx_th_tiles_put_2);
    return false;
  }

  private boolean _jspx_meth_tiles_put_3(javax.servlet.jsp.tagext.JspTag _jspx_th_tiles_insert_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  tiles:put
    org.apache.struts.taglib.tiles.PutTag _jspx_th_tiles_put_3 = (org.apache.struts.taglib.tiles.PutTag) _jspx_tagPool_tiles_put_type_name.get(org.apache.struts.taglib.tiles.PutTag.class);
    _jspx_th_tiles_put_3.setPageContext(_jspx_page_context);
    _jspx_th_tiles_put_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_tiles_insert_0);
    _jspx_th_tiles_put_3.setName("contentbody");
    _jspx_th_tiles_put_3.setType("string");
    int _jspx_eval_tiles_put_3 = _jspx_th_tiles_put_3.doStartTag();
    if (_jspx_eval_tiles_put_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_tiles_put_3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_tiles_put_3.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_tiles_put_3.doInitBody();
      }
      do {
        out.write("\r\n\r\n<!--main list start -->\r\n\r\n            <table style=\"width: 95%;\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" align=\"center\">\r\n              <tbody>\r\n                <tr>\r\n                  <td align=\"center\" width=\"20%\"><img style=\"width: 156px; height: 180px;\" src=\"\" alt=\"Mainpicture\" title=\"Mainpicture\"></td>\r\n                  <td>\r\n                  <span class=\"detail_title\">Titel des Films Over </span><br/>\r\n<span class=\"detail_genre\">Genre1, Genre2</span><br>\r\n<span class=\"detail_describ\">ganz lang </span>\r\nund dann drei Punkte . . .<br>\r\nVorhanden: 3 DVD's<br>\r\n                  </td>\r\n                </tr>\r\n                <tr>\r\n                  <td style=\"width: 100%;\" colspan=\"2\"> <span class=\"detail_hartist\">Darsteller</span><br/>\r\n                    <span class=\"detail_artist\">Max Schmeling</span>\r\n                  </td>\r\n                </tr>\r\n                <tr>\r\n                  <td style=\"width: 100%;\" colspan=\"2\"> <span class=\"detail_hdir\">Regie </span><br/>\r\n                    <span class=\"detail_dir\">&nbsp;</span>\r\n");
        out.write("                  </td>\r\n                </tr>\r\n                <tr>\r\n                  <td style=\"width: 100%;\" colspan=\"2\"> <span class=\"detail_haudio\">AudioFormate</span><br/>\r\n                    <span class=\"detail_audio\">&nbsp;</span>\r\n                  </td>\r\n                </tr>\r\n                <tr>\r\n                  <td style=\"width: 100%;\" colspan=\"2\"> <span class=\"detail_hvideo\">VideoFormate</span><br/>\r\n                    <span class=\"detail_video\">&nbsp;</span>\r\n                  </td>\r\n                </tr>\r\n              </tbody>\r\n            </table>\r\n            <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"width: 90%;\" align=\"center\">\r\n              <tbody>\r\n                <tr>\r\n                  <th colspan=\"4\" class=\"detail_hpicture\" style=\"text-align:left;\">Weitere Bilder </th>\r\n                </tr>\r\n                <tr>\r\n                  <td class=\"detail_picture\">Bild 1</td>\r\n                  <td class=\"detail_picture\">Bild 2</td>\r\n                  <td class=\"detail_picture\">Bild 3</td>\r\n");
        out.write("                  <td class=\"detail_picture\">Bild 4</td>\r\n                </tr>\r\n              </tbody>\r\n            </table>\r\n\r\n\r\n\r\n<!--main list end -->\r\n\r\n\r\n\r\n\r\n  ");
        int evalDoAfterBody = _jspx_th_tiles_put_3.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_tiles_put_3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
        out = _jspx_page_context.popBody();
    }
    if (_jspx_th_tiles_put_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_tiles_put_type_name.reuse(_jspx_th_tiles_put_3);
    return false;
  }
}
