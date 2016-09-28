<%--
  Created by IntelliJ IDEA.
  User: OKK
  Date: 14.08.2016
  Time: 19:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="p" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div>
    <p>Привіт, ${user.name}</p>
    Профіль:
    <p>${user.name}</p>
    <p>${user.secondname}</p>
    <p>${user.email}</p>
    <p>${user.phone}</p>
    <p>${user.registrationDate.toString()}</p>
    Ви записані на:


    <p:forEach items="${records}" var="e">
        <div>
           <p style="text-align: left" ;>${e.excursionDay}</p>
            <p style="text-align: left" ;>${e.excursionStart}</p>
            <p style="text-align: left" ;>${e.excursion.branch.name} </p>
            <p style="text-align: left" ;>${e.excursion.branch.address} </p>


                <p style="text-align: center"><form:form cssStyle="text-align: center" action="/excursionRecord/delete/${e.id}">
                    <input type="hidden" name="userId" value="${user.id}">
                    <button type="submit">Видалити</button></form:form>
                </p>
        </div>
    </p:forEach>
        <p><form:form cssStyle="text-align: center" action="/excursionRecord/deleteAll">
            <input type="hidden" name="userId" value="${user.id}">
            <button type="submit">Видалити усі</button></form:form>
</div>

