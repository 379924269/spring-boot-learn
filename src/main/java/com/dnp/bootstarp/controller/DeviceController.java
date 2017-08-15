package

        com.dnp.bootstarp.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.dnp.bootstarp.model.Application;
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

import com.dnp.bootstarp.model.Device;
import com.dnp.bootstarp.service.DeviceService;
import com.dnp.bootstarp.common.page.PageVo;

/**
 * <p>
 * 设备信息  前端控制器
 * </p>
 *
 * @author stylefeng
 * @since 2017-08-09
 */
@Api(value = "DeviceController" , description = "设备信息" )
@RestController
@RequestMapping(value = "/device" , produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class DeviceController {
    @Autowired
    private DeviceService deviceService;

    @RequestMapping(value = "" , method = RequestMethod.GET)
    @ApiOperation(value = "查询所有设备信息" , notes = "查询所有设备信息" )
    public Object findAll(PageVo pageVo,
                          @ApiParam(name = "search" , value = "模糊查询字段" , required = false) @RequestParam(required = false, defaultValue = "" ) String search) {
        Page page = new Page(pageVo.getOffset(), pageVo.getLimit());
        return deviceService.selectMapsPage(page, new EntityWrapper<Device>());

    }

    @RequestMapping(value = "finAllRelation" , method = RequestMethod.GET)
    @ApiOperation(value = "查询设备即相关信息" , notes = "查询设备记即相关信息" )
    public Object findAllRelation(PageVo pageVo,
                          @ApiParam(name = "search" , value = "模糊查询字段" , required = false) @RequestParam(required = false, defaultValue = "" ) String search) {
        return deviceService.findAllRelation(pageVo, search);
    }


    @RequestMapping(value = "/{id}" , method = RequestMethod.GET)
    @ApiOperation(value = "查询设备信息详情" , notes = "查询设备信息详情" , httpMethod = "GET" )
    public Device findById(@ApiParam(name = "id" , value = "设备信息id" , required = true) @PathVariable("id" ) Integer id) {
        return deviceService.selectById(id);
    }

    @RequestMapping(value = "/{id}" , method = RequestMethod.PUT)
    @ApiOperation(value = "修改设备信息" , notes = "修改设备信息" )
    public void update(Device device) {
        deviceService.updateAllColumnById(device);
    }

    @RequestMapping(value = "" , method = RequestMethod.POST)
    @ApiOperation(value = "添加设备信息" , notes = "添加设备信息" )
    public void save(

            @ApiParam(name = "serialNumber" , value = "设备的SN（序列号）" )
            @RequestParam(required = false, name = "serialNumber" ) String serialNumber
            ,
            @ApiParam(name = "downloads" , value = "下载次数" )
            @RequestParam(required = false, name = "downloads" ) Integer downloads
            ,
            @ApiParam(name = "configId" , value = "配置id" )
            @RequestParam(required = false, name = "configId" ) Integer configId
            ,
            @ApiParam(name = "applicationId" , value = "应用id" )
            @RequestParam(required = false, name = "applicationId" ) Integer applicationId
            ,
            @ApiParam(name = "locationId" , value = "归属地id" )
            @RequestParam(required = false, name = "locationId" ) Integer locationId
            ,
            @ApiParam(name = "modelId" , value = "型号id" )
            @RequestParam(required = false, name = "modelId" ) Integer modelId
            ,
            @ApiParam(name = "tfcardId" , value = "TF卡id" )
            @RequestParam(required = false, name = "tfcardId" ) Integer tfcardId
            ,
            @ApiParam(name = "token" , value = "设备口令" )
            @RequestParam(required = false, name = "token" ) String token
            ,
            @ApiParam(name = "expirationTime" , value = "口令过期过期时间" )
            @RequestParam(required = false, name = "expirationTime" ) Long expirationTime
            ,
            @ApiParam(name = "createdDate" , value = "创建时间" )
            @RequestParam(required = false, name = "createdDate" ) Long createdDate
            ,
            @ApiParam(name = "adaptionDate" , value = "适配（激活）时间" )
            @RequestParam(required = false, name = "adaptionDate" ) Long adaptionDate
    ) {
        Device device = new Device(

                serialNumber, downloads, configId, applicationId, locationId, modelId, tfcardId, token, expirationTime, createdDate, adaptionDate);
        deviceService.insertAllColumn(device);
    }

    @RequestMapping(value = "/{id}" , method = RequestMethod.DELETE)
    @ApiOperation(value = "删除设备信息" , notes = "修改设备信息" )
    public void delete(@ApiParam(name = "id" , value = "设备信息id" , required = true) @PathVariable("id" ) Integer id) {
        deviceService.deleteById(id);
    }

}
