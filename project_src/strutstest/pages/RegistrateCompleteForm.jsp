<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>

<html:html>
<head>
  <title><bean:message key="registrateComplete.title" /></title>
</head>
<body>

<logic:notPresent name="org.apache.struts.action.MESSAGE" scope="application">
  <font color="red">ERROR: Application resources not loaded</font>
</logic:notPresent>

<h3><bean:message key="registrateComplete.heading" /></h3>
<p> <bean:message key="registrate.Complete.message" /></p>

<html:form>
	<p> <html:submit property="action" value="OK" /></p>	
</html:form>

</body>
</html:html>