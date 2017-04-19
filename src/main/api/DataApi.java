/**
 * Created by XiaoJiang01 on 2017/2/23.
 */
public interface LocationApi {

    /**
     *
     * @api {get} http://localhost:8080/iws/api/data/query 查询检测数据
     * @apiName query
     * @apiGroup data
     * @apiVersion 0.1.0
     * @apiDescription 传条件查询,返回条件下全部数据。
     *
     * @apiParam {String} deviceId 设备id
     * @apiParam {String} startTime 开始时间id(日期格式:'yyyy-MM-dd HH:mm:ss')
     * @apiParam {String} endTime 结束时间id(日期格式:'yyyy-MM-dd HH:mm:ss')
     * @apiParam {String} timeStep 时间间隔id(以秒为单位,如:间隔为1分钟,传入60)
     * @apiParam {String} token 身份验证
     *
     *
     * @apiSuccessExample Success-Response:
     *  HTTP/1.1 200 OK
     * {
     * callStatus:"SUCCEED",
     * errorCode:"No_Error",
     * data(List):{
     *      id:1
     *      groupid:1
     *      deviceid:1
     *      com:1
     *      number:1
     *      time:'2017-01-01 12:00:00'
     *      error:'ER010203'(01 02 03位上的三个数据有异常)
     *      count:40(数据总数为40)
     *      param01:100.20(实际值)
     *      type01:1
     *      name01:'泵前压力'
     *      param02:200.20
     *      type02:1
     *      name02:'泵后压力'
     *      param50:null(数据最大容量为50,实际只有40个参数)
     *      type50:null
     *      name50:null
     * }
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
