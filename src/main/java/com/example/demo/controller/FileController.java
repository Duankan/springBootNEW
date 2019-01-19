package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.multipart.MultipartFile;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * 文件上传下载控制器
 */
@Controller
@RequestMapping("/file")
public class FileController {
    @RequestMapping(value="/upload",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> upload(@RequestParam("file") MultipartFile file){
        Map<String,Object> result=new HashMap<>();
        if(!file.isEmpty()){
            try{
                String path= ContextLoader.getCurrentWebApplicationContext().getServletContext().getRealPath("/");
                BufferedOutputStream out = new BufferedOutputStream(
                        new FileOutputStream(new File(path+file.getOriginalFilename())));
                out.write(file.getBytes());
                out.flush();
                out.close();
                result.put("code",1);
                result.put("msg","上传成功");
                return result;
            }
            catch (Exception e){
                e.printStackTrace();
                result.put("code",-1);
                result.put("msg","上传失败");
                return result;
            }
        }
        result.put("code",-1);
        result.put("msg","请选择文件");
        return result;
    }
    @RequestMapping("/html")
    public String toFileHtml(){
        return "test";
    }
}
