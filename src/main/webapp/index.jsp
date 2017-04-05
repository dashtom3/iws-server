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
<form action="api/system/pic.do" method="post">
    <input type="hidden" name="token" value="123"/>
    <input type="submit" value="pic"/>
</form>
<form action="api/system/list.do" method="post">
    <input type="hidden" name="token" value="123"/>
    <input type="submit" value="list"/>
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
<form action="api/location/detail.do" method="post">
    <input type="text" name="locationId"/>
    <input type="hidden" name="token" value="123"/>
    <input type="submit" value="detail"/>
</form>
device
<form action="api/device/start.do" method="post">
    <input type="text" name="com"/>
    <input type="hidden" name="token" value="123"/>
    <input type="submit" value="start"/>
</form>
<form action="api/device/enable.do" method="post">
    <input type="text" name="groupId"/>
    <input type="hidden" name="token" value="123"/>
    <input type="submit" value="enable"/>
</form>
user
<form action="api/user/getVerifyCode.do" method="post">
    <input type="text" name="username"/>
    <input type="hidden" name="token" value="123"/>
    <input type="submit" value="getVerifyCode"/>
</form>
<form action="api/user/login.do" method="post">
    <input type="text" name="username"/>
    <input type="password" name="password">
    <input type="hidden" name="token" value="123"/>
    <input type="submit" value="login"/>
</form>
role
<form action="api/role/list.do" method="post">
    <input type="hidden" name="token" value="123"/>
    <input type="submit" value="list"/>
</form>
<form action="api/role/delete.do" method="post">
    <input type="hidden" name="token" value="123"/>
    <input type="text" name="roleId" value="123"/>
    <input type="submit" value="delete"/>
</form>
deviceTerm
<form action="api/deviceTerm/query.do" method="post">
    <input type="text" name="name"/>
    <input type="hidden" name="token" value="123"/>
    <input type="submit" value="query"/>
</form>

JsonArray<br />
<input type="text" name="" value="" id="systemId"><br>
<input type="text" name="" value="" id="name"><br>
<input type="button" name="" value="JsonArray" onclick="btn()">
</body>


<script type="text/javascript">
    function btn () {
        var name = document.getElementById('name').value
        var systemId = document.getElementById('systemId').value
        var subitem = JSON.stringify([{
            systemId: systemId,
            areaId:110000
        }])
        subitem = subitem;
        console.log(subitem);
        var xhr = new XMLHttpRequest();
        xhr.open("POST", "http://localhost:8080/iws/api/role/add?token=123&name="+name+"&")
        xhr.setRequestHeader("Content-Type", "application/json")
        xhr.send(subitem)
//        xhr.onreadystatechange = function () {
//            switch (this.readyState) {
//                case 4:
//                    console.log('ok');
//                    var result = JSON.parse(this.responseText)
//                    console.log(result)
//                    break
//            }
//        }
    }
</script>
</html>
