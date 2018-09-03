package com.syl.controller;

import com.syl.entity.User;
import com.syl.service.UserService;
import com.syl.utils.IdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController("/")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("addUser")
    public User addUser(@ModelAttribute("User") User user) {

        String id = IdUtil.generateId();
        user.setId(id);
        userService.saveUser(user);

        return user;
    }
}
