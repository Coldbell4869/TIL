<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="ko">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>로그인</title>
    <link href="https://stackpath.bootstrapcdn.com/bootswatch/4.2.1/lux/bootstrap.min.css" rel="stylesheet" integrity="sha384-kW2H6mf/72/MKlmwB//Zcwg0ckiegojPx/fio14/rpoYw2LMhULTn5YhS1QyrQfx" crossorigin="anonymous">
</head>

<body>

<h1>LOGIN</h1>
<form action="/login" method="post">
    <div class="container" style="padding-top: 15px;">
        <div class="content">
            <div class="form-group">
                <label for="email">email : </label>
                <input type="text" class="form-control" id="email" name="email" size="20" >
            </div>
            <div class="form-group">
                <label for="title">password : </label>
                <input type="text" class="form-control" id="title" name="passwd" size="20" >
            </div>
            <div class="buttons" style="float:right;">
                <button type="button" class="btn btn-outline-secondary" onClick="location.href='/list'">취소</button>
                <button type="submit" class="btn btn-outline-secondary">로그인</button>
            </div>
        </div>
    </div>


<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.bundle.min.js" integrity="sha384-zDnhMsjVZfS3hiP7oCBRmfjkQC4fzxVxFhBx8Hkz2aZX8gEvA/jsP3eXRCvzTofP" crossorigin="anonymous"></script>
</body>
</html>
