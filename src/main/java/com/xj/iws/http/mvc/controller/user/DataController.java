package com.xj.iws.http.mvc.controller.user;

import com.xj.iws.common.utils.DataWrapper;
import com.xj.iws.common.utils.ExcelUtil;
import com.xj.iws.http.mvc.entity.util.ViewDataEntity;
import com.xj.iws.http.mvc.service.DataService;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 管理全部数据请求
 *
 * @author Created by XiaoJiang01 on 2017/2/21.
 */
@Controller
@RequestMapping("api/data")
public class DataController {

    /**
     *
     */
    @Autowired
    DataService dataService;

    @RequestMapping(value = "query", method = RequestMethod.GET)
    @ResponseBody
    public DataWrapper<List<ViewDataEntity>> query(
            @RequestParam(value = "token", required = true) String token,
            @RequestParam(value = "deviceId", required = true) String deviceId,
            @RequestParam(value = "startTime", required = true) String startTime,
            @RequestParam(value = "endTime", required = true) String endTime,
            @RequestParam(value = "timeStep", required = true) String timeStep
    ) {
        Map<String, String> conditions = new HashMap<String, String>();
        conditions.put("deviceId", deviceId);
        conditions.put("startTime", startTime);
        conditions.put("endTime", endTime);
        conditions.put("timeStep", timeStep);
        return dataService.query(conditions);
    }

    @RequestMapping(value = "presentData", method = RequestMethod.GET)
    @ResponseBody
    public DataWrapper<ViewDataEntity> presentData(
            @RequestParam(value = "token", required = true) String token,
            @RequestParam(value = "deviceId", required = true) int deviceId
    ) {
        return dataService.presentData(deviceId);
    }

    @RequestMapping(value = "outputExcel", method = RequestMethod.GET)
    @ResponseBody
    public void outputExcel(
            HttpServletResponse response,
            @RequestParam(value = "token", required = true) String token,
            @RequestParam(value = "deviceId", required = true) String deviceId,
            @RequestParam(value = "startTime", required = true) String startTime,
            @RequestParam(value = "endTime", required = true) String endTime,
            @RequestParam(value = "timeStep", required = true) String timeStep
    ) throws IOException {
        Map<String, String> conditions = new HashMap<String, String>();
        conditions.put("deviceId", deviceId);
        conditions.put("startTime", startTime);
        conditions.put("endTime", endTime);
        conditions.put("timeStep", timeStep);

        List<ViewDataEntity> viewDatas = dataService.query(conditions).getData();

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        try {
            ExcelUtil.createWorkBook(viewDatas).write(os);
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] content = os.toByteArray();
        InputStream is = new ByteArrayInputStream(content);
        // 设置response参数，可以打开下载页面
        response.reset();
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment;filename=" + new String((ExcelUtil.fileName(viewDatas)).getBytes(), "iso-8859-1"));
        ServletOutputStream out;
        out = response.getOutputStream();
        BufferedInputStream bis;
        BufferedOutputStream bos;

        bis = new BufferedInputStream(is);
        bos = new BufferedOutputStream(out);
        byte[] buff = new byte[2048];
        int bytesRead;
        // Simple read/write loop.
        while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
            bos.write(buff, 0, bytesRead);
        }

        if (bis != null) bis.close();
        if (bos != null) bos.close();

    }
}
