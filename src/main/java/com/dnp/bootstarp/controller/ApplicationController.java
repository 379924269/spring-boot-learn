package

        com.dnp.bootstarp.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.dnp.bootstarp.common.page.PageVo;
import com.dnp.bootstarp.model.Application;
import com.dnp.bootstarp.service.ApplicationService;
import com.github.pagehelper.PageHelper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 应用信息  前端控制器
 * </p>
 *
 * @author stylefeng
 * @since 2017-08-09
 */
@Api(value = "ApplicationController" , description = "应用信息" )
@RestController
@RequestMapping(value = "/application" , produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ApplicationController {
    @Autowired
    private ApplicationService applicationService;

    @RequestMapping(value = "" , method = RequestMethod.GET)
    @ApiOperation(value = "查询所有应用信息" , notes = "查询所有应用信息" )
    public Object findAll(PageVo pageVo,
                          @ApiParam(name = "search" , value = "模糊查询字段" , required = false) @RequestParam(required = false, defaultValue = "" ) String search) {
        Page page = new Page(pageVo.getOffset(), pageVo.getLimit());
        return applicationService.selectMapsPage(page, new EntityWrapper<Application>());
    }


    @RequestMapping(value = "/{id}" , method = RequestMethod.GET)
    @ApiOperation(value = "查询应用信息详情" , notes = "查询应用信息详情" , httpMethod = "GET" )
    public Application findById(@ApiParam(name = "id" , value = "应用信息id" , required = true) @PathVariable("id" ) Integer id) {
        return applicationService.selectById(id);
    }

    @RequestMapping(value = "/{id}" , method = RequestMethod.PUT)
    @ApiOperation(value = "修改应用信息" , notes = "修改应用信息" )
    public void update(@ModelAttribute Application application) {
        applicationService.updateById(application);
    }

    @RequestMapping(value = "" , method = RequestMethod.POST)
    @ApiOperation(value = "添加应用信息" , notes = "添加应用信息" )
    public void save(

            @ApiParam(name = "name" , value = "应用名称" )
            @RequestParam(required = false, name = "name" ) String name
            ,
            @ApiParam(name = "versionName" , value = "应用版本名称" )
            @RequestParam(required = false, name = "versionName" ) String versionName
            ,
            @ApiParam(name = "versionCode" , value = "应用版本号" )
            @RequestParam(required = false, name = "versionCode" ) Integer versionCode
            ,
            @ApiParam(name = "packageName" , value = "应用报名" )
            @RequestParam(required = false, name = "packageName" ) String packageName
            ,
            @ApiParam(name = "system" , value = "应用版本：如：华为、中心等（包名相同不同版本）" )
            @RequestParam(required = false, name = "system" ) String system
            ,
            @ApiParam(name = "md5" , value = "应用MD5" )
            @RequestParam(required = false, name = "md5" ) String md5
            ,
            @ApiParam(name = "size" , value = "应用大小" )
            @RequestParam(required = false, name = "size" ) Integer size
            ,
            @ApiParam(name = "url" , value = "应用地址" )
            @RequestParam(required = false, name = "url" ) String url
            ,
            @ApiParam(name = "createdDate" , value = "创建时间" )
            @RequestParam(required = false, name = "createdDate" ) Long createdDate
            ,
            @ApiParam(name = "description" , value = "应用描述" )
            @RequestParam(required = false, name = "description" ) String description
    ) {
        Application application = new Application(

                name, versionName, versionCode, packageName, system, md5, size, url, createdDate, description);
        applicationService.insertAllColumn(application);
    }

    @RequestMapping(value = "/{id}" , method = RequestMethod.DELETE)
    @ApiOperation(value = "删除应用信息" , notes = "修改应用信息" )
    public void delete(@ApiParam(name = "id" , value = "应用信息id" , required = true) @PathVariable("id" ) Integer id) {
        applicationService.deleteById(id);
    }

    @GetMapping("logTest" )
    @ApiOperation(value = "日志测试" , notes = "日志测试" )
    public void logTest() {
        Logger logger = LoggerFactory.getLogger(this.getClass());
        logger.debug("This is a debug message" );
        logger.info("This is an info message" );
        logger.warn("This is a warn message" );
        logger.error("This is an error message" );
    }


}
