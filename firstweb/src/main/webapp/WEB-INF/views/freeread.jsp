<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html lang="ko">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>게시글 목록</title>
    <link href="/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container table-bordered" style="padding-top: 15px;">
    <div class="panel panel-default">
        <div class="panel-heading">
            <h3 class="panel-title">작성자</h3>
        </div>
        <div class="panel-body">
            ${freeview.name}
        </div>
    </div>
    <div class="panel panel-default">
        <div class="panel-heading">
            <h3 class="panel-title">작성 시간</h3>
        </div>
        <div class="panel-body">
            ${freeview.regdate}
        </div>
    </div>
    <div class="panel panel-default">
        <div class="panel-heading">
            <h3 class="panel-title">제목</h3>
        </div>
        <div class="panel-body">
            ${freeview.title}
        </div>
    </div>
    <div class="panel panel-default">
        <div class="panel-heading">
            <h3 class="panel-title">내용</h3>
        </div>
        <div class="panel-body">
            ${freeview.contents}
        </div>
    </div>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
</body>
</html>