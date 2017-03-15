/**
 * Created by XiaoJiang01 on 2017/2/23.
 */
public interface RoomApi {
    /**
     *
     * @api {post} http://localhost:8080/iws/api/room/add 添加泵房
     * @apiName add
     * @apiGroup room
     * @apiVersion 0.1.0
     * @apiDescription 注册添加新泵房
     *
     * @apiParam {int} locationId 泵房所属区域地点id
     * @apiParam {String} name 泵房名称
     * @apiParam {String} describes 泵房描述
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
     * }
     *
     */

    /**
     *
     * @api {post} http://localhost:8080/iws/api/room/delete 删除泵房
     * @apiName delete
     * @apiGroup room
     * @apiVersion 0.1.0
     * @apiDescription 删除泵房
     *
     * @apiParam {String} id 泵房id
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
     * @api {post} http://localhost:8080/iws/api/room/update 编辑泵房
     * @apiName update
     * @apiGroup room
     * @apiVersion 0.1.0
     * @apiDescription 编辑修改系统，更改系统状态
     *
     * @apiParam {int} id 泵房id
     * @apiParam {int} locationId 泵房所属区域地点id
     * @apiParam {String} name 泵房名称
     * @apiParam {String} describes 泵房描述
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
     * @api {post} http://localhost:8080/iws/api/room/detail 查看泵房
     * @apiName detail
     * @apiGroup room
     * @apiVersion 0.1.0
     * @apiDescription 获取某一泵房及泵房所属地点、泵房内所有控制器
     *
     * @apiParam {int} id 泵房id
     * @apiParam {String} token 身份验证
     *
     * @apiSuccessExample Success-Response:
     *  HTTP/1.1 200 OK
     * {
     * callStatus:"SUCCEED",
     * errorCode:"No_Error",
     * data:{
     *      id:1,
     *      locationId:1,
     *      name:"name",
     *      describes:"describes"
     *      location:{
     *          id:1，
     *          systemId:1，
     *          areaId:110101,
     *          positionX:123.1234567890,
     *          positionY:123.123456,
     *          name:"name",
     *          describes:"describes",
     *      }
     *      equipment(List):{
     *          id:1,
     *          roomId:1,
     *          equipmentType:"equipmenttype000",
     *          parameterId:"1",
     *          com:"com1",
     *          num:1,
     *          name:"name",
     *          describes:"describes"
     *      }
     *
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
