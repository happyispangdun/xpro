package com.syl.dao;


import com.syl.entity.Menu;
import com.syl.entity.Role_Menu;

import java.util.List;

public interface MenuDao extends BaseDao<Menu> {

    int saveRole4Menu(List<Role_Menu> rMenus);

    int delRole4Menu(String menuId);

}
