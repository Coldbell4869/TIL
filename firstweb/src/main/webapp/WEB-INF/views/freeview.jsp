<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html lang="ko">
<%--<head>--%>
    <%--<meta charset="utf-8">--%>
    <%--<meta http-equiv="X-UA-Compatible" content="IE=edge">--%>
    <%--<meta name="viewport" content="width=device-width, initial-scale=1">--%>
    <%--<title>게시글 보기</title>--%>
    <%--<link href="/css/bootstrap.min.css" rel="stylesheet">--%>
<%--</head>--%>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link href="/css/view.css" type="text/css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>


<div id = "container">
    <div id = "view-top" class="page-header">
        <div id = "view-title" class="col-md-6 col-xs-6">${freeboard.title}</div>
        <div id = "view-date" class="col-md-2 col-md-offset-2 col-xs-2 col-xs-offset-2">${freeboard.regdate}</div>
        <div id = "view-writer" class="col-md-2 col-xs-2">${freeboard.name}</div>
    </div>
    <div id = "content">
        ${freeboard.content}
    </div>
    <div id = "view-bottom">
        <button type="button" class="btn btn-default col-md-2 col-md-offset-6 col-xs-2 col-xs-offset-5" id = "btn-update" onClick="location.href='form1.html'">수 정</button>
        <button type="button" class="btn btn-default col-md-2 col-xs-2" id = "btn-delete"onClick="location.href='delete.html'" >삭 제</button>
        <button type="button" class="btn btn-default col-md-2 col-xs-2" id = "btn-list" onClick="location.href='board.html'">목 록</button>
    </div>
</div>

</body>


<%--<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>--%>
<%--<script src="/js/bootstrap.min.js"></script>--%>
</html>