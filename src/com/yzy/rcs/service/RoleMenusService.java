package com.yzy.rcs.service;

import com.yzy.rcs.domain.RoleMenus;

import java.util.List;


public interface RoleMenusService {

    List<RoleMenus> loadRoleMenusService(Integer roleid);

    void saveRoleMeunsService(String rmids);
}
