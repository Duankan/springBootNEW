package com.example.demo.shiro;

import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
  * 1、在class上添加注解，@ControllerAdvice;
  * 2、在方法上添加@ExcetionHandler拦截相应的异常信息；可以用来捕捉shiro的权限拦截异常
  * 3、如果返回的是String或者是Json数据，那么需要在方法上添加@ResponseBody注解.
  */
@ControllerAdvice
public class GlobalDefaultExceptionHandler {
    @SuppressWarnings("unchecked")
    @ExceptionHandler(UnauthorizedException.class)
    @ResponseBody
    public Map<String,Object> defaultExceptionHandler(HttpServletRequest req, Exception e) {
        Map<String,Object> result=new HashMap<>();
        result.put("error",true);
        result.put("code",-3);
        result.put("msg","无访问权限!");
        return result;
    }
}
