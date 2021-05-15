<%--
  Created by IntelliJ IDEA.
  User: cleber
  Date: 5/11/21
  Time: 8:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="ValidationLoginServlet"  method="post" style="display: flex; flex-direction: column; align-items: center">
        <br/>
        <label>
            Login: <input type="email" name="login"/>
        </label>
        <br/>
        <label>
            Password: <input type="password" name="password">
        </label>
        <br/>
        <input type="submit" name="register" value="Submit">


        <%  if(request.getParameter("register") != null) {%>
            <jsp:useBean id="login"  class="to.Login" scope="request"/>
            <jsp:setProperty name="login" property="*"/>
            <jsp:forward page="ValidationLoginServlet"/>
        <%}%>
    </form>
</body>
</html>
