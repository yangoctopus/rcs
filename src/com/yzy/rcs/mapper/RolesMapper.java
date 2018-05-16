package com.yzy.rcs.mapper;

import com.yzy.rcs.domain.Roles;

import java.util.List;

public interface RolesMapper {
     List<Roles> findRolesKey(Roles roles);
     void saveRoles(Roles roles);
     void updateRoles(Roles roles);
    void delRoles(Roles roles);

}
