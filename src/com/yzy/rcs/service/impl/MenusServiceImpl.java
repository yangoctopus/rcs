package com.yzy.rcs.service.impl;

import com.yzy.rcs.domain.Menus;
import com.yzy.rcs.mapper.MenusMapper;
import com.yzy.rcs.service.MenusService;
import com.yzy.rcs.vo.MenusVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class MenusServiceImpl implements MenusService {
    @Autowired
    private MenusMapper menusMapper;
    @Override
    public List<MenusVo> loadMenus() {
        List<Menus> mlist=menusMapper.loadMenus();
        List<MenusVo> mvolist=new ArrayList<>();
        for(Menus menus:mlist){
            MenusVo menusVo=new MenusVo();
            BeanUtils.copyProperties(menus,menusVo);
            mvolist.add(menusVo);
        }
        return mvolist;
    }

    @Override
    public List<MenusVo> loadMenusResources(String username) {
        List<Menus> mlist = menusMapper.loadMenusResources(username);
        //创建List<MenusVo>对象
        List<MenusVo> mvoList=new ArrayList<MenusVo>();

        for(Menus m:mlist){
            MenusVo mvo = new MenusVo();
            BeanUtils.copyProperties(m,mvo);

            mvoList.add(mvo);
        }
        return mvoList;
    }

}
