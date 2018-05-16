package com.yzy.rcs.service;

import com.yzy.rcs.vo.DataGridModel;
import com.yzy.rcs.vo.UsersVo;

import java.util.List;

public interface UsersService {
    UsersVo login(UsersVo usersVo);
    DataGridModel<UsersVo> loadAll(UsersVo usersVo);

    DataGridModel<UsersVo> findKey(UsersVo usersVo);
    void saveUsers(UsersVo usersVo);

    void updateUsers(UsersVo usersVo);

    void delUsers(UsersVo usersVo);

    List<Integer> loadUserRoleService(String username);
}
