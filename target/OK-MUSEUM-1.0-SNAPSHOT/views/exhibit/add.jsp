<%--
  Created by IntelliJ IDEA.
  User: OKK
  Date: 09.08.2016
  Time: 10:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<form action="/exhibit/new?${_csrf.parameterName}=${_csrf.token}" method="post" enctype="multipart/form-data">

    <table cellpadding="5px">
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
                Період часу:
            </td>
            <td align="left">
                <input type="text" name="timePeriod">
            </td>
        </tr>
        <tr>
            <td align="right">
                Матеріал:
            </td>
            <td align="left">
                <input type="text" name="material">
            </td>
        </tr>
        <tr>
            <td align="right">
               Країна походження:
            </td>
            <td align="left">
                <input type="text" name="origin">
            </td>
        </tr>
        <tr>
            <td align="right">
                Зображення:
            </td>
            <td align="left">
                <input type="file" name="miniature">
            </td>
        </tr>
        <tr>
            <td align="right">
                Підтвердження паролю:
            </td>
            <td align="left">
                <button type="submit">Додати</button>
            </td>
        </tr>
    </table>
</form>
