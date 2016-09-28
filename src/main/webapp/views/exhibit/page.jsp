<%--
  Created by IntelliJ IDEA.
  User: OKK
  Date: 12.08.2016
  Time: 00:13
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="seс" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<p>

<div>
<c:forEach items="${exhibitList}" var="ex">
    <div style="width: 90%; height: 130px; background-color: antiquewhite; color: white; float: left; margin: 10px; border: 3px black; border-radius: 5px; position: center;">
    <table style="height: 100%; height: 100%" cellpadding="5">
    <tr>
    <td style="width: 25%; vertical-align: middle; horiz-align: center"><img
    style="max-height: 180px" src="data:image/jpg;base64,${ex.miniature}"></td>
    <td style="width: 65%; vertical-align: middle; ">
    <p style="text-align: left" ;>Опис експоната: ${ex.description}</p>
    <p style="text-align: left" ;> ${ex.timePeriod}</p>
    <p style="text-align: left" ;>Матеріал: ${ex.material} </p>
    <p style="text-align: left" ;>Регіон: ${ex.origin} </p></td>
    <td style="width: 10%; vertical-align: middle; horiz-align: right">

    <sec:authorize access="hasRole('ROLE_ADMIN') or hasRole('ROLE_STAFF')">
    <p style="text-align: center"><a href="/exhibitImage/all/${ex.id}">Усі фото</a></p>
    </sec:authorize></td>

    </tr>
    </table>
    </div>
</c:forEach>
    </div>
    </p>

