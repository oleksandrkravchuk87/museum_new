<%--
  Created by IntelliJ IDEA.
  User: OKK
  Date: 08.08.2016
  Time: 19:11
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="seс" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<p>
<form action="/exhibit/page?${_csrf.parameterName}=${_csrf.token}" method="post" enctype="multipart/form-data">
Знайти експонат: <input type="text" name="serch">
<button type="submit">Знайти</button></form>
<div>
<c:forEach items="${exhibits}" var="ex">
    <div style="width: 90%; height: 130px;  background-color: antiquewhite; color: white; float: left; margin: 10px; border: 3px black; border-radius: 5px; position: center;"
         onmouseover="this.style.backgroundColor='#555'; this.border ='5px'"
         onmouseout="this.style.backgroundColor='antiquewhite';">
        <table style="height: 100%; height: 100%" cellpadding="5">
            <tr>
                <td style="width: 25%; vertical-align: middle;  horiz-align: center"><img
                        style="max-height: 180px" src="data:image/jpg;base64,${ex.miniature}"></td>
                <td style="width: 65%; vertical-align: middle; ">
                    <p style="text-align: left" ;>Опис експоната: ${ex.description}</p>
                    <p style="text-align: left" ;> ${ex.timePeriod}</p>
                    <p style="text-align: left" ;>Матеріал: ${ex.material} </p>
                    <p style="text-align: left" ;>Регіон: ${ex.origin} </p></td>
                <td style="width: 10%; vertical-align: middle; horiz-align: right">

                    <sec:authorize access="hasRole('ROLE_ADMIN') or hasRole('ROLE_STAFF')">
                        <p style="text-align: center"><a href="/exhibitImage/all/${ex.id}">Усі фото</a></p>
                        <p style="text-align: center"><a href="/exhibit/edit/${ex.id}">Редагувати</a></p>
                        <p style="text-align: center"><form:form cssStyle="text-align: center"
                                                                 action="/exhibit/delete/${ex.id}">
                            <button type="submit">Видалити</button>
                        </form:form>
                        </p>
                    </sec:authorize></td>
            </tr>


        </table>


    </div>
</c:forEach>
<sec:authorize access="hasRole('ROLE_ADMIN') or hasRole('ROLE_STAFF')">
    </div>
    <div style="font-size: 14pt;">
        <p><a href="/exhibit/add">Додати експонат</a></p>
    </div>
</sec:authorize>
</div>
</p>