<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Writeform</title>
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
		</div>
	</div>
</nav>
<%--상단 내비바 끝--%>

<div class="container">
	<div class="row">
		<%--<div class="col-lg-2">--%>
			<%--&lt;%&ndash;왼쪽공간&ndash;%&gt;--%>
		<%--</div>--%>

		<div class="col-lg-12">

			<div class="card border-success mb-3">
				<div class="card-header">
					${board.nickname} /
					${board.regdate}
				</div>
				<div class="card-body">
					<h4 class="card-title">${board.title}</h4>
					<p class="card-text">${board.content}</p>
				</div>
			</div>

			<div class="buttons text-right">
				<button type="button" class="btn btn-danger">delete</button>
				<button type="button" class="btn btn-outline-warning">modify</button>
				<button type="button" class="btn btn-outline-success">reply</button>
				<a class="btn btn-outline-info" href="/board" role="button">back</a>
			</div>
		</div>

		<%--<div class="col-lg-2">--%>
			<%--&lt;%&ndash;오른쪽공간&ndash;%&gt;--%>
		<%--</div>--%>
	</div>
</div>

</body>
</html>