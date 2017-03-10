/**
 * Created by XiaoJiang01 on 2017/2/23.
 */
public interface LocationApi {
    /**
     *
     * @api {post} http://localhost:8080/IWS-Server/api/location/add 添加地点
     * @apiName add
     * @apiGroup location
     * @apiVersion 0.1.0
     * @apiDescription 注册添加新地点
     *
     * @apiParam {String} name 地点名称
     * @apiParam {String} positionX 地点经度坐标
     * @apiParam {String} positionY 地点维度坐标
     * @apiParam {String} positionId 地点所属区域编号，标识到城区
     * @apiParam {String} systemId 系统名称
     * @apiParam {String} blockName 地点下级名称
     * @apiParam {String} token 身份验证
     *
     * @apiSuccessExample Success-Response:
     *  HTTP/1.1 200 OK
     * {
     * callStatus:"SUCCEED",
     * errorCode:"No_Error",
     * data:null,
     * token:"SK1d7a4fe3-c2cd-417f-8f6f-bf7412592996",
     * numberPerPage:0,
     * currentPage:0,
     * totalNumber:0,
     * totalPage:0
     *  }
     *
     *  @apiErrorExample {json} Error-Response:
     *  HTTP/1.1 200 OK
     * {
     * callStatus:"FAILED",
     * errorCode:"Error",
     * data:null,
     * token:null,
     * numberPerPage:0,
     * currentPage:0,
     * totalNumber:0,
     * totalPage:0
     *  }
     *
     */

    /**
     *
     * @api {post} http://localhost:8080/IWS-Server/api/location/update 编辑地点
     * @apiName update
     * @apiGroup location
     * @apiVersion 0.1.0
     * @apiDescription 编辑修改系统，更改系统状态
     *
     * @apiParam {String} positionId 地点id
     * @apiParam {String} name 地点名称
     * @apiParam {String} blockName 地点下级名称
     * @apiParam {String} token 身份验证
     *
     * @apiSuccessExample Success-Response:
     *  HTTP/1.1 200 OK
     * {
     * callStatus:"SUCCEED",
     * errorCode:"No_Error",
     * data:null,
     * token:"SK1d7a4fe3-c2cd-417f-8f6f-bf7412592996",
     * numberPerPage:0,
     * currentPage:0,
     * totalNumber:0,
     * totalPage:0
     *  }
     *
     *  @apiErrorExample {json} Error-Response:
     *  HTTP/1.1 200 OK
     * {
     * callStatus:"FAILED",
     * errorCode:"Error",
     * data:null,
     * token:null,
     * numberPerPage:0,
     * currentPage:0,
     * totalNumber:0,
     * totalPage:0
     *  }
     *
     */

    /**
     *
     * @api {post} http://localhost:8080/IWS-Server/api/location/addtoOthers 添加地点到其他系统
     * @apiName addtoOthers
     * @apiGroup location
     * @apiVersion 0.1.0
     * @apiDescription 将已有地点添加到其他系统中
     *
     * @apiParam {String} positionId 地点id
     * @apiParam {String} systemId 系统id
     * @apiParam {String} token 身份验证
     *
     * @apiSuccessExample Success-Response:
     *  HTTP/1.1 200 OK
     * {
     * callStatus:"SUCCEED",
     * errorCode:"No_Error",
     * data:null,
     * token:"SK1d7a4fe3-c2cd-417f-8f6f-bf7412592996",
     * numberPerPage:0,
     * currentPage:0,
     * totalNumber:0,
     * totalPage:0
     *  }
     *
     *  @apiErrorExample {json} Error-Response:
     *  HTTP/1.1 200 OK
     * {
     * callStatus:"FAILED",
     * errorCode:"Error",
     * data:null,
     * token:null,
     * numberPerPage:0,
     * currentPage:0,
     * totalNumber:0,
     * totalPage:0
     *  }
     *
     */

    /**
     *
     * @api {post} http://localhost:8080/IWS-Server/api/location/delete 删除地点
     * @apiName delete
     * @apiGroup location
     * @apiVersion 0.1.0
     * @apiDescription 删除地点
     *
     * @apiParam {String} locationId 系统id
     * @apiParam {String} token 身份验证
     *
     * @apiSuccessExample Success-Response:
     *  HTTP/1.1 200 OK
     * {
     * callStatus:"SUCCEED",
     * errorCode:"No_Error",
     * data:null,
     * token:"SK1d7a4fe3-c2cd-417f-8f6f-bf7412592996",
     * numberPerPage:0,
     * currentPage:0,
     * totalNumber:0,
     * totalPage:0
     *  }
     *
     *  @apiErrorExample {json} Error-Response:
     *  HTTP/1.1 200 OK
     * {
     * callStatus:"FAILED",
     * errorCode:"Error",
     * data:null,
     * token:null,
     * numberPerPage:0,
     * currentPage:0,
     * totalNumber:0,
     * totalPage:0
     *  }
     *
     */

    /**
     *
     * @api {post} http://localhost:8080/IWS-Server/api/location/inquiry 查询地点
     * @apiName inquiry
     * @apiGroup location
     * @apiVersion 0.1.0
     * @apiDescription 按条件查询地点
     *
     * @apiParam {String} name 地点名称
     * @apiParam {String} positionX 地点经度坐标
     * @apiParam {String} positionY 地点维度坐标
     * @apiParam {String} positionId 地点所属区域编号，标识到城区
     * @apiParam {String} systemId 所属系统id
     * @apiParam {String} token 身份验证
     *
     * @apiSuccessExample Success-Response:
     *  HTTP/1.1 200 OK
     * {
     * callStatus:"SUCCEED",
     * errorCode:"No_Error",
     * data:List,
     * token:"SK1d7a4fe3-c2cd-417f-8f6f-bf7412592996",
     * numberPerPage:0,
     * currentPage:0,
     * totalNumber:0,
     * totalPage:0
     *  }
     *
     *  @apiErrorExample {json} Error-Response:
     *  HTTP/1.1 200 OK
     * {
     * callStatus:"FAILED",
     * errorCode:"Error",
     * data:null,
     * token:null,
     * numberPerPage:0,
     * currentPage:0,
     * totalNumber:0,
     * totalPage:0
     *  }
     *
     */

    /**
     *
     * @api {post} http://localhost:8080/IWS-Server/api/location/detail 查看地点
     * @apiName detail
     * @apiGroup location
     * @apiVersion 0.1.0
     * @apiDescription 查看地点详情
     *
     * @apiParam {String} locationId 地点id
     * @apiParam {String} token 身份验证
     *
     * @apiSuccessExample Success-Response:
     *  HTTP/1.1 200 OK
     * {
     * callStatus:"SUCCEED",
     * errorCode:"No_Error",
     * data:LocationEntity,
     * token:"SK1d7a4fe3-c2cd-417f-8f6f-bf7412592996",
     * numberPerPage:0,
     * currentPage:0,
     * totalNumber:0,
     * totalPage:0
     *  }
     *
     *  @apiErrorExample {json} Error-Response:
     *  HTTP/1.1 200 OK
     * {
     * callStatus:"FAILED",
     * errorCode:"Error",
     * data:null,
     * token:null,
     * numberPerPage:0,
     * currentPage:0,
     * totalNumber:0,
     * totalPage:0
     *  }
     *
     */
}
