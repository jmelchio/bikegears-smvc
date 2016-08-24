<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/pages/fragments/taglibs.jspf" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@ include file="/WEB-INF/pages/fragments/headSection.jspf" %>
        <title><spring:message code="application.title"/></title>
    </head>
    <body>
        <div id="container">
            <%@ include file="/WEB-INF/pages/fragments/header.jspf" %>
            <%@ include file="/WEB-INF/pages/fragments/menu.jspf" %>
            <div id="content">
                <h2><spring:message code="welcome.header"/></h2>
                <p><spring:message code="welcome.text"/></p>
            </div>
            <%@ include file="/WEB-INF/pages/fragments/footer.jspf" %>
        </div>
    </body>
</html>
