package com.yzy.rcs.service.impl;

import com.yzy.rcs.domain.RoleMenus;
import com.yzy.rcs.mapper.RoleMenusMapper;
import com.yzy.rcs.service.RoleMenusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleMenusServiceImpl implements RoleMenusService {
    @Autowired
    private RoleMenusMapper roleMenusMapper;

    @Override
    public List<RoleMenus> loadRoleMenusService(Integer roleid) {
        return roleMenusMapper.loadRoleMenus(roleid);
    }

    @Override
    public void saveRoleMeunsService(String rmids) {
        // TODO Auto-generated method stub

        String[] rms = rmids.split(",");

        Integer rid = Integer.parseInt(rms[0]);

        //删除该角色对应的所有资源关系
        roleMenusMapper.deleteRoleMenus(rid);

        for (int x = 1; x < rms.length; x++) {

            //创建RoleMenus对象
            RoleMenus roleMenus = new RoleMenus();
            //roleMenus封装数据
            roleMenus.setRid(rid);
            roleMenus.setMid(Integer.parseInt(rms[x]));
            roleMenusMapper.saveRoleMenus(roleMenus);
        }
    }
}