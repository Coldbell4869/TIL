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
<div class="container">
    <table class="table table-hover">
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
        <c:forEach items="${freeboards}" var="freeboards">
            <tr>
                <td scope="row" class = board><a href="/freeview?id=${freeboards.id}">${freeboards.id}</a></td>
                <td><a href="/freeview?id=${freeboards.id}">${freeboards.title}</a></td>
                <td><a href="/freeview?id=${freeboards.id}">${freeboards.name}</a></td>
                <td><a href="/freeview?id=${freeboards.id}">${freeboards.regdate}</a></td>
                <td><a href="/freeview?id=${freeboards.id}">${freeboards.readcount}</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <div class="row">
        <div class="float-left">
            <div class="col-sm">
                <div>
                <ul class="pagination pagination-sm">
                    <li class="page-item disabled">
                        <a class="page-link" href="#">&laquo;</a>
                    </li>
                    <li class="page-item active">
                        <a class="page-link" href="#">1</a>
                    </li>
                    <li class="page-item">
                        <a class="page-link" href="#">2</a>
                    </li>
                    <li class="page-item">
                        <a class="page-link" href="#">3</a>
                    </li>
                    <li class="page-item">
                        <a class="page-link" href="#">4</a>
                    </li>
                    <li class="page-item">
                        <a class="page-link" href="#">5</a>
                    </li>
                    <li class="page-item">
                        <a class="page-link" href="#">&raquo;</a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
    <div class="col-sm">
        <div class="col text-right">
            <%--<button type="button" class="btn btn-outline-secondary" id = "btn-write" onClick="location.href='/write'">글쓰기</button>--%>
            <c:if test="${sessionScope.logininfo == null}">
                <button type="button" class="btn btn-outline-secondary" id = "btn-login" onClick="location.href='/login'">로그인</button>
            </c:if>
            <c:if test="${sessionScope.logininfo == null}">
                ${sessionScope.logininfo.name}&nbsp;
                <button type="button" class="btn btn-outline-secondary" id = "btn-write" onClick="location.href='/write'">글쓰기</button>
                <button type="button" class="btn btn-outline-secondary" id = "btn-logout" onClick="location.href='/logout'">로그아웃</button>
            </c:if>
        </div>
    </div>

</div>

<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.bundle.min.js" integrity="sha384-zDnhMsjVZfS3hiP7oCBRmfjkQC4fzxVxFhBx8Hkz2aZX8gEvA/jsP3eXRCvzTofP" crossorigin="anonymous"></script>
</body>
</html>
