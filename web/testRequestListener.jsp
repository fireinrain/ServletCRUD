<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/7/30
  Time: 14:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    request.setAttribute("test",1);
    request.setAttribute("test",2);
    request.removeAttribute("test");
%>