<%@ taglib uri="/WEB-INF/struts-bean.tld"  prefix="bean"  %>
<%@ taglib uri="/WEB-INF/struts-html.tld"  prefix="html"  %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>

<html:html locale="true">
<head>
  <title><bean:message key="registrate.title" /></title>
  <html:base />
</head>
<body bgcolor="white">

<logic:notPresent name="org.apache.struts.action.MESSAGE" scope="application">
  <font color="red">ERROR: Application resources not loaded</font>
</logic:notPresent>

<h3><bean:message key="registrate.heading" /></h3>
<p> <bean:message key="registrate.message" /></p>

<html:form action="/htmlFormActionPath" focus="username">
<p> <bean:message key="registrate.UserName" />:
    <html:text property="username" size="40" maxlength="40" /><br/>
    <font color=red><html:errors property="username" /></font></p>
<p> <bean:message key="registrate.LastName" />:
    <html:text property="lastname" size="40" maxlength="40" /><br/>
    <font color=red><html:errors property="lastname" /></font></p>
<p> <bean:message key="registrate.FirstName" />:
    <html:text property="firstname" size="40" maxlength="40" /><br/>
    <font color=red><html:errors property="firstname" /></font></p>
<p> <bean:message key="registrate.Password" />:
    <html:text property="password" size="40" maxlength="40" /><br/>
    <font color=red><html:errors property="password" /></font></p>
<p> <bean:message key="registrate.RePassword" />:
    <html:text property="repassword" size="40" maxlength="40" /><br/>
    <font color=red><html:errors property="repassword" /></font></p>
<p> <bean:message key="registrate.Email" />:
    <html:text property="email" size="40" maxlength="40" /><br/>
    <font color=red><html:errors property="email" /></font></p>
<p> <html:submit property="action" value="Registrate" />
    <html:submit property="action" value="Cancel" /></p>

</html:form>

</body>
</html:html>