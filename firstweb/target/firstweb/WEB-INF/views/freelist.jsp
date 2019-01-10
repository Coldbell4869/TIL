<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
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
        <tr>
            <c:forEach items="${requestScope.freelist}" var="free">
            <td scope="row" class = board>${free.id}</td>
            <td><a href = "/free/read">${free.title}</a></td>
            <td>${free.name}</td>
            <td>${free.regdate}</td>
            <td>${free.viewcount}</td>
        </tr>
        </c:forEach>
        </tbody>
    </table>

    <a class="btn pull-right btn-default" href="http://localhost:8080/freewrite.jsp">글쓰기</a>

    <ul class="pull-left pagination">
        <li class="active"><a href="#">1</a></li>
        <li><a href="#">2</a></li>
        <li><a href="#">3</a></li>
        <li><a href="#">4</a></li>
        <li><a href="#">5</a></li>
    </ul>

</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
</body>
</html>