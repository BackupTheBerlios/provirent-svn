<%@ taglib uri="/WEB-INF/taglib/struts-tiles.tld" prefix="tiles"%>

<tiles:insert page="/templates/main.jsp" flush="true">

<tiles:put name="title" value="PROfessional VIdeo RENTalStore" />
<tiles:put name="top10month_link" value="top10.jsp" />

<tiles:put name="contentbody" type="string">
  Willkommen auf unserer neuen Webseite<br/>
</tiles:put>

<tiles:put name="head_login" type="string">
                        <form id="login" action="" method="post" name="LoginForm">
                        <label class="login_label">Benutzername:</label>
                        <input class="login" style="font-weight: bold;" name="username" size="13" type="text"/>
                        <label class="login_label">Password:</label>
                        <input class="login" name="userpassword" size="14" type="password"/>
                        <input id="submit_search" type="submit" value="login" />
                      </form>
</tiles:put>
</tiles:insert>



