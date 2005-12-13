<%@ taglib uri="/tags/struts-bean.tld"  prefix="bean"  %>
<%@ taglib uri="/tags/struts-html.tld"  prefix="html"  %>
<%@ taglib uri="/tags/c.tld" prefix="c" %>


            <table class="menue_tbl" border="0" cellpadding="0" cellspacing="0">
              <thead class="menue_tbl"> <tr>
                <th>Aktuelles</th>
              </tr>
              </thead> <tbody class="menue_tbl">
                <tr>
                  <td class="menue_tbl"><a href="#">Neuheiten</a></td>
                </tr>
                <tr>
                  <td class="menue_tbl"><a href="http://www.web.de" class="menue_tbl">Top 10 Monat</a></td>
                </tr>
                <tr>
                  <td class="menue_tbl"><a href="#">Top 100 Jahr</a></td>
                </tr>
                <tr>
                  <td class="menue_tbl"><a href="#">Vorschau</a></td>
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
                  <td class="menue_tbl"><html:link action="genre/action.do"> Action </html:link></td>
                </tr>
                <tr>
                  <td class="menue_tbl"><a href="#"> Drama </a></td>
                </tr>
                <tr>
                  <td class="menue_tbl"><a href="#"> Comedy </a></td>
                </tr>
                <tr>
                  <td class="menue_tbl"><a href="#"> Thriller </a></td>
                </tr>
              </tbody>
            </table>