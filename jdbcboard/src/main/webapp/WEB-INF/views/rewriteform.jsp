<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>WriteForm</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="wrieform.css">
</head>
<body>
<form action="/rewrite" method="post">
<div class="container">
    <div class="page-header">
        <h2>글쓰기</h2>
    </div>
    <div class="content">
        <div class="row">


                <div class="form-group col-md-4 cos-xs-4" style="float: left;">
                    <label for="name">이름:</label>
                    <label>${sessionScope.logininfo.nickname}</label>
                </div>

                <div class="form-group col-md-4 offset-md-4 cos-xs-4" style="float: right;">
                </div>

        </div>

        <input type="hidden" name="id" value="${board.id}">
        <div class="form-group">
            <label for="title">제목:</label>
            <input type="text" class="form-control" id="title" placeholder="Enter Title" name="title" value="${board.title}">
        </div>
        <div class="form-group">
            <label for="content">내용:</label>
            <textarea class="form-control" rows="12" id="content" name="content">


                ${board.content}</textarea>
        </div>
        <div class="buttons" style="float: right;">
            <button type="button" class="btn btn-default" onClick="location.href='/board'">취소</button>
            <input type="submit" class="btn btn-default" value="등록"/>
        </div>
    </div>
</div>

</body>
</html>
