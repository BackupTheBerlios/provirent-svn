<%@ taglib uri="/WEB-INF/taglib/struts-tiles.tld" prefix="tiles"%>
<%@ taglib uri="/WEB-INF/taglib/struts-logic.tld" prefix="logic"%>

<tiles:insert page="/templates/main.jsp" flush="true">

<tiles:put name="title" value="Top 10" />
<tiles:put name="top10month_link" value="top10.jsp" />

<tiles:put name="head_login" type="string">
  <span class="pref"><a href="pref.jsp" class="pref">Meine Daten</a>&nbsp;</span>
  <span class="pref"><a href="basket.jsp" class="pref">Warenkorb</a></span>
  <span class="pref"><a href="logout.jsp" class="pref">Logout</a></span>
</tiles:put>

<tiles:put name="contentbody" type="string">

<!--main list start -->

            <table style="width: 95%;" border="0" cellpadding="0" cellspacing="0" align="center">
              <tbody>
                <tr>
                  <td align="center" width="20%"><img style="width: 156px; height: 180px;" src="" alt="Mainpicture" title="Mainpicture"></td>
                  <td>
                  <span class="detail_title">Titel des Films Over </span><br/>
<span class="detail_genre">Genre1, Genre2</span><br>
<span class="detail_describ">ganz lang </span>
und dann drei Punkte . . .<br>
Vorhanden: 3 DVD's<br>
                  </td>
                </tr>
                <tr>
                  <td style="width: 100%;" colspan="2"> <span class="detail_hartist">Darsteller</span><br/>
                    <span class="detail_artist">Max Schmeling</span>
                  </td>
                </tr>
                <tr>
                  <td style="width: 100%;" colspan="2"> <span class="detail_hdir">Regie </span><br/>
                    <span class="detail_dir">&nbsp;</span>
                  </td>
                </tr>
                <tr>
                  <td style="width: 100%;" colspan="2"> <span class="detail_haudio">AudioFormate</span><br/>
                    <span class="detail_audio">&nbsp;</span>
                  </td>
                </tr>
                <tr>
                  <td style="width: 100%;" colspan="2"> <span class="detail_hvideo">VideoFormate</span><br/>
                    <span class="detail_video">&nbsp;</span>
                  </td>
                </tr>
              </tbody>
            </table>
            <table border="1" cellpadding="0" cellspacing="0" style="width: 90%;" align="center">
              <tbody>
                <tr>
                  <th colspan="4" class="detail_hpicture" style="text-align:left;">Weitere Bilder </th>
                </tr>
                <tr>
                  <td class="detail_picture">Bild 1</td>
                  <td class="detail_picture">Bild 2</td>
                  <td class="detail_picture">Bild 3</td>
                  <td class="detail_picture">Bild 4</td>
                </tr>
              </tbody>
            </table>



<!--main list end -->




  </tiles:put>
</tiles:insert>



