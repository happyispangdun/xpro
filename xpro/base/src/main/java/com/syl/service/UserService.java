package com.syl.service;

import com.syl.entity.User;
import com.syl.entity.User_Role;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;


public interface UserService {

    int saveUser(User user);

    int editUser(User user);

    int delUser(String id);

    User getUserById(String id);

    List<User> findByAll();

    int saveUserAndRole(List<User_Role> userRoles);

    int delRole2User(String userId);

    int delUserAndRole(List<User_Role> userRoles);

    Map<String, Object> findByUserNameAndPass(String username, String password);
}
