<html>
<body>
<h2>Hello World!</h2>
<form action="api/system/add.do" method="post">
    <input type="text" name="name"/>
    <input type="hidden" name="pic" value="pic">
    <input type="hidden" name="token" value="123"/>
    <input type="submit" value="add"/>
</form>
<form action="api/system/update.do" method="post">
    <input type="text" name="name"/>
    <input type="text" name="id">
    <input type="hidden" name="token" value="123"/>
    <input type="submit" value="update"/>
</form>
</body>
</html>
