<%@ taglib uri="/taglib/struts-bean" prefix="bean" %>
<%@ taglib uri="/taglib/struts-html" prefix="html" %>
<%@ taglib uri="/taglib/struts-logic" prefix="logic" %>
<%@ taglib uri="/taglib/struts-tiles" prefix="tiles" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title><tiles:getAsString name="title"/></title>
  <html:base/>
  <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
  <link rel="stylesheet" type="text/css" href="<html:rewrite page='/style.css'/>" title="externe Styles">
</head>

<body>
<table align="center" border="0" cellpadding="0" cellspacing="0" width="100%">
  <tbody>
    <tr>
      <td width="10%">&nbsp;</td>
      <td>&nbsp;</td>
      <td width="10%">&nbsp;</td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td>
      <table align="center" bgcolor="#c2d9c1" border="0" cellpadding="0" cellspacing="0" width="100%">
        <tbody>
          <tr>
            <td colspan="7" bgcolor="#000000"><img src="images/1pxtrans.gif" alt=""></td>
            <td style="background-image: url(images/border_r.gif);"><img src="images/1pxtrans.gif" height="1" width="3" alt=""></td>
          </tr>
          <tr>
            <td bgcolor="#000000" width="1"><img src="images/1pxtrans.gif" alt=""></td>
            <td colspan="5" height="70">Logo</td>
            <td bgcolor="#000000" width="1"><img src="images/1pxtrans.gif" alt=""></td>
            <td style="background-image: url(images/border_r.gif);"><img src="images/1pxtrans.gif" width="3" alt=""></td>
          </tr>
          <tr>
            <td colspan="7" bgcolor="#000000"><img src="images/1pxtrans.gif" alt=""></td>
            <td style="background-image: url(images/border_r.gif);"><img src="images/1pxtrans.gif" height="1" width="3" alt=""></td>
          </tr>
          <tr>
            <td bgcolor="#000000" width="1"><html:img page="/images/1pxtrans.gif" alt=""/></td>
            <td colspan="5" height="20" valign="middle">
            <table border="0" cellpadding="0" cellspacing="0" width="100%">
              <tbody>
                <tr>
                  <td width="53%">
                    <!--head start-->
                    <div align="left">

                      <logic:present name="user">
                        <span class="pref">
                          <html:link forward="pref">Meine Daten</html:link>&nbsp;
                          <html:link forward="basket">Warenkorb</html:link>&nbsp;
                          <html:link forward="logout">Logout</html:link>
                        </span>

                      </logic:present>
                      <logic:notPresent scope="session" name="user">
                        <html:form action="/LogonSubmit" focus="username" method="post">
                          <span class="login_label">Benutzername:</span>
                          <html:text property="username"size="13" styleClass="login"/>
                          <span class="login_label">Password:</span>
                          <html:password property="password" size="13" styleClass="login" redisplay="false"/>
                          <html:submit styleClass="submit_search" value="login"/>
                        </html:form>
                      </logic:notPresent>

                    </div>
                  </td>
                  <td width="50%">
                    <div class="head_menue" align="right">
                     	<a href="index.jsp" class="head_menue">&Uuml;bersicht</a>&nbsp;|&nbsp;<a href="index.jsp" class="head_menue">Impressum</a>&nbsp;|&nbsp;<a href="index.jsp" class="head_menue">Hilfe</a>&nbsp;
                    </div>

                    <!--head end-->
                  </td>
 </tr>
              </tbody>
            </table>
            </td>
            <td bgcolor="#000000" width="1"><img src="images/1pxtrans.gif" alt=""></td>
            <td style="background-image: url(images/border_r.gif);"><img src="images/1pxtrans.gif" width="3" alt=""></td>
          </tr>
          <tr>
            <td colspan="7" bgcolor="#000000"><img src="images/1pxtrans.gif" alt=""></td>
            <td style="background-image: url(images/border_r.gif);"><img src="images/1pxtrans.gif" height="1" width="3" alt=""></td>
          </tr>
          <tr>
            <td colspan="7" bgcolor="#f9efd2" height="2"><img src="images/1pxtrans.gif" alt=""></td>
            <td bgcolor="#f9efd2"><img src="images/1pxtrans.gif" height="1" width="3" alt=""></td>
          </tr>
          <tr>
            <td colspan="3" bgcolor="#000000"><img src="images/1pxtrans.gif" alt=""></td>
            <td colspan="1" bgcolor="#f9efd2" width="2"><img src="images/1pxtrans.gif" alt=""></td>
            <td colspan="3" bgcolor="#000000"><img src="images/1pxtrans.gif" alt=""></td>
            <td style="background-image: url(images/border_r.gif);"><img src="images/1pxtrans.gif" height="1" width="3" alt=""></td>
          </tr>
          <tr>
            <td bgcolor="#000000" width="1"><img src="images/1pxtrans.gif" alt=""></td>
            <td valign="top">
