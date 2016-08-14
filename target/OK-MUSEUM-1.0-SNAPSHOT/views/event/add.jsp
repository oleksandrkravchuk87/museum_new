
<%--
  Created by IntelliJ IDEA.
  User: OKK
  Date: 08.08.2016
  Time: 13:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<form action="/event/new?${_csrf.parameterName}=${_csrf.token}" method="post" enctype="multipart/form-data">

    <table cellpadding="5px">
        <tr>
            <td align="right">
                Назва:
            </td>
            <td align="left">
                <input type="text" name="name">
            </td>
        </tr>
        <tr>
            <td align="right">
                Опис:
            </td>
            <td align="left">
                <input type="text" name="description">
            </td>
        </tr>
        <tr>
            <td align="right">
                Дата:
            </td>
            <td align="left">
                <input type="text" name="passingDate">
            </td>
        </tr>
        <tr>
            <td align="right">
                Фото
            </td>
            <td align="left">
                <input type="file" name="image">
            </td>
        </tr>


        <tr>
            <td>

            </td>
            <td align="left">
                <button type="submit">Додати</button>
            </td>
        </tr>
    </table>


</form>

