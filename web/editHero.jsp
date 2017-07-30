<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/7/28
  Time: 21:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<form action="/editHero?id=${hero.id}" method="post">
    名字：<input type="text" name="name" value="${hero.name}"> <br>
    血量：<input type="text" name="hp" value="${hero.hp}"/><br>
    伤害：<input type="text" name="damage" value="${hero.damage}"/><br>
    <input type="submit" value="更新"/>
</form>
