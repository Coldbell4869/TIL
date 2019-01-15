<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html lang="ko">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>게시글 목록</title>
    <link href="https://stackpath.bootstrapcdn.com/bootswatch/4.2.1/lux/bootstrap.min.css" rel="stylesheet" integrity="sha384-kW2H6mf/72/MKlmwB//Zcwg0ckiegojPx/fio14/rpoYw2LMhULTn5YhS1QyrQfx" crossorigin="anonymous">
</head>
<body>
<div class="container table-bordered" style="padding-top: 15px;">
    <table class="table table-striped">
        <thead>
        <tr>
            <th scope="col">번호</th>
            <th scope="col">제목</th>
            <th scope="col">작성자</th>
            <th scope="col">날짜</th>
            <th scope="col">조회수</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${requestScope.freelist}" var="free">
            <tr>
                <td scope="row" class = board><a href="/free/read?id=${free.id}">${free.id}</a></td>
                <td><a href="/free/read?id=${free.id}">${free.title}</a></td>
                <td><a href="/free/read?id=${free.id}">${free.name}</a></td>
                <td><a href="/free/read?id=${free.id}">${free.regdate}</a></td>
                <td><a href="/free/read?id=${free.id}">${free.viewcount}</a></td>
           </tr>
        </c:forEach>
        </tbody>
    </table>

    <a class="btn pull-right btn-default" href="http://localhost:8080/write.html">글쓰기</a>

    <ul class="pull-left pagination">
        <li class="active"><a href="#">1</a></li>
        <li><a href="#">2</a></li>
        <li><a href="#">3</a></li>
        <li><a href="#">4</a></li>
        <li><a href="#">5</a></li>
    </ul>

</div>

<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.bundle.min.js" integrity="sha384-zDnhMsjVZfS3hiP7oCBRmfjkQC4fzxVxFhBx8Hkz2aZX8gEvA/jsP3eXRCvzTofP" crossorigin="anonymous"></script>
</body>
</html>
