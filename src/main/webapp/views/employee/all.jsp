<%--
  Created by IntelliJ IDEA.
  User: OKK
  Date: 08.08.2016
  Time: 19:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="e" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="seс" uri="http://www.springframework.org/security/tags" %>


        <e:forEach items="${employees}" var="em">
            <div style="width: 90%; height: 200px;  background-color: antiquewhite; color: white; float: left; margin: 10px; border: 3px black; border-radius: 5px; position: center;"
                 onmouseover="this.style.backgroundColor='#555'; this.border ='5px'"
                 onmouseout="this.style.backgroundColor='antiquewhite';">


                <table style="height: 100%; height: 100%" cellpadding="5">
                    <tr>
                        <td style="width: 25%; vertical-align: middle;  horiz-align: center"><img
                                style="max-height: 180px" src="data:image/jpg;base64,${em.image}"></td>
                        <td style="width: 65%; vertical-align: middle; ">
                            <p style="text-align: left" ;>${em.name} ${em.secondName} ${em.middleName} </p>
                            <p style="text-align: left" ;>Посада: ${em.position} </p>
                            <p style="text-align: left" ;>Контактний телефон: ${em.phone} </p>
                            <p style="text-align: left" ;>Email: ${em.email} </p>
                            <p style="text-align: left" ;>Дата народження: ${em.birthDate} </p></td>
                        <td style="width: 10%; vertical-align: middle; horiz-align: right">

                            <sec:authorize access="hasRole('ROLE_ADMIN')">
                                <p style="text-align: center"><a href="/employee/edit/${em.id}">Редагувати</a></p>
                                <p style="text-align: center">
                                    <form:form cssStyle="text-align: center" action="/employee/delete/${em.id}">
                                        <button type="submit">Видалити</button>
                                    </form:form></p>
                            </sec:authorize></td>
                    </tr>
                </table>

            </div>
        </e:forEach>
        <seс:authorize access="hasRole('ROLE_ADMIN')">
            <div >
                <p><a href="/employee/add">Додати працівника</a></p>
            </div>
        </seс:authorize>


