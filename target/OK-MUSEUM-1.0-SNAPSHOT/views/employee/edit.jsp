<%--
  Created by IntelliJ IDEA.
  User: OKK
  Date: 09.08.2016
  Time: 10:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

        <form action="/employee/edit?${_csrf.parameterName}=${_csrf.token}" method="post" enctype="multipart/form-data">
            <table cellpadding="5px">
                <input type="hidden" name="id" value="${employee.id}">
                <tr>
                    <td align="right">
                        Ім´я:
                    </td>
                    <td align="left">
                        <input type="text" name="name" value="${employee.name}">
                    </td>
                </tr>
                <tr>
                    <td align="right">
                        Прізвище:
                    </td>
                    <td align="left">
                        <input type="text" name="secondName" value="${employee.secondName}">
                    </td>
                </tr>
                <tr>
                    <td align="right">
                        По-батькові:
                    </td>
                    <td align="left">
                        <input type="text" name="middleName" value="${employee.middleName}">
                    </td>
                </tr>
                <tr>
                    <td align="right">
                        Телефон:
                    </td>
                    <td align="left">
                        <input type="text" name="phone" value="${employee.phone}">
                    </td>
                </tr>
                <tr>
                    <td align="right">
                        E-mail:
                    </td>
                    <td align="left">
                        <input type="text" name="email" value="${employee.email}">
                    </td>
                </tr>
                <tr>
                    <td align="right">
                        Дата народження:
                    </td>
                    <td align="left">
                        <input type="text" name="birthDate" value="${employee.birthDate}">
                    </td>
                </tr>
                <tr>
                    <td align="right">
                        Посада:
                    </td>
                    <td align="left">
                        <input type="text" name="position" value="${employee.position}">
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
                        <button type="submit">Редагувати</button>
                    </td>
                </tr>
            </table>


        </form>

