<%@ taglib uri="/tags/struts-bean.tld"  prefix="bean"  %>
<%@ taglib uri="/tags/struts-html.tld"  prefix="html"  %>
<%@ taglib uri="http://displaytag.sf.net"  prefix="display"  %>


            <table border="0" cellpadding="0" cellspacing="0" width="100%">
              <tbody>
                <tr>
                  <td align="center" width="20%"><img style="width: 75px; height: 75px;" src="" alt="" border="0"></td>
                  <td>
                  <span class="list_title">Titel des Films </span>
<span class="list_summary">Hier kommt ein ganz kurzer Text rein<br>
ganz lang <br>
und dann drei Punkte . . . <a href="#">&gt;&gt;mehr&lt;&lt;</a> </span></td>
                  <td width="10%">
Bestellen </td>
                </tr>
              </tbody>
            </table>
            <br>
&nbsp; <br>
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

<display:table name="sessiongenrelist"  pagesize="2" class="list">
	<display:column property="id" />

</display:table> 

