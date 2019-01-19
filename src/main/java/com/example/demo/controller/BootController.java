package com.example.demo.controller;

import com.example.demo.entity.Work;
import com.example.demo.service.WorkService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/boot")
public class BootController {
    @Autowired
    WorkService workService;
    @ApiOperation(value="查询work", notes="查找work根据id")
    @RequestMapping(value="/getWork",method = RequestMethod.GET)
    public Work getWork(HttpServletRequest request, Model model) {
        Integer id = Integer.parseInt(request.getParameter("id"));
        return workService.getWorkById(id);
    }
    /**
     * @api {post} /:all
     * @apiDescription  这只是一个登录的接口描述
     * @apiName work
     * @apiGroup work
     * @apiError userNotFound  The <code>id</code>
     * @apiSampleRequest http://192.168.1.86:8080/boot/all
     * @apiSuccessExample {json} 返回样例:
     * {"code":"0","msg":"注册成功"}
     */
    @RequiresRoles("admin")
    @ApiOperation(value="查找所有work", notes="查找所有work")
    @RequestMapping(value="/all",method = RequestMethod.GET)
    public Map<String,Object> findAll(){
        return workService.findAll();
    }
    /**
     * @api {post} /:getWork2
     * @apiDescription  这只是一个restful风格的查找work的接口描述
     * @apiName getWork2
     * @apiGroup work
     * @apiError userNotFound  The <code>id</code>
     * @apiSampleRequest http://192.168.1.86:8080/boot/getWork2/1
     * @apiSuccessExample {json} 返回样例:
     * {"code":"0","msg":"注册成功"}
     */
    //RESTful接口方式
    @RequiresPermissions("/boot/getWork2")
    @ApiOperation(value="查找work", notes="根据workid查找work")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer")
    @RequestMapping(value="getWork2/{id}",method = RequestMethod.GET)
    public Work getWork2(@PathVariable Integer id){
        return workService.getWorkById(id);
    }
}
