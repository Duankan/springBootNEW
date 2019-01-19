package com.example.demo.service.impl;

import com.example.demo.dao.WorkMapper;
import com.example.demo.entity.Work;
import com.example.demo.service.WorkService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class WorkServiceImpl implements WorkService {
    @Resource
    WorkMapper workMapper;
    @Override
    public Work getWorkById(Integer id) {
        return workMapper.selectByPrimaryKey(id);
    }
    @Override
    public Map<String, Object> findAll() {
        Map<String, Object> result = new HashMap<>();
        List<Work> ls = workMapper.findAll();
        if (ls != null && ls.size() > 0) {
            result.put("code", 1);
            result.put("msg", "success");
            result.put("total", ls.size());
        } else {
            result.put("code", -1);
            result.put("msg", "failed");
            result.put("total", 0);
        }
        result.put("rows", ls);
        return result;
    }
}
