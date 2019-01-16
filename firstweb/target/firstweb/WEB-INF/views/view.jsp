<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://stackpath.bootstrapcdn.com/bootswatch/4.2.1/lux/bootstrap.min.css" rel="stylesheet" integrity="sha384-kW2H6mf/72/MKlmwB//Zcwg0ckiegojPx/fio14/rpoYw2LMhULTn5YhS1QyrQfx" crossorigin="anonymous">
</head>

<body>
<div class="container">
    <div class="card border-primary mb-3">
        <div class="card-header">작성일 : ${freeboard.regdate}</div>
        <div class="card-header">작성자 : ${freeboard.name}</div>
        <div class="card-body">
            <h4 class="card-title">${freeboard.title}</h4>
            <p class="card-text">${freeboard.content}</p>
        </div>
    </div>

    <br/>

    <div class="row">
        <div class="col-sm">
            <div class="col text-center">
                <button type="button" class="btn btn-outline-secondary" id = "btn-list" onClick="location.href='/list'">목록</button>
            </div>
        </div>
        <div class="col-sm">
            <div class="col text-center">
                <button type="button" class="btn btn-outline-secondary" id = "btn-update" onClick="location.href='/modify?id=${freeboard.id}'">수정</button>
            </div>
        </div>
        <div class="col-sm">
            <div class="col text-center">
                <button type="button" class="btn btn-outline-secondary" id = "btn-delete" onClick="location.href='/delete?id=${freeboard.id}'">삭제</button>
            </div>
        </div>
    </div>

</div>

    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.bundle.min.js" integrity="sha384-zDnhMsjVZfS3hiP7oCBRmfjkQC4fzxVxFhBx8Hkz2aZX8gEvA/jsP3eXRCvzTofP" crossorigin="anonymous"></script>
    </body>

</html>