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
                <h2><spring:message code="ride.entry.header"/></h2>
                <form:form commandName="bikeRide" action="rideentry.html">
                    <fieldset>
                        <form:hidden path="id"/>
                        <form:hidden path="bikeRider.id"/>
                        <table>
                            <tr>
                                <td class="nowrap"><label for="date"><spring:message code="ride.entry.date"/></label></td>
                                <td><form:input path="date"/></td>
                                <td><form:errors path="date"/></td>
                            </tr>
                            <tr>
                                <td class="nowrap"><label for="startLocation"><spring:message code="ride.entry.startLocation"/></label></td>
                                <td><form:input path="startLocation"/></td>
                                <td><form:errors path="startLocation"/></td>
                            </tr>
                            <tr>
                                <td class="nowrap"><label for="finishLocation"><spring:message code="ride.entry.finishLocation"/></label></td>
                                <td><form:input path="finishLocation"/></td>
                                <td><form:errors path="finishLocation"/></td>
                            </tr>
                            <tr>
                                <td class="nowrap"><label for="distanceKm"><spring:message code="ride.entry.distanceKm"/></label></td>
                                <td><form:input path="distanceKm"/></td>
                                <td><form:errors path="distanceKm"/></td>
                            </tr>
                            <tr>
                                <td class="nowrap"><label for="rideTimeSeconds"><spring:message code="ride.entry.rideTimeSeconds"/></label></td>
                                <td><form:input path="rideTimeSeconds"/></td>
                                <td><form:errors path="rideTimeSeconds"/></td>
                            </tr>
                            <tr>
                                <td class="nowrap"><label for="averageHr"><spring:message code="ride.entry.averageHr"/></label></td>
                                <td><form:input path="averageHr"/></td>
                                <td><form:errors path="averageHr"/></td>
                            </tr>
                            <tr>
                                <td class="nowrap"><label for="maximumHr"><spring:message code="ride.entry.maximumHr"/></label></td>
                                <td><form:input path="maximumHr"/></td>
                                <td><form:errors path="maximumHr"/></td>
                            </tr>
                            <tr>
                                <td class="nowrap"><label for="caloriesBurnt"><spring:message code="ride.entry.caloriesBurnt"/></label></td>
                                <td><form:input path="caloriesBurnt"/></td>
                                <td><form:errors path="caloriesBurnt"/></td>
                            </tr>
                            <tr>
                                <td class="nowrap"><label for="bikeRideType.id"><spring:message code="ride.entry.type"/></label></td>
                                <td>
                                    <form:select path="bikeRideType.id">
                                        <form:option value="-"  label="---------"/>
                                        <form:options items="${rideTypeList}" itemValue="id" itemLabel="name"/>
                                    </form:select>
                                </td>
                                <td><form:errors path="bikeRideType.id"/></td>
                            </tr>
                            <tr>
                                <td class="nowrap"><label for="bike.id"><spring:message code="ride.entry.bike"/></label></td>
                                <td>
                                    <form:select path="bike.id">
                                        <form:option value="-"  label="---------"/>
                                        <form:options items="${bikeList}" itemValue="id" itemLabel="fullModel"/>
                                    </form:select>
                                </td>
                                <td><form:errors path="bike.id"/></td>
                            </tr>
                            <tr>
                                <td class="nowrap"><label for="journal"><spring:message code="ride.entry.journal"/></label></td>
                                <td colspan="2"><form:textarea path="journal" cols="40" rows="4"/></td>
                            </tr>
                            <tr>
                                <td colspan="3"><input type="submit" value="<spring:message code="ride.entry.submit"/>"/></td>
                            </tr>
                        </table>
                    </fieldset>
                </form:form>
            </div>
            <%@ include file="/WEB-INF/pages/fragments/footer.jspf" %>
        </div>
    </body>
</html>
