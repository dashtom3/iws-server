define({ "api": [
  {
    "type": "post",
    "url": "http://localhost:8080/iws/api/area/area",
    "title": "城区详情",
    "name": "area",
    "group": "area",
    "version": "0.1.0",
    "description": "<p>获取城区及其所在城市、省份</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "areaId",
            "description": "<p>城区id</p>"
          }
        ]
      }
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": " HTTP/1.1 200 OK\n{\ndata:{\n    id:1,\n    areaId:340103,\n    name:\"庐阳区\",\n    cityId:340100,\n\n    city:{\n    id:1,\n    cityId:340100,\n    name:\"合肥市\",\n    provinceId:340000,\n    }\n\n    province:{\n        id:1,\n        provinceId:340000,\n        name:\"安徽省\",\n    }\n\n}\n}\ntoken:\"SK1d7a4fe3-c2cd-417f-8f6f-bf7412592996\",\nnumberPerPage:0,\ncurrentPage:0,\ntotalNumber:0,\ntotalPage:0\n }",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "Error-Response:",
          "content": " HTTP/1.1 200 OK\n{\ncallStatus:\"FAILED\",\nerrorCode:\"Error\",\ndata:null,\ntoken:null,\nnumberPerPage:0,\ncurrentPage:0,\ntotalNumber:0,\ntotalPage:0\n }",
          "type": "json"
        }
      ]
    },
    "filename": "D:/desktop/Program/ApiDoc/source/AreaApi.java",
    "groupTitle": "area"
  },
  {
    "type": "post",
    "url": "http://localhost:8080/iws/api/area/areas",
    "title": "城区列表",
    "name": "areas",
    "group": "area",
    "version": "0.1.0",
    "description": "<p>获取全部城区，按城市-省份封装</p>",
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": " HTTP/1.1 200 OK\n{\ncallStatus:\"SUCCEED\",\nerrorCode:\"No_Error\",\ndata(List):{\n    id:1,\n    provinceId:340000,\n    name:\"安徽省\",\n\n    cities(List):{\n        id:1,\n        cityId:340100,\n        name:\"合肥市\",\n        provinceId:340000\n\n        areas(List):{\n            id:1,\n            areaId:340103,\n            name:\"庐阳区\",\n            cityId:340100\n        }\n    }\n}\n}\ntoken:\"SK1d7a4fe3-c2cd-417f-8f6f-bf7412592996\",\nnumberPerPage:0,\ncurrentPage:0,\ntotalNumber:0,\ntotalPage:0\n }",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "Error-Response:",
          "content": " HTTP/1.1 200 OK\n{\ncallStatus:\"FAILED\",\nerrorCode:\"Error\",\ndata:null,\ntoken:null,\nnumberPerPage:0,\ncurrentPage:0,\ntotalNumber:0,\ntotalPage:0\n }",
          "type": "json"
        }
      ]
    },
    "filename": "D:/desktop/Program/ApiDoc/source/AreaApi.java",
    "groupTitle": "area"
  },
  {
    "type": "post",
    "url": "http://localhost:8080/iws/api/area/citise",
    "title": "城市列表",
    "name": "cities",
    "group": "area",
    "version": "0.1.0",
    "description": "<p>获取全部城市，按省份封装</p>",
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": " HTTP/1.1 200 OK\n{\ncallStatus:\"SUCCEED\",\nerrorCode:\"No_Error\",\ndata(List):{\n    id:1,\n    provinceId:340000,\n    name:\"安徽省\",\n\n    cities(List):{\n        id:1,\n        cityId:340100,\n        name:\"合肥市\",\n        provinceId:340000\n    }\n}\n}\ntoken:\"SK1d7a4fe3-c2cd-417f-8f6f-bf7412592996\",\nnumberPerPage:0,\ncurrentPage:0,\ntotalNumber:0,\ntotalPage:0\n }",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "Error-Response:",
          "content": " HTTP/1.1 200 OK\n{\ncallStatus:\"FAILED\",\nerrorCode:\"Error\",\ndata:null,\ntoken:null,\nnumberPerPage:0,\ncurrentPage:0,\ntotalNumber:0,\ntotalPage:0\n }",
          "type": "json"
        }
      ]
    },
    "filename": "D:/desktop/Program/ApiDoc/source/AreaApi.java",
    "groupTitle": "area"
  },
  {
    "type": "post",
    "url": "http://localhost:8080/iws/api/area/city",
    "title": "城市详情",
    "name": "city",
    "group": "area",
    "version": "0.1.0",
    "description": "<p>获取城市及其所在省份、下属地区</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "cityId",
            "description": "<p>城市id</p>"
          }
        ]
      }
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": " HTTP/1.1 200 OK\n{\ndata:{\n    id:1,\n    cityId:340100,\n    name:\"合肥市\",\n    provinceId:340000,\n\n    province:{\n        id:1,\n        provinceId:340000,\n        name:\"安徽省\",\n    }\n\n    areas(List):{\n        id:1,\n        areaId:340103,\n        name:\"庐阳区\",\n        cityId:340100\n    }\n}\n}\ntoken:\"SK1d7a4fe3-c2cd-417f-8f6f-bf7412592996\",\nnumberPerPage:0,\ncurrentPage:0,\ntotalNumber:0,\ntotalPage:0\n }",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "Error-Response:",
          "content": " HTTP/1.1 200 OK\n{\ncallStatus:\"FAILED\",\nerrorCode:\"Error\",\ndata:null,\ntoken:null,\nnumberPerPage:0,\ncurrentPage:0,\ntotalNumber:0,\ntotalPage:0\n }",
          "type": "json"
        }
      ]
    },
    "filename": "D:/desktop/Program/ApiDoc/source/AreaApi.java",
    "groupTitle": "area"
  },
  {
    "type": "post",
    "url": "http://localhost:8080/iws/api/area/province",
    "title": "省份详情",
    "name": "province",
    "group": "area",
    "version": "0.1.0",
    "description": "<p>获取省份及其下属城市</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "provinceId",
            "description": "<p>省份id</p>"
          }
        ]
      }
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": " HTTP/1.1 200 OK\n{\ncallStatus:\"SUCCEED\",\nerrorCode:\"No_Error\",\ndata:{\n    id:1,\n    provinceId:340000,\n    name:\"安徽省\",\n\n    cities(List):{\n        id:1,\n        cityId:340100,\n        name:\"合肥市\",\n        provinceId:340000\n    }\n}\n}\ntoken:\"SK1d7a4fe3-c2cd-417f-8f6f-bf7412592996\",\nnumberPerPage:0,\ncurrentPage:0,\ntotalNumber:0,\ntotalPage:0\n }",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "Error-Response:",
          "content": " HTTP/1.1 200 OK\n{\ncallStatus:\"FAILED\",\nerrorCode:\"Error\",\ndata:null,\ntoken:null,\nnumberPerPage:0,\ncurrentPage:0,\ntotalNumber:0,\ntotalPage:0\n }",
          "type": "json"
        }
      ]
    },
    "filename": "D:/desktop/Program/ApiDoc/source/AreaApi.java",
    "groupTitle": "area"
  },
  {
    "type": "post",
    "url": "http://localhost:8080/iws/api/area/provinces",
    "title": "省份列表",
    "name": "provinces",
    "group": "area",
    "version": "0.1.0",
    "description": "<p>获取全部省份</p>",
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": " HTTP/1.1 200 OK\n{\ncallStatus:\"SUCCEED\",\nerrorCode:\"No_Error\",\ndata(List):{\n    id:1,\n    provinceId:340000,\n    name:\"安徽省\"\n    }\n}\ntoken:\"SK1d7a4fe3-c2cd-417f-8f6f-bf7412592996\",\nnumberPerPage:0,\ncurrentPage:0,\ntotalNumber:0,\ntotalPage:0\n }",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "Error-Response:",
          "content": " HTTP/1.1 200 OK\n{\ncallStatus:\"FAILED\",\nerrorCode:\"Error\",\ndata:null,\ntoken:null,\nnumberPerPage:0,\ncurrentPage:0,\ntotalNumber:0,\ntotalPage:0\n }",
          "type": "json"
        }
      ]
    },
    "filename": "D:/desktop/Program/ApiDoc/source/AreaApi.java",
    "groupTitle": "area"
  },
  {
    "type": "post",
    "url": "http://localhost:8080/iws/api/location/add",
    "title": "添加地点",
    "name": "add",
    "group": "location",
    "version": "0.1.0",
    "description": "<p>注册添加新地点</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "systemId",
            "description": "<p>系统id</p>"
          },
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "areaId",
            "description": "<p>地点所属区域编号，标识到城区</p>"
          },
          {
            "group": "Parameter",
            "type": "double",
            "optional": false,
            "field": "positionX",
            "description": "<p>地点经度坐标</p>"
          },
          {
            "group": "Parameter",
            "type": "double",
            "optional": false,
            "field": "positionY",
            "description": "<p>地点维度坐标</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "name",
            "description": "<p>地点名称</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "describes",
            "description": "<p>地点描述</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "token",
            "description": "<p>身份验证</p>"
          }
        ]
      }
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": " HTTP/1.1 200 OK\n{\ncallStatus:\"SUCCEED\",\nerrorCode:\"No_Error\",\ndata:null,\ntoken:\"SK1d7a4fe3-c2cd-417f-8f6f-bf7412592996\",\nnumberPerPage:0,\ncurrentPage:0,\ntotalNumber:0,\ntotalPage:0\n }",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "Error-Response:",
          "content": " HTTP/1.1 200 OK\n{\ncallStatus:\"FAILED\",\nerrorCode:\"Error\",\ndata:null,\ntoken:null,\nnumberPerPage:0,\ncurrentPage:0,\ntotalNumber:0,\ntotalPage:0\n }",
          "type": "json"
        }
      ]
    },
    "filename": "D:/desktop/Program/ApiDoc/source/LocationApi.java",
    "groupTitle": "location"
  },
  {
    "type": "post",
    "url": "http://localhost:8080/iws/api/location/delete",
    "title": "删除地点",
    "name": "delete",
    "group": "location",
    "version": "0.1.0",
    "description": "<p>删除地点</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "id",
            "description": "<p>地点id</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "token",
            "description": "<p>身份验证</p>"
          }
        ]
      }
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": " HTTP/1.1 200 OK\n{\ncallStatus:\"SUCCEED\",\nerrorCode:\"No_Error\",\ndata:null,\ntoken:\"SK1d7a4fe3-c2cd-417f-8f6f-bf7412592996\",\nnumberPerPage:0,\ncurrentPage:0,\ntotalNumber:0,\ntotalPage:0\n }",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "Error-Response:",
          "content": " HTTP/1.1 200 OK\n{\ncallStatus:\"FAILED\",\nerrorCode:\"Error\",\ndata:null,\ntoken:null,\nnumberPerPage:0,\ncurrentPage:0,\ntotalNumber:0,\ntotalPage:0\n }",
          "type": "json"
        }
      ]
    },
    "filename": "D:/desktop/Program/ApiDoc/source/LocationApi.java",
    "groupTitle": "location"
  },
  {
    "type": "post",
    "url": "http://localhost:8080/iws/api/location/detail",
    "title": "查看地点",
    "name": "detail",
    "group": "location",
    "version": "0.1.0",
    "description": "<p>获取某一地点及其所属系统、地点下全部泵房</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "id",
            "description": "<p>地点id</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "token",
            "description": "<p>身份验证</p>"
          }
        ]
      }
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": " HTTP/1.1 200 OK\n{\ncallStatus:\"SUCCEED\",\nerrorCode:\"No_Error\",\ndata:{\n     id:1，\n     systemId:1，\n     areaId:110101,\n     positionX:123.1234567890,\n     positionY:123.1234567890,\n     name:\"name\",\n     describes:\"describes\",\n     system:{\n         id:1,\n         name:\"name\",\n         pic:\"WIN-INF/pic/a.jpg\",\n         describes:\"describes\"\n\n     }\n     room(List):{\n         id:1,\n         locationId:1,\n         name:\"name\",\n         describes:\"describes\"\n     }\n}\ntoken:\"SK1d7a4fe3-c2cd-417f-8f6f-bf7412592996\",\nnumberPerPage:0,\ncurrentPage:0,\ntotalNumber:0,\ntotalPage:0\n }",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "Error-Response:",
          "content": " HTTP/1.1 200 OK\n{\ncallStatus:\"FAILED\",\nerrorCode:\"Error\",\ndata:null,\ntoken:null,\nnumberPerPage:0,\ncurrentPage:0,\ntotalNumber:0,\ntotalPage:0\n }",
          "type": "json"
        }
      ]
    },
    "filename": "D:/desktop/Program/ApiDoc/source/LocationApi.java",
    "groupTitle": "location"
  },
  {
    "type": "post",
    "url": "http://localhost:8080/iws/api/location/query",
    "title": "查询地点",
    "name": "query",
    "group": "location",
    "version": "0.1.0",
    "description": "<p>条件查询,获取条件下全部地点。province,city,area中，查询优先级为area,city,province</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "systemId",
            "description": "<p>系统id</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "provinceId",
            "description": "<p>省份id</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "cityId",
            "description": "<p>城市id</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "areaId",
            "description": "<p>城区id</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "token",
            "description": "<p>身份验证</p>"
          }
        ]
      }
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": " HTTP/1.1 200 OK\n{\ncallStatus:\"SUCCEED\",\nerrorCode:\"No_Error\",\ndata(List):{\n     id:1，\n     systemId:1，\n     areaId:110101,\n     positionX:123.1234567890,\n     positionY:123.1234567890,\n     name:\"name\",\n     describes:\"describes\"\n}\ntoken:\"SK1d7a4fe3-c2cd-417f-8f6f-bf7412592996\",\nnumberPerPage:0,\ncurrentPage:0,\ntotalNumber:0,\ntotalPage:0\n }",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "Error-Response:",
          "content": " HTTP/1.1 200 OK\n{\ncallStatus:\"FAILED\",\nerrorCode:\"Error\",\ndata:null,\ntoken:null,\nnumberPerPage:0,\ncurrentPage:0,\ntotalNumber:0,\ntotalPage:0\n }",
          "type": "json"
        }
      ]
    },
    "filename": "D:/desktop/Program/ApiDoc/source/LocationApi.java",
    "groupTitle": "location"
  },
  {
    "type": "post",
    "url": "http://localhost:8080/iws/api/location/update",
    "title": "编辑地点",
    "name": "update",
    "group": "location",
    "version": "0.1.0",
    "description": "<p>编辑修改系统，更改系统状态</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "id",
            "description": "<p>地点id</p>"
          },
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "systemId",
            "description": "<p>系统id</p>"
          },
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "areaId",
            "description": "<p>地点所属区域编号，标识到城区</p>"
          },
          {
            "group": "Parameter",
            "type": "double",
            "optional": false,
            "field": "positionX",
            "description": "<p>地点经度坐标</p>"
          },
          {
            "group": "Parameter",
            "type": "double",
            "optional": false,
            "field": "positionY",
            "description": "<p>地点维度坐标</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "name",
            "description": "<p>地点名称</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "describes",
            "description": "<p>地点描述</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "token",
            "description": "<p>身份验证</p>"
          }
        ]
      }
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": " HTTP/1.1 200 OK\n{\ncallStatus:\"SUCCEED\",\nerrorCode:\"No_Error\",\ndata:null,\ntoken:\"SK1d7a4fe3-c2cd-417f-8f6f-bf7412592996\",\nnumberPerPage:0,\ncurrentPage:0,\ntotalNumber:0,\ntotalPage:0\n }",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "Error-Response:",
          "content": " HTTP/1.1 200 OK\n{\ncallStatus:\"FAILED\",\nerrorCode:\"Error\",\ndata:null,\ntoken:null,\nnumberPerPage:0,\ncurrentPage:0,\ntotalNumber:0,\ntotalPage:0\n }",
          "type": "json"
        }
      ]
    },
    "filename": "D:/desktop/Program/ApiDoc/source/LocationApi.java",
    "groupTitle": "location"
  },
  {
    "type": "post",
    "url": "http://localhost:8080/iws/api/role/add",
    "title": "添加角色",
    "name": "add",
    "group": "role",
    "version": "0.1.0",
    "description": "<p>注册添加新角色</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "long",
            "optional": false,
            "field": "roleId",
            "description": "<p>角色id</p>"
          },
          {
            "group": "Parameter",
            "type": "int[]",
            "optional": false,
            "field": "systemId",
            "description": "<p>系统id</p>"
          },
          {
            "group": "Parameter",
            "type": "int[]",
            "optional": false,
            "field": "provinceId",
            "description": "<p>省份id</p>"
          },
          {
            "group": "Parameter",
            "type": "int[]",
            "optional": false,
            "field": "cityId",
            "description": "<p>城市id</p>"
          },
          {
            "group": "Parameter",
            "type": "int[]",
            "optional": false,
            "field": "areaId",
            "description": "<p>城区id</p>"
          },
          {
            "group": "Parameter",
            "type": "int[]",
            "optional": false,
            "field": "limitation",
            "description": "<p>操作权限</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "name",
            "description": "<p>角色名称</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "describes",
            "description": "<p>角色描述</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "token",
            "description": "<p>身份验证</p>"
          }
        ]
      }
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": " HTTP/1.1 200 OK\n{\ncallStatus:\"SUCCEED\",\nerrorCode:\"No_Error\",\ndata:null,\ntoken:\"SK1d7a4fe3-c2cd-417f-8f6f-bf7412592996\",\nnumberPerPage:0,\ncurrentPage:0,\ntotalNumber:0,\ntotalPage:0\n }",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "Error-Response:",
          "content": " HTTP/1.1 200 OK\n{\ncallStatus:\"FAILED\",\nerrorCode:\"Error\",\ndata:null,\ntoken:null,\nnumberPerPage:0,\ncurrentPage:0,\ntotalNumber:0,\ntotalPage:0\n }",
          "type": "json"
        }
      ]
    },
    "filename": "D:/desktop/Program/ApiDoc/source/RoleApi.java",
    "groupTitle": "role"
  },
  {
    "type": "post",
    "url": "http://localhost:8080/iws/api/role/delete",
    "title": "删除角色",
    "name": "delete",
    "group": "role",
    "version": "0.1.0",
    "description": "<p>删除角色</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "roleId",
            "description": "<p>角色id</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "token",
            "description": "<p>身份验证</p>"
          }
        ]
      }
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": " HTTP/1.1 200 OK\n{\ncallStatus:\"SUCCEED\",\nerrorCode:\"No_Error\",\ndata:null,\ntoken:\"SK1d7a4fe3-c2cd-417f-8f6f-bf7412592996\",\nnumberPerPage:0,\ncurrentPage:0,\ntotalNumber:0,\ntotalPage:0\n }",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "Error-Response:",
          "content": " HTTP/1.1 200 OK\n{\ncallStatus:\"FAILED\",\nerrorCode:\"Error\",\ndata:null,\ntoken:null,\nnumberPerPage:0,\ncurrentPage:0,\ntotalNumber:0,\ntotalPage:0\n }",
          "type": "json"
        }
      ]
    },
    "filename": "D:/desktop/Program/ApiDoc/source/RoleApi.java",
    "groupTitle": "role"
  },
  {
    "type": "post",
    "url": "http://localhost:8080/iws/api/role/detail",
    "title": "查看角色",
    "name": "detail",
    "group": "role",
    "version": "0.1.0",
    "description": "<p>查看角色详情</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "roleId",
            "description": "<p>角色id</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "token",
            "description": "<p>身份验证</p>"
          }
        ]
      }
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": " HTTP/1.1 200 OK\n{\ncallStatus:\"SUCCEED\",\nerrorCode:\"No_Error\",\ndata:{\n    roleId:20170101123030,\n    name:\"name\",\n    role(List):{\n        id:1,\n        roleId:20170101123030,\n        systemId:1,\n        provinceId:110000,\n        cityId:110100,\n        areaId:0,\n        limitation:1,\n        name:\"name\",\n        describes:\"describes\"\n    }\n}\ntoken:\"SK1d7a4fe3-c2cd-417f-8f6f-bf7412592996\",\nnumberPerPage:0,\ncurrentPage:0,\ntotalNumber:0,\ntotalPage:0\n }",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "Error-Response:",
          "content": " HTTP/1.1 200 OK\n{\ncallStatus:\"FAILED\",\nerrorCode:\"Error\",\ndata:null,\ntoken:null,\nnumberPerPage:0,\ncurrentPage:0,\ntotalNumber:0,\ntotalPage:0\n }",
          "type": "json"
        }
      ]
    },
    "filename": "D:/desktop/Program/ApiDoc/source/RoleApi.java",
    "groupTitle": "role"
  },
  {
    "type": "post",
    "url": "http://localhost:8080/iws/api/role/list",
    "title": "角色列表",
    "name": "list",
    "group": "role",
    "version": "0.1.0",
    "description": "<p>查看角色详情</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "token",
            "description": "<p>身份验证</p>"
          }
        ]
      }
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": " HTTP/1.1 200 OK\n{\ncallStatus:\"SUCCEED\",\nerrorCode:\"No_Error\",\ndata(List):{\n    roleId:20170101123030,\n    name:\"name\",\n    role(List):{\n        id:1,\n        roleId:20170101123030,\n        systemId:1,\n        provinceId:110000,\n        cityId:110100,\n        areaId:0,\n        limitation:1,\n        name:\"name\",\n        describes:\"describes\"\n    }\n}\ntoken:\"SK1d7a4fe3-c2cd-417f-8f6f-bf7412592996\",\nnumberPerPage:0,\ncurrentPage:0,\ntotalNumber:0,\ntotalPage:0\n }",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "Error-Response:",
          "content": " HTTP/1.1 200 OK\n{\ncallStatus:\"FAILED\",\nerrorCode:\"Error\",\ndata:null,\ntoken:null,\nnumberPerPage:0,\ncurrentPage:0,\ntotalNumber:0,\ntotalPage:0\n }",
          "type": "json"
        }
      ]
    },
    "filename": "D:/desktop/Program/ApiDoc/source/RoleApi.java",
    "groupTitle": "role"
  },
  {
    "type": "post",
    "url": "http://localhost:8080/iws/api/role/query",
    "title": "查询角色",
    "name": "query",
    "group": "role",
    "version": "0.1.0",
    "description": "<p>按条件查询角色</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "systemId",
            "description": "<p>系统id</p>"
          },
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "provinceId",
            "description": "<p>省份id</p>"
          },
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "cityId",
            "description": "<p>城市id</p>"
          },
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "areaId",
            "description": "<p>城区id</p>"
          },
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "limitation",
            "description": "<p>操作权限</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "name",
            "description": "<p>角色名称</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "token",
            "description": "<p>身份验证</p>"
          }
        ]
      }
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": " HTTP/1.1 200 OK\n{\ncallStatus:\"SUCCEED\",\nerrorCode:\"No_Error\",\ndata(List):{\n    roleId:20170101123030,\n    name:\"name\",\n    role(List):{\n        id:1,\n        roleId:20170101123030,\n        systemId:1,\n        provinceId:110000,\n        cityId:110100,\n        areaId:0,\n        limitation:1,\n        name:\"name\",\n        describes:\"describes\"\n    }\n}\ntoken:\"SK1d7a4fe3-c2cd-417f-8f6f-bf7412592996\",\nnumberPerPage:0,\ncurrentPage:0,\ntotalNumber:0,\ntotalPage:0\n }",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "Error-Response:",
          "content": " HTTP/1.1 200 OK\n{\ncallStatus:\"FAILED\",\nerrorCode:\"Error\",\ndata:null,\ntoken:null,\nnumberPerPage:0,\ncurrentPage:0,\ntotalNumber:0,\ntotalPage:0\n }",
          "type": "json"
        }
      ]
    },
    "filename": "D:/desktop/Program/ApiDoc/source/RoleApi.java",
    "groupTitle": "role"
  },
  {
    "type": "post",
    "url": "http://localhost:8080/iws/api/role/update",
    "title": "编辑角色",
    "name": "update",
    "group": "role",
    "version": "0.1.0",
    "description": "<p>编辑修改角色</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "long",
            "optional": false,
            "field": "roleId",
            "description": "<p>角色id</p>"
          },
          {
            "group": "Parameter",
            "type": "int[]",
            "optional": false,
            "field": "systemId",
            "description": "<p>系统id</p>"
          },
          {
            "group": "Parameter",
            "type": "int[]",
            "optional": false,
            "field": "provinceId",
            "description": "<p>省份id</p>"
          },
          {
            "group": "Parameter",
            "type": "int[]",
            "optional": false,
            "field": "cityId",
            "description": "<p>城市id</p>"
          },
          {
            "group": "Parameter",
            "type": "int[]",
            "optional": false,
            "field": "areaId",
            "description": "<p>城区id</p>"
          },
          {
            "group": "Parameter",
            "type": "int[]",
            "optional": false,
            "field": "limitation",
            "description": "<p>操作权限</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "name",
            "description": "<p>角色名称</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "describes",
            "description": "<p>角色描述</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "token",
            "description": "<p>身份验证</p>"
          }
        ]
      }
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": " HTTP/1.1 200 OK\n{\ncallStatus:\"SUCCEED\",\nerrorCode:\"No_Error\",\ndata:null,\ntoken:\"SK1d7a4fe3-c2cd-417f-8f6f-bf7412592996\",\nnumberPerPage:0,\ncurrentPage:0,\ntotalNumber:0,\ntotalPage:0\n }",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "Error-Response:",
          "content": " HTTP/1.1 200 OK\n{\ncallStatus:\"FAILED\",\nerrorCode:\"Error\",\ndata:null,\ntoken:null,\nnumberPerPage:0,\ncurrentPage:0,\ntotalNumber:0,\ntotalPage:0\n }",
          "type": "json"
        }
      ]
    },
    "filename": "D:/desktop/Program/ApiDoc/source/RoleApi.java",
    "groupTitle": "role"
  },
  {
    "type": "post",
    "url": "http://localhost:8080/iws/api/room/add",
    "title": "添加泵房",
    "name": "add",
    "group": "room",
    "version": "0.1.0",
    "description": "<p>注册添加新泵房</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "locationId",
            "description": "<p>泵房所属区域地点id</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "name",
            "description": "<p>泵房名称</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "describes",
            "description": "<p>泵房描述</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "token",
            "description": "<p>身份验证</p>"
          }
        ]
      }
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": " HTTP/1.1 200 OK\n{\ncallStatus:\"SUCCEED\",\nerrorCode:\"No_Error\",\ndata:null,\ntoken:\"SK1d7a4fe3-c2cd-417f-8f6f-bf7412592996\",\nnumberPerPage:0,\ncurrentPage:0,\ntotalNumber:0,\ntotalPage:0\n }",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "Error-Response:",
          "content": " HTTP/1.1 200 OK\n{\ncallStatus:\"FAILED\",\nerrorCode:\"Error\",\ndata:null,\ntoken:null,\nnumberPerPage:0,\ncurrentPage:0,\ntotalNumber:0,\ntotalPage:0\n}",
          "type": "json"
        }
      ]
    },
    "filename": "D:/desktop/Program/ApiDoc/source/RoomApi.java",
    "groupTitle": "room"
  },
  {
    "type": "post",
    "url": "http://localhost:8080/iws/api/room/delete",
    "title": "删除泵房",
    "name": "delete",
    "group": "room",
    "version": "0.1.0",
    "description": "<p>删除泵房</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "id",
            "description": "<p>泵房id</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "token",
            "description": "<p>身份验证</p>"
          }
        ]
      }
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": " HTTP/1.1 200 OK\n{\ncallStatus:\"SUCCEED\",\nerrorCode:\"No_Error\",\ndata:null,\ntoken:\"SK1d7a4fe3-c2cd-417f-8f6f-bf7412592996\",\nnumberPerPage:0,\ncurrentPage:0,\ntotalNumber:0,\ntotalPage:0\n }",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "Error-Response:",
          "content": " HTTP/1.1 200 OK\n{\ncallStatus:\"FAILED\",\nerrorCode:\"Error\",\ndata:null,\ntoken:null,\nnumberPerPage:0,\ncurrentPage:0,\ntotalNumber:0,\ntotalPage:0\n }",
          "type": "json"
        }
      ]
    },
    "filename": "D:/desktop/Program/ApiDoc/source/RoomApi.java",
    "groupTitle": "room"
  },
  {
    "type": "post",
    "url": "http://localhost:8080/iws/api/room/detail",
    "title": "查看泵房",
    "name": "detail",
    "group": "room",
    "version": "0.1.0",
    "description": "<p>获取某一泵房及泵房所属地点、泵房内所有控制器</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "id",
            "description": "<p>泵房id</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "token",
            "description": "<p>身份验证</p>"
          }
        ]
      }
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": " HTTP/1.1 200 OK\n{\ncallStatus:\"SUCCEED\",\nerrorCode:\"No_Error\",\ndata:{\n     id:1,\n     locationId:1,\n     name:\"name\",\n     describes:\"describes\"\n     location:{\n         id:1，\n         systemId:1，\n         areaId:110101,\n         positionX:123.1234567890,\n         positionY:123.123456,\n         name:\"name\",\n         describes:\"describes\",\n     }\n     equipment(List):{\n         id:1,\n         roomId:1,\n         equipmentType:\"equipmenttype000\",\n         parameterId:\"1\",\n         com:\"com1\",\n         num:1,\n         name:\"name\",\n         describes:\"describes\"\n     }\n\n}\ntoken:\"SK1d7a4fe3-c2cd-417f-8f6f-bf7412592996\",\nnumberPerPage:0,\ncurrentPage:0,\ntotalNumber:0,\ntotalPage:0\n }",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "Error-Response:",
          "content": " HTTP/1.1 200 OK\n{\ncallStatus:\"FAILED\",\nerrorCode:\"Error\",\ndata:null,\ntoken:null,\nnumberPerPage:0,\ncurrentPage:0,\ntotalNumber:0,\ntotalPage:0\n }",
          "type": "json"
        }
      ]
    },
    "filename": "D:/desktop/Program/ApiDoc/source/RoomApi.java",
    "groupTitle": "room"
  },
  {
    "type": "post",
    "url": "http://localhost:8080/iws/api/room/update",
    "title": "编辑泵房",
    "name": "update",
    "group": "room",
    "version": "0.1.0",
    "description": "<p>编辑修改系统，更改系统状态</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "id",
            "description": "<p>泵房id</p>"
          },
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "locationId",
            "description": "<p>泵房所属区域地点id</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "name",
            "description": "<p>泵房名称</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "describes",
            "description": "<p>泵房描述</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "token",
            "description": "<p>身份验证</p>"
          }
        ]
      }
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": " HTTP/1.1 200 OK\n{\ncallStatus:\"SUCCEED\",\nerrorCode:\"No_Error\",\ndata:null,\ntoken:\"SK1d7a4fe3-c2cd-417f-8f6f-bf7412592996\",\nnumberPerPage:0,\ncurrentPage:0,\ntotalNumber:0,\ntotalPage:0\n }",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "Error-Response:",
          "content": " HTTP/1.1 200 OK\n{\ncallStatus:\"FAILED\",\nerrorCode:\"Error\",\ndata:null,\ntoken:null,\nnumberPerPage:0,\ncurrentPage:0,\ntotalNumber:0,\ntotalPage:0\n }",
          "type": "json"
        }
      ]
    },
    "filename": "D:/desktop/Program/ApiDoc/source/RoomApi.java",
    "groupTitle": "room"
  },
  {
    "type": "post",
    "url": "http://localhost:8080/iws/api/system/add",
    "title": "添加系统",
    "name": "add",
    "group": "system",
    "version": "0.1.0",
    "description": "<p>注册添加新系统</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "name",
            "description": "<p>系统名称</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "pic",
            "description": "<p>图片</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "describes",
            "description": "<p>系统描述</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "token",
            "description": "<p>身份验证</p>"
          }
        ]
      }
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": " HTTP/1.1 200 OK\n{\ncallStatus:\"SUCCEED\",\nerrorCode:\"No_Error\",\ndata:null,\ntoken:\"SK1d7a4fe3-c2cd-417f-8f6f-bf7412592996\",\nnumberPerPage:0,\ncurrentPage:0,\ntotalNumber:0,\ntotalPage:0\n }",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "Error-Response:",
          "content": " HTTP/1.1 200 OK\n{\ncallStatus:\"FAILED\",\nerrorCode:\"Error\",\ndata:null,\ntoken:null,\nnumberPerPage:0,\ncurrentPage:0,\ntotalNumber:0,\ntotalPage:0\n }",
          "type": "json"
        }
      ]
    },
    "filename": "D:/desktop/Program/ApiDoc/source/SystemApi.java",
    "groupTitle": "system"
  },
  {
    "type": "post",
    "url": "http://localhost:8080/iws/api/system/delete",
    "title": "删除系统",
    "name": "delete",
    "group": "system",
    "version": "0.1.0",
    "description": "<p>删除系统</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "id",
            "description": "<p>系统id</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "token",
            "description": "<p>身份验证</p>"
          }
        ]
      }
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": " HTTP/1.1 200 OK\n{\ncallStatus:\"SUCCEED\",\nerrorCode:\"No_Error\",\ndata:null,\ntoken:\"SK1d7a4fe3-c2cd-417f-8f6f-bf7412592996\",\nnumberPerPage:0,\ncurrentPage:0,\ntotalNumber:0,\ntotalPage:0\n }",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "Error-Response:",
          "content": " HTTP/1.1 200 OK\n{\ncallStatus:\"FAILED\",\nerrorCode:\"Error\",\ndata:null,\ntoken:null,\nnumberPerPage:0,\ncurrentPage:0,\ntotalNumber:0,\ntotalPage:0\n }",
          "type": "json"
        }
      ]
    },
    "filename": "D:/desktop/Program/ApiDoc/source/SystemApi.java",
    "groupTitle": "system"
  },
  {
    "type": "post",
    "url": "http://localhost:8080/iws/api/system/detail",
    "title": "查看系统",
    "name": "detail",
    "group": "system",
    "version": "0.1.0",
    "description": "<p>获取某一系统及系统下全部地点</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "id",
            "description": "<p>系统id</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "token",
            "description": "<p>身份验证</p>"
          }
        ]
      }
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": " HTTP/1.1 200 OK\n{\ncallStatus:\"SUCCEED\",\nerrorCode:\"No_Error\",\ndata:{\n    id:1\n    name:\"name\"\n    pic:\"WIN-INF/pic/a.jpg\"\n    describes:\"describes\"\n\n    location(List):{\n        id:1\n        systemId:1\n        areaId:110101\n        positionX:123.1234567890\n        positionY:123.1234567890\n        name:\"name\"\n        describes:\"describes\"\n    }\n}\ntoken:\"SK1d7a4fe3-c2cd-417f-8f6f-bf7412592996\",\nnumberPerPage:0,\ncurrentPage:0,\ntotalNumber:0,\ntotalPage:0\n }",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "Error-Response:",
          "content": " HTTP/1.1 200 OK\n{\ncallStatus:\"FAILED\",\nerrorCode:\"Error\",\ndata:null,\ntoken:null,\nnumberPerPage:0,\ncurrentPage:0,\ntotalNumber:0,\ntotalPage:0\n }",
          "type": "json"
        }
      ]
    },
    "filename": "D:/desktop/Program/ApiDoc/source/SystemApi.java",
    "groupTitle": "system"
  },
  {
    "type": "post",
    "url": "http://localhost:8080/iws/api/system/list",
    "title": "系统列表",
    "name": "list",
    "group": "system",
    "version": "0.1.0",
    "description": "<p>获取全部系统及系统下全部地点</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "token",
            "description": "<p>身份验证</p>"
          }
        ]
      }
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": " HTTP/1.1 200 OK\n{\ncallStatus:\"SUCCEED\",\nerrorCode:\"No_Error\",\ndata(List):{\n    id:1\n    name:\"name\"\n    pic:\"WIN-INF/pic/a.jpg\"\n    describes:\"describes\"\n\n    location(List):{\n        id:1\n        systemId:1\n        areaId:110101\n        positionX:123.1234567890\n        positionY:123.1234567890\n        name:\"name\"\n        describes:\"describes\"\n    }\n}\ntoken:\"SK1d7a4fe3-c2cd-417f-8f6f-bf7412592996\",\nnumberPerPage:0,\ncurrentPage:0,\ntotalNumber:0,\ntotalPage:0\n }",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "Error-Response:",
          "content": " HTTP/1.1 200 OK\n{\ncallStatus:\"FAILED\",\nerrorCode:\"Error\",\ndata:null,\ntoken:null,\nnumberPerPage:0,\ncurrentPage:0,\ntotalNumber:0,\ntotalPage:0\n }",
          "type": "json"
        }
      ]
    },
    "filename": "D:/desktop/Program/ApiDoc/source/SystemApi.java",
    "groupTitle": "system"
  },
  {
    "type": "post",
    "url": "http://localhost:8080/iws/api/system/update",
    "title": "编辑系统",
    "name": "update",
    "group": "system",
    "version": "0.1.0",
    "description": "<p>编辑修改系统，更改系统状态</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "id",
            "description": "<p>系统id</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "pic",
            "description": "<p>图片</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "name",
            "description": "<p>系统名称</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "describes",
            "description": "<p>系统描述</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "token",
            "description": "<p>身份验证</p>"
          }
        ]
      }
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": " HTTP/1.1 200 OK\n{\ncallStatus:\"SUCCEED\",\nerrorCode:\"No_Error\",\ndata:null,\ntoken:\"SK1d7a4fe3-c2cd-417f-8f6f-bf7412592996\",\nnumberPerPage:0,\ncurrentPage:0,\ntotalNumber:0,\ntotalPage:0\n }",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "Error-Response:",
          "content": " HTTP/1.1 200 OK\n{\ncallStatus:\"FAILED\",\nerrorCode:\"Error\",\ndata:null,\ntoken:null,\nnumberPerPage:0,\ncurrentPage:0,\ntotalNumber:0,\ntotalPage:0\n }",
          "type": "json"
        }
      ]
    },
    "filename": "D:/desktop/Program/ApiDoc/source/SystemApi.java",
    "groupTitle": "system"
  },
  {
    "type": "post",
    "url": "http://localhost:8080/iws/api/user/changePwd",
    "title": "修改密码",
    "name": "changePwd",
    "group": "user",
    "version": "0.1.0",
    "description": "<p>修改当前用户密码</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "oldPwd",
            "description": "<p>原始密码</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "newPwd",
            "description": "<p>新密码</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "token",
            "description": "<p>身份验证</p>"
          }
        ]
      }
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": " HTTP/1.1 200 OK\n{\ncallStatus:\"SUCCEED\",\nerrorCode:\"No_Error\",\ndata:null,\ntoken:\"SK1d7a4fe3-c2cd-417f-8f6f-bf7412592996\",\nnumberPerPage:0,\ncurrentPage:0,\ntotalNumber:0,\ntotalPage:0\n }",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "Error-Response:",
          "content": " HTTP/1.1 200 OK\n{\ncallStatus:\"FAILED\",\nerrorCode:\"Error\",\ndata:null,\ntoken:null,\nnumberPerPage:0,\ncurrentPage:0,\ntotalNumber:0,\ntotalPage:0\n }",
          "type": "json"
        }
      ]
    },
    "filename": "D:/desktop/Program/ApiDoc/source/UserApi.java",
    "groupTitle": "user"
  },
  {
    "type": "post",
    "url": "http://localhost:8080/iws/api/user/detail",
    "title": "用户详情",
    "name": "detail",
    "group": "user",
    "version": "0.1.0",
    "description": "<p>获取当前用户详情</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "token",
            "description": "<p>身份验证</p>"
          }
        ]
      }
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": " HTTP/1.1 200 OK\n{\ncallStatus:\"SUCCEED\",\nerrorCode:\"No_Error\",\ndata:{\n    id:1,\n    username:18712345678,\n    password:\"d1b2cc725d846f0460ff290c60925070\",\n    roleid:\"RL1d7a4fe3-c2cd-417f-8f6f-bf7412592996\",\n    status:1,\n    date:2017-01-01 12:00:00,\n    name:\"name\",\n    describes:\"describes\",\n    }\n}\ntoken:\"SK1d7a4fe3-c2cd-417f-8f6f-bf7412592996\",\nnumberPerPage:0,\ncurrentPage:0,\ntotalNumber:0,\ntotalPage:0\n }",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "Error-Response:",
          "content": " HTTP/1.1 200 OK\n{\ncallStatus:\"FAILED\",\nerrorCode:\"Error\",\ndata:null,\ntoken:null,\nnumberPerPage:0,\ncurrentPage:0,\ntotalNumber:0,\ntotalPage:0\n }",
          "type": "json"
        }
      ]
    },
    "filename": "D:/desktop/Program/ApiDoc/source/UserApi.java",
    "groupTitle": "user"
  },
  {
    "type": "post",
    "url": "http://localhost:8080/iws/api/user/forgetPwd",
    "title": "忘记密码",
    "name": "forgetPwd",
    "group": "user",
    "version": "0.1.0",
    "description": "<p>重置当前用户密码</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "username",
            "description": "<p>用户名</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "password",
            "description": "<p>新密码</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "code",
            "description": "<p>短信验证码</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "token",
            "description": "<p>身份验证</p>"
          }
        ]
      }
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": " HTTP/1.1 200 OK\n{\ncallStatus:\"SUCCEED\",\nerrorCode:\"No_Error\",\ndata:null,\ntoken:\"SK1d7a4fe3-c2cd-417f-8f6f-bf7412592996\",\nnumberPerPage:0,\ncurrentPage:0,\ntotalNumber:0,\ntotalPage:0\n }",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "Error-Response:",
          "content": " HTTP/1.1 200 OK\n{\ncallStatus:\"FAILED\",\nerrorCode:\"Error\",\ndata:null,\ntoken:null,\nnumberPerPage:0,\ncurrentPage:0,\ntotalNumber:0,\ntotalPage:0\n }",
          "type": "json"
        }
      ]
    },
    "filename": "D:/desktop/Program/ApiDoc/source/UserApi.java",
    "groupTitle": "user"
  },
  {
    "type": "post",
    "url": "http://localhost:8080/iws/api/user/getVerifyCode",
    "title": "获取验证码",
    "name": "getVerifyCode",
    "group": "user",
    "version": "0.1.0",
    "description": "<p>获取验证码</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "username",
            "description": "<p>用户名,须为11位手机号码</p>"
          }
        ]
      }
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": " HTTP/1.1 200 OK\n{\ncallStatus:\"SUCCEED\",\nerrorCode:\"No_Error\",\ndata:null,\ntoken:\"SK1d7a4fe3-c2cd-417f-8f6f-bf7412592996\",\nnumberPerPage:0,\ncurrentPage:0,\ntotalNumber:0,\ntotalPage:0\n }",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "Error-Response:",
          "content": " HTTP/1.1 200 OK\n{\ncallStatus:\"FAILED\",\nerrorCode:\"Error\",\ndata:null,\ntoken:null,\nnumberPerPage:0,\ncurrentPage:0,\ntotalNumber:0,\ntotalPage:0\n }",
          "type": "json"
        }
      ]
    },
    "filename": "D:/desktop/Program/ApiDoc/source/UserApi.java",
    "groupTitle": "user"
  },
  {
    "type": "post",
    "url": "http://localhost:8080/iws/api/user/login",
    "title": "用户登录",
    "name": "login",
    "group": "user",
    "version": "0.1.0",
    "description": "<p>用户登录</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "username",
            "description": "<p>用户名</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "password",
            "description": "<p>密码</p>"
          }
        ]
      }
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": " HTTP/1.1 200 OK\n{\ncallStatus:\"SUCCEED\",\nerrorCode:\"No_Error\",\ndata:{\n    id:1,\n    username:18712345678,\n    password:\"d1b2cc725d846f0460ff290c60925070\",\n    roleid:\"RL1d7a4fe3-c2cd-417f-8f6f-bf7412592996\",\n    status:1,\n    date:2017-01-01 12:00:00,\n    name:\"name\",\n    describes:\"describes\",\n}\ntoken:\"SK1d7a4fe3-c2cd-417f-8f6f-bf7412592996\",\nnumberPerPage:0,\ncurrentPage:0,\ntotalNumber:0,\ntotalPage:0\n }",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "Error-Response:",
          "content": " HTTP/1.1 200 OK\n{\ncallStatus:\"FAILED\",\nerrorCode:\"Error\",\ndata:null,\ntoken:null,\nnumberPerPage:0,\ncurrentPage:0,\ntotalNumber:0,\ntotalPage:0\n }",
          "type": "json"
        }
      ]
    },
    "filename": "D:/desktop/Program/ApiDoc/source/UserApi.java",
    "groupTitle": "user"
  },
  {
    "type": "post",
    "url": "http://localhost:8080/iws/api/user/reLogin",
    "title": "退出登录",
    "name": "reLogin",
    "group": "user",
    "version": "0.1.0",
    "description": "<p>退出登录</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "token",
            "description": "<p>身份验证</p>"
          }
        ]
      }
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": " HTTP/1.1 200 OK\n{\ncallStatus:\"SUCCEED\",\nerrorCode:\"No_Error\",\ndata:null,\ntoken:\"SK1d7a4fe3-c2cd-417f-8f6f-bf7412592996\",\nnumberPerPage:0,\ncurrentPage:0,\ntotalNumber:0,\ntotalPage:0\n }",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "Error-Response:",
          "content": " HTTP/1.1 200 OK\n{\ncallStatus:\"FAILED\",\nerrorCode:\"Error\",\ndata:null,\ntoken:null,\nnumberPerPage:0,\ncurrentPage:0,\ntotalNumber:0,\ntotalPage:0\n }",
          "type": "json"
        }
      ]
    },
    "filename": "D:/desktop/Program/ApiDoc/source/UserApi.java",
    "groupTitle": "user"
  },
  {
    "type": "post",
    "url": "http://localhost:8080/iws/api/user/register",
    "title": "注册用户",
    "name": "register",
    "group": "user",
    "version": "0.1.0",
    "description": "<p>注册新用户</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "username",
            "description": "<p>用户名</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "password",
            "description": "<p>密码</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "code",
            "description": "<p>短信验证码</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "name",
            "description": "<p>昵称 nullable</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "describes",
            "description": "<p>用户描述 nullable</p>"
          }
        ]
      }
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": " HTTP/1.1 200 OK\n{\ncallStatus:\"SUCCEED\",\nerrorCode:\"No_Error\",\ndata:{\n    username:18712345678,\n    password:\"d1b2cc725d846f0460ff290c60925070\",\n    name:\"name\",\n    describes:\"describes\",\n}\ntoken:\"SK1d7a4fe3-c2cd-417f-8f6f-bf7412592996\",\nnumberPerPage:0,\ncurrentPage:0,\ntotalNumber:0,\ntotalPage:0\n }",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "Error-Response:",
          "content": " HTTP/1.1 200 OK\n{\ncallStatus:\"FAILED\",\nerrorCode:\"Error\",\ndata:null,\ntoken:null,\nnumberPerPage:0,\ncurrentPage:0,\ntotalNumber:0,\ntotalPage:0\n }",
          "type": "json"
        }
      ]
    },
    "filename": "D:/desktop/Program/ApiDoc/source/UserApi.java",
    "groupTitle": "user"
  },
  {
    "type": "post",
    "url": "http://localhost:8080/iws/api/user/update",
    "title": "编辑用户",
    "name": "update",
    "group": "user",
    "version": "0.1.0",
    "description": "<p>编辑修改用户昵称 描述 头像</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "name",
            "description": "<p>用户名称</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "describes",
            "description": "<p>用户描述</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "pic",
            "description": "<p>图片</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "token",
            "description": "<p>身份验证</p>"
          }
        ]
      }
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": " HTTP/1.1 200 OK\n{\ncallStatus:\"SUCCEED\",\nerrorCode:\"No_Error\",\ndata:{\n    id:1,\n    username:18712345678,\n    password:\"d1b2cc725d846f0460ff290c60925070\",\n    roleid:\"RL1d7a4fe3-c2cd-417f-8f6f-bf7412592996\",\n    status:1,\n    date:2017-01-01 12:00:00,\n    name:\"name\",\n    describes:\"describes\",\n}\ntoken:\"SK1d7a4fe3-c2cd-417f-8f6f-bf7412592996\",\nnumberPerPage:0,\ncurrentPage:0,\ntotalNumber:0,\ntotalPage:0\n }",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "Error-Response:",
          "content": " HTTP/1.1 200 OK\n{\ncallStatus:\"FAILED\",\nerrorCode:\"Error\",\ndata:null,\ntoken:null,\nnumberPerPage:0,\ncurrentPage:0,\ntotalNumber:0,\ntotalPage:0\n }",
          "type": "json"
        }
      ]
    },
    "filename": "D:/desktop/Program/ApiDoc/source/UserApi.java",
    "groupTitle": "user"
  }
] });
