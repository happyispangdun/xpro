package com.syl.dao;



import com.syl.entity.User;
import com.syl.entity.User_Role;

import java.util.List;
import java.util.Map;

public interface UserDao extends BaseDao<User> {

    int saveUser4Role(List<User_Role> userRoles);

    int delUserId4Role(String userId);

    int delUser4Role(List<User_Role> userRoles);

    Map<String, Object> findByUserNameAndPass(String username, String password);

    List<User_Role> findByUserId(String userId);


}
