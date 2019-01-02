package com.example.demo.service;
import com.example.demo.entity.Work;

import java.util.Map;

/**
 * creete by dankin 2019-01-02
 * desrc:example of spring-boot
 */
public interface WorkService {
    public Work getWorkById(Integer id);
    public Map<String,Object> findAll();
}
