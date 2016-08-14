<%--
  Created by IntelliJ IDEA.
  User: OKK
  Date: 08.08.2016
  Time: 19:11
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ taglib prefix="seс" uri="http://www.springframework.org/security/tags" %>


<p>
<c:forEach items="${events}" var="e">
    <div style="width: 300px; height: 300px; background-color: darkgrey; color: white; float: left; margin: 10px; border: 3px double black; border-radius: 50%;">
    <p style="text-align: left" ;>${e.name}</p>
    <p style="text-align: left" ;>${e.description}</p>
    <p style="text-align: left" ;>${e.passingDate} </p>
    <img src="data:image/jpg;base64,${e.image}">
    <sec:authorize access="hasRole('ROLE_ADMIN')">
    <p style="text-align: center"><a href="/event/edit/${e.id}">Edit</a></p>
    <p style="text-align: center"><form:form cssStyle="text-align: center" action="/event/delete/${e.id}">
        <button type="submit">Delete</button></form:form>
    </p></sec:authorize>
    </div>
</c:forEach>
<sec:authorize access="hasRole('ROLE_ADMIN')">
<p><a href="/event/add">Додати Подію</a></p>
</p></sec:authorize>


