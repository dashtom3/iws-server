<html>
<body>
<h2>Hello World!</h2>
<form action="api/system/add.do" method="post">
    <input type="text" name="name">
    <input type="text" name="pic">
    <input type="hidden" name="token" value="123">
    <input type="submit" value="add">
</form>
<br /><br />
<form action="api/system/list.do" method="post">
    <input type="text" name="name">
    <input type="hidden" name="token" value="123">
    <input type="submit" value="list">
</form>
<br /><br />
<form action="api/system/detail.do" method="post">
    <input type="text" name="systemId">
    <input type="hidden" name="token" value="123">
    <input type="submit" value="detail">
</form>
</body>
</html>
