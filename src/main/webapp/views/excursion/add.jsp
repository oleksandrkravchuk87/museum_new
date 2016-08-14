
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div style="width: 300px">
    <form:form action="/excursion/create" method="post" modelAttribute="excursion">
        <p align="right"><form:label path="excursionTheme">Тема: </form:label>
        <form:input path="excursionTheme"/></p>
        <input>
        <p align="right"> <form:label path="excursionDate">Дата: </form:label>
        <form:input path="excursionDate"/></p>
        <p align="right"> <form:label path="excursionStart">Початок о: </form:label>
        <form:input path="excursionStart"/></p>
        <p align="right"> <form:label path="excursionDuration">Тривалість: </form:label>
        <form:input path="excursionDuration"/></p>
        <p align="right">  <form:button>Додати екскурсію</form:button></p>
    </form:form>



</div>



