package com.example.demo.service;

import com.example.demo.entity.Permission;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;

import java.util.List;

/**
 * shiro权限管理器
 */
public interface UserManagerService {
public User getUserByUserName(String name);
public List<Role> getRoleByUserid(Integer id);
public List<Permission> getPermissionByRoleid(Integer id);
}
