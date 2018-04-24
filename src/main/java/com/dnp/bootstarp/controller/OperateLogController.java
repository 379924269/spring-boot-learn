package com.dnp.bootstarp.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dnp.bootstarp.model.OperateLog;
import com.dnp.bootstarp.service.OperateLogService;
import com.dnp.bootstarp.common.page.PageVo;

import java.sql.Date;

/**
 * <p>
 * 操作日志  前端控制器
 * </p>
 *
 * @author huazai
 * @since 2018-04-24
 */
@Api(value = "OperateLogController", description = "操作日志")
@RestController
@RequestMapping(value = "/operateLog", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class OperateLogController {
    @Autowired
    private OperateLogService operateLogService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ApiOperation(value = "查询所有操作日志", notes = "查询所有操作日志")
    public Object findAll(PageVo pageVo,
                          @ApiParam(name = "search", value = "模糊查询字段", required = false) @RequestParam(required = false, defaultValue = "") String search) {
        return null;
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "查询操作日志详情", notes = "查询操作日志详情", httpMethod = "GET")
    public OperateLog findById(@ApiParam(name = "id", value = "操作日志id", required = true) @PathVariable("id") Integer id) {
        return operateLogService.selectById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ApiOperation(value = "修改操作日志", notes = "修改操作日志")
    public void updateById(OperateLog operateLog) {
        operateLogService.updateById(operateLog);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ApiOperation(value = "添加操作日志", notes = "添加操作日志")
    public void save(
            @ApiParam(name = "logType", value = "日志类型,1：正常日志，2：异常日志")
            @RequestParam(required = false, name = "logType") Integer logType
            ,
            @ApiParam(name = "createdDate", value = "创建日期")
            @RequestParam(required = false, name = "createdDate") Date createdDate
            ,
            @ApiParam(name = "userId", value = "产生日志用户id")
            @RequestParam(required = false, name = "userId") Integer userId
            ,
            @ApiParam(name = "userEmail", value = "产生日志用户email")
            @RequestParam(required = false, name = "userEmail") String userEmail
            ,
            @ApiParam(name = "description", value = "日志描述")
            @RequestParam(required = false, name = "description") String description
            ,
            @ApiParam(name = "ip", value = "产生日志IP地址")
            @RequestParam(required = false, name = "ip") String ip
    ) {
        OperateLog operateLog = new OperateLog(logType, createdDate, userId, userEmail, description, ip);
        operateLogService.insert(operateLog);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ApiOperation(value = "删除操作日志", notes = "修改操作日志")
    public void deleteById(@ApiParam(name = "id", value = "操作日志id", required = true) @PathVariable("id") Integer id) {
        operateLogService.deleteById(id);
    }

}
