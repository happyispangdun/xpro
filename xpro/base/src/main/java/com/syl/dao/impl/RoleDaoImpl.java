package com.syl.dao.impl;

import com.syl.dao.RoleDao;
import com.syl.entity.Role;
import com.syl.entity.User_Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RoleDaoImpl implements RoleDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(Role role) {
        return jdbcTemplate.update("inset into S_ROLE(id,name,isLeft,state,isLogin,isNew,isEdit,isDel,isQuery) values(?,?,?,?,?,?,?,?,?)", role.getId(), role.getName(), role.getIsLeaf(), role.getState(), role.getIsLogin(), role.getIsNew(), role.getIsEdit(), role.getIsDel(), role.getIsQuery());
    }

    @Override
    public int edit(Role role) {
        return jdbcTemplate.update("update S_ROLE set isLeft=?,state=?,isLogin=?,isNew=?,isEdit=?isDel=?,isQuery=? where id=?", role.getIsLeaf(), role.getState(), role.getIsLogin(), role.getIsNew(), role.getIsEdit(), role.getIsDel(), role.getIsQuery(), role.getId());
    }

    @Override
    public int delete(String id) {
        return jdbcTemplate.update("delete from S_ROLE where id=?", id);
    }

    @Override
    public Role findById(String id) {
        List<Role> list = jdbcTemplate.query("select * from S_ROLE where id=?", new Object[]{id}, new BeanPropertyRowMapper(Role.class));
        if (list != null && list.size() > 0) {
            return list.get(0);
        } else {
            return new Role();
        }
    }

    @Override
    public List<Role> findByAll() {
        List<Role> list = jdbcTemplate.query("select * from S_ROLE where id=?", new Object[]{}, new BeanPropertyRowMapper(Role.class));
        if (list != null && list.size() > 0) {
            return list;
        } else {
            return new ArrayList<Role>();
        }
    }

    @Override
    public List<User_Role> findByRoleId(String roleId) {
        return jdbcTemplate.query("select * from s_user_role where roleId=?", new Object[]{roleId}, new BeanPropertyRowMapper(User_Role.class));
    }

    @Override
    public int delRole(String roleId) {
        return jdbcTemplate.update("delete from s_user_role where roleId=?", roleId);
    }

    @Override
    public int delMenu4Role(String roleId) {
        return jdbcTemplate.update("delete from s_role_menu where roleId=?", roleId);
    }
}
