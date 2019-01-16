package com.example.demo.dao;

import com.example.demo.entity.Role;

import java.util.List;

public interface RoleMapper {
    int deleteByPrimaryKey(Integer id);
    int insert(Role record);
    int insertSelective(Role record);
    Role selectByPrimaryKey(Integer id);
    int updateByPrimaryKeySelective(Role record);
    int updateByPrimaryKey(Role record);
    List<Role> getRoleByUserid(Integer id);
}