<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="seс" uri="http://www.springframework.org/security/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    .leftimg {
        float:left;
        margin: 7px 7px 7px 0;
    }

</style>


<c:forEach items="${branches}" var="b">
    <div style="width: 100%; height: 50%;  margin: 10px; border: 1px; ">


        <h2>${b.name}</h2>
       <p>${b.address}</p>

        <p> <img src="data:image/jpg;base64,${b.image}" width="132" height="174" class="leftimg">${b.description}</p>

        <p>${b.workingHours}</p>

        <seс:authorize access="hasRole('ROLE_ADMIN')">
            <p style="text-align: center"><a href="/branch/edit/${b.id}">Редагувати</a>
                <form:form cssStyle="text-align: center" action="/branch/delete/${b.id}">
                    <button type="submit">Видалити</button></form:form></p>
        </seс:authorize>

    </div>
    <br>
</c:forEach>
<seс:authorize access="hasRole('ROLE_ADMIN')">
<a href="/branch/add">Додати філіал</a>
</seс:authorize>
