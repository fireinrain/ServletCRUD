<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
    <!--//其实是一个表单提交-->
    <form action="/addHero" method="post">
        名字：<input type="text" name="name" placeholder="新的英雄"><br>
        血量：<input type="text" name="hp" placeholder="英雄的hp"><br>
        伤害：<input type="text" name="damage" placeholder="英雄的伤害"><br>
        <input type="submit" value="增加">
    </form>

