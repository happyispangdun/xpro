package com.syl.service.impl;

import com.syl.dao.UserDao;
import com.syl.entity.User;
import com.syl.entity.User_Role;
import com.syl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public int saveUser(User user) {
        return userDao.save(user);
    }

    @Override
    public int editUser(User user) {
        return userDao.edit(user);
    }

    @Override
    public int delUser(String id) {
        return userDao.delete(id);
    }

    @Override
    public User getUserById(String id) {
        return userDao.findById(id);
    }

    @Override
    public List<User> findByAll() {
        return userDao.findByAll();
    }

    @Override
    @Transactional
    public int saveUserAndRole(List<User_Role> userRoles) {
        userDao.delUser4Role(userRoles);
        return userDao.saveUser4Role(userRoles);
    }

    @Override
    public int delRole2User(String userId) {
        return userDao.delUserId4Role(userId);
    }

    @Override
    public int delUserAndRole(List<User_Role> userRoles) {
        return userDao.delUser4Role(userRoles);
    }

    @Override
    public Map<String, Object> findByUserNameAndPass(String username, String password) {
        return userDao.findByUserNameAndPass(username, password);
    }
}
