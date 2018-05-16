package com.yzy.rcs.mapper;

import com.yzy.rcs.domain.RoleMenus;

import java.util.List;

public interface RoleMenusMapper {

    List<RoleMenus> loadRoleMenus(Integer roleid);

    void deleteRoleMenus(Integer rid);

    void saveRoleMenus(RoleMenus roleMenus);
}
