<%@ taglib uri="/WEB-INF/struts-html.tld"  prefix="html"  %>
<%@ taglib uri="/WEB-INF/struts-bean.tld"  prefix="bean"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<c:choose>
    <c:when test="${empty sessionScope.sessionuser}">

	  <div align="right">
		<table cellspacing="0" cellpadding="0" border="0">
		
			<html:form action="/Login" method="post">
			  <tr>
			  	<td>
                  <label class="login_label"><bean:message key="main.login.username"/>:</label>
                  <html:text property="username" styleClass="login" style="font-weight: bold;" size="13"/>
				</td>
			  	<td>
                  <label class="login_label"><bean:message key="main.login.passwort"/>:</label>
                  <html:password property="password" styleClass="login" size="14" />
				</td>
				<td>
					<html:submit title="main.login.submit" styleId="submit_search"/>
				</td>
			  </tr>
			</html:form>
			
	  	</table>
	  </div>

    </c:when>
	<c:otherwise>
	
		<bean:define id="user" scope="session" name="sessionuser"/>
		
			<table width="100%" cellspacing="0" cellpadding="0" border="0">
			
				<tr>
				  	<td>
	                  <span class="pref">Herzlich willkommen, ${user.person.firstName}&nbsp;${user.person.lastName} !!!  &nbsp;</span>
					</td>
				  	<td align="right">
	                  <b onmouseover="this.style.cursor ='hand'" onclick="document.location.href = 'Logout.do'">Ausloggen</b>
					</td>
			  	</tr>
				
		  	</table>

    </c:otherwise>	
</c:choose>

<!--
                  </td>
				  </tr>
				  <tr>
                  <td width="100%">
                  <div class="head_menue" align="right">
                  	<a href="index.jsp" class="head_menue">&Uuml;bersicht</a>&nbsp;|&nbsp;<a href="index.jsp" class="head_menue">Impressum</a>&nbsp;|&nbsp;<a href="index.jsp" class="head_menue">Hilfe</a>&nbsp;
                  </div>
-->