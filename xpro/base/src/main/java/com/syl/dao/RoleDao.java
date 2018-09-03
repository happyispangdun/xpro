package com.syl.dao;


import com.syl.entity.Role;
import com.syl.entity.User_Role;

import java.util.List;

public interface RoleDao extends BaseDao<Role> {
    List<User_Role> findByRoleId(String roleId);

    int delRole(String roleId);

    int delMenu4Role(String roleId);

}
