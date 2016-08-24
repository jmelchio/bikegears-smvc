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
                <h2><spring:message code="bike.entry.header"/></h2>
                <form:form commandName="bike" action="bikeentry.html">
                    <fieldset>
                        <form:hidden path="id"/>
                        <form:hidden path="bikeRider.id"/>
                        <table>
                            <tr>
                                <td class="nowrap"><label for="brand"><spring:message code="bike.entry.brand"/></label></td>
                                <td><form:input path="brand"/></td>
                                <td><form:errors path="brand"/></td>
                            </tr>
                            <tr>
                                <td class="nowrap"><label for="model"><spring:message code="bike.entry.model"/></label></td>
                                <td><form:input path="model"/></td>
                                <td><form:errors path="model"/></td>
                            </tr>
                            <tr>
                                <td class="nowrap"><label for="year"><spring:message code="bike.entry.year"/></label></td>
                                <td><form:input path="year"/></td>
                                <td><form:errors path="year"/></td>
                            </tr>
                            <tr>
                                <td class="nowrap"><label for="color"><spring:message code="bike.entry.color"/></label></td>
                                <td><form:input path="color"/></td>
                                <td><form:errors path="color"/></td>
                            </tr>
                            <tr>
                                <td class="nowrap"><label for="bikeType.id"><spring:message code="bike.entry.bike.type"/></label></td>
                                <td>
                                    <form:select path="bikeType.id">
                                        <form:option value="-"  label="---------"/>
                                        <form:options items="${bikeTypeList}" itemValue="id" itemLabel="name"/>
                                    </form:select>
                                </td>
                                <td><form:errors path="bikeType.id"/></td>
                            </tr>
                            <tr>
                                <td class="nowrap"><label for="description"><spring:message code="bike.entry.description"/></label></td>
                                <td colspan="2"><form:textarea path="description" cols="40" rows="4"/></td>
                            </tr>
                            <tr>
                                <td colspan="3"><input type="submit" value="<spring:message code="bike.entry.submit"/>"/></td>
                            </tr>
                        </table>
                    </fieldset>
                </form:form>
            </div>
            <%@ include file="/WEB-INF/pages/fragments/footer.jspf" %>
        </div>
    </body>
</html>
