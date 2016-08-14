<%--
  Created by IntelliJ IDEA.
  User: OKK
  Date: 08.08.2016
  Time: 19:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="e" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="seс" uri="http://www.springframework.org/security/tags" %>
<div style = "text-align:  center;
font-size: 2.2em;
padding-left: 10% ;
padding-right: 10%
">


<p>
<e:forEach items="${excursions}" var="e">
    <a href="/excursionRecord/add/${e.id}">
    <div style="width: 300px; height: 300px; background-color: darkgrey; color: white; float: left; margin: 10px; border: 3px double black; border-radius: 50%;">
    <p style="text-align: left" ;>${e.excursionTheme}</p>
    <p style="text-align: left" ;>${e.excursionDuration}</p>
    <p style="text-align: left" ;>${e.excursionDay} </p>
    <p style="text-align: left" ;>${e.excursionStart} </p>
    <p style="text-align: left" ;>${e.branch.name} </p>
    <seс:authorize access="hasRole('ROLE_ADMIN')">
    <p style="text-align: center"><a href="/excursion/edit/${e.id}">Edit</a></p>
    <p style="text-align: center"><form:form cssStyle="text-align: center" action="/excursion/delete/${e.id}">
        <button type="submit">Delete</button></form:form>
    </p></seс:authorize>
    </div>
    </a>
</e:forEach>
<seс:authorize access="hasRole('ROLE_ADMIN')">
<p><a href="/excursion/add">Додати екскурсію</a></p></seс:authorize>
</p>
</div>
