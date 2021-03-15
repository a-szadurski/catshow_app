<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="navbar.jsp" %>
<!-- Header -->
<header class="w3-container w3-grey w3-center" style="padding:64px 16px">
    <h2 class="w3-margin w3-jumbo">UPCOMING SHOW</h2>
    <p class="w3-xlarge">${upcomingShow.name}, ${upcomingShow.city}</p>

    <c:forEach items="${upcomingDates}" var="upcomingDate">
        <h4>${upcomingDate.date}</h4>
    </c:forEach>
    <button class="w3-button w3-black w3-padding-large w3-medium w3-margin-top">Register your cat</button>
</header>

<!-- First Grid -->
<div class="w3-row-padding w3-container">
    <div class="w3-content">
        <div class="">
            <h1>Latest results</h1>

            <h2>${latestShow.name}, ${latestShow.city}</h2>
            <h3>Organized by: ${latestShow.organizer}</h3>
            <c:forEach items="${latestDates}" var="latestDate">
                <h4>${latestDate.date}</h4>
            </c:forEach>

            <table class="w3-table-all">
                <tbody>
                <tr>
                    <th>KOT</th>
                    <th>EMS</th>
                    <th>RATING</th>
                    <th>DATE</th>
                </tr>
                <c:forEach items="${contestants}" var="contestant">
                    <tr>
                        <td>${contestant.cat.name}</td>
                        <td>${contestant.cat.ems}</td>
                        <td>${contestant.rating}</td>
                        <td>${contestant.showDate.date}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

        </div>

    </div>
</div>
<%@include file="footer.jsp" %>
