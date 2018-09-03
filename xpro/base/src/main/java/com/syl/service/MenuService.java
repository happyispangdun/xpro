package com.syl.service;


import com.syl.entity.Menu;
import com.syl.entity.Role_Menu;

import java.util.List;

public interface MenuService {

    int saveMenu(Menu menu);

    int editMenu(Menu menu);

    int delMenu(String id);

    Menu findById(String id);

    List<Menu> findByAll();

    int delFindByMenuId(String menuId);

    int saveMenuAndRole(List<Role_Menu> rMenus);
}
