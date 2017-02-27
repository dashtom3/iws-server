import com.jiang.utils.DataWrapper;

/**
 * Created by XiaoJiang01 on 2017/2/23.
 */
public interface SystemApi {
    /**
     *
     * @api {post} http://localhost:8080/IWS-Server/api/system/add 添加系统
     * @apiName add
     * @apiGroup system
     * @apiVersion 0.1.0
     * @apiDescription 注册添加新系统
     *
     * @apiParam {String} name 系统名称
     * @apiParam {String} pic 图片
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
     * @api {post} http://localhost:8080/IWS-Server/api/system/update 编辑系统
     * @apiName update
     * @apiGroup system
     * @apiVersion 0.1.0
     * @apiDescription 编辑修改系统，更改系统状态
     *
     * @apiParam {String} SystemId 系统id
     * @apiParam {String} pic 图片
     * @apiParam {String} name 系统名称
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
     * @api {post} http://localhost:8080/IWS-Server/api/system/delete 删除系统
     * @apiName delete
     * @apiGroup system
     * @apiVersion 0.1.0
     * @apiDescription 删除系统
     *
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
     * @api {post} http://localhost:8080/IWS-Server/api/system/inquiry 查询系统
     * @apiName inquiry
     * @apiGroup system
     * @apiVersion 0.1.0
     * @apiDescription 按条件查询系统
     *
     * @apiParam {String} name 系统名称
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
     * data:List,
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
     * @api {post} http://localhost:8080/IWS-Server/api/system/detail 查看系统
     * @apiName detail
     * @apiGroup system
     * @apiVersion 0.1.0
     * @apiDescription 查看系统详情
     *
     * @apiParam {String} systemId 系统id
     * @apiParam {String} token 身份验证
     *
     * @apiSuccessExample Success-Response:
     *  HTTP/1.1 200 OK
     * {
     * callStatus:"SUCCEED",
     * errorCode:"No_Error",
     * data:SystemEntity,
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
     * data:systemEntity,
     * token:null,
     * numberPerPage:0,
     * currentPage:0,
     * totalNumber:0,
     * totalPage:0
     *  }
     *
     */

}
