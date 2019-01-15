package com.example.demo.service.impl;

import com.example.demo.dao.PermissionMapper;
import com.example.demo.dao.RoleMapper;
import com.example.demo.dao.UserMapper;
import com.example.demo.entity.Permission;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.service.UserManagerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserManagerServiceImpl implements UserManagerService{
    @Resource
    UserMapper userMapper;
    @Resource
    RoleMapper roleMapper;
    @Resource
    PermissionMapper permissionMapper;
    @Override
    public User getUserByUserName(String name) {
        return userMapper.getUserByUserName(name);
    }
    @Override
    public List<Role> getRoleByUserid(Integer id) {
        return roleMapper.getRoleByUserid(id);
    }
    @Override
    public List<Permission> getPermissionByRoleid(Integer id) {
        return permissionMapper.getPermissionByRoleid(id);
    }
}
