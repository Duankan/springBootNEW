package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

/**
 * 登录前端控制器
 */
@RestController
@RequestMapping("/")
public class LoginController {
    /**
     * @api {post} /:userName
     * @apiDescription  这只是一个登录的接口描述
     * @apiName login
     * @apiParam {String} userName 用户的姓名
     * @apiParam {String} password 用户的年龄
     * @apiParamExample {json} Request-Example:
     * {
     *     "userName":"dankin",
     *     "password":"123456"
     * }
     * @apiGroup login
     * @apiError userNotFound  The <code>id</code>
     * @apiSampleRequest /login
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Map<String,Object> login(@RequestBody String param){
        Map<String,Object> result=new HashMap<>();
        if(StringUtils.isEmpty(param)){
            result.put("code","-11");
            result.put("msg","请填写账户信息");
        }
        Subject subject = SecurityUtils.getSubject();
        JSONObject object= (JSONObject) JSONObject.parse(param);
        String userName=object.getString("userName");
        String password=object.getString("password");
        UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
        try {
            subject.login(token);
            result.put("token",subject.getSession().getId());
            result.put("msg","登录成功");
            result.put("code",1);
        }
        catch (IncorrectCredentialsException e){
            result.put("msg","密码错误");
            result.put("code",-12);
        }
        catch (LockedAccountException e){
            result.put("msg","账户已被锁定");
            result.put("code",-13);
        }
        catch (AuthenticationException e){
            result.put("msg","该用户不存在");
            result.put("code",-14);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return  result;
    }
    @RequestMapping("/unLogin")
    public Map<String,Object> unLogin(){
        Map<String,Object> result=new HashMap<>();
        result.put("code",-1);
        result.put("msg","未登录");
        return result;
    }
}
