<%--
  Created by IntelliJ IDEA.
  User: OKK
  Date: 08.08.2016
  Time: 13:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>



        <form action="/employee/new?${_csrf.parameterName}=${_csrf.token}" method="post" enctype="multipart/form-data">
            <table cellpadding="5px">
                <tr>
                    <td align="right">
                        Ім´я:
                    </td>
                    <td align="left">
                        <input type="text" name="name">
                    </td>
                </tr>
                <tr>
                    <td align="right">
                        Прізвище:
                    </td>
                    <td align="left">
                        <input type="text" name="secondName">
                    </td>
                </tr>
                <tr>
                    <td align="right">
                        По-батькові:
                    </td>
                    <td align="left">
                        <p><input type="text" name="middleName"></p>
                    </td>
                </tr>
                <tr>
                    <td align="right">
                        Телефон:
                    </td>
                    <td align="left">
                        <input type="text" name="phone">
                    </td>
                </tr>
                <tr>
                    <td align="right">
                        E-mail:
                    </td>
                    <td align="left">
                        <input type="text" name="email">
                    </td>
                </tr>
                <tr>
                    <td align="right">
                        Дата народження:
                    </td>
                    <td align="left">
                        <input type="text" name="birthDate" placeholder="дд/мм/рррр">
                    </td>
                </tr>
                <tr>
                    <td align="right">
                        Посада:
                    </td>
                    <td align="left">
                        <input type="text" name="position">
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
