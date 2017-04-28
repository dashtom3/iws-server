<html>
<body>
<h2>Hello World!</h2>
system
<form action="api/system/add.do" method="post">
    <input type="text" name="name"/>
    <input type="text" name="pic" value="pic">
    token<input type="text" name="token" value="123"/>
    <input type="submit" value="add"/>
</form>
<form action="http://61.190.61.78:6784/iws/api/system/pic.do" method="post">
    token<input type="text" name="token" value=""/>
    <input type="submit" value="pic"/>
</form>
<form action="api/customer/system/list.do" method="post">
    token<input type="text" name="token" value=""/>
    <input type="submit" value="list"/>
</form>
<form action="api/customer/system/detail.do" method="post">
    token<input type="text" name="token" value=""/>
    token<input type="text" name="systemId" value="1"/>
    <input type="submit" value="list"/>
</form>
area
<form action="api/area/cities.do" method="post">

    token<input type="text" name="token" value="123"/>
    <input type="submit" value="cities"/>
</form>
<form action="api/area/areas.do" method="post">

    token<input type="text" name="token" value="123"/>
    <input type="submit" value="areas"/>
</form>
<form action="api/area/province.do" method="post">
    <input type="text" name="provinceId" value="110000"/>
    token<input type="text" name="token" value="123"/>
    <input type="submit" value="province"/>
</form>
<form action="api/area/city.do" method="post">
    <input type="text" name="cityId" value="110100"/>
    token<input type="text" name="token" value="123"/>
    <input type="submit" value="city"/>
</form>
<form action="api/area/area.do" method="post">
    <input type="text" name="areaId" value="140101"/>
    token<input type="text" name="token" value="123"/>
    <input type="submit" value="area"/>
</form>
location
<form action="api/location/query.do" method="post">
    <input type="text" name="systemId"/>
    <input type="text" name="areaId"/>
    <input type="text" name="cityId"/>
    <input type="text" name="provinceId"/>
    token<input type="text" name="token" value="123"/>
    <input type="submit" value="query"/>
</form>
<form action="api/location/detail.do" method="post">
    <input type="text" name="locationId"/>
    token<input type="text" name="token" value="SK123"/>
    <input type="submit" value="detail"/>
</form>
<form action="api/location/lockedList.do" method="get">
    <input type="text" name="systemId"/>
    token<input type="text" name="token" value=""/>
    <input type="submit" value="lockedList"/>
</form>
<form action="api/location/list" method="post">
    <input type="text" name="systemId"/>
    token<input type="text" name="token" value=""/>
    <input type="submit" value="list"/>
</form>
device
<form action="api/room/start" method="post">
    <input type="text" name="groupId"/>
    <input type="text" name="groupId"/>
    token<input type="text" name="token" value="SK123"/>
    <input type="submit" value="start"/>
</form>
<form action="api/device/enable.do" method="post">
    <input type="text" name="groupId"/>
    token<input type="text" name="token" value="123"/>
    <input type="submit" value="enable"/>
</form>

<form action="api/device/delete" method="post">
    <input type="text" name="groupId"/>
    token<input type="text" name="token" value="SK123"/>
    <input type="submit" value="delete"/>
</form>

<form action="api/device/groupDetail" method="get">
    <input type="text" name="groupId"/>
    token<input type="text" name="token" value="SK123"/>
    <input type="submit" value="groupDetail"/>
</form>

<form action="api/device/groupType" method="get">
    token<input type="text" name="token" value="SK123"/>
    <input type="submit" value="groupType"/>
</form>


<form action="api/device/addGroup" method="post">
    <input type="text" name="terms"/>
    token<input type="text" name="token" value="SK123"/>
    <input type="submit" value="addGroup"/>
</form>

<form action="api/device/update" method="post">
    <input type="text" name="terms"/>
    <input type="text" name="groupId"/>
    token<input type="text" name="token" value="SK123"/>
    <input type="submit" value="update"/>
</form>

<form action="api/device/list" method="get">
    token<input type="text" name="token" value="SK123"/>
    <input type="submit" value="list"/>
</form>
user
<form action="api/user/getVerifyCode.do" method="post">
    <input type="text" name="username"/>
    token<input type="text" name="token" value="123"/>
    <input type="submit" value="getVerifyCode"/>
</form>
<form action="api/user/login.do" method="post">
    <input type="text" name="username"/>
    <input type="password" name="password">
    token<input type="text" name="token" value="123"/>
    <input type="submit" value="login"/>
</form>
<form action="api/user/changePwd.do" method="post">
    <input type="text" name="oldPwd"/>
    <input type="text" name="newPwd">
    token<input type="text" name="token" value=""/>
    <input type="submit" value="changePwd"/>
</form>
role
<form action="http://61.190.61.78:6784/iws/api/role/list" method="post">
    token<input type="text" name="token" value="123"/>
    <input type="submit" value="list"/>
