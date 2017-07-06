<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.zain.AppUser" %>
<html>
<body>
<h2>Home!</h2>
Welcome <%= ((AppUser)request.getSession().getAttribute("appUser")).getDisplayName() %>
<br />
<form method="post" action="/logout">
    <input type="submit" value="Logout">
</form>
</body>
</html>
