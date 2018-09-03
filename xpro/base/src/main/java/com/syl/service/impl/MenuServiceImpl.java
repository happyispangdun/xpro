package com.syl.service.impl;

import com.syl.dao.impl.MenuDaoImp;
import com.syl.entity.Menu;
import com.syl.entity.Role_Menu;
import com.syl.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuDaoImp menuDao;

    @Override
    public int saveMenu(Menu menu) {
        return menuDao.save(menu);
    }

    @Override
    public int editMenu(Menu menu) {
        return menuDao.edit(menu);
    }

    @Override
    public int delMenu(String id) {
        return menuDao.delete(id);
    }

    @Override
    public Menu findById(String id) {
        return menuDao.findById(id);
    }

    @Override
    public List<Menu> findByAll() {
        return menuDao.findByAll();
    }

    @Override
    public int delFindByMenuId(String menuId) {
        return menuDao.delRole4Menu(menuId);
    }

    @Override
    public int saveMenuAndRole(List<Role_Menu> rMenus) {
        return menuDao.saveRole4Menu(rMenus);
    }
}
