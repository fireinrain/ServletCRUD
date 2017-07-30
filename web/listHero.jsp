<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/7/28
  Time: 22:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--引入jq和bootstrap--%>
<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js"></script>
<link href="https://cdn.bootcss.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" rel="stylesheet">


<script>
    $(function () {
        $("a").addClass("btn btn-default btn-xs");

    });


</script>
<table style="width: 500px;margin: 44px auto" class="table table-striped table-bordered table-hover" align='center' border='1' cellspacing='0'>
    <tr>
       <td>编号(id)</td>
        <td>名称(name)</td>
        <td>血量(hp)</td>
        <td>伤害(damage)</td>
        <td>编辑(edit)</td>
        <td>删除(delete)</td>
    </tr>

    <c:forEach items="${heroes}" var="hero" varStatus="hrs" >
        <tr>
            <td>${hero.id}</td>
            <td>${hero.name}</td>
            <td>${hero.hp}</td>
            <td>${hero.damage}</td>
            <td><a href="/editHero?id=${hero.id}">修改</a></td>
            <td><a href="/deleteHero?id=${hero.id}">删除</a></td>
        </tr>
    </c:forEach>
    <tr >
        <td align="center" colspan="2">
            <a href="?start=0">[首页]</a>
        </td>
        <td align="center" colspan="1">
            <a href="?start=${pre}">[上一页]</a>
        </td>
        <td align="center" colspan="1">
            <a href="?start=${next}">[下一页]</a>
        </td>
        <td align="center" colspan="2">
            <a href="?start=${last}">[尾页]</a>
        </td>

    </tr>


</table>

<footer>
    你的ip是：${ip}
</footer>