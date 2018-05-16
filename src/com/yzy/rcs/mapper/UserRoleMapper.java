package com.yzy.rcs.mapper;

import com.yzy.rcs.domain.UserRole;
import java.util.List;

public interface UserRoleMapper {
    public void saveUserRole(UserRole userRole);
    public void delUserRole(String username);

    List<Integer> loadUserRole(String username);
}
