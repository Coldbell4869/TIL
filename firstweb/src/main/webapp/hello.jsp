<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>hello.jsp</title>
</head>
<body>
<h1>hello coldbell</h1>
<%!
    int k = 5;
    int plus(int i , int k){
        return i + k;
    }
%>
<%
    out.write(plus(10, 50) + "");   //write 에러 아님. 원래 그런거임.
    for(int i = 0; i < 100; i++){
%>
i = <%=i%> <br>
<%
    }
%>
</body>
</html>

