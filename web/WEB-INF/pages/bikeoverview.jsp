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
                <h2><spring:message code="bike.overview.header"/></h2>
                <p>
                    The bike overview page ...
                </p>
                <h2><spring:message code="bike.overview.bike.header"/></h2>
                <c:choose>
                    <c:when test="${!empty requestScope.bikes}">
                        <table>
                            <tr>
                                <th><spring:message code="bike.overview.brand"/></th>
                                <th><spring:message code="bike.overview.model"/></th>
                                <th><spring:message code="bike.overview.year"/></th>
                                <th><spring:message code="bike.overview.color"/></th>
                                <th><spring:message code="bike.overview.type"/></th>
                                <th><spring:message code="bike.overview.description"/></th>
                                <th></th>
                            </tr>
                            <tbody>
                                <c:forEach items="${bikes}" var="bike" varStatus="status">
                                    <tr class="<c:out value="${status.index % 2 > 0 ? 'odd': 'even'}"/>">
                                        <td class="nowrap">${bike.brand}</td>
                                        <td class="nowrap">${bike.model}</td>
                                        <td>${bike.year}</td>
                                        <td>${bike.color}</td>
                                        <td class="nowrap">TODO: ...</td>
                                        <td>${bike.description}</td>
                                        <td>
                                            <a href="bikeentry.html?id=${bike.id}"><spring:message code="application.update"/></a>
                                            <a href="bikedelete.html?id=${bike.id}"><spring:message code="application.delete"/></a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </c:when>
                    <c:otherwise>
                        <p><spring:message code="bike.overview.nobikesfound"/></p>
                    </c:otherwise>
                </c:choose>
                <h2><spring:message code="bike.overview.biketype.header"/></h2>
                <c:choose>
                    <c:when test="${!empty requestScope.biketypes}">
                        <table>
                            <tr>
                                <th><spring:message code="bike.overview.name"/></th>
                                <th><spring:message code="bike.overview.description"/></th>
                            </tr>
                            <tbody>
                                <c:forEach items="${biketypes}" var="biketype" varStatus="status">
                                    <tr class="<c:out value="${status.index % 2 > 0 ? 'odd': 'even'}"/>">
                                        <td class="nowrap">${biketype.name}</td>
                                        <td>${biketype.description}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </c:when>
                    <c:otherwise>
                        <p><spring:message code="bike.overview.nobiketypesfound"/></p>
                    </c:otherwise>
                </c:choose>
            </div>
            <%@ include file="/WEB-INF/pages/fragments/footer.jspf" %>
        </div>
    </body>
</html>
