<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<tiles:insert page="/templates/main.jsp" flush="true">

<tiles:put name="title" value="PROfessional VIdeo RENTalStore" />
<tiles:put name="top10month_link" value="top10.jsp" />

<tiles:put name="contentbody" type="string">



<logic:present name="SearchResults">
<!--top browse start -->
            <table style="width: 95%; text-align: left;" border="0" cellpadding="0" cellspacing="0" align="center">
              <tbody>
                <tr>
                  <td class="prev_page_browse">&nbsp;&nbsp; <a href="">&lt;&lt; zur&uuml;ck &lt;&lt;</a><br>
													</td>
                  <td class="overview_page_browse" style="">&nbsp;Seite 1 / 5 <br>
                  </td>
                  <td class="next_page_browse">&nbsp;<a href="">&gt;&gt; vor &gt;&gt;</a>&nbsp;&nbsp;<br>
                  </td>
                </tr>
              </tbody>
            </table>
<!--top browse end -->

  <logic:iterate id="movie" name="SearchResults">

    <table border="0" cellpadding="0" cellspacing="0" width="100%">
      <tbody>
        <tr>
          <td align="center" width="20%"><img style="width: 75px; height: 75px;" src="" alt="" border="0">
          </td>
          <td>
            <span class="list_title"><bean:write name="movie" property="movietitle"/></span>
            <span class="list_summary"><bean:write name="movie" property="moviedescrib"/>
              <html:link forward="logout" paramId="id" paramProperty="movieid" paramName="movie">
                &gt;&gt;mehr&lt;&lt;
              </html:link>
            </span>
          </td>
          <td width="10%">
            <a href="#">Bestellen</a>
          </td>
        </tr>
      </tbody>
    </table>
  </logic:iterate>


  <!--bottom browse start -->
            <table style="width: 95%; text-align: left;" border="0" cellpadding="0" cellspacing="0" align="center">
              <tbody>
                <tr>
                  <td class="prev_page_browse">&nbsp;&nbsp; <a href="">&lt;&lt; zur&uuml;ck &lt;&lt;</a><br>
													</td>
                  <td class="overview_page_browse" style="">&nbsp;Seite 1 / 5 <br>
                  <a href="" class="single_page_browse">1</a>&nbsp;&nbsp;
                  <a href="" class="single_page_browse">2</a>&nbsp;&nbsp;
                  <a href="" class="single_page_browse">3</a>&nbsp;&nbsp;
                  <a href="" class="single_page_browse">4</a>&nbsp;&nbsp;
                  <a href="" class="single_page_browse">5</a>&nbsp;&nbsp;
                  </td>
                  <td class="next_page_browse">&nbsp;<a href="">&gt;&gt; vor &gt;&gt;</a>&nbsp;&nbsp;<br>
                  </td>
                </tr>
              </tbody>
            </table>
<!--bottom browse end -->

</logic:present>
</tiles:put>

</tiles:insert>
