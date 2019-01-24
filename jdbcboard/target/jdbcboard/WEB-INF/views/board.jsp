<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <meta charset="utf-8">
				
				<!-- Latest compiled and minified CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

		<!-- jQuery library -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

		<!-- Latest compiled JavaScript -->
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
	
	
<body>
	
	<h1 style="text-align:center; margin-top:50px;">게시판 만들기 </h1>
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
	<table class = "table table-bordered table-hover" style='width:50%; margin:50px auto;'>
		<thead style="background-color:#ebebeb;">
			<th width="10%">글번호</th>
			<th width="45%">제목</th>
			<th width="15%">글쓴이</th>
			<th width="15%">날짜</th>
			<th width="15%">조회수</th>
		</thead>
		<tbody>
			<c:forEach items="${boards}" var="board">
			<tr>
				<td>${board.id}</td>
				<td>
					<c:forEach begin="1" end="${board.groupDepth}">&nbsp;</c:forEach>
					<a href="/read?id=${board.id}">${board.title}</a></td>
				<td>${board.nickname}</td>
				<td>${board.regdate}</td>
				<td>${board.readCount}</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	
	
	<div class="text-center" style="width:50%; margin:0 auto; margin-top:50px;">
		</br>
		<ul class = "pagination">
			<li><a href="#">&laquo;</a></li>
			<li><a href="#">1</a></li>
			<li><a href="#">2</a></li>
			<li><a href="#">3</a></li>
			<li><a href="#">4</a></li>
			<li><a href="#">5</a></li>
			<li><a href="#">6</a></li>
			<li><a href="#">7</a></li>
			<li><a href="#">8</a></li>	
			<li><a href="#">9</a></li>
			<li><a href="#">10</a></li>
			<li><a href="#">&raquo;</a></li>
		</ul>
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


    
</body>





	

</html>





<!--
<form action="http://localhost/hidden.php">
        <input type="text" name="id" >
        <input type="hidden" name="pw" value="pw">
        <input type="submit">
    </form>
    
	<div class="container">
  <h2>Dropdowns</h2>
  <p>The .divider class is used to separate links inside the dropdown menu with a thin horizontal line:</p>
  <div class="dropdown">
    <button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown">Tutorials
    <span class="caret"></span></button>
    <ul class="dropdown-menu">
      <li><a href="#">HTML</a></li>
      <li><a href="#">CSS</a></li>
      <li><a href="#">JavaScript</a></li>
      <li class="divider"></li>
      <li><a href="#">About Us</a></li>
    </ul>
  </div>
</div>  
-->