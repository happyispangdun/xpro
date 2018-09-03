package com.syl.dao.impl;


import com.syl.dao.MenuDao;
import com.syl.entity.Menu;
import com.syl.entity.Role_Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MenuDaoImp implements MenuDao {
    @Override
    public int saveRole4Menu(List<Role_Menu> rMenus) {
        int[] c = jdbcTemplate.batchUpdate("insert into s_role_menu(roleId,menuid) values(?,?)", new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                Role_Menu rMenu = rMenus.get(i);
                ps.setString(1, rMenu.getRoleId());
                ps.setString(2, rMenu.getMenuId());
            }

            @Override
            public int getBatchSize() {
                return rMenus.size();
            }
        });
        return c.length;
    }

    @Override
    public int delRole4Menu(String menuId) {
        return jdbcTemplate.update("delete from s_role_menu where menuId=?", menuId);
    }

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(Menu menu) {
        return jdbcTemplate.update("insert into s_menu(id,name,isLeaf,state,pid,url) values(?,?,?,?,?,?)", menu.getId(), menu.getName(), menu.getIsLeaf(), menu.getState(), menu.getPid(), menu.getUrl());
    }

    @Override
    public int edit(Menu menu) {
        return jdbcTemplate.update("update s_menu set name=?,isLeaf=?,state=?,pid=?,url=? where id=?", menu.getName(), menu.getIsLeaf(), menu.getState(), menu.getPid(), menu.getUrl());
    }

    @Override
    public int delete(String id) {
        return jdbcTemplate.update("delete from s_menu where id=?", id);
    }

    @Override
    public Menu findById(String id) {
        List<Menu> menus = jdbcTemplate.query("select * from s_menu where id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Menu.class));
        if (null == menus || menus.size() == 0) {
            return new Menu();
        } else {
            return menus.get(0);
        }
    }

    @Override
    public List<Menu> findByAll() {
        List<Menu> menus = jdbcTemplate.query("select * from s_menu", new Object[]{}, new BeanPropertyRowMapper<>(Menu.class));
        if (null == menus || menus.size() == 0) {
            return new ArrayList<Menu>();
        } else {
            return menus;
        }
    }
}
