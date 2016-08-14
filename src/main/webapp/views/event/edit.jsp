<%--
  Created by IntelliJ IDEA.
  User: OKK
  Date: 09.08.2016
  Time: 10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div style = "text-align:  center;
font-size: 2.2em;
padding-left: 10% ;
padding-right: 10%
">
<form action="/event/edit?${_csrf.parameterName}=${_csrf.token}" method="post" enctype="multipart/form-data">
    <input type="hidden" name="id" value="${event.id}">
    <p> <input type="text" name="name"></p>
    <p> <input type="text" name="description"></p>
    <p> <input type="text" name="passingDate"></p>
    <p>Зображення: <input type="file" name="image"></p>
    <button type="submit">Змінити</button>
</form>
</div>