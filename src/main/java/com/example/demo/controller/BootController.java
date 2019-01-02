package com.example.demo.controller;

import com.example.demo.entity.Work;
import com.example.demo.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/boot")
public class BootController {
    @Autowired
    WorkService workService;
    @RequestMapping("/getWork")
    public Work getWork(HttpServletRequest request, Model model) {
        Integer id = Integer.parseInt(request.getParameter("id"));
        return workService.getWorkById(id);
    }
    @RequestMapping("/all")
    public Map<String,Object> findAll(){
        return workService.findAll();
    }
}
