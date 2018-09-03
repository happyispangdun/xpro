package com.syl.service.impl;

import com.syl.dao.RoleDao;
import com.syl.entity.Role;
import com.syl.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public int saveRole(Role role) {
        return roleDao.save(role);
    }

    @Override
    public int editRole(Role role) {
        return roleDao.edit(role);
    }

    @Override
    @Transactional
    public int delRole(String id) {
        roleDao.delRole(id);
        return roleDao.delRole(id);
    }

    @Override
    public Role getRoleById(String id) {
        return roleDao.findById(id);
    }

    @Override
    public List<Role> findByAll() {
        return roleDao.findByAll();
    }

    @Override
    public int delRole4Role(String roleId) {
        return roleDao.delRole(roleId);
    }

    @Override
    public int delMenu4Role(String roleId) {
        return roleDao.delMenu4Role(roleId);
    }
}
