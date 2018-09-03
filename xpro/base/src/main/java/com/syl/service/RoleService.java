package com.syl.service;


import com.syl.entity.Role;

import java.util.List;

public interface RoleService {

    int saveRole(Role role);

    int editRole(Role role);

    int delRole(String id);

    Role getRoleById(String id);

    List<Role> findByAll();

    int delRole4Role(String roleId);

    int delMenu4Role(String roleId);

}
