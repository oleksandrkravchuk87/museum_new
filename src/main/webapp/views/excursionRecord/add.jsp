<%--
  Created by IntelliJ IDEA.
  User: OKK
  Date: 08.08.2016
  Time: 19:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<form action="/excursionRecord/new?${_csrf.parameterName}=${_csrf.token}" method="post" enctype="multipart/form-data">
    ${excursion.excursionTheme}
     Філіал:  ${excursion.branch.name}
        <br>
     Адреса:   ${excursion.branch.address}

        <br>
        <sec:authentication property="name"/>
        <br>
        <input type="hidden" name="excursionId" value="${excursion.id}">
    <input type="hidden" name="userId" value="<sec:authentication property="name"/>">
        <p><select  name="excursionDay">
            <option disabled selected="selected">Виберіть день</option>
            <option value="Понеділок">Понеділок</option>
            <option value="Вівторок">Вівторок</option>
            <option value="Четвер">Четвер</option>
            <option value="П´ятниця">П´ятниця</option>
            <option value="Субота">Субота</option>
        </select></p>

        <p><select size="5" name="excursionStart">
            <option disabled>Виберіть час</option>
            <option value="11:00">11:00</option>
            <option value="12:00">12:00</option>
            <option value="14:00">14:00</option>
            <option value="15:00">15:00</option>

        </select></p>

        <button type="submit">Записатись</button>
</form>

