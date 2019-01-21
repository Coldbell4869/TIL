<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>글 작성</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://stackpath.bootstrapcdn.com/bootswatch/4.2.1/lux/bootstrap.min.css" rel="stylesheet" integrity="sha384-kW2H6mf/72/MKlmwB//Zcwg0ckiegojPx/fio14/rpoYw2LMhULTn5YhS1QyrQfx" crossorigin="anonymous">
</head>

<body>
<form action="/write" method="post">
<div class="container" style="padding-top: 15px;">
    <div class="content">
        <div class="form-group">
            <label>작성자 : </label>
            <%--<input type="text" class="form-control" id="name" name="name" placeholder="작성자 이름을 입력하세요. ">--%>
                <label>${sessionScope.logininfo.user_name}</label>
        </div>
        <div class="form-group">
            <label for="title">제목</label>
            <input type="text" class="form-control" id="title" name="title" placeholder="제목을 입력하세요. ">
        </div>
        <div class="form-group">
            <label for="content">내용</label>
            <textarea class="form-control" rows="5" id="content" name="content" placeholder="내용을 입력하세요. "></textarea>
        </div>
        <div class="buttons" style="float:right;">
            <button type="button" class="btn btn-outline-secondary" onClick="location.href='/list'">취소</button>
            <button type="submit" class="btn btn-outline-secondary">등록</button>
        </div>
    </div>
</div>

<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.bundle.min.js" integrity="sha384-zDnhMsjVZfS3hiP7oCBRmfjkQC4fzxVxFhBx8Hkz2aZX8gEvA/jsP3eXRCvzTofP" crossorigin="anonymous"></script>
</body>

</html>