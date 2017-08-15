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

import com.dnp.bootstarp.model.User;
import com.dnp.bootstarp.service.UserService;
import com.dnp.bootstarp.common.page.PageVo;

/**
 * <p>
 * 用户信息  前端控制器
 * </p>
 *
 * @author stylefeng
 * @since 2017-08-09
 */
@Api(value = "UserController" , description = "用户信息" )
@RestController
@RequestMapping(value = "/user" , produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "" , method = RequestMethod.GET)
    @ApiOperation(value = "查询所有用户信息" , notes = "查询所有用户信息" )
    public Object findAll(PageVo pageVo,
                          @ApiParam(name = "search" , value = "模糊查询字段" , required = false) @RequestParam(required = false, defaultValue = "" ) String search) {
        return null;
    }


    @RequestMapping(value = "/{id}" , method = RequestMethod.GET)
    @ApiOperation(value = "查询用户信息详情" , notes = "查询用户信息详情" , httpMethod = "GET" )
    public User findById(@ApiParam(name = "id" , value = "用户信息id" , required = true) @PathVariable("id" ) Integer id) {
        return userService.selectById(id);
    }

    @RequestMapping(value = "/{id}" , method = RequestMethod.PUT)
    @ApiOperation(value = "修改用户信息" , notes = "修改用户信息" )
    public void update(User user) {
        userService.updateAllColumnById(user);
    }

    @RequestMapping(value = "" , method = RequestMethod.POST)
    @ApiOperation(value = "添加用户信息" , notes = "添加用户信息" )
    public void save(

            @ApiParam(name = "name" , value = "用户名称" )
            @RequestParam(required = false, name = "name" ) String name
            ,
            @ApiParam(name = "email" , value = "用户email" )
            @RequestParam(required = false, name = "email" ) String email
            ,
            @ApiParam(name = "password" , value = "用户密码" )
            @RequestParam(required = false, name = "password" ) String password
            ,
            @ApiParam(name = "createdDate" , value = "用户创建日期" )
            @RequestParam(required = false, name = "createdDate" ) Long createdDate
            ,
            @ApiParam(name = "roleId" , value = "角色id" )
            @RequestParam(required = false, name = "roleId" ) Integer roleId
    ) {
        User user = new User(

                name, email, password, createdDate, roleId);
        userService.insertAllColumn(user);
    }

    @RequestMapping(value = "/{id}" , method = RequestMethod.DELETE)
    @ApiOperation(value = "删除用户信息" , notes = "修改用户信息" )
    public void delete(@ApiParam(name = "id" , value = "用户信息id" , required = true) @PathVariable("id" ) Integer id) {
        userService.deleteById(id);
    }

}
