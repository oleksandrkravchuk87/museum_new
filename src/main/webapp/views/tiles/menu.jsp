<%--
  Created by IntelliJ IDEA.
  User: OKK
  Date: 07.08.2016
  Time: 11:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style type="text/css">
    .menu{
        padding: 0;
        margin: 0;
        font-size: 100%;
    }
    .menu li{
        list-style: none;
        float: left;
        height: 33px;
        padding: 0;
        margin: 0;
        width: 20%;
        text-align: center;
        background: antiquewhite;
        position: relative;
        padding-top: 12px;
    }
    .menu li:hover{
        background: burlywood;
    }
    .menu li:hover ul{
        display: block;
    }
    .menu li ul{
        list-style: none;
        padding: 0;
        margin: 0;
        width: 150px;
        display: none;
        position: absolute;
        left: 0;
        top: 45px;
    }
    .menu li ul li{
        float: none;
        height: 33px;
        margin: 0;
        width: 150px;
        text-align: center;
        background: antiquewhite;
    }
    .menu li a{
        display: block;
        width: 150px;
        height: 33px;
        color: saddlebrown;
        text-decoration: none;
    }
</style>
<div style="padding-left: 10% ;
padding-right: 10%">
    <ul class="menu">
        <li><a href="/">Додому</a></li>
        <li>
            <a href="/about">Про музей</a>
            <ul>
                <li><a href="/branch/all">Філіали</a></li>
                <li><a href="/press">У прессі</a></li>
                <li><a href="/map">Як знайти</a></li>
            </ul>
        </li>
        <li>
            <a href="#">Для відвідувачів</a>
            <ul>
                <li><a href="/excursion/all">Екскурсії</a></li>
            </ul>
        </li>
        <li>
            <a href="#">Для працівників</a>
            <ul>
                <li><a href="/employee/all">Співробітники</a></li>
                <li><a href="/exhibit/all">Експонати</a></li>
            </ul>
        </li>
        <li>
            <a href="#">Публікації</a>

        </li>
    </ul>
</div>
