<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="kr" xmlns:th="http://www.thymeleaf.org">
<head>
    <title>${documentTitle}</title>
    <meta charset="UTF-8">

<!--    <script src="/jquery.jqGrid-3.8.2/js/jquery-1.4.2.min.js"></script> //-->
    <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.14/themes/redmond/jquery-ui.css" type="text/css" />
    <!-- jqGrid CSS -->
    <link rel="stylesheet" href="//cdn.jsdelivr.net/jqgrid/4.6.0/css/ui.jqgrid.css" type="text/css" />
    <!-- The actual JQuery code -->
    <script type="text/javascript" src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
    <!-- The JQuery UI code -->
    <script type="text/javascript" src="https://code.jquery.com/ui/1.10.3/jquery-ui.min.js"></script>
    <!-- The jqGrid language file code-->
    <script type="text/javascript" src="//cdn.jsdelivr.net/jqgrid/4.6.0/i18n/grid.locale-kr.js"></script>
    <!-- The atual jqGrid code -->
    <script type="text/javascript">
        jQuery.jgrid.no_legacy_api = true;
    </script>
    <script type="text/javascript" src="//cdn.jsdelivr.net/jqgrid/4.6.0/jquery.jqGrid.src.js"></script>
    <script src="/js/common.js"></script>
    <link rel="stylesheet" href="/css/main.css">

    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Lora&family=Noto+Sans+KR:wght@100;200;300;400;500&display=swap" rel="stylesheet">
</head>
<body>
<div class="top_menu" <% if( isPopup == true) { %>style="display:none"<% } %>>
    <div class="logo"><a href="/"><img src="/image/logo1.png"></a></div>
    <div class="top_right_menu"><a href="/customer/customerlist">거래처 관리</a> &nbsp; | &nbsp; <a href="/giro/index">지로 관리</a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="/member/login">로그인</a></div>
</div>
<div class="main_content_wrap">
