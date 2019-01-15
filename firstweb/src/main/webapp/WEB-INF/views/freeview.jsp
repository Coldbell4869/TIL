<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html lang="ko">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>게시글 보기</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.bundle.min.js" integrity="sha384-zDnhMsjVZfS3hiP7oCBRmfjkQC4fzxVxFhBx8Hkz2aZX8gEvA/jsP3eXRCvzTofP" crossorigin="anonymous"></script>
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

<%--<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>--%>
</body>
</html>