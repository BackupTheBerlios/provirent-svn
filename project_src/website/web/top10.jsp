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

<!--main list start -->


<!-- 1 start-->
<table border="0" cellpadding="0" cellspacing="0" width="100%">
  <tbody>
    <tr>
      <td align="center" width="20%"><img style="width: 75px; height: 75px;" src="" alt="" border="0"></td>
        <td>
          <span class="list_title">Titel des Films </span>
          <span class="list_summary">Hier kommt ein ganz kurzer Text rein<br>
            ganz lang <br>
              und dann drei Punkte . . . <a href="details.jsp">&gt;&gt;mehr&lt;&lt;</a> </span></td>
              <td width="10%"><a href="#">Bestellen</a></td>
            </tr>
          </tbody>
        </table>
<!-- 1 end-->

<!-- 2 start-->
<table border="0" cellpadding="0" cellspacing="0" width="100%">
  <tbody>
    <tr>
      <td align="center" width="20%"><img style="width: 75px; height: 75px;" src="" alt="" border="0"></td>
        <td>
          <span class="list_title">Titel des Films </span>
          <span class="list_summary">Hier kommt ein ganz kurzer Text rein<br>
            ganz lang <br>
              und dann drei Punkte . . . <a href="details.jsp">&gt;&gt;mehr&lt;&lt;</a> </span></td>
              <td width="10%"><a href="#">Bestellen</a></td>
            </tr>
          </tbody>
        </table>
<!--2 end-->


<!--main list end -->

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



  </tiles:put>
</tiles:insert>



