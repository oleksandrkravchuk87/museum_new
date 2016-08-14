<%--
  Created by IntelliJ IDEA.
  User: OKK
  Date: 11.08.2016
  Time: 22:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: OKK
  Date: 09.08.2016
  Time: 10:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

        <form action="/exhibit/addImage?${_csrf.parameterName}=${_csrf.token}" method="post" enctype="multipart/form-data">
            <table cellpadding="5px">
                <input type="hidden" name="id" value="${exhibit.id}">
                <tr>
                    <td align="right">
                        ${exhibit.description}"
                    </td>
                    <td align="left">

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
                    <td align="right">

                    </td>
                    <td align="left">
                        <button type="submit">Додати</button>
                    </td>
                </tr>
            </table>
        </form>


