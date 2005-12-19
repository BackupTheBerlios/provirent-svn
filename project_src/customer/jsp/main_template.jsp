<%@ taglib uri="/WEB-INF/struts-tiles.tld"  prefix="tiles"  %>
<%@ taglib uri="/WEB-INF/struts-html.tld"  prefix="html"  %>
<%@ taglib uri="/WEB-INF/struts-bean.tld"  prefix="bean"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld"  prefix="logic"  %>
<html:html>
<head>
	<html:base/>
	<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
  <title>PROfessional VIdeo RENTalStore </title>
  <link rel="stylesheet" type="text/css" href="<html:rewrite page='/css/style.css' />" title="externe Styles">
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
            <td colspan="7" bgcolor="#000000"><html:img page="/pics/1pxtrans.gif"/></td>
            <td background="border_r.gif"><img src="1pxtrans.gif" height="1" width="3"></td>
          </tr>
          <tr>
            <td bgcolor="#000000" width="1"><html:img page="/pics/1pxtrans.gif"/></td>
            <td colspan="5" height="70"><html:img page="/pics/provirent-logo.png" height="70" width="500" alt="provirent-Logo"/></td>
            <td bgcolor="#000000" width="1"><html:img page="/pics/1pxtrans.gif"/></td>
            <td background="border_r.gif"><img src="1pxtrans.gif" width="3"></td>
          </tr>
          <tr>
            <td colspan="7" bgcolor="#000000"><html:img page="/pics/1pxtrans.gif"/></td>
            <td background="border_r.gif"><img src="1pxtrans.gif" height="1" width="3"></td>
          </tr>
          <tr>
            <td bgcolor="#000000" width="1"><html:img page="/pics/1pxtrans.gif"/></td>
            <td colspan="5" height="20" valign="middle">
            <table border="0" cellpadding="0" cellspacing="0" width="100%">
              <tbody>
                <tr>
				 <td>
<!--head start-->

<tiles:insert attribute="mitglieder" />

<!--head end-->
          </td>
				</tr>
              </tbody>
            </table>
            </td>
            <td bgcolor="#000000" width="1"><html:img page="/pics/1pxtrans.gif"/></td>
            <td background="border_r.gif"><img src="1pxtrans.gif" width="3"></td>
          </tr>
          <tr>
            <td colspan="7" bgcolor="#000000"><html:img page="/pics/1pxtrans.gif"/></td>
            <td background="border_r.gif"><img src="1pxtrans.gif" height="1" width="3"></td>
          </tr>
          <tr>
            <td colspan="7" bgcolor="#f9efd2" height="2"><html:img page="/pics/1pxtrans.gif"/></td>
            <td bgcolor="#f9efd2"><img src="1pxtrans.gif" height="1" width="3"></td>
          </tr>
          <tr>
            <td colspan="3" bgcolor="#000000"><html:img page="/pics/1pxtrans.gif"/></td>
            <td colspan="1" bgcolor="#f9efd2" width="2"><html:img page="/pics/1pxtrans.gif"/></td>
            <td colspan="3" bgcolor="#000000"><html:img page="/pics/1pxtrans.gif"/></td>
            <td background="border_r.gif"><img src="1pxtrans.gif" height="1" width="3"></td>
          </tr>
          <tr>
            <td bgcolor="#000000" width="1"><html:img page="/pics/1pxtrans.gif"/></td>
            <td valign="top">
<!--menue start-->

<tiles:insert attribute="navigation" />

<!--menue end--> 
			</td>
            <td bgcolor="#000000" width="1"><html:img page="/pics/1pxtrans.gif"/></td>
            <td bgcolor="#f9efd2" width="2"><html:img page="/pics/1pxtrans.gif"/></td>
            <td bgcolor="#000000" width="1"><html:img page="/pics/1pxtrans.gif"/></td>
            <td valign="top" width="85%">
<!--main start-->
<logic:present name="org.apache.struts.action.ERROR">
		<html:errors/>
		<br/>
</logic:present>

<tiles:insert attribute="inhalt" />
<!--main end-->
			</td>
            <td bgcolor="#000000" width="1"><html:img page="/pics/1pxtrans.gif"/></td>
            <td background="border_r.gif"><img src="1pxtrans.gif" width="3"></td>
          </tr>
          <tr>
            <td colspan="3" bgcolor="#000000"><html:img page="/pics/1pxtrans.gif"/></td>
            <td colspan="1" bgcolor="#f9efd2" width="2"><html:img page="/pics/1pxtrans.gif"/></td>
            <td colspan="3" bgcolor="#000000"><html:img page="/pics/1pxtrans.gif"/></td>
            <td background="border_r.gif"><img src="1pxtrans.gif" height="1" width="3"></td>
          </tr>
          <tr>
            <td colspan="7" bgcolor="#f9efd2" height="2"><html:img page="/pics/1pxtrans.gif"/></td>
            <td bgcolor="#f9efd2"><img src="1pxtrans.gif" height="1" width="1"></td>
          </tr>
          <tr>
            <td colspan="7" bgcolor="#000000"><html:img page="/pics/1pxtrans.gif"/></td>
            <td background="border_r.gif"><img src="1pxtrans.gif" height="1" width="3"></td>
          </tr>
          <tr>
            <td bgcolor="#000000" width="1"><html:img page="/pics/1pxtrans.gif"/></td>
            <td colspan="5">
            <div class="copyright">&copy;
Remo Griesch,
Stefan Forstner, Philipp Schneider<br>
            </div>
            </td>
            <td bgcolor="#000000" width="1"><html:img page="/pics/1pxtrans.gif"/></td>
            <td background="border_r.gif"><img src="1pxtrans.gif" width="3"></td>
          </tr>
          <tr>
            <td colspan="7" bgcolor="#000000"><html:img page="/pics/1pxtrans.gif"/></td>
            <td background="border_r.gif"><img src="1pxtrans.gif" height="1" width="3"></td>
          </tr>
          <tr>
            <td colspan="7" background="border.gif"><img src="border_bl.gif" height="7"></td>
            <td background="border_br.gif"><img src="1pxtrans.gif" height="1" width="3"></td>
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
</html:html>
