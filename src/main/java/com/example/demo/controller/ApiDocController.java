package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * APIdoc文档管理代码示例
 */
@Controller
@RequestMapping("/apidoc")
public class ApiDocController {
    /**
     * @api {get} /index/:userName
     * @apiDescription  这只是一个测试的接口描述
     * @apiName index
     * @apiParam {String} userName 用户的姓名
     * @apiParam {Number} userAge 用户的年龄
     * @apiParamExample {json} Request-Example:
     * {
     *     "userName":"dankin",
     *     "userAge":26
     * }
     * @apiGroup index
     * @apiError userNotFound  The <code>id</code>
     * @apiSampleRequest http://192.168.1.86:8080/apidoc/index
     */
    @RequestMapping("/index")
    @ResponseBody
    @CrossOrigin
    public Map<String,Object> index(){
        Map<String,Object> result=new HashMap<>();
        result.put("code",1);
        result.put("msg","成功");
        return result;
    }
}
