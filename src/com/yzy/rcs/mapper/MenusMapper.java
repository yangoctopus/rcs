package com.yzy.rcs.mapper;



import com.yzy.rcs.domain.Menus;

import java.util.List;

public interface MenusMapper {
    public List<Menus> loadMenus();

    List<Menus> loadMenusResources(String username);
}
