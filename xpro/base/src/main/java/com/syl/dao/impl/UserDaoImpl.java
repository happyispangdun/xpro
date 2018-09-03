package com.syl.dao.impl;

import com.syl.dao.UserDao;
import com.syl.entity.User;
import com.syl.entity.User_Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(User user) {

        return jdbcTemplate.update("insert into S_USER(id,username,password,name,phone) values(?,?,?,?,?)", user.getId(), user.getUsername(), user.getPassword(), user.getName(), user.getPhone());
    }

    @Override
    public int edit(User user) {
        return jdbcTemplate.update("update S_USER set password=?,name=?,phone=? where id=?", user.getPassword(), user.getName(), user.getPhone(), user.getId());
    }

    @Override
    public int delete(String id) {
        return jdbcTemplate.update("delete from S_USER where id = ?", id);
    }

    @Override
    public User findById(String id) {
        List<User> list = jdbcTemplate.query("select * from S_USER where id=?", new Object[]{id}, new BeanPropertyRowMapper(User.class));
        if (list != null && list.size() > 0) {
            return list.get(0);
        } else {
            return new User();
        }
    }

    @Override
    public List<User> findByAll() {
        List<User> list = jdbcTemplate.query("select * from S_USER ", new Object[]{}, new BeanPropertyRowMapper(User.class));
        if (!list.isEmpty() && list.size() > 0) {
            return list;
        } else {
            return new ArrayList<User>();
        }
    }

    public int saveUser4Role(List<User_Role> userRoles) {
        int[] c = jdbcTemplate.batchUpdate("insert into s_user_role(userId,roleId) values(?,?)", new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                User_Role userRole = userRoles.get(i);
                ps.setString(1, userRole.getUserId());
                ps.setString(2, userRole.getRoleId());
            }

            @Override
            public int getBatchSize() {
                return userRoles.size();
            }
        });
        return c.length;
    }

    @Override
    public int delUserId4Role(String userId) {

        return jdbcTemplate.update("delete from s_user_role where userid=?", userId);
    }

    @Override
    public List<User_Role> findByUserId(String userId) {
        return jdbcTemplate.query("select * from s_user_role where userId=?", new String[]{userId}, new BeanPropertyRowMapper(User_Role.class));
    }

    @Override
    public int delUser4Role(List<User_Role> userRoles) {
        int[] c = jdbcTemplate.batchUpdate("delete from s_user_role where userId=? and roleId=?", new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                User_Role userRole = userRoles.get(i);
                preparedStatement.setString(1, userRole.getUserId());
                preparedStatement.setString(2, userRole.getRoleId());
            }

            @Override
            public int getBatchSize() {
                return userRoles.size();
            }
        });
        return c.length;
    }

    @Override
    public Map<String, Object> findByUserNameAndPass(String username, String password) {
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select distinct * from s_user_role r inner join  s_user u on r.userId = u.id INNER JOIN s_role s on r.roleId=s.id where u.username=? and u.password=?", new Object[]{username, password});
        if (list != null && list.size() > 0) {
            return list.get(0);
        } else {
            new HashMap<String, Object>();
        }
        return null;
    }
}
