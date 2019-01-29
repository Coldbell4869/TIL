<html>
	<head>
		 <meta charset="utf-8">
 		 <meta name="viewport" content="width=device-width, initial-scale=1">
 		 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
 		 <link href="../../css/delete.css" type="text/css" rel="stylesheet">
 		 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
 		 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	</head>
	<body>
		<div class="panel panel-default" id = "delete-panel">
	      	<div class="panel-heading">비밀번호를 입력하세요.</div>
	      	<div class="panel-body">
				<form class="form-horizontal" action="/action_page.php">
					<div class="form-group pwd-form">
				      <label class="control-label col-sm-2 col-sm-offset-1" for="pwd">Password:</label>
				      <div class="col-sm-8">
				        <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="pwd">
				      </div>
				    </div>
					<center>
					<button type="submit" class="btn btn-default">확인</button>
					<button type="button" class="btn btn-default" onClick="location.href='board.html'">취소</button>
					</center>
				</form>
	      	</div>
    	</div>
	</body>

</html>