<%@ taglib uri="/WEB-INF/taglib/struts-tiles.tld" prefix="tiles"%>
<%@ taglib uri="/WEB-INF/taglib/struts-html.tld" prefix="html" %>
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
            <td bgcolor="#000000" width="1"><img src="images/1pxtrans.gif" alt=""></td>
            <td colspan="5" height="20" valign="middle">
            <table border="0" cellpadding="0" cellspacing="0" width="100%">
              <tbody>
                <tr>
                  <td width="53%">
                    <!--head start-->
                    <div align="left">
                      <tiles:insert attribute='head_login' />
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
                  <td class="menue_tbl"><a href="#" class="menue_tbl">Neuheiten</a></td>
                </tr>
                <tr>
                  <td class="menue_tbl"><a href="<tiles:getAsString name="top10month_link"/>" class="menue_tbl">Top 10 Monat</td>
                </tr>
                <tr>
                  <td class="menue_tbl"><a href="#" class="menue_tbl">Top 100 Jahr</a></td>
                </tr>
                <tr>
                  <td class="menue_tbl"><a href="#" class="menue_tbl">Vorschau</a></td>
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
                  		<form id="search" action="" method="post" name="SearchForm">
	                  	<input name="searchfor" size="16" type="text">
    	            </td>
    	        </tr>
    	        <tr>
					<td>
        	            <select name="selectName" size="1" id="select_search">
		                    <option value="0">all</option>
		                    <option value="1">Movie</option>
        		            <option value="2">Artist</option>
                		    <option value="3">genre</option>
	                    </select>
                    </td>
                    <td>
    	                <input value="Suche" id="submit_search" type="submit">
    	                </form>
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
