<%--
  Created by IntelliJ IDEA.
  User: NGOC HUY
  Date: 2/10/2025
  Time: 9:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<%
    HttpSession session2 = request.getSession(false);
    if(session2 != null){
        session2.invalidate();
    }
    response.sendRedirect("login.jsp");

%>>
<body>

</body>
</html>