</form>
<form action="http://61.190.61.78:6784/iws/api/role/delete" method="post">
    token<input type="text" name="token" value="SK123"/>
    <input type="text" name="roleId" value="123"/>
    <input type="submit" value="delete"/>
</form>
<form action="api/role/query" method="post">
    token<input type="text" name="token" value="SK123"/>
    <input type="text" name="systemId" value="1"/>
    <input type="submit" value="query"/>
</form>

<form action="api/role/detail" method="post">
    token<input type="text" name="token" value="SK123"/>
    <input type="text" name="roleId" value="1"/>
    <input type="submit" value="detail"/>
</form>
deviceTerm
<form action="api/deviceTerm/query.do" method="post">
    <input type="text" name="name"/>
    token<input type="text" name="token" value="SK123"/>
    <input type="submit" value="query"/>
</form>
<form action="api/deviceTerm/pointRole" method="post">
    token<input type="text" name="token" value="SK123"/>
    <input type="submit" value="pointRole"/>
</form>
<form action="api/deviceTerm/list" method="post">
    token<input type="text" name="token" value="SK123"/>
    <input type="text" name="type" value="1"/>
    <input type="submit" value="list"/>
</form>
<form action="api/deviceTerm/update" method="post">
    token<input type="text" name="token" value="SK123"/>
    <input type="text" name="name" value="update"/>
    <input type="text" name="id" value="1"/>
    <input type="submit" value="update"/>
</form>
<form action="api/deviceTerm/detail" method="post">
    token<input type="text" name="token" value="SK123"/>
    <input type="text" name="deviceTermId" value="1"/>
    <input type="submit" value="detail"/>
</form>
<form action="api/deviceTerm/typeList" method="post">
    token<input type="text" name="token" value="SK123"/>
    <input type="submit" value="typeList"/>
</form>

data
<form action="api/data/query" method="get">
    <input type="text" name="deviceId" value="1"/>
    <input type="text" name="startTime" value="2016-01-01 12:00:00"/>
    <input type="text" name="endTime" value="2018-01-01 12:00:00"/>
    <input type="text" name="timeStep" value="60"/>
    token<input type="text" name="token" value="SK123"/>
    <input type="submit" value="query"/>
</form>

<form action="api/data/outputExcel" method="get">
    <input type="text" name="deviceId" value="1"/>
    <input type="text" name="startTime" value="2016-01-01 12:00:00"/>
    <input type="text" name="endTime" value="2018-01-01 12:00:00"/>
    <input type="text" name="timeStep" value="60"/>
    token<input type="text" name="token" value="SK123"/>
    <input type="submit" value="outputExcel"/>
</form>

<form action="api/data/presentData" method="get">
    <input type="text" name="deviceId" value="1"/>
    token<input type="text" name="token" value="SK123"/>
    <input type="submit" value="presentDate"/>
</form>

room
<form action="api/room/groupList" method="get">
    token<input type="text" name="token" value="SK123"/>
    <input type="text" name="roomId" value="1"/>
    <input type="submit" value="groupList"/>
</form>

<form action="api/room/groupDetail" method="get">
    token<input type="text" name="token" value="SK123"/>
    <input type="text" name="groupId" value="1"/>
    <input type="submit" value="groupDetail"/>
</form>

alarm
<form action="api/alarm/list" method="get">
    token<input type="text" name="token" value="SK123"/>
    <input type="submit" value="list"/>
</form>

userManage
<form action="api/userManage/list" method="get">
    token<input type="text" name="token" value="123"/>
    <input type="submit" value="list"/>
</form>

role<br />
<input type="text" name="" value="" id="systemId"><br>
<input type="text" name="" value="" id="name"><br>
<input type="button" name="" value="addRole" onclick="btn()">

<input type="button" name="" value="addDevice" onclick="device()">

<input type="button" name="" value="addDeviceTerm" onclick="deviceTerm()">

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
    }

    function device () {
        var name = '123'
        var systemId = document.getElementById('systemId').value
        var subitem = JSON.stringify([{
            termId: systemId,
            number:'01'
        },{
            termId: systemId,
            number:'02'
        }])
        subitem = subitem;
        console.log(subitem);
        var xhr = new XMLHttpRequest();
        xhr.open("POST", "http://localhost:8080/iws/api/room/addDevice?token=SK123&name="+name+"&")
        xhr.setRequestHeader("Content-Type", "application/json")
        xhr.send(subitem)
    }

    function deviceTerm () {
        var name = '123'
        var type = 2
        var subitem = JSON.stringify([{
            number:'1',
            type:1
        },{
            number:'2',
            type:2
        }])
        subitem = subitem;
        console.log(subitem);
        var xhr = new XMLHttpRequest();
        xhr.open("POST", "http://localhost:8080/iws/api/deviceTerm/add?token=SK123&name="+name+"&type="+type+"&")
        xhr.setRequestHeader("Content-Type", "application/json")
        xhr.send(subitem)
    }
</script>
</html>
