<%@ taglib uri="/WEB-INF/taglib/struts-tiles.tld" prefix="tiles"%>
<%@ taglib uri="/WEB-INF/taglib/struts-logic.tld" prefix="logic"%>

<tiles:insert page="/templates/main.jsp" flush="true">

<tiles:put name="title" value="Top 10" />
<tiles:put name="top10month_link" value="top10.jsp" />

<tiles:put name="head_login" type="string">
  <span class="pref"><a href="pref.jsp" class="pref">Meine Daten</a>&nbsp;</span>
  <span class="pref"><a href="basket.jsp" class="pref">Warenkorb</a>&nbsp;</span>
  <span class="pref"><a href="logout.jsp" class="pref">Logout</a></span>
</tiles:put>

<tiles:put name="contentbody" type="string">


<!--main list start -->

            <table style="width: 90%; text-align: left;" align="center" border="1" cellpadding="0" cellspacing="0">
			<thead class="basket_head">
                <tr>
                  <th style="width: 10%; text-align: center;">Pos<br>
                  </th>
                  <th style="width: 44%; text-align: left;">DVD - Name<br>
                  </th>
                  <th style="width: 15%; text-align: center;">Tage<br>
                  </th>
                  <th style="width: 15%; text-align: center;">Vorhanden<br>
                  </th>
                  <th style="width: 1%;"><br>
                  </th>
                  <th style="width: 15%; text-align: center;">Preis<br>
                  </th>
                </tr>
             </thead>
			<tbody class="basket_item">
                <tr>
                  <td><br>
                  </td>
                  <td><br>
                  </td>
                  <td><br>
                  </td>
                  <td><br>
                  </td>
                  <td><br>
                  </td>
                  <td><br>
                  </td>
                </tr>
                <tr>
                  <td><br>
                  </td>
                  <td><br>
                  </td>
                  <td><br>
                  </td>
                  <td><br>
                  </td>
                  <td><br>
                  </td>
                  <td><br>
                  </td>
                </tr>
              </tbody>
            </table>


<!--main list end -->
  </tiles:put>
</tiles:insert>