<!--menue start-->
            <table class="menue_tbl" border="0" cellpadding="0" cellspacing="0">
              <thead class="menue_tbl"> <tr>
                <th>Aktuelles</th>
              </tr>
              </thead> <tbody class="menue_tbl">
                <tr>
                  <td class="menue_tbl"><html:link forward="search/new">Neuheiten</html:link></td>
                </tr>
                <tr>
                  <td class="menue_tbl"><html:link forward="search/top10month">Top 10 Monat</html:link></td>
                </tr>
                <tr>
                  <td class="menue_tbl"><html:link forward="search/top100year">Top 100 Jahr</html:link></td>
                </tr>
                <tr>
                  <td class="menue_tbl"><html:link forward="search/preview">Vorschau</html:link></td>
                </tr>
              </tbody>
            </table>
            <br>
            <table class="menue_suche" border="0" cellpadding="0" cellspacing="0">
              <thead class="menue_tbl"> <tr>
                <th colspan="2">Suche</th>
              </tr>
            </thead> <tbody>
              <tr>
                <td colspan="2">

                  <html:form action="/SearchSubmit" focus="username" method="post">
                    <html:text property="searchfor"size="13" styleClass="login"/>
                  </td>
                </tr>
                <tr>
                  <td>

                    <html:select property="selectName" size="1" multiple="false">
                      <html:option value="0">all</html:option>
                      <html:option value="1">Movie</html:option>
                      <html:option value="2">Artist</html:option>
                      <html:option value="3">Genre</html:option>
                    </html:select>

                  </td>
                  <td>
                    <html:submit styleClass="submit_search" value="Suche"/>
                  </html:form>




                  </td>
                </tr>
              </tbody>
            </table>
            <br>
            <table class="menue_tbl" border="0" cellpadding="0" cellspacing="0">
              <thead class="menue_tbl"> <tr>
                <th>Genre</th>
              </tr>
              </thead> <tbody  class="menue_tbl">
                <tr>
                  <td class="menue_tbl"><a href="#" class="menue_tbl"> Action </a></td>
                </tr>
                <tr>
                  <td class="menue_tbl"><a href="#" class="menue_tbl"> Drama </a></td>
                </tr>
                <tr>
                  <td class="menue_tbl"><a href="#" class="menue_tbl"> Comedy </a></td>
                </tr>
                <tr>
                  <td class="menue_tbl"><a href="#" class="menue_tbl"> Thriller </a></td>
                </tr>
              </tbody>
            </table>


<!--menue end--> </td>
            <td bgcolor="#000000" width="1"><img src="images/1pxtrans.gif" alt=""></td>
            <td bgcolor="#f9efd2" width="3"><img src="images/1pxtrans.gif" alt=""></td>
            <td bgcolor="#000000" width="1"><img src="images/1pxtrans.gif" alt=""></td>
            <td valign="top" width="85%" style="padding-top:20px; padding-right:1px; padding-left: 1px;">
<!--main start-->
<html:errors/>
&nbsp;<br />
<tiles:insert attribute='contentbody' />

<!--main end--> </td>
            <td bgcolor="#000000" width="1"><img src="images/1pxtrans.gif" alt=""></td>
            <td style="background-image: url(images/border_r.gif);"><img src="images/1pxtrans.gif" width="3" alt=""></td>
          </tr>
          <tr>
            <td colspan="3" bgcolor="#000000"><img src="images/1pxtrans.gif" alt=""></td>
            <td colspan="1" bgcolor="#f9efd2" width="2"><img src="images/1pxtrans.gif" alt=""></td>
            <td colspan="3" bgcolor="#000000"><img src="images/1pxtrans.gif" alt=""></td>
            <td style="background-image: url(images/border_r.gif);"><img src="images/1pxtrans.gif" height="1" width="3" alt=""></td>
          </tr>
          <tr>
            <td colspan="7" bgcolor="#f9efd2" height="2"><img src="images/1pxtrans.gif" alt=""></td>
            <td bgcolor="#f9efd2"><img src="images/1pxtrans.gif" height="1" width="1" alt=""></td>
          </tr>
          <tr>
            <td colspan="7" bgcolor="#000000"><img src="images/1pxtrans.gif" alt=""></td>
            <td style="background-image: url(images/border_r.gif);"><img src="images/1pxtrans.gif" height="1" width="3" alt=""></td>
          </tr>
          <tr>
            <td bgcolor="#000000" width="1"><img src="images/1pxtrans.gif" alt=""></td>
            <td colspan="5">
            <div class="copyright">&copy;
Remo Griesch,
Stefan Forstner, Philipp Schneider<br>
            </div>
            </td>
            <td bgcolor="#000000" width="1"><img src="images/1pxtrans.gif" alt=""></td>
            <td style="background-image: url(images/border_r.gif);"><img src="images/1pxtrans.gif" width="3" alt=""></td>
          </tr>
          <tr>
            <td colspan="7" bgcolor="#000000"><img src="images/1pxtrans.gif" alt=""></td>
            <td style="background-image: url(images/border_r.gif);"><img src="images/1pxtrans.gif" height="1" width="3" alt=""></td>
          </tr>
          <tr>
            <td colspan="7" style="background-image: url(images/border.gif);"><img src="border_bl.gif" height="7" alt=""></td>
            <td style="background-image: url(images/border_br.gif);"><img src="images/1pxtrans.gif" height="1" width="3" alt=""></td>
          </tr>
        </tbody>
      </table>
      </td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
  </tbody>
</table>



</body>
</html>
