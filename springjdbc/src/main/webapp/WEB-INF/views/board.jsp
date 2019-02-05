<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Board</title>
		<link href="https://stackpath.bootstrapcdn.com/bootswatch/4.2.1/flatly/bootstrap.min.css" rel="stylesheet" integrity="sha384-9dACWymWSkhCeCgbjV6xqS20Luu4ue6QnEvr+nMXpPMwIq/OB89AoRh27Flsrxzs" crossorigin="anonymous">
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.bundle.min.js" integrity="sha384-zDnhMsjVZfS3hiP7oCBRmfjkQC4fzxVxFhBx8Hkz2aZX8gEvA/jsP3eXRCvzTofP" crossorigin="anonymous"></script>
    </head>

<body>
<%--상단 내비바 시작--%>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary col-lg-12">
	<div class="container">
	<a class="navbar-brand" href="/board">Coldpaper Board</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor01" aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

		<div class="collapse navbar-collapse" id="navbarColor01">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active">
					<a class="nav-link" href="/board">Board</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="https://coldbell4869.github.io/" target="_blank">Blog</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="https://github.com/coldbell4869" target="_blank">Github</a>
				</li>
			</ul>
				<%--로그인/로그아웃 버튼 시작--%>
				<ul class="nav navbar-nav ml-auto">
					<li class="nav-item">
						<a class="nav-link" href="/login" id="">Login</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="/joinform" id="">Join</a>
					</li>
					<%--<li class="nav-item">--%>
						<%--<a class="nav-link" href="/logout" id="">Logout</a>--%>
					<%--</li>--%>
				</ul>
		<%--로그인/로그아웃 버튼 끝--%>
		</div>
	</div>
</nav>
<%--상단 내비바 끝--%>

<div class="container">

<%--게시판 테이블 시작--%>
	<table class="table table-hover col-sm-12">
		<thead>
		<tr>
			<th scope="col" width="10%">#</th>
			<th scope="col" width="55%">Title</th>
			<th scope="col" width="10%">Nickname</th>
			<th scope="col" width="15%">Regdate</th>
			<th scope="col" width="10%">Hits</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach items="${boards}" var="board">
		<tr>
			<td>${board.id}</td>
			<td>
				<a href="/view?id=${board.id}">
				<c:forEach begin="1" end="${board.groupDepth}">[RE]</c:forEach>
				${board.title}</a></td>
			<td>${board.nickname}</td>
			<td>${board.regdate}</td>
			<td>${board.readCount}</td>
		</tr>
		</c:forEach>
		</tbody>
	</table>
<%--게시판 테이블 끝--%>

	<%--페이지네이션 + 검색 시작--%>
	<div class="row">
		<div class="col-lg-4 text-center">
			<form class="form-inline justify-content-center">
				<div class="form-group">
					<select class="custom-select">
						<option selected="1">Title</option>
						<option value="2">Nickname</option>
						<option value="3">Content</option>
					</select>
					<input class="form-control" type="text" placeholder="Search" maxlength="15">
					<button class="btn btn-primary" type="submit">Search</button>
				</div>
			</form>
		</div>

		<div class="col-lg-4 text-center">
			<ul class="pagination justify-content-center">
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

		<div class="col-lg-4 text-center">
			<a class="btn btn-primary btn-lg" href="/writeform" role="button">Write</a>
		</div>
	</div>
	<%--페이지네이션 + 검색 끝--%>
</body>
</html>