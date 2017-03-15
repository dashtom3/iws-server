<html>
<body>
<h2>Hello World!</h2>
system
<form action="api/system/add.do" method="post">
    <input type="text" name="name"/>
    <input type="hidden" name="pic" value="pic">
    <input type="hidden" name="token" value="123"/>
    <input type="submit" value="add"/>
</form>
area
<form action="api/area/cities.do" method="post">

    <input type="hidden" name="token" value="123"/>
    <input type="submit" value="cities"/>
</form>
<form action="api/area/areas.do" method="post">

    <input type="hidden" name="token" value="123"/>
    <input type="submit" value="areas"/>
</form>
<form action="api/area/province.do" method="post">
    <input type="text" name="provinceId" value="110000"/>
    <input type="hidden" name="token" value="123"/>
    <input type="submit" value="province"/>
</form>
<form action="api/area/city.do" method="post">
    <input type="text" name="cityId" value="110100"/>
    <input type="hidden" name="token" value="123"/>
    <input type="submit" value="city"/>
</form>
<form action="api/area/area.do" method="post">
    <input type="text" name="areaId" value="140101"/>
    <input type="hidden" name="token" value="123"/>
    <input type="submit" value="area"/>
</form>
location
<form action="api/location/query.do" method="post">
    <input type="text" name="systemId"/>
    <input type="text" name="areaId"/>
    <input type="text" name="cityId"/>
    <input type="text" name="provinceId"/>
    <input type="hidden" name="token" value="123"/>
    <input type="submit" value="query"/>
</form>
device
<form action="api/device/start.do" method="post">
    <input type="text" name="com"/>
    <input type="hidden" name="token" value="123"/>
    <input type="submit" value="start"/>
</form>
</body>
</html>
