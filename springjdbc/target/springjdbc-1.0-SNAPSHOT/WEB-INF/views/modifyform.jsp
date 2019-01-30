<!DOCTYPE html>
<html lang="en">
<head>
  <title>BoardModify</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link rel="stylesheet" type="text/css" href="../../css/modifyform.css">
</head>
<body>

<div class="container">
  <div class="page-header">
  <h2>글 수정하기</h2>
</div>
  <div class="content">
  <div class="row">
  
  <form action="/action_page.php">
    <div class="form-group col-md-4 cos-xs-4" style="float: left;">
      <label for="email">닉네임:</label>
      <div type="email" class="form-control" id="email" placeholder="Enter email" name="email"></div>
    </div>

    <div class="form-group col-md-4 offset-md-4 cos-xs-4" style="float: right;">
      <label for="pwd">비밀번호:</label>
      <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="pwd">
    </div>

  </div>


    <div class="form-group">
      <label for="pwd">제목:</label>
      <input type="title" class="form-control" id="pwd" placeholder="원래제목 불러오기" name="pwd">
    </div>
    <div class="form-group">
      <label for="comment">내용:</label>
      <textarea class="form-control" rows="12" id="comment"></textarea>
    </div>
    <div class="buttons" style="float: right;">
    <button type="submit" class="btn btn-default" onClick="location.href='view.jsp'">취소</button>
    <button type="submit" class="btn btn-default">수정</button>
    </div>
  </form>
</div>
</div>

</body>
</html>
