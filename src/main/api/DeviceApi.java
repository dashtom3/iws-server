/**
 * Created by XiaoJiang01 on 2017/2/24.
 */
public interface DeviceApi {

    /**
     *
     * @api {post} http://localhost:8080/iws/api/device/addGroup 添加控制器组
     * @apiName addGroup
     * @apiGroup device
     * @apiVersion 0.1.0
     * @apiDescription 添加控制器组
     *
     * @apiParam {String} terms 控制器id的字符串(格式:"1,2,3,")
     * @apiParam {int} type 控制器类型
     * @apiParam {String} name 控制器名称
     * @apiParam {String} describes 控制器描述
     * @apiParam {String} token 身份验证
     *
     * @apiSuccessExample Success-Response:
     *  HTTP/1.1 200 OK
     * {
     * callStatus:"SUCCEED",
     * errorCode:"No_Error",
     * data:{
     *     id:1,
     *     terms:"1,2,"
     *     status:1,
     *     type:"水箱变频",
     *     name:"水箱变频001",
     *     describes:"123",
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

    /**
     *
     * @api {post} http://localhost:8080/iws/api/device/delete 删除控制器组
     * @apiName delete
     * @apiGroup device
     * @apiVersion 0.1.0
     * @apiDescription 删除控制器组
     *
     * @apiParam {int} groupId 控制器id
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
     * @api {post} http://localhost:8080/iws/api/device/update 编辑控制器组
     * @apiName update
     * @apiGroup device
     * @apiVersion 0.1.0
     * @apiDescription 编辑修改控制器
     *
     * @apiParam {int} id 控制器组id
     * @apiParam {List} devices 控制器实例int数组(基本控制器id)
     * @apiParam {String} type 控制器类型
     * @apiParam {String} name 控制器名称
     * @apiParam {String} describes 控制器描述
     * @apiParam {String} token 身份验证
     *
     * @apiSuccessExample Success-Response:
     *  HTTP/1.1 200 OK
     * {
     * callStatus:"SUCCEED",
     * errorCode:"No_Error",
     * data:{
     *     id:1,
     *     terms:"1,2,"
     *     status:1,
     *     type:"水箱变频",
     *     name:"水箱变频001",
     *     describes:"123",
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


    /**
     *
     * @api {get} http://localhost:8080/iws/api/device/list 控制器组列表
     * @apiName list
     * @apiGroup device
     * @apiVersion 0.1.0
     * @apiDescription 控制器组列表
     *
     * @apiParam {String} token 身份验证
     *
     * @apiSuccessExample Success-Response:
     *  HTTP/1.1 200 OK
     * {
     * callStatus:"SUCCEED",
     * errorCode:"No_Error",
     * data:{
     *     id:1,
     *     terms:"1,2,"
     *     status:1,
     *     type:"水箱变频",
     *     name:"水箱变频001",
     *     describes:"123",
     *     deviceTerm(List):{
     *          id:1,
     *          count:41,
     *          protocol:"MODBUS",
     *          type:1,
     *          name:"PLC控制器",
     *          describes:"PLC控制器"
     *     }
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

    /**
     *
     * @api {get} http://localhost:8080/iws/api/device/groupDetail 控制器组详情
     * @apiName groupDetail
     * @apiGroup device
     * @apiVersion 0.1.0
     * @apiDescription 查看控制器组详情
     * @apiParam {String} groupId 控制器id
     * @apiParam {String} token 身份验证
     *
     * @apiSuccessExample Success-Response:
     *  HTTP/1.1 200 OK
     * {
     * callStatus:"SUCCEED",
     * errorCode:"No_Error",
     * data:{
     *     id:1,
     *     terms:"1,2,"
     *     status:1,
     *     type:"水箱变频",
     *     name:"水箱变频001",
     *     describes:"123",
     *     deviceTerm(List):{
     *          id:1,
     *          count:41,
     *          protocol:"MODBUS",
     *          type:1,
     *          name:"PLC控制器",
     *          describes:"PLC控制器"
     *     }
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
