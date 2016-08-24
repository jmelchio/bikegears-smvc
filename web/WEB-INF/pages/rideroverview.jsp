<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/fragments/taglibs.jspf" %>
<%@ include file="/WEB-INF/pages/fragments/formats.jspf" %>

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
                <h2><spring:message code="rider.overview.header"/></h2>
                <c:choose>
                    <c:when test="${!empty sessionScope.bgSession.bikeRider.person}">
                        <p>
                            <spring:message code="rider.overview.name"/>${sessionScope.bgSession.bikeRider.person.firstName} ${sessionScope.bgSession.bikeRider.person.lastName}<br/>
                            <spring:message code="rider.overview.since"/>${sessionScope.bgSession.bikeRider.since}<br/>
                            <a href="riderentry.html?id=${person.id}"><spring:message code="application.update"/></a>
                        </p>
                    </c:when>
                    <c:otherwise>
                        <p>
                            <a href="personentry.html"><spring:message code="application.create"/></a>
                        </p>
                    </c:otherwise>
                </c:choose>
                <h2><spring:message code="rider.overview.recent.header"/></h2>
                <c:choose>
                    <c:when test="${!empty requestScope.rides}">
                        <table>
                            <tr>
                                <th><spring:message code="rider.overview.rides.date"/></th>
                                <th><spring:message code="rider.overview.rides.dist"/></th>
                                <th><spring:message code="rider.overview.rides.time"/></th>
                                <th><spring:message code="rider.overview.rides.avg"/></th>
                                <th><spring:message code="rider.overview.rides.journal"/></th>
                                <th></th>
                            </tr>
                            <c:forEach items="${rides}" var="ride" varStatus="status">
                                <tr class="<c:out value="${status.index % 2 > 0 ? 'odd': 'even'}"/>">
                                    <td class="date"><fmt:formatDate value="${ride.date}" pattern="${ptnDate}"/></td>
                                    <td class="number">${ride.distanceKm}</td>
                                    <td class="date">${ride.rideTime}</td>
                                    <td class="number"><fmt:formatNumber value="${ride.averageSpeed}" pattern="${ptnNumber}"/></td>
                                    <td class="journal">${ride.journal}</td>
                                    <td>
                                        <a href="rideentry.html?id=${ride.id}"><spring:message code="application.update"/></a>
                                        <a href="ridedelete.html?id=${ride.id}"><spring:message code="application.delete"/></a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </table>
                    </c:when>
                    <c:otherwise>
                        <p>
                            <spring:message code="rider.overview.noridesfound"/>
                        </p>
                    </c:otherwise>
                </c:choose>
            </div>
            <%@ include file="/WEB-INF/pages/fragments/footer.jspf" %>
        </div>
    </body>
</html>
