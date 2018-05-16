package com.yzy.rcs.service;

import com.yzy.rcs.vo.DataGridModel;
import com.yzy.rcs.vo.RolesVo;

import java.util.List;


public interface RolesService {
    public DataGridModel<RolesVo> findRolesKey(RolesVo rolesVo);
    public void saveRoles(RolesVo rolesVo);
    public void updateRoles(RolesVo rolesVo);
    public void delRoles(RolesVo rolesVo);

    List<RolesVo> loadAllRolesListService();
}
