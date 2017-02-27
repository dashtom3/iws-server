/**
 * Created by XiaoJiang01 on 2017/2/24.
 */
public interface DataApi {
    /**
     *
     * @api {post} http://localhost:8080/IWS-Server/api/data/new 获取实时数据
     * @apiName new
     * @apiGroup data
     * @apiVersion 0.1.0
     * @apiDescription 获取当前时刻检测数据
     *
     * @apiParam {String} deviceId 设备id
     * @apiParam {String} token 身份验证
     *
     * @apiSuccessExample Success-Response:
     *  HTTP/1.1 200 OK
     * {
     * callStatus:"SUCCEED",
     * errorCode:"No_Error",
     * data:DataEntity,
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
     * @api {post} http://localhost:8080/IWS-Server/api/data/detail 查看详情
     * @apiName detail
     * @apiGroup data
     * @apiVersion 0.1.0
     * @apiDescription 查看数据详情
     *
     * @apiParam {String} dataId 设备id
     * @apiParam {String} token 身份验证
     *
     * @apiSuccessExample Success-Response:
     *  HTTP/1.1 200 OK
     * {
     * callStatus:"SUCCEED",
     * errorCode:"No_Error",
     * data:DataEntity,
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
     * @api {post} http://localhost:8080/IWS-Server/api/data/inquiry 查询数据
     * @apiName inquiry
     * @apiGroup data
     * @apiVersion 0.1.0
     * @apiDescription 按条件查询数据
     *
     * @apiParam {String} deviceId 设备id
     * @apiParam {String} startTime 开始时间
     * @apiParam {String} endTime 结束时间
     * @apiParam {String} alarm 是否为报警数据
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

}
