package com.syl.service.impl;


import com.syl.entity.User;
import com.syl.entity.User_Role;
import com.syl.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testSaveUser() {
        User user = new User();
        UUID uid = UUID.randomUUID();
        String id = uid.toString().replace("-", "");
        user.setId(id);
        user.setName("aaaa");
        user.setUsername("user");
        user.setPassword("aaaaa");
        int i = userService.saveUser(user);
        assertNotEquals(i, 0);
    }

    @Test
    public void testUserAndRole() {
        List<User_Role> li = new ArrayList<User_Role>();
        User_Role userRole = new User_Role();
        userRole.setRoleId("1");
        userRole.setUserId("1");
        User_Role userRole2 = new User_Role();
        userRole2.setRoleId("1");
        userRole2.setUserId("1");
        li.add(userRole);
        li.add(userRole2);
        userService.saveUserAndRole(li);
    }

    @Test
    public void testFindByUserNameAndPass() {
        Map<String, Object> user = userService.findByUserNameAndPass("user", "user");
        assertNotNull(user.get("username"));
    }


}
