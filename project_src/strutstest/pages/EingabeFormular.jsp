<%@ taglib uri="/WEB-INF/struts-bean.tld"  prefix="bean"  %>
<%@ taglib uri="/WEB-INF/struts-html.tld"  prefix="html"  %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>

<html:html locale="true">
<head>
  <title><bean:message key="welcome.title" /></title>
  <html:base />
</head>
<body bgcolor="white">

<logic:notPresent name="org.apache.struts.action.MESSAGE" scope="application">
  <font color="red">ERROR: Application resources not loaded</font>
</logic:notPresent>

<h3><bean:message key="welcome.heading" /></h3>
<p> <bean:message key="welcome.message" /></p>

<html:form action="/htmlFormActionPath" focus="username">
<p> <bean:message key="welcome.Name" />:
    <html:text property="username" size="40" maxlength="40" /><br/>
    <font color=red><html:errors property="username" /></font></p>
<p> <bean:message key="welcome.Password" />:
    <html:text property="password" size="40" maxlength="40" /><br/>
    <font color=red><html:errors property="password" /></font></p>
<p> <html:submit property="action" value="Weiter" />
    <html:submit property="action" value="Abbrechen" /></p>
<p> <html:link property="action" value="registrate"</p>

</html:form>

</body>
</html:html>
