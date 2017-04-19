/**
 * Created by XiaoJiang01 on 2017/2/23.
 */
public interface LocationApi {

    /**
     *
     * @api {get} http://localhost:8080/iws/api/alarm/list 报警信息列表
     * @apiName list
     * @apiGroup alarm
     * @apiVersion 0.1.0
     * @apiDescription 返回全部报警信息
     *
     * @apiParam {String} token 身份验证
     *
     *
     * @apiSuccessExample Success-Response:
     *  HTTP/1.1 200 OK
     * {
     * callStatus:"SUCCEED",
     * errorCode:"No_Error",
     * data(List):{
     *      id:1,
     *      locationId:1,
     *      groupId:1,
     *      roomId:1,
     *      startTime:"2017-01-01 12:00:00",
     *      endTime:"2017-01-02 12:00:00",
     *      status:1(0未确认,1已确认),
     *      confirm:1(0未结束,1已结束),
     *      name:"123",
     *      describes:"123",
     *      locationName:"XX小区",
     *      roomName:"01泵房",
     *      groupName:"01控制柜"
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
