<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>

<html:html>
<head>
  <title>Ergebnisanzeige</title>
</head>
<body>

<h1>Eingegebene Daten</h1>
<p> Name:
    <b><bean:write property="username"
                   name="DatenFormBean" /></b></p>
<p> Passwort:
    <b><bean:write property="password"
                   name="DatenFormBean" /></b></p>

</body>
</html:html>
