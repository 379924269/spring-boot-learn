package

        com.dnp.bootstarp.controller;

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

import com.dnp.bootstarp.model.ResRole;
import com.dnp.bootstarp.service.ResRoleService;
import com.dnp.bootstarp.common.page.PageVo;

/**
 * <p>
 * 资源角色关系信息  前端控制器
 * </p>
 *
 * @author stylefeng
 * @since 2017-08-09
 */
@Api(value = "ResRoleController", description = "资源角色关系信息")
@RestController
@RequestMapping(value = "/resRole", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ResRoleController {
    @Autowired
    private ResRoleService resRoleService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ApiOperation(value = "查询所有资源角色关系信息", notes = "查询所有资源角色关系信息")
    public Object findAll(PageVo pageVo,
                          @ApiParam(name = "search", value = "模糊查询字段", required = false) @RequestParam(required = false, defaultValue = "") String search) {
        return null;
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "查询资源角色关系信息详情", notes = "查询资源角色关系信息详情", httpMethod = "GET")
    public ResRole findById(@ApiParam(name = "id", value = "资源角色关系信息id", required = true) @PathVariable("id") Integer id) {
        return resRoleService.selectById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ApiOperation(value = "修改资源角色关系信息", notes = "修改资源角色关系信息")
    public void update(ResRole resRole) {
        resRoleService.updateAllColumnById(resRole);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ApiOperation(value = "添加资源角色关系信息", notes = "添加资源角色关系信息")
    public void save(

            @ApiParam(name = "resourceId", value = "资源id")
            @RequestParam(required = false, name = "resourceId") Integer resourceId
            ,
            @ApiParam(name = "roleId", value = "角色id")
            @RequestParam(required = false, name = "roleId") Integer roleId
    ) {
        ResRole resRole = new ResRole(

                resourceId, roleId);
        resRoleService.insertAllColumn(resRole);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ApiOperation(value = "删除资源角色关系信息", notes = "修改资源角色关系信息")
    public void delete(@ApiParam(name = "id", value = "资源角色关系信息id", required = true) @PathVariable("id") Integer id) {
        resRoleService.deleteById(id);
    }

}
