<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html lang="ko">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>게시글 목록</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container table-bordered" style="padding-top: 15px;">
    <form>
        <div class="form-group">
            <label for="Name">작성자</label>
            <input type="text" class="form-control" id="Name" placeholder="작성자 이름을 입력하세요. ">
        </div>
        <div class="form-group">
            <label for="Password">비밀번호</label>
            <input type="password" class="form-control" id="Password" placeholder="비밀번호를 입력하세요. (게시글 수정,삭제 시 사용) ">
        </div>
        <div class="form-group">
            <label for="Title">제목</label>
            <input type="text" class="form-control" id="Title" placeholder="제목을 입력하세요. ">
        </div>
        <div class="form-group">
            <label for="Comment">내용</label>
            <textarea class="form-control" rows="5" id="Comment"></textarea>
        </div>
        <button type="cancel" class="pull-right btn btn-default">작성 취소</button>
        <button type="submit" class="pull-right btn btn-default">작성 완료</button>
    </form>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>