<%--
  Created by IntelliJ IDEA.
  User: OKK
  Date: 09.08.2016
  Time: 10:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<form action="/exhibit/edit?${_csrf.parameterName}=${_csrf.token}" method="post" enctype="multipart/form-data">
    <table cellpadding="5px">
        <input type="hidden" name="id" value="${exhibit.id}">
        <tr>
            <td align="right">
                Опис:
            </td>
            <td align="left">
                <input type="text" name="description" value="${exhibit.description}">
            </td>
        </tr>
        <tr>
            <td align="right">
                Період часу:
            </td>
            <td align="left">
                <input type="text" name="timePeriod" value="${exhibit.timePeriod}">
            </td>
        </tr>
        <tr>
            <td align="right">
                Матеріал:
            </td>
            <td align="left">
                <input type="text" name="material" value="${exhibit.material}">
            </td>
        </tr>
        <tr>
            <td align="right">
                Країна походження:
            </td>
            <td align="left">
                <input type="text" name="origin" value="${exhibit.origin}">
            </td>
        </tr>
        <tr>
            <td align="right">
                Мініатюра:
            </td>
            <td align="left">
                <input type="file" name="miniature">
            </td>
        </tr>

        <tr>
            <td align="right">

            </td>
            <td align="left">
                <button type="submit">Редагувати</button>
            </td>
        </tr>
    </table>
</form>
