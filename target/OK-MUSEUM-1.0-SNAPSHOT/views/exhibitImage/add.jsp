<%--
  Created by IntelliJ IDEA.
  User: OKK
  Date: 09.08.2016
  Time: 10:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<form action="/exhibitImage/new?${_csrf.parameterName}=${_csrf.token}" method="post" enctype="multipart/form-data">
    <input type="hidden" name="id" value="${id}">
      <p>Зображення: <input type="file" name="image"></p>
    <button type="submit">Додати</button>
</form>
