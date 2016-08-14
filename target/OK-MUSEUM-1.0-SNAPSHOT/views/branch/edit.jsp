<%--
  Created by IntelliJ IDEA.
  User: OKK
  Date: 09.08.2016
  Time: 10:38
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

    <div style="margin-top: 50px;">
        <form action="/branch/edit?${_csrf.parameterName}=${_csrf.token}" method="post" enctype="multipart/form-data">
            <input type="hidden" name="id" value="${branch.id}">
            <table cellpadding="5px">
                <tr>
                    <td align="right">
                        Назва:
                    </td>
                    <td align="left">
                        <input type="text" name="name" value="${branch.name}">
                    </td>
                </tr>
                <tr>
                    <td align="right">
                        Адресса:
                    </td>
                    <td align="left">
                        <input type="text" name="address" value="${branch.address}">
                    </td>
                </tr>
                <tr>
                    <td align="right">
                        Час роботи:
                    </td>
                    <td align="left">
                        <input type="text" name="workingHours" value="${branch.workingHours}">
                    </td>
                </tr>
                <tr>
                    <td align="right">
                        Опис:
                    </td>
                    <td align="left">
                        <textarea name="description">${branch.description}</textarea>
                    </td>
                </tr>
                <tr>
                    <td align="right">
                        Зображення:
                    </td>
                    <td align="left">
                        <input type="file" name="image">
                    </td>
                </tr>
                <tr>
                    <td>

                    </td>
                    <td align="left">
                        <button type="submit">Редагувати</button>
                    </td>
                </tr>
            </table>


        </form>
    </div>


