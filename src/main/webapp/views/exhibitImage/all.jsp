<%--
  Created by IntelliJ IDEA.
  User: OKK
  Date: 08.08.2016
  Time: 19:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="p" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="seс" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


Усі фото:
<p:forEach items="${exhibitImages}" var="ei">
    <div>

    <img src="data:image/jpg;base64,${ei.image}">

            <seс:authorize access="hasRole('ROLE_ADMIN') or hasRole('ROLE_STAFF')">
    <p style="text-align: center"><form:form cssStyle="text-align: center" action="/exhibitImage/delete/${ei.id}">
        <input type="hidden" name="exId" value="${exhibit}">
        <button type="submit">Delete</button></form:form>
    </p></seс:authorize>
    </div>
</p:forEach>
<seс:authorize access="hasRole('ROLE_ADMIN') or hasRole('ROLE_STAFF')">
    <div>
    <p style="text-align: center">

        <a href="/exhibitImage/add/${exhibit}">Додати</a></p></div>
    </p>
</seс:authorize>


