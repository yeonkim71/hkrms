<%--
  Created by IntelliJ IDEA.
  User: hkadmin
  Date: 2023-08-16
  Time: 오후 2:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="kr" xmlns:th="http://www.thymeleaf.org">
<head>
    <title>DATABASE 테스트</title>
    <meta charset="UTF-8">
</head>
<body>
<div>
    <!--
    <ul>
        <li th:each="item : ${list}">
            <dl>
                <dd><span th:text="${ item.CustCd }"></span></dd>
                <dt><a href="#"><span th:text="${ item.CustName1 }"></span></a></dt>
                <dd><span th:text="${ item.CustGuName }"></span></dd>
            </dl>
        </li>
    </ul>
    //-->
    <div> ${ URL }</div>
    <div> ${ DriverName }</div>
    <div> ${ UserNmae }</div>
</div>
</body>
</html>