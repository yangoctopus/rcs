package com.yzy.rcs.service;

import com.yzy.rcs.vo.MenusVo;

import java.util.List;

public interface MenusService {
    public List<MenusVo> loadMenus();

    List<MenusVo> loadMenusResources(String username);
}
