<!DOCTYPE html>
<html lang="kr" xmlns:th="http://www.thymeleaf.org">
<head>
    <title>${documentTitle}</title>
    <meta charset="UTF-8">
</head>
<body>
<div>${documentTitle}</div>
<div>

    <table>
        <tr>
            <th>CustCd</th>
            <th>CustName1</th>
            <th>CustGuName</th>
            <th>CustGuCd</th>
        </tr>
        <tr th:each="item : ${list}">
            <td><span th:text="${ item.CustCd }">${ item.CustCd }</span></td>
            <td><a href="#"><span th:text="${ item.CustName1 }">${ item.CustName1 }</span></a></td>
            <td><span th:text="${ item.CustGuName }">${ item.CustGuName }</span></td>
            <td><span th:text="${ item.CustGuCd }">${ item.CustGuCd }</span></td>
        </tr>
    </table>

</div>
</body>
</html>