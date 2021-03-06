<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html lang="ko">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>게시글 작성</title>
    <link href="/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container table-bordered" style="padding-top: 15px;">
    <form action="/form1" method="post">
        <div class="form-group">
            <label for="Name">작성자</label>
            <input type="text" class="form-control" name="name" id="Name" placeholder="작성자 이름을 입력하세요. ">
        </div>

        <div class="form-group">
            <label for="checkbox">체크박스</label>
            <div class="checkbox" id="checkbox">
                <label>
                    <input type="checkbox" name="checkbox" id="checkbox1" value="그냥 ">
                    그냥&nbsp;
                </label>
                <label for="checkbox2">
                    <input type="checkbox" name="checkbox" id="checkbox2" value="넣어본 ">
                    넣어본&nbsp;
                </label>
                <label for="checkbox3">
                    <input type="checkbox" name="checkbox" id="checkbox3" value="체크박스 ">
                    체크박스&nbsp;
                </label>
            </div>
        </div>

        <div class="form-group">
            <label for="Radios">라디오버튼</label>
            <div class="radio" id="Radios">
                <label for="Radios1">
                    <input type="radio" name="radio" id="Radios1" value="라디오" checked>
                    라디오&nbsp;
                </label>
                <label for="Radios2">
                    <input type="radio" name="radio" id="Radios2" value="버튼">
                    버튼&nbsp;
                </label>
            </div>
        </div>

        <div class="form-group">
            <label for="Password">비밀번호</label>
            <input type="password" class="form-control" name="password" id="Password" placeholder="비밀번호를 입력하세요. (게시글 수정,삭제 시 사용) ">
        </div>

        <div class="form-group">
            <label for="Title">제목</label>
            <input type="text" class="form-control" name="title" id="Title" placeholder="제목을 입력하세요. ">
        </div>

        <div class="form-group">
            <label for="Contents">내용</label>
            <textarea class="form-control" rows="5" name="contents" id="Contents" placeholder="내용을 입력하세요. "></textarea>
        </div>
        <button type="submit" class="pull-right btn btn-default">작성 완료</button>
        <button type="reset" class="pull-right btn btn-default">작성 취소</button>
    </form>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
</body>
</html>