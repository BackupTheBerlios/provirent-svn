<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<tiles:insert page="/templates/main.jsp" flush="true">

  <tiles:put name="title" value="PROfessional VIdeo RENTalStore" />

  <tiles:put name="contentbody" type="string">

    <logic:present name="MovieDetails">

    <table style="width: 95%;" border="0" cellpadding="0" cellspacing="0" align="center">
      <tbody>
        <tr>
          <td align="center" width="20%"><img style="width: 156px; height: 180px;" src="" alt="Mainpicture" title="Mainpicture"></td>
            <td>
              <span class="detail_title"><bean:write name="MovieDetails" property=""/></span><br/>
              <span class="detail_genre">Genre1, Genre2</span><br/>
              <span class="detail_describ"><bean:write name="MovieDetails" property=""/></span>
            </td>
                </tr>
                <tr>
                  <td style="width: 100%;" colspan="2"> <span class="detail_hartist">Darsteller</span><br/>
                    <span class="detail_artist"><bean:write name="MovieDetails" property=""/></span>
                  </td>
                </tr>
                <tr>
                  <td style="width: 100%;" colspan="2"> <span class="detail_hdir">Regie </span><br/>
                    <span class="detail_dir"><bean:write name="MovieDetails" property=""/></span>
                  </td>
                </tr>
                <tr>
                  <td style="width: 100%;" colspan="2"> <span class="detail_haudio">AudioFormate</span><br/>
                    <span class="detail_audio"><bean:write name="MovieDetails" property=""/></span>
                  </td>
                </tr>
                <tr>
                  <td style="width: 100%;" colspan="2"> <span class="detail_hvideo">VideoFormate</span><br/>
                    <span class="detail_video"><bean:write name="MovieDetails" property=""/></span>
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
      </logic:present>

      <logic:notPresent name="MovieDetails">
        Keine Details zu diesem Film gefunden
      </logic:notPresent>
          </tiles:put>

        </tiles:insert>
