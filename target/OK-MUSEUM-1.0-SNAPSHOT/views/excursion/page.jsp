<%--
  Created by IntelliJ IDEA.
  User: OKK
  Date: 08.08.2016
  Time: 19:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div>
    <p style="text-align: left" ;>${e.excursionTheme}</p>
    <p style="text-align: left" ;>${e.excursionDate}</p>
    <p style="text-align: left" ;>${e.excursionStart} </p>
    <p style="text-align: left" ;>${e.excursionDuration} </p>
    <p style="text-align: center"><a href="/excursion/edit/${e.id}">Edit</a></p>
    <p style="text-align: center"><form:form cssStyle="text-align: center" action="/excursion/delete/${e.id}">
        <button type="submit">Delete</button></form:form>
    </p>
</div>