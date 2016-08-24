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
                <h2><spring:message code="ride.delete.header"/></h2>
                <p><spring:message code="ride.delete.confirm"/></p>
                <form:form commandName="bikeRide" action="ridedelete.html">
                    <fieldset>
                        <form:hidden path="id"/>
                        <form:hidden path="bikeRiderId"/>
                        <table>
                            <tr>
                                <td class="nowrap"><label for="date"><spring:message code="ride.delete.date"/></label></td>
                                <td><form:input path="date"/></td>
                                <td><form:errors path="date"/></td>
                            </tr>
                            <tr>
                                <td class="nowrap"><label for="startLocation"><spring:message code="ride.delete.startLocation"/></label></td>
                                <td><form:input path="startLocation"/></td>
                                <td><form:errors path="startLocation"/></td>
                            </tr>
                            <tr>
                                <td class="nowrap"><label for="finishLocation"><spring:message code="ride.delete.finishLocation"/></label></td>
                                <td><form:input path="finishLocation"/></td>
                                <td><form:errors path="finishLocation"/></td>
                            </tr>
                            <tr>
                                <td class="nowrap"><label for="distanceKm"><spring:message code="ride.delete.distanceKm"/></label></td>
                                <td><form:input path="distanceKm"/></td>
                                <td><form:errors path="distanceKm"/></td>
                            </tr>
                            <tr>
                                <td class="nowrap"><label for="journal"><spring:message code="ride.delete.journal"/></label></td>
                                <td colspan="2"><form:textarea path="journal" cols="40" rows="4"/></td>
                            </tr>
                            <tr>
                                <td colspan="3"><input type="submit" value="<spring:message code="ride.delete.submit"/>"/></td>
                            </tr>
                        </table>
                    </fieldset>
                </form:form>
            </div>
            <%@ include file="/WEB-INF/pages/fragments/footer.jspf" %>
        </div>
    </body>
</html>
