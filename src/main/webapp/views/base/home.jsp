<%--
  Created by IntelliJ IDEA.
  User: OKK
  Date: 08.08.2016
  Time: 12:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: OKK
  Date: 08.08.2016
  Time: 19:11
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="seс" uri="http://www.springframework.org/security/tags" %>

<c:forEach items="${events}" var="e">
    <div style="margin: 5px; margin-top: 5px;  background-color: crimson; width: 400px; height: 400px; overflow: hidden; color: #171717">
        <img src="data:image/jpg;base64,${e.image}" max-width: 100%; max-height: 100px;>
        <div style="padding: 10px;">
    <h3 style="text-align: left" ;>${e.name}</h3>
    <p style="text-align: left" ;>${e.description}</p>
    <p style="text-align: left" ;>${e.passingDate} </p></div>
    </div>
</c:forEach>



