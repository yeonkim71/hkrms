<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="left_menu">
    <%
        if(top_loc != null && !"".equals(top_loc) && "customer".equals(top_loc)) {
    %>
    <ul>
        <li><a href="/customer/CMP010104">거래처 관리</a></li>
        <li><a href="/customer/CMP010105">거거래처 조회 신텅</a></li>
        <li><a href="/customer/customerlist3">거거래처 일괄 신텅</a></li>
        <li><a href="/customer/customerlist4">거거래처 결과 및 등록</a></li>
        <li><a href="/customer/customerlist5">거거래처 요청 확인</a></li>
    </ul>
    <%
        }
    %>
</div>