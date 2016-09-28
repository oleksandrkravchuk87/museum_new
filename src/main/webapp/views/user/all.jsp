<%--
  Created by IntelliJ IDEA.
  User: OKK
  Date: 09.08.2016
  Time: 12:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="p" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="seс" uri="http://www.springframework.org/security/tags" %>



<p:forEach items="${users}" var="u">
    <div>
    <p style="text-align: left" ;>${u.name}</p>
    <p style="text-align: left" ;>${u.secondname}</p>
    <p style="text-align: left" ;>${u.email} </p>
    <p style="text-align: left" ;>${u.phone} </p>
    <p style="text-align: left" ;>${u.role} </p>
    <p style="text-align: left" ;>${u.registrationDate} </p>
    <sec:authorize access="hasRole('ROLE_ADMIN')">
    <p style="text-align: center"><a href="/user/edit/${u.id}">Edit</a></p>
    <p style="text-align: center"><form:form cssStyle="text-align: center" action="/user/delete/${u.id}">
        <button type="submit">Delete</button></form:form>
    </p></sec:authorize>
    </div>
</p:forEach>
<sec:authorize access="hasRole('ROLE_ADMIN')">
<p><a href="/user/add">Додати користувача</a></p></sec:authorize>
