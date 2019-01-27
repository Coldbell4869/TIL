<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html lang="ko">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>게시글 목록</title>
	<link href="https://stackpath.bootstrapcdn.com/bootswatch/4.2.1/lux/bootstrap.min.css" rel="stylesheet" integrity="sha384-kW2H6mf/72/MKlmwB//Zcwg0ckiegojPx/fio14/rpoYw2LMhULTn5YhS1QyrQfx" crossorigin="anonymous">
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.bundle.min.js" integrity="sha384-zDnhMsjVZfS3hiP7oCBRmfjkQC4fzxVxFhBx8Hkz2aZX8gEvA/jsP3eXRCvzTofP" crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
	<div style="width:50%; margin:0 auto; padding-top:50px;">
		<c:if test="${sessionScope.logininfo == null}">
			<a class="btn btn-default" href="/login" id="" style='width:15%; float:right;'>로그인</a>
		</c:if>
		<c:if test="${sessionScope.logininfo != null}">
			${sessionScope.logininfo.nickname}&nbsp;
			<a class="btn btn-default" href="/write" id="" style='width:15%; float:right;'>글쓰기</a> &nbsp;
			<a class="btn btn-default" href="/logout" id="" style='width:15%; float:right;'>로그아웃</a>
		</c:if>
	</div>
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
        <c:forEach items="${boards}" var="board">
            <tr>
                <td scope="row" class = board><a href="/view?id=${board.id}">${board.id}</a></td>
                <td><a href="/view?id=${board.id}">${board.title}</a></td>
                <td><a href="/view?id=${board.id}">${board.user_name}</a></td>
                <td><a href="/view?id=${board.id}">${board.regdate}</a></td>
                <td><a href="/view?id=${board.id}">${board.readcount}</a></td>
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
		
		<div class="box1" style="width:40%; margin:3% auto 10%;">
			<div class="form-group" style="width:17%; margin-right:2%; float:left;">
				<label class="sr-only" for="sop">sop</label>
				<select name=sop class="form-control">
					<option value=제목>제목</option>
					<option value=내용>내용</option>
					<option value=작성자>작성자</option>
				</select>
			</div>
			<div class="form-group" style="width:60%; float:left;">
				<label class="sr-only" for="stx">stx</label>
				<input name=stx maxlength=15 size=10 itemname="검색어" required value='' class="form-control">
			</div>
			<div class="form-group" >
					<button class="btn " style="float: right; width:17%;">검색</button>
			</div>
		</div>
	<div class="col-sm">
		<div class="col text-right">
			<button type="button" class="btn btn-outline-secondary" id = "btn-write" onClick="location.href='/write'">글쓰기</button>
		</div>
	</div>

</div>
</body>
</html>